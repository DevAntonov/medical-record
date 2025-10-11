package com.med.app.backend.repository.record;

import com.med.app.backend.model.record.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, UUID>
{
    Optional<Diagnosis> findByName(String name);
}