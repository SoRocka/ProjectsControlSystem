package org.pcs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Employee {


    @Size(min=2, max = 45, message = "Name should be between 2 or 30 characters.")
   private String name;
    @Size(min=2, max = 45, message = "Surname should be between 2 or 30 characters.")
    private String surname;
    @Email(message = "Email should be valid.")
    private String email;
    @Size (min = 11, max = 11, message ="Invalid phone number.")
    private String phone_number;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int project_id;

    public Employee() {

    }

    public Employee(int id, String name, String surname, String email, String phone_number, int project_id) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone_number = phone_number;
        this.id = id;
        this.project_id = project_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}

