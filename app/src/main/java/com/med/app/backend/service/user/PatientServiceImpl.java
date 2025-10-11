package com.med.app.backend.service.user;

import com.med.app.backend.model.user.Doctor;
import com.med.app.backend.model.user.Patient;
import com.med.app.backend.repository.user.DoctorRepository;
import com.med.app.backend.repository.user.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService
{
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;


    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, DoctorRepository doctorRepository)
    {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }


    @Override
    public Patient createPatient(Patient patient)
    {
        return patientRepository.save(patient);
    }


    @Override
    public Patient getPatientById(UUID id)
    {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }


    @Override
    public Patient getPatientByEgn(String pin)
    {
        return patientRepository.findAll()
                .stream()
                .filter(p -> p.getPin().equals(pin))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Patient with this PIN not found"));
    }


    @Override
    public List<Patient> getAllPatients()
    {
        return patientRepository.findAll();
    }


    @Override
    public Patient assignGeneralPractitioner(UUID patientUuid, UUID doctorUuid)
    {
        Patient patient = getPatientById(patientUuid);
        Doctor doctor = doctorRepository.findById(doctorUuid)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        patient.setGeneralPractitioner(doctor);
        return patientRepository.save(patient);
    }


    @Override
    public void deletePatient(UUID id)
    {
        Patient patient = getPatientById(id);
        patientRepository.delete(patient);
    }

}
