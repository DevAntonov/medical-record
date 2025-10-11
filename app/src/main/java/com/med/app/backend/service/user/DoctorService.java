package com.med.app.backend.service.user;

import com.med.app.backend.model.user.Doctor;

import java.util.List;
import java.util.UUID;

public interface DoctorService
{
    Doctor createDoctor(Doctor doctor);
    Doctor getDoctorById(UUID uuid);
    List<Doctor> getAllDoctors();
    List<Doctor> getGeneralPractitioners();
}
