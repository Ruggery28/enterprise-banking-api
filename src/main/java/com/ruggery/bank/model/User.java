package com.ruggery.bank.model;

import jakarta.persistence.*;

@Entity // 1. Tells Hibernate: "Create a table for this class inside MySQL"
@Table(name = "users") // 2. Explicitly names the SQL table 'users'
public class User {

    @Id // 3. Marks this specific field as the Primary Key column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. Tells MySQL to auto-increment this ID number (1, 2, 3...) automatically
    private Long id;

    @Column(nullable = false) // 5. Ensures this column can never be empty/null in the database
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true) // 6. Ensures no two users can register with the same email address
    private String email;

    // JPA requires a protected or public no-argument constructor to reconstruct objects from the database.
    // Let's add it right here:
    protected User() {}

    // Keep your existing full constructor below:
    public User(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
