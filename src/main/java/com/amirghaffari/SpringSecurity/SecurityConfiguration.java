package com.amirghaffari.SpringSecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/").permitAll()
                .antMatchers("/secured").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin").hasAnyRole("ADMIN")
                .and().logout().logoutSuccessUrl("/logoutSuccess").and().formLogin()
                .and().exceptionHandling().accessDeniedPage("/accessDenied");
    }


    // in production, passwords are kept in an encoded format in DB.
    // if password are encoded using BCrypt algorithm, then uncomment the below bean.
    // Spring Security is smart and will use this bean automatically to encode
    // the password that the user enters before comparing it with the passwords in DB
    /*
    @Bean
    public BCryptPasswordEncoder pwdEncoder(){
        return new BCryptPasswordEncoder();
    }
    */
}

