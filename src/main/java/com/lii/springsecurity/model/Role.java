package com.lii.springsecurity.model;

import com.lii.springsecurity.enums.RoleName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private RoleName name;

    public Role(RoleName roleName) {
        this.name = roleName;
    }
}
