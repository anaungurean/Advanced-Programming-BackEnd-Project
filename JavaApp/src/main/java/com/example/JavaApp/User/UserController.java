package com.example.JavaApp.User;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create")
    @Operation(summary = "Create a new user", description = "Add a new player to the system")
    public ResponseEntity<String> createPlayer(@RequestBody User user) {
        try {
            userService.addNewUser(user);
            return ResponseEntity.ok("User created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user");
        }
    }
    @PostMapping("/login")
    @Operation(summary = "Login a user", description = "Login a user to the system")
    public ResponseEntity<String> login(@RequestBody User user) {

        String email = user.getEmail();
        String password = user.getPassword();

         User user1 = userService.getUserByEmail(email);

        if (user1 == null) {
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email ");
        }

        if (!userService.verifyPassword(user1, password)) {
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid  password");
        }

         return ResponseEntity.ok("Login successful");
    }

    @Operation(summary = "Get user by ID", description = "Retrieve a user by ID")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Update user", description = "Update user details")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userService.getUserById(id);

        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }

         user.setId(id);
        userService.updateUser(user);

        return ResponseEntity.ok("User updated successfully");
    }

    @Operation(summary = "Delete user", description = "Delete a user by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        User existingUser = userService.getUserById(id);

        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteUser(id);

        return ResponseEntity.ok("User deleted successfully");
    }



}
