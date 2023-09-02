package com.med.app.backend.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for user persistence management
 *
 * @author A.Antonov
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID>
{
}
