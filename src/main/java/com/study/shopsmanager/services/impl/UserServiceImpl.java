package com.study.shopsmanager.services.impl;

import com.study.shopsmanager.dto.UserDTO;
import com.study.shopsmanager.entities.UserEntity;
import com.study.shopsmanager.repositories.UserRepository;
import com.study.shopsmanager.services.UserService;
import com.study.shopsmanager.utils.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;
  @Autowired
  UserMapper userMapper;

  @Override
  public UserDTO getUser(Long id) {
    return null;
  }

  @Override
  public UserDTO getUser(String username) {
    UserEntity userEntity = userRepository.findByUsername(username);

    if (userEntity == null) {
      throw new UsernameNotFoundException("User not found");
    }

    return userMapper.toUserDTO(userEntity);
  }

  @Override
  public Iterable<UserDTO> getUsers() {
    Iterable<UserEntity> userEntities = userRepository.findAll();

    return userMapper.toUserDTOs(userEntities);
  }

  @Override
  public UserDTO saveUser(UserDTO userDTO) {
    UserEntity userEntity = userMapper.toUserEntity(userDTO);

    userDTO = userMapper.toUserDTO(userRepository.save(userEntity));

    return userDTO;
  }

  @Override
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserDetails userEntity = userRepository.findByUsername(username);

    if (userEntity == null) {
      throw new UsernameNotFoundException("User not found");
    }

    return userEntity;
  }
}
