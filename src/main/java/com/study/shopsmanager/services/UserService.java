package com.study.shopsmanager.services;

import com.study.shopsmanager.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
  UserDTO getUser(Long id) throws UsernameNotFoundException;
  UserDTO getUser(String username) throws UsernameNotFoundException;
  Iterable<UserDTO> getUsers();
  UserDTO saveUser(UserDTO userDTO);
  void deleteUser(Long id);
}
