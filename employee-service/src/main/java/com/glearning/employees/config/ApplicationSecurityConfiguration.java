package com.glearning.employees.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.glearning.employees.service.DomainUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {
		
		@Autowired
		private DomainUserDetailsService domainUserDetailsService;
		
		// Authentication
	@Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        //configure users
		/*
		 * authenticationManagerBuilder .inMemoryAuthentication() .withUser("kiran")
		 * .password(passwordEncoder().encode("welcome")) .roles("USER") .and()
		 * .withUser("vinay") .password(passwordEncoder().encode("welcome"))
		 * .roles("USER","ADMIN"); }
		 * 
		 */
		
		
		        //configure users
		     authenticationManagerBuilder
		     .userDetailsService(this.domainUserDetailsService)
		     .passwordEncoder(passwordEncoder());
		    
	}
	
	 @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	        // configure authorization rules here
	        httpSecurity.cors().disable();
	        httpSecurity.csrf().disable();
	        httpSecurity.headers().frameOptions().disable();
	        httpSecurity
	                .authorizeRequests()
	                .antMatchers(HttpMethod.POST,"/api/roles/**")
	                .permitAll()
	                .antMatchers(HttpMethod.GET,"/api/roles/**")
	                .permitAll()
	                .and()
	                .authorizeRequests()
	                .antMatchers(HttpMethod.POST,"/api/users/**")
	                .permitAll()
	                .antMatchers(HttpMethod.GET,"/api/users/**")
	                .permitAll()
	                .and()
	                .authorizeRequests()
	                	.antMatchers(HttpMethod.GET,"/api/employees/**")
	               // .hasAnyRole("USER", "ADMIN")
	                	.permitAll()
	                .antMatchers("/h2-console/**","/login**","/contact-us**").permitAll()
	                .and()
	                .authorizeRequests()
	                	.antMatchers(HttpMethod.POST,"/api/employees/**")
	                .hasAuthority("ADMIN")
	                	.antMatchers(HttpMethod.PUT,"/api/employees/**")
	                .hasAuthority("ADMIN")
	                	.antMatchers(HttpMethod.DELETE,"/api/employees/**")
	                .hasAuthority("ADMIN")
	                .anyRequest()
	                .authenticated()
	                .and()
	                .formLogin()
	                .and()
	                .httpBasic()
	               .and()
	                /*
	                   Set the sessioncreation policy to avoid using cookies for authentication
	                   https://stackoverflow.com/questions/50842258/spring-security-caching-my-authentication/50847571
	                 */
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  
	    }
	
	 @Bean
	 public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
}


