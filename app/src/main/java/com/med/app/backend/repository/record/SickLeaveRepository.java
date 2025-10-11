package com.med.app.backend.repository.record;

import com.med.app.backend.model.record.SickLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SickLeaveRepository extends JpaRepository<SickLeave, UUID>
{
}