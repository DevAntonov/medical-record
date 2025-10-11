package com.med.app.backend.model.record;

import com.med.app.backend.model.user.Doctor;
import com.med.app.backend.model.user.Patient;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "visits")
public class Visit
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cPatientId", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "cDoctorId", nullable = false)
    private Doctor doctor;

    @Column(name = "cVisitDate", nullable = false)
    private LocalDate visitDate;

    @ManyToOne
    @JoinColumn(name = "cDiagnosisId")
    private Diagnosis diagnosis;

    @OneToOne(mappedBy = "visit", cascade = CascadeType.ALL)
    private Treatment treatment;

    @OneToOne(mappedBy = "visit", cascade = CascadeType.ALL)
    private SickLeave sickLeave;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public SickLeave getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(SickLeave sickLeave) {
        this.sickLeave = sickLeave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visit visits)) return false;
        return Objects.equals(id, visits.id) &&
               Objects.equals(patient, visits.patient) &&
               Objects.equals(doctor, visits.doctor) &&
               Objects.equals(visitDate, visits.visitDate) &&
               Objects.equals(diagnosis, visits.diagnosis) &&
               Objects.equals(treatment, visits.treatment) &&
               Objects.equals(sickLeave, visits.sickLeave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctor, visitDate, diagnosis, treatment, sickLeave);
    }
}
