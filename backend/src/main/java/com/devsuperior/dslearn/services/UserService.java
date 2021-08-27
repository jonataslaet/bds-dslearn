package com.devsuperior.dslearn.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearn.dtos.UserDTO;
import com.devsuperior.dslearn.entities.User;
import com.devsuperior.dslearn.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthService authService;

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		authService.validSelfOrAdmin(id);
		Optional<User> userOptional = userRepository.findById(id);
		userOptional.orElseThrow(() -> new EntityNotFoundException("User not found"));
		return new UserDTO(userOptional.get());
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> userByEmail = userRepository.findByEmail(email);
		if (!userByEmail.isPresent()) {
			throw new EntityNotFoundException("User not found for email: " + email);
		}
		return userByEmail.get();
	}

}
