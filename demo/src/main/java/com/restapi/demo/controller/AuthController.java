package com.restapi.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.demo.config.JwtUtil;
import com.restapi.demo.dto.TokenDto;
import com.restapi.demo.exception.InvalidUsernameException;
import com.restapi.demo.model.User;
import com.restapi.demo.service.AuthService;
import com.restapi.demo.service.MyUserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private AuthService authService;
	@Autowired
	private MyUserService myUserService;
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/signup")
	public User signUp(@RequestBody User user) throws InvalidUsernameException {
		return authService.signUp(user);
	}
	
	@PostMapping("/login")
	public UserDetails login(Principal principal) {
		/* Make this login as Authenticated API 
		 * If this method is called, it means that Spring Filter alreeady
		 * has correct username/password
		 * 
		 * Can i ask spring filter to share these username and password  with me?
		 * -- yes but only username, spring filter never ever shares user password 
		 * */
		String username = principal.getName();
		return myUserService.loadUserByUsername(username);
	}
	
	@PostMapping("/token/generate")
	public TokenDto generateToken(@RequestBody User user,TokenDto dto) {
		/*Step 1. Build authentication ref based on username,passord given*/
		Authentication auth = 
		new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
	
		authenticationManager.authenticate(auth);
		
		/*Step 2: Generate the token since we know that credentials are correct */
		String token =  jwtUtil.generateToken(user.getUsername()); 
		dto.setToken(token);
		dto.setUsername(user.getUsername());
		dto.setExpiry(jwtUtil.extractExpiration(token).toString());
		return dto; 
	}
	
	@GetMapping("/user/details")
	public UserDetails getUserDetails(Principal principal) {
		String username = principal.getName();
		return myUserService.loadUserByUsername(username);
	}
}