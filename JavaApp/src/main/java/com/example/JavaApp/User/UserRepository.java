package com.example.JavaApp.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
    User findByEmail(String email);
    @Procedure("log_in")
    int signIn(
            @Param("p_email") String email,
            @Param("p_password") String password
    ); // de elim



    @Procedure("sign_up")
    void signUp(
            @Param("p_last_name") String lastName,
            @Param("p_first_name") String firstName,
            @Param("p_email") String email,
            @Param("p_password") String password
    ); // de elim

}
