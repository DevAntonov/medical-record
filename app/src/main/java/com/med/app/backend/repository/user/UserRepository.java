package com.med.app.backend.repository.user;


import com.med.app.backend.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
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
