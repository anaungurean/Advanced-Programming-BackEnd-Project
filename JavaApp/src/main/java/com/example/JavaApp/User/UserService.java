package com.example.JavaApp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(User user) {
         String email = user.getEmail();
        boolean emailExists = userRepository.existsByEmail(email);
        System.out.println(emailExists);
        if (emailExists) {
            throw new IllegalArgumentException("Email already exists");
        }
         //userRepository.save(user); //pentru java
        userRepository.signUp(user.getLastName(), user.getFirstName(), email, user.getPassword()); //de elim
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean verifyPassword(User user, String password) {
        return user.getPassword().equals(password);
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void updateUser(User updatedUser) {
        userRepository.save(updatedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public int logIn(String email, String password) {
         return  userRepository.signIn(email, password);
        //de eliminat

    }
}
