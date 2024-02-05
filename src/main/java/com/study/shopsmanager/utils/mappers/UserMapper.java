package com.study.shopsmanager.utils.mappers;

import com.study.shopsmanager.dto.UserDTO;
import com.study.shopsmanager.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserDTO toUserDTO(UserEntity userEntity);
  Iterable<UserDTO> toUserDTOs(Iterable<UserEntity> userEntities);
  UserEntity toUserEntity(UserDTO userDTO);
}
