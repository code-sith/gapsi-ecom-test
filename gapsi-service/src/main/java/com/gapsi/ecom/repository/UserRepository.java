package com.gapsi.ecom.repository;

import com.gapsi.ecom.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
