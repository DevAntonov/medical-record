package com.med.app.backend.repository.record;

import com.med.app.backend.model.record.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface VisitRepository extends JpaRepository<Visit, UUID>
{
    List<Visit> findByPatientId(UUID patientId);
    List<Visit> findByDoctorId(UUID doctorId);
    List<Visit> findByVisitDateBetween(LocalDate start, LocalDate end);
    List<Visit> findByDoctorIdAndVisitDateBetween(UUID doctorId, LocalDate start, LocalDate end);
}