package com.rajeev.springbootjpaexample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.JoinColumn;

// import javax.persistence.CascadeType;
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.EnumType;
// import javax.persistence.Enumerated;
// // import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.JoinTable;
// import javax.persistence.ManyToMany;
// // import javax.persistence.NamedQueries;
// import javax.persistence.NamedQuery;
// import javax.persistence.OneToMany;
// import javax.persistence.OneToOne;
// import javax.persistence.Table;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;
// // import javax.persistence.Transient;

@Entity
@Table(name = "EMPLOYEE_DATA")
@NamedQuery(query = "select e from Employee e where e.age>=:minage order by e.name",name = "emp name and age asc")
@NamedQuery(query = "select e from Employee e order by e.name",name = "emp name asc")
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    // @Transient
    private int age;
    @Column(unique = true)
    private String ssn;
    @Column(name = "employee_name")
    private String name;
    @Temporal(TemporalType.TIME)
    private Date dob;
    
    // @Enumerated(EnumType.ORDINAL)
    @Enumerated(EnumType.STRING)
    private EmployeeType type;
    
    // @OneToOne(fetch = FetchType.EAGER)
    //By default fetchtype is eager that means whether we fetch or use  the access card details obj or not it sql query runs
    //LAZY IT will fetch data on demand if not use it will not fetch Access card details
    // @OneToOne(fetch = FetchType.LAZY)
    @OneToOne
    private AccessCard card;

    //1:1 eager by default
    //1:M lazy by default
    @OneToMany(mappedBy = "employee",cascade = CascadeType.REMOVE)
    private List<PayStub> payStubs = new ArrayList<>();
   @ManyToMany
   @JoinTable(name = "EMAIL_GROUP_SUBSCRIPTIONS",
       joinColumns = @JoinColumn(name="EMPLOYEE_ID"),
        inverseJoinColumns = @JoinColumn(name="SUBSCRIPTION_EMAIL_ID")
     )
    
    private List<EmailGroup> emailGroups = new ArrayList<>();
    public void addEmailGroups(EmailGroup emailGroup){
        this.emailGroups.add(emailGroup);
    } 

    public List<EmailGroup> getEmailGroups() {
        return emailGroups;
    }

    public void setEmailGroups(List<EmailGroup> emailGroups) {
        this.emailGroups = emailGroups;
    }

    public void addPayStub(PayStub payStub){
         this.payStubs.add(payStub);
    }

    public List<PayStub> getPayStubs() {
        return payStubs;
    }

    public void setPayStubs(List<PayStub> payStubs) {
        this.payStubs = payStubs;
    }

    public Employee(int age, String ssn, String name, Date dob, EmployeeType type) {
        this.age = age;
        this.ssn = ssn;
        this.name = name;
        this.dob = dob;
        this.type = type;
    }

    public Employee() {
    }

    public Employee(int age, String ssn, String name, Date dob, EmployeeType type, AccessCard card) {
        this.age = age;
        this.ssn = ssn;
        this.name = name;
        this.dob = dob;
        this.type = type;
        this.card = card;
    }

    @Override
    public String toString() {
        return "Employee [age=" + age + ", card=" + card + ", dob=" + dob + ", id=" + id + ", name=" + name + ", ssn="
                + ssn + ", type=" + type + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public AccessCard getCard() {
        return card;
    }

    public void setCard(AccessCard card) {
        this.card = card;
    }
    
   
  



   

}
