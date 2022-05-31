package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.RoleType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleType name;


    public RoleType getName() {
        return name;
    }

    public Role setName(RoleType name) {
        this.name = name;
        return this;
    }

}
