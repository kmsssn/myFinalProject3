package kz.myfinalproject.controllers;

import kz.myfinalproject.dto.CourseDTO;
import kz.myfinalproject.dto.FacultyDTO;
import kz.myfinalproject.mapper.CourseMapper;
import kz.myfinalproject.mapper.FacultyMapper;
import kz.myfinalproject.models.Course;
import kz.myfinalproject.models.User;
import kz.myfinalproject.service.CourseService;
import kz.myfinalproject.service.FacultyService;
import kz.myfinalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private FacultyMapper facultyMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @GetMapping(value="/")
    public String indexPage(){
        return "index";
    }

    @GetMapping(value="/sign-in")
    public String signIn(){
        return "sign_in";
    }

    @GetMapping(value="/sign-up")
    public String signUp(Model model){
        List<FacultyDTO> faculties = facultyService.getAllFaculties();
        List<Course> courses = courseService.getAllCourses();

        model.addAttribute("faculties", faculties);
        model.addAttribute("courses", courses);
        return "sign_up";
    }

    @PostMapping(value="/to-sign-up")
    public String toSignUp(@RequestParam(name="user_email") String email,
                           @RequestParam(name="user_first_name") String firstName,
                           @RequestParam(name="user_last_name") String lastName,
                           @RequestParam(name="faculty_id") Long facultyId,
                           @RequestParam(name="course_id") Long courseId,
                           @RequestParam(name="user_password") String password,
                           @RequestParam(name="user_rep_password") String repPassword){
        if(password.equals(repPassword)){
            User user=new User();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            FacultyDTO faculty = facultyService.getFacultyById(facultyId);
            if (faculty == null) {
                return "redirect:/sign-up?error=invalidFaculty";
            }
            user.setFaculty(facultyMapper.toModel(faculty));

            CourseDTO course = courseService.getCourseById(courseId);
            if (course == null) {
                return "redirect:/sign-up?error=invalidCourse";
            }
            user.setCourse(courseMapper.toModel(course));
            User newUser=userService.addUser(user);
            if (newUser!=null){
                return "redirect:/sign-up?success";
            }else{
                return "redirect:/sign-up?emailError";
            }
        }else{
            return "redirect:/sign-up?passwordError";
        }
    }

    @GetMapping(value="403-error")
    public String accessDenied(){
        return "error403";
    }

    @GetMapping(value = "/change-password")
    public String updPassword(){
        return "change_password";
    }

    @PostMapping(value="/to-change-password")
    public String toChangePassword(
                           @RequestParam(name="old_password") String oldPassword,
                           @RequestParam(name="new_password") String newPassword,
                           @RequestParam(name="rep_new_password") String repNewPassword) {
        if(newPassword.equals(repNewPassword)){

            User user=userService.changePassword(newPassword, oldPassword);
            if(user!=null){
                return "redirect:/change-password?success";
            }else{
                return "redirect:/change-password?oldPasswordError";
            }

        }else{
            return "redirect:/change-password?passwordMissmatch";
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profilePage(Model model) {
        User user = userService.getCurrentSessionUser();
        model.addAttribute("user", user);
        return "profile";
    }

}
