package com.med.app.backend.controller;

import com.med.app.backend.model.user.Doctor;
import com.med.app.backend.service.user.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController
{
    private final DoctorService doctorService;


    @Autowired
    public DoctorController(DoctorService doctorService)
    {
        this.doctorService = doctorService;
    }


    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor)
    {
        return ResponseEntity.ok(doctorService.createDoctor(doctor));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable UUID uuid)
    {
        return ResponseEntity.ok(doctorService.getDoctorById(uuid));
    }


    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors()
    {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }


    @GetMapping("/gps")
    public ResponseEntity<List<Doctor>> getGeneralPractitioners()
    {
        return ResponseEntity.ok(doctorService.getGeneralPractitioners());
    }
}
