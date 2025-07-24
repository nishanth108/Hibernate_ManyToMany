package com.tap.entities;

import jakarta.persistence.*;

import java.util.List;

public class Project {
    private int id;
    private String name;
    @ManyToMany(cascade = {
            CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
    })
    @JoinTable(
            name = "emp_project",
            joinColumns = @JoinColumn(name = "prg_id"),
            inverseJoinColumns = @JoinColumn(name = "emp_id")
    )
    private List<Employee> employee;

}
