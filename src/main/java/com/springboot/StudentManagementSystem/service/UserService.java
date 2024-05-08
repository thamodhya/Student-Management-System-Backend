
package com.springboot.StudentManagementSystem.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
        import com.springboot.StudentManagementSystem.model.User;
        import com.springboot.StudentManagementSystem.repository.UserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    public User saveUser(User user) {
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }



    public String deleteUser(int userId) {
        userRepository.deleteById(userId);
        return "student removed !! " + userId;
    }

    public boolean loginUser(String email, String password) {
        User user = userRepository.findOneByEmailAndPassword(email,password);
        if (user != null) {
            return true;
        }else{
            return false;
        }
    }



    public User updateUser(User user) {

        User existingStudent = userRepository.findById(user.getUserId()).orElse(null);
        existingStudent.setUsername(user.getUsername());
        //existingStudent.setPassword(user.getPassword());
        existingStudent.setEmail(user.getEmail());
        existingStudent.setCountry(user.getCountry());
        existingStudent.setUseraddress(user.getUseraddress());
        existingStudent.setGender(user.getGender());
        return userRepository.save(existingStudent);
    }

    public User updatePassword(User user) {
        User existingStudent = userRepository.findById(user.getUserId()).orElse(null);
        existingStudent.setPassword(user.getPassword());
        //existingStudent.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(existingStudent);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}