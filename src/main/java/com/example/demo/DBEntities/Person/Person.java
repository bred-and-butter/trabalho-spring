package com.example.demo.DBEntities.Person;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
abstract public class Person {
    @EmbeddedId
    private PersonId id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String address;

    public Person (PersonId id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public PersonId getId() {return id;}
    public void setId(PersonId id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}
    public void setAddress(String address) {this.address = address;}

    public String getAddress() {return address;}
    public void setPhone(String phone) {this.phone = phone;}
}
