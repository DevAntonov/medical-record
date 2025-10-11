package com.med.app.backend.repository.user;

import com.med.app.backend.model.user.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID>
{
    Optional<Patient> findByPin(String pin);
    List<Patient> findByGeneralPractitionerId(UUID generalPractitionerId);
}