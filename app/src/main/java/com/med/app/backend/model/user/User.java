package com.med.app.backend.model.user;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * User class to represent user entity
 *
 * @author A.Antonov
 */
@Entity
@Table(name = "tUsers")
public class User
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;

    @Column(name = "cUsername", nullable = false, unique = true)
    private String username;

    @Column(name = "cPasswordHash", nullable = false)
    private String passwordHash;

    @Column(name = "cEmail")
    private String email;

    @Column(name = "cEnabled", nullable = false)
    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "cAssociatedPatientId")
    private Patient associatedPatient;

    @OneToOne
    @JoinColumn(name = "cAssociatedDoctorId")
    private Doctor associatedDoctor;

    @ManyToMany
    @JoinTable(
            name = "tUserRoles",
            joinColumns = @JoinColumn(name = "cUserId"),
            inverseJoinColumns = @JoinColumn(name = "cRoleId")
    )
    private Set<Role> roles;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Patient getAssociatedPatient() {
        return associatedPatient;
    }

    public void setAssociatedPatient(Patient associatedPatient) {
        this.associatedPatient = associatedPatient;
    }

    public Doctor getAssociatedDoctor() {
        return associatedDoctor;
    }

    public void setAssociatedDoctor(Doctor associatedDoctor) {
        this.associatedDoctor = associatedDoctor;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return enabled == user.enabled &&
                Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(passwordHash, user.passwordHash) &&
                Objects.equals(email, user.email) &&
                Objects.equals(associatedPatient, user.associatedPatient) &&
                Objects.equals(associatedDoctor, user.associatedDoctor) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, passwordHash, email, enabled, associatedPatient, associatedDoctor, roles);
    }
}
