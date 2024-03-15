package com.med.app.backend.user.model.record;


import com.med.app.backend.user.model.user.Doctor;
import com.med.app.backend.user.model.user.Patient;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cRecords")
public class Record
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "cDoctorId", nullable = false)
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "cPatientId", nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "cDiagnosisId", nullable = false)
    private Diagnosis diagnosis;
    @OneToOne(targetEntity = MedicalNote.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cMedicalNoteId")
    private MedicalNote medicalNote;
    @Column(name = "cDateCreated", nullable = false)
    private Date dateCreated;
    @ManyToMany
    @JoinTable(name = "tRecordsMedicine", joinColumns = @JoinColumn(name = "cRecordId"), inverseJoinColumns = @JoinColumn(name = "cMedicineId"))
    private List<Medicine> medicine;
    @Column(name = "cDescription")
    private String description;


    public UUID getId()
    {
        return id;
    }


    public void setId(UUID id)
    {
        this.id = id;
    }


    public Doctor getDoctor()
    {
        return doctor;
    }


    public void setDoctor(Doctor doctor)
    {
        this.doctor = doctor;
    }


    public Patient getPatient()
    {
        return patient;
    }


    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }


    public Diagnosis getDiagnosis()
    {
        return diagnosis;
    }


    public void setDiagnosis(Diagnosis diagnosis)
    {
        this.diagnosis = diagnosis;
    }


    public MedicalNote getMedicalNote()
    {
        return medicalNote;
    }


    public void setMedicalNote(MedicalNote medicalNote)
    {
        this.medicalNote = medicalNote;
    }


    public Date getDateCreated()
    {
        return dateCreated;
    }


    public void setDateCreated(Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }


    public List<Medicine> getMedicine()
    {
        return medicine;
    }


    public void setMedicine(List<Medicine> medicine)
    {
        this.medicine = medicine;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Record record)) return false;
        return Objects.equals(id, record.id);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
