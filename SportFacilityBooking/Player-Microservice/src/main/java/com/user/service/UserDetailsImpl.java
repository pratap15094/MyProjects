package com.user.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.user.entity.User;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Integer player_id;
	private String username;
	private String email;
	private String pan_number;
	private String mob_number;
	private String DOB;
	private String address;
	private String city;
	private String state;
	private String country;
	
	@JsonIgnore
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Integer player_id, String username, String email, String pan_number, String mob_number,
			String DOB, String address, String city, String state, String country, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.player_id = player_id;
		this.username = username;
		this.email = email;
		this.pan_number = pan_number;
		this.mob_number = mob_number;
		this.DOB = DOB;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

		return new UserDetailsImpl(user.getPlayer_id(), user.getUsername(), user.getEmail(), user.getPan_number(),
				user.getMob_number(), user.getDOB(), user.getPassword(), user.getAddress(), user.getCity(),
				user.getState(), user.getCountry(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	
	
	public Integer getPlayer_id() {
		return player_id;
	}

	public String getPan_number() {
		return pan_number;
	}

	public String getMob_number() {
		return mob_number;
	}

	public String getDOB() {
		return DOB;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public String getEmail() {
		return email;
	}

	@Override
	  public String getPassword() {
	    return password;
	  }

	  @Override
	  public String getUsername() {
	    return username;
	  }

	  @Override
	  public boolean isAccountNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isAccountNonLocked() {
	    return true;
	  }

	  @Override
	  public boolean isCredentialsNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isEnabled() {
	    return true;
	  }

	  @Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (o == null || getClass() != o.getClass())
	      return false;
	    UserDetailsImpl user = (UserDetailsImpl) o;
	    return Objects.equals(player_id, user.player_id);
	  }
	
}
