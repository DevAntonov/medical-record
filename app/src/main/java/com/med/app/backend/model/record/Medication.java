package com.med.app.backend.model.record;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tMedications")
public class Medication
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;

    @Column(name = "cName", nullable = false)
    private String name;

    @Column(name = "cDosage")
    private String dosage;

    @Column(name = "cInstructions")
    private String instructions;

    @ManyToMany(mappedBy = "medications")
    private Set<Treatment> treatments;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Set<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(Set<Treatment> treatments) {
        this.treatments = treatments;
    }
}
