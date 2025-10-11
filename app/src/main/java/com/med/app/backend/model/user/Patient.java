package com.med.app.backend.model.user;

import com.med.app.backend.model.record.HealthInsurancePayment;
import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * Patient class to represent Patient entity.
 * <p>
 * Extends user class.
 *
 * @author A.Antonov
 */
@Entity
@Table(name = "tPatients")
public class Patient
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;

    @Column(name = "cFirstName", nullable = false)
    private String firstName;

    @Column(name = "cLastName", nullable = false)
    private String lastName;

    @Column(name = "cPin", nullable = false, unique = true)
    private String pin;

    @ManyToOne
    @JoinColumn(name = "cGeneralPractitionerId")
    private Doctor generalPractitioner;

    @OneToMany(mappedBy = "patient")
    private Set<HealthInsurancePayment> insurancePayments;

    // TODO: Constructors?

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

    public String getPin()
    {
        return pin;
    }

    public void setPin(String pin)
    {
        this.pin = pin;
    }

    public Doctor getGeneralPractitioner() {
        return generalPractitioner;
    }

    public void setGeneralPractitioner(Doctor generalPractitioner) {
        this.generalPractitioner = generalPractitioner;
    }

    public Set<HealthInsurancePayment> getInsurancePayments() {
        return insurancePayments;
    }

    public void setInsurancePayments(Set<HealthInsurancePayment> insurancePayments) {
        this.insurancePayments = insurancePayments;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) &&
               Objects.equals(firstName, patient.firstName) &&
               Objects.equals(lastName, patient.lastName) &&
               Objects.equals(pin, patient.pin) &&
               Objects.equals(generalPractitioner, patient.generalPractitioner) &&
               Objects.equals(insurancePayments, patient.insurancePayments);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), id, firstName, lastName, pin, generalPractitioner, insurancePayments);
    }
}
