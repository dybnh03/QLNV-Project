package com.example.qlnvproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    private long department_id;
    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    private String departmentName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Employee> employeeList;

}
