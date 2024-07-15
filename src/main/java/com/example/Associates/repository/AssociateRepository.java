package com.example.Associates.repository;

import com.example.Associates.model.Associate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AssociateRepository extends JpaRepository<Associate, UUID> {

    Optional<Associate> findByFullName(String fullName);

    Optional<Associate> findByIndividualRegistry(String individualRegistry);

    boolean existsByIndividualRegistry(String individualRegistry);
}
