package com.study.shopsmanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity implements GrantedAuthority {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  @Transient
  @ManyToMany
  private Set<UserEntity> users;

  @Override
  public String getAuthority() {
    return getName();
  }
}
