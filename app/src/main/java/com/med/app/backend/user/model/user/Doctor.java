package com.med.app.backend.user.model.user;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;


/**
 * Doctor class to represent Doctor entity.
 * <p>
 * Extends user class
 *
 * @author A.Antonov
 */
@Entity
@PrimaryKeyJoinColumn(name = "cUserId")
@Table(name = "tDoctors")
public class Doctor extends User
{
    @Column(name = "cDoctorId")
    private String doctorId;

    // TODO: Think about doctor patient connections and doctor specialty conn
}
