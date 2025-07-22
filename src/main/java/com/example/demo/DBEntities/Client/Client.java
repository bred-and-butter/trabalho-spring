package com.example.demo.DBEntities.Client;

import com.example.demo.DBEntities.Person.PersonId;
import com.example.demo.DBEntities.Person.Person;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@IdClass(PersonId.class)
@Table(name = "person")
public class Client extends Person {
    @Column(nullable = false)
    private Date register_date;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Person person;

    public Client (PersonId id, String name, String email, String phone, String address, Date date, Person person) {
        super(id, name, email, phone, address);
        this.register_date = date;
        this.person = person;
    }

}
