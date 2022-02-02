package com.adresar.job.model;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private LocalDate dateOfBirth;

    private String email;

    private String phoneNumber;


    public User() {
    }

    public User(String firstName, String lastName, String address, LocalDate dateOfBirth, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof User))
            return false;

        User user = (User) obj;
        return Objects.equals(this.id, user.id) && Objects.equals(this.firstName, user.firstName)&& Objects.equals(this.lastName, user.lastName)
                && Objects.equals(this.dateOfBirth, user.dateOfBirth) && Objects.equals(this.email, user.email) && Objects.equals(this.phoneNumber, user.phoneNumber);
    }


    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", date_of_birth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", phone_number=" + phoneNumber +
                '}';
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
