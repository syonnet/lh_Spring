package com.lh_Spring.Controller;


import com.lh_Spring.Model.User;
import com.lh_Spring.Service.RegistrationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping(path = "/register")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
        if(tempEmail != null && !"".equals(tempEmail)){
            User userObj = registrationService.fetchUserByEmail(tempEmail);
            if(userObj != null){
                throw new Exception("Correo ya esta en uso");}
        }
        User u = null;
        u = registrationService.saveUser(user);
        return u;
    }

    @PostMapping(path = "/login")
    public User loginUser(@RequestBody User user) throws Exception{
        String tempEmail = user.getEmail();
        String tempPass  = user.getPassword();
        User userObj = null;
        if(tempEmail != null && tempPass != null){
            userObj = registrationService.fetchUserByEmailAndPassword(tempEmail,tempPass);
        }
        if(userObj == null)
            throw new Exception("Datos Incorrectos");
        return userObj;
    }

    @PostMapping(path = "/logout")
    public ResponseEntity<?> logoutUser(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }



        return ResponseEntity.ok("Logout exitoso");
    }

}

