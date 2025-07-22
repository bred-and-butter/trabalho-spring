package com.example.demo.DBEntities.Client;

import com.example.demo.DBEntities.Person.PersonId;
import com.example.demo.DBEntities.Person.Person;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@IdClass(PersonId.class)
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name = "cpf"),
        @PrimaryKeyJoinColumn(name = "cnpj")
})
@Table(name = "client")
public class Client extends Person {
    @Column(nullable = false)
    private Date register_date;

    //@OneToOne(cascade = CascadeType.ALL)

    private Person person;

    public Client (String cpf, String cnpj, String name, String email, String phone, String address, Date date, Person person) {
        super(cpf, cnpj, name, email, phone, address);
        this.register_date = date;
        this.person = person;
    }

}
