package com.med.app.backend.service.user;

import com.med.app.backend.model.user.Patient;

import java.util.List;
import java.util.UUID;


public interface PatientService
{
    Patient createPatient(Patient patient);
    Patient getPatientById(UUID id);
    Patient getPatientByEgn(String egn);
    List<Patient> getAllPatients();
    Patient assignGeneralPractitioner(UUID patientUuid, UUID doctorUuid);
    void deletePatient(UUID id);
}
