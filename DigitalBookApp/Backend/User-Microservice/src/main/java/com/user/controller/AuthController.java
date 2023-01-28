package com.user.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.dto.AuthorDto;
import com.user.entity.ERole;
import com.user.entity.Role;
import com.user.entity.User;
import com.user.payload.request.LoginRequest;
import com.user.payload.request.SignupRequest;
import com.user.payload.response.JwtResponse;
import com.user.payload.response.MessageResponse;
import com.user.repository.RoleRepository;
import com.user.repository.UserRepository;
import com.user.service.SendEmail;
import com.user.service.UserDetailsImpl;
import com.user.utility.JwtUtils;


@RestController
@CrossOrigin(origins = "*",allowedHeaders="*")
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;
  
  @Autowired
  SendEmail sendEmail;
  
  @Autowired
  RestTemplate restTemplate;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(), 
                         roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    //Create new user's account
    User user = new User(signUpRequest.getUsername(), 
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()));
    Set<String> tmpRoles = new HashSet<>();
    tmpRoles.add(signUpRequest.getRole());
    Set<String> strRoles = tmpRoles;
    Set<Role> roles = new HashSet<>();
    System.out.println(strRoles);
    if (strRoles.isEmpty()) {
    	System.out.println("role is here!!null!!");
      Role userRole = roleRepository.findByName(ERole.ROLE_GUEST)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else
    {
      strRoles.forEach(role -> {
    	 System.out.println(role);
        switch (role) {
        case "ROLE_READER":
        	System.out.println("role is here!!!!!");
          Role adminRole = roleRepository.findByName(ERole.ROLE_READER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "ROLE_AUTHOR":
          Role modRole = roleRepository.findByName(ERole.ROLE_AUTHOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);
          String rolefordto = "ROLE_AUTHOR";
          String url = "http://localhost:8082/book/addauthor";
          AuthorDto authorDto = new AuthorDto();
          authorDto.setAuthorName(user.getUsername());
          authorDto.setAuthorEmail(user.getEmail());
          authorDto.setAuthorPassword(user.getPassword());
          authorDto.setAuthorRole(rolefordto);
          HttpHeaders headers = new HttpHeaders();
        	headers.setContentType(MediaType.APPLICATION_JSON);
       	    HttpEntity entity = new HttpEntity(authorDto,headers);
        	ResponseEntity<String> status = this.restTemplate.exchange(url, HttpMethod.POST,entity, String.class);

          break;
        default:
        	System.out.println("role is here!!null1!!");
          Role userRole = roleRepository.findByName(ERole.ROLE_GUEST)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }
    String info = ""+user.getUsername()+" Congratulations!, You have been registered with Digital book. Enjoy Learnings!";
    user.setRoles(roles);
	userRepository.save(user);
    sendEmail.mailer(user.getEmail(),info);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}