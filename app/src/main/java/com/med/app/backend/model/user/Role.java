package com.med.app.backend.model.user;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tRoles")
public class Role
{
    @Id
    @GeneratedValue
    @Column(name = "cId")
    private UUID id;

    @Column(name = "cName", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {}

    public Role(String name) {
        this.name = name;
    }

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
               Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
