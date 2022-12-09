package com.example.pathfinder.repository;

import com.example.pathfinder.model.entity.Role;
import com.example.pathfinder.model.entity.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType user);
}
