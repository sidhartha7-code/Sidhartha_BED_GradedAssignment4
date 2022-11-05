package com.glearning.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.glearning.employees.model.MyUserDetails;
import com.glearning.employees.model.User;
import com.glearning.employees.repository.UserRepository;

@Service("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {
	
	 @Autowired
	   private UserRepository userRepository;

	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = this.userRepository.getUserByUsername(username);
	        if (user == null) {
				throw new UsernameNotFoundException("Could not find user");
			}
	        //convert into UserDetails object which Spring Security can understand
	        return new MyUserDetails(user);

}
}
