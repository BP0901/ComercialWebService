package com.R2S.R2Sshop.data.repository;

import com.R2S.R2Sshop.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
