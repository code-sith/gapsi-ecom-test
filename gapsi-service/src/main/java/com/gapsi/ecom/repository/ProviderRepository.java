package com.gapsi.ecom.repository;

import com.gapsi.ecom.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProviderRepository extends JpaRepository<ProviderEntity, Long> {

    Optional<ProviderEntity> findByName(String name);
}
