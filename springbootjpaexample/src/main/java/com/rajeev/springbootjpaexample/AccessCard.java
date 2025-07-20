package com.rajeev.springbootjpaexample;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.OneToOne;



@Entity
public class AccessCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date issueDate;
    private boolean isActive;
    private String firmwareVersion;
    @OneToOne(mappedBy = "card")
    // @OneToOne
    private Employee owner;
    
    public AccessCard() {
    }

    public AccessCard(Date issueDate, boolean isActive, String firmwareVersion, Employee owner) {
        this.issueDate = issueDate;
        this.isActive = isActive;
        this.firmwareVersion = firmwareVersion;
        this.owner = owner;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

  
    public AccessCard(Date issueDate, boolean isActive, String firmwareVersion) {
        this.issueDate = issueDate;
        this.isActive = isActive;
        this.firmwareVersion = firmwareVersion;
    }

 
    

    @Override
    public String toString() {
        return "AccessCard [firmwareVersion=" + firmwareVersion + ", id=" + id + ", isActive=" + isActive
                + ", issueDate=" + issueDate + "]";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public String getFirmwareVersion() {
        return firmwareVersion;
    }
    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }
    

}
