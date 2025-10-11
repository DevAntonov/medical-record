package com.med.app.backend.controller;

import com.med.app.backend.model.user.Patient;
import com.med.app.backend.service.user.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/patients")
public class PatientController
{
    private final PatientService patientService;


    @Autowired
    public PatientController(PatientService patientService)
    {
        this.patientService = patientService;
    }


    @PostMapping
    public ResponseEntity<Patient> createPatient(Patient patient)
    {
        return ResponseEntity.ok(patientService.createPatient(patient));
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<Patient> getPatientById(@PathVariable UUID uuid)
    {
        return ResponseEntity.ok(patientService.getPatientById(uuid));
    }


    @GetMapping
    public ResponseEntity<Iterable<Patient>> getAllPatients()
    {
        return ResponseEntity.ok(patientService.getAllPatients());
    }


    @PutMapping("/{uuid}/assign-gp/{doctorUuid}")
    public ResponseEntity<Patient> assignGeneralPractitioner(@PathVariable UUID uuid, @PathVariable UUID doctorUuid)
    {
        return ResponseEntity.ok(patientService.assignGeneralPractitioner(uuid, doctorUuid));
    }


    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID uuid)
    {
        patientService.deletePatient(uuid);
        return ResponseEntity.noContent().build();
    }
}
