package com.lii.springsecurity.repository;

import com.lii.springsecurity.enums.RoleName;
import com.lii.springsecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByName(RoleName name);
}
