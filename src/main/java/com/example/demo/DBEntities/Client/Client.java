package com.example.demo.DBEntities.Client;

import com.example.demo.DBEntities.Person.CPFCNPJId;
import com.example.demo.DBEntities.Person.Person;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@IdClass(CPFCNPJId.class)
@Table(name = "person")
public class Client extends Person {
    @Column(nullable = false)
    private Date register_date;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Client client;
}
