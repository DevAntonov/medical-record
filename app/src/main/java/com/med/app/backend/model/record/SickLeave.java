package com.med.app.backend.model.record;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tSickLeaves")
public class SickLeave
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;

    @Column(name = "cStartDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "cDurationDays", nullable = false)
    private int durationDays;

    @OneToOne
    @JoinColumn(name = "cVisitId", nullable = false)
    private Visit visit;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
}
