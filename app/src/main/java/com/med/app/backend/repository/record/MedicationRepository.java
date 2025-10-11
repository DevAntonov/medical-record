package com.med.app.backend.repository.record;

import com.med.app.backend.model.record.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, UUID>
{
}