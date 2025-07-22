package com.example.demo.DBEntities.Person;

import com.example.demo.DBEntities.Client.Client;
import com.example.demo.DBEntities.Employee.Employee;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@IdClass(PersonId.class)
@Table(name = "person")
public class Person implements Serializable {
    @Id
    private String cpf;
    @Id
    private String cnpj;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String address;

    //@OneToOne
    //@MapsId
    //@JoinColumn(name = "client_id")
    private Client client;

    //@OneToOne
    //@MapsId
    //@JoinColumn(name = "employee_id")
    private Employee employee;

    public Person (String cpf, String cnpj, String name, String email, String phone, String address) {
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}
    public void setAddress(String address) {this.address = address;}

    public String getAddress() {return address;}
    public void setPhone(String phone) {this.phone = phone;}
}
