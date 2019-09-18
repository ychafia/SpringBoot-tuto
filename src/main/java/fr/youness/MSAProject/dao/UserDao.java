package fr.youness.MSAProject.dao;

import fr.youness.MSAProject.models.User;
import fr.youness.MSAProject.models.UserDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User findByIsActiveAndUsername(Boolean isActive, String username);
}
