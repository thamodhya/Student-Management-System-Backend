
package com.springboot.StudentManagementSystem.repository;

        import com.springboot.StudentManagementSystem.model.Student;
        import com.springboot.StudentManagementSystem.model.User;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import java.util.List;
        import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //User findByUsername(String username);
    User findByPassword(String password);
    User findOneByEmailAndPassword(String email, String password);
    //Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    //Optional<User> findByLogin(String login);
}