package com.klasevich.monitorsensors.security.config;

import com.klasevich.monitorsensors.security.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/swagger-ui/**").hasAnyRole(Role.ADMINISTRATOR.name())
                .antMatchers(HttpMethod.GET, "/api/**", "/swagger-ui/**").hasAnyRole(Role.ADMINISTRATOR.name(), Role.VIEWER.name())
                .antMatchers(HttpMethod.POST, "/api/**").hasAnyRole(Role.ADMINISTRATOR.name())
                .antMatchers(HttpMethod.PUT, "/api/**", "/swagger-ui/**").hasAnyRole(Role.ADMINISTRATOR.name())
                .antMatchers(HttpMethod.DELETE, "/api/**", "/swagger-ui/**").hasAnyRole(Role.ADMINISTRATOR.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin"))
                        .roles(Role.ADMINISTRATOR.name())
                        .build(),
                User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("user"))
                        .roles(Role.VIEWER.name())
                        .build()
        );
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
