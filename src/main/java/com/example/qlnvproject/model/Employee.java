package com.example.qlnvproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    private long id;
    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    private String username;
    @NotEmpty
    @Size(min = 2, message = "full name should have at least 2 characters")
    private String fullname;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 8, message = "password should have at least 8 characters")
    private String pass;
    @NotEmpty
    @Size(min = 2, message = "birthday should have at least 2 characters")
    private String birthday;
    @NotEmpty
    @Size(min = 2, message = "degree should have at least 2 characters")
    private String degree;
    @NotEmpty
    @Size(min = 2, message = "specialize should have at least 2 characters")
    private String specialize;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false, referencedColumnName = "department_id")
    @JsonBackReference
    private Department department;



}
