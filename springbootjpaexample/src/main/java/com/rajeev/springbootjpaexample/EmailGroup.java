package com.rajeev.springbootjpaexample;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.ManyToMany;



@Entity
public class EmailGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToMany(mappedBy = "emailGroups")
    private List<Employee> members= new ArrayList<>();
    public void addMembers(Employee employee){
        this.members.add(employee);
    }
    public List<Employee> getMembers() {
        return members;
    }
    public void setMembers(List<Employee> members) {
        this.members = members;
    }
    @Override
    public String toString() {
        return "EmailGroup [id=" + id + ", name=" + name + "]";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public EmailGroup() {
    }
    public EmailGroup(String name) {
        this.name = name;
    }
    

}
