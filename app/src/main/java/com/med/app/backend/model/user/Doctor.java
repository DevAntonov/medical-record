package com.med.app.backend.model.user;


import com.med.app.backend.model.record.Specialization;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;


/**
 * Doctor class to represent Doctor entity.
 * <p>
 *
 * @author A.Antonov
 */
@Entity
@Table(name = "tDoctors")
public class Doctor
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;

    @Column(name = "cFirstName", nullable = false)
    private String firstName;

    @Column(name = "cLastName", nullable = false)
    private String lastName;

    @Column(name = "cIsGeneralPractitioner", nullable = false)
    private boolean isGeneralPractitioner;

    @ManyToMany
    @JoinTable(
            name = "tDoctorSpecializations",
            joinColumns = @JoinColumn(name = "cDoctorId"),
            inverseJoinColumns = @JoinColumn(name = "cSpecializationId")
    )
    private Set<Specialization> specializations;

    @Column(name = "cDoctorCode")
    private String doctorCode;

    @ManyToMany
    @JoinTable(
            name = "tDoctorPatients",
            joinColumns = @JoinColumn(name = "cDoctorId"),
            inverseJoinColumns = @JoinColumn(name = "cPatientId")
    )
    private List<Patient> patients;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public boolean isGeneralPractitioner() {
        return isGeneralPractitioner;
    }


    public void setGeneralPractitioner(boolean generalPractitioner) {
        isGeneralPractitioner = generalPractitioner;
    }


    public Set<Specialization> getSpecializations() {
        return specializations;
    }


    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }


    public String getDoctorCode()
    {
        return doctorCode;
    }


    public void setDoctorCode(String doctorId)
    {
        this.doctorCode = doctorId;
    }


    public List<Patient> getPatients()
    {
        return patients;
    }


    public void setPatients(List<Patient> patients)
    {
        this.patients = patients;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Doctor doctor)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(id, doctor.id) &&
               Objects.equals(firstName, doctor.firstName) &&
               Objects.equals(lastName, doctor.lastName) &&
               isGeneralPractitioner == doctor.isGeneralPractitioner &&
               Objects.equals(doctorCode, doctor.doctorCode);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), id, firstName, lastName, isGeneralPractitioner, doctorCode);
    }
}
