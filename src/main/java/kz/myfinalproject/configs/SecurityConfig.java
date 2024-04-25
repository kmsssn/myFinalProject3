package kz.myfinalproject.configs;

import kz.myfinalproject.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserService userService(){
        return new UserService();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.exceptionHandling().accessDeniedPage("/403-error");

        AuthenticationManagerBuilder builder=
                http.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(userService()).passwordEncoder(passwordEncoder());

        http.formLogin()
                .loginPage("/sign-in") // "/sign-in" Controller page
                .loginProcessingUrl("/auth") //<form action="/auth" method="POST">
                .usernameParameter("user_email")
                // <input type="email" name="user_email">
                .passwordParameter("user_password") //<input type="password" name=""user_password"
                .defaultSuccessUrl("/profile") // response.sendRedirect("/profile")
                .failureUrl("/sign-in?auth_error");

        http.logout()
                .logoutUrl("/sign-out") //POST request to /sign-out
                .logoutSuccessUrl("/sign-in");

        //http.csrf().disable();

        return http.build();

    }
}
