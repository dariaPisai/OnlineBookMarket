package com.webapp.springboot.OnlineBookMarket.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

//    InMemoryUserDetailsManager
//    InMemoryUserDetailsManager(UserDetails... users)
@Bean
public InMemoryUserDetailsManager createUserDetailsManager() {
    // Use a PasswordEncoder to encode your password
    String username = "admin";
    String Password = "parola123";

    PasswordEncoder encoder = passwordEncoder();
    UserDetails userDetails1 = createNewUser("admin", "parola123" );
    UserDetails userDetails2 = createNewUser("daria", "parola" );
    return new InMemoryUserDetailsManager(userDetails1, userDetails2);
}

private UserDetails createNewUser(String username, String Password) {
    PasswordEncoder encoder = passwordEncoder();
    UserDetails admin = User
            .builder()
            .username(username)
            .password(encoder.encode(Password)) // Encode the password
            .roles("USER", "ADMIN")
            .build();
    return admin;
}

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Use BCryptPasswordEncoder for encoding
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());

        http.formLogin(withDefaults());

        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();

    }


}
