package com.lh_Spring.Repository;

import com.lh_Spring.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<User,Integer> {
    public User findByEmail(String email);

    public User findByEmailAndPassword(String email, String password);

}
