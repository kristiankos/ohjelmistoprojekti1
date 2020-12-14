package com.example.ohjelmistoprojekti1;

import com.example.ohjelmistoprojekti1.web.UserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .cors().and().csrf().disable()
        .authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out
        .and()
        .authorizeRequests().antMatchers("/anssurs/**","/answers/**","/options/**","/questions/**","/surveys/**").permitAll()
        .and()
        .authorizeRequests().anyRequest().authenticated()
        .and()
      .formLogin()
      
      //loginsivuna toimii login, josta aina uudelleenohjaus pelaajalistaan
          .loginPage("/login")
          .defaultSuccessUrl("/kyselylista", true)
          .permitAll()
          .and()
      .logout()
          .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}

