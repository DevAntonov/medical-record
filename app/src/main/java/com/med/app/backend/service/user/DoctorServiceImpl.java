package com.med.app.backend.service.user;

import com.med.app.backend.model.user.Doctor;
import com.med.app.backend.repository.user.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService
{
    private DoctorRepository doctorRepository;


    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository)
    {
        this.doctorRepository = doctorRepository;
    }


    @Override
    public Doctor createDoctor(Doctor doctor)
    {
        return doctorRepository.save(doctor);
    }


    @Override
    public Doctor getDoctorById(UUID uuid)
    {
        return doctorRepository.findById(uuid).orElseThrow(() -> new IllegalArgumentException("Doctor not found with id: " + uuid));
    }


    @Override
    public List<Doctor> getAllDoctors()
    {
        return doctorRepository.findAll();
    }


    @Override
    public List<Doctor> getGeneralPractitioners()
    {
        return doctorRepository.findAll().stream().filter(Doctor::isGeneralPractitioner).collect(Collectors.toList());
    }
}
