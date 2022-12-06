package se.exam.project.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin
public class UserController {


    @Autowired
    UserRepository userRepository;

    @RequestMapping("/login")
    public User login(@RequestBody User user){
        User foundUser;
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            foundUser = userRepository.findByUsername(user.getUsername()).get();
        } else {
            return null;
        }
        if (foundUser.getPassword().equals(user.getPassword())) {
            return foundUser;
        }
        return null;
    }

//    @RequestMapping("/user")
//    public Principal user(HttpServletRequest request){
//        String authToken = request.getHeader("Authorization")
//                .substring("Basic".length()).trim();
//        return () ->  new String(Base64.getDecoder()
//                .decode(authToken)).split(":")[0];
//    }
}
