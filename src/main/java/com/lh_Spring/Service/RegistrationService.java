package com.lh_Spring.Service;

import com.lh_Spring.Model.User;
import com.lh_Spring.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public User saveUser(User user){
        return registrationRepository.save(user);
    }
    public User fetchUserByEmail(String email) {
        return registrationRepository.findByEmail(email);
    }
    public User fetchUserByEmailAndPassword(String email,String password) {
        return registrationRepository.findByEmailAndPassword(email,password);
    }

}
