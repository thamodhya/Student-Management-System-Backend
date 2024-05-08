
package com.springboot.StudentManagementSystem.controller;

        import com.springboot.StudentManagementSystem.model.User;
        import com.springboot.StudentManagementSystem.service.UserService;
        import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.http.ResponseEntity;

        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.List;
        import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;
    //private JwtUtils jwtUtils;

    @PostMapping("/addUser")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        return "New user is added";
    }
    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/MyProfile/{userId}")
    public User findUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }


    @PutMapping("/update/{userId}")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable int userId) {
        return userService.deleteUser(userId);
    }

    @PutMapping("/resetPassword/{userId}")
    public User updatePassword(@RequestBody User user)
    {
        return userService.updatePassword(user);
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        if (userService.loginUser(email, password)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }




}
