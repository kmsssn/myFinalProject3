package kz.bitlab.myfinalproject.service;

import kz.bitlab.myfinalproject.dto.UserDTO;
import kz.bitlab.myfinalproject.mapper.UserMapper;
import kz.bitlab.myfinalproject.models.Permission;
import kz.bitlab.myfinalproject.models.User;
import kz.bitlab.myfinalproject.repository.PermissionRepository;
import kz.bitlab.myfinalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(username);
        if (user!=null){
            return user;
        }else{
            throw new UsernameNotFoundException("User Not Found");
        }
    }

    public User addUser(User user) {
        User checkUser = userRepository.findByEmail(user.getEmail());
        if (checkUser == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
        return null;
    }

    public User changePassword(String newPassword, String oldPassword){

        User currentUser=getCurrentSessionUser();
        if (passwordEncoder.matches(oldPassword, currentUser.getPassword())){
            currentUser.setPassword(passwordEncoder.encode(newPassword));
            return userRepository.save(currentUser);
        }
        return null;
    }

    public User getCurrentSessionUser(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User user=(User)authentication.getPrincipal();
            if(user!=null){
                return user;
            }
        }
        return null;
    }

    public List<UserDTO> getAllUsers() {
        return userMapper.toDTOList(userRepository.findAll());
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public UserDTO getUserById(Long id){

        return userMapper.toDTO(userRepository.findById(id).orElse(new User()));

    }

    public User getUserByEmail(String email) {

        return userRepository.findByEmail(email);

    }
}
