package com.med.app.backend.model.record;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tTreatments")
public class Treatment
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;

    @ManyToMany
    @JoinTable(
        name = "tTreatmentMedications",
        joinColumns = @JoinColumn(name = "cTreatmentId"),
        inverseJoinColumns = @JoinColumn(name = "cMedicationId")
    )
    private List<Medication> medications;

    @Column(name = "cNotes")
    private String notes;

    @OneToOne
    @JoinColumn(name = "cVisitId", nullable = false)
    private Visit visit;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
}
