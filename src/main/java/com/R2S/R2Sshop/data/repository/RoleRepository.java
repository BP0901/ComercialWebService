package com.R2S.R2Sshop.data.repository;

import com.R2S.R2Sshop.data.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Override
    Optional<Role> findById(Long id);
}
