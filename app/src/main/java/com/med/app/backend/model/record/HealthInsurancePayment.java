package com.med.app.backend.model.record;

import com.med.app.backend.model.user.Patient;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tHealthInsurancePayments")
public class HealthInsurancePayment
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cPatientId", nullable = false)
    private Patient patient;

    @Column(name = "cPaymentDate", nullable = false)
    private LocalDate paymentDate;

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

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}
