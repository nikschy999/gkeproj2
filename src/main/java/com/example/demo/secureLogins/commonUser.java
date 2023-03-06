package com.example.demo.secureLogins;


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="commonuser")
public class commonUser {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="mobilenumber")
    private String mobileNumber;
    @Column(name="name")
    private String name;
    @Column(name="hashcode")
    private String hashCode;
    @Column(name="salt")
    private String Salt;

    public String getHashCode() {
        return this.hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public String getSalt() {
        return this.Salt;
    }

    public void setSalt(String Salt) {
        this.Salt = Salt;
    }

    public String getId() {
        return this.id;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}