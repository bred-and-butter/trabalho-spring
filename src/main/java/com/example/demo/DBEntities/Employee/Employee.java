package com.example.demo.DBEntities.Employee;

import com.example.demo.DBEntities.Person.Person;
import com.example.demo.DBEntities.Person.PersonId;
import jakarta.persistence.*;

@Entity
@IdClass(PersonId.class)
@Table(name = "employee")
public class Employee extends Person {
    @Column(nullable = false)
    private String work_position;

    private String area_of_activity;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean active = true;

    //@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Person person;

    public Employee(String cpf, String cnpj, String name, String email, String phone, String address, String work_position,
                    String area_of_activity, String password, Boolean active, Person person) {
        super(cpf, cnpj, name, email, phone, address);
        this.work_position = work_position;
        this.area_of_activity = area_of_activity;
        this.password = password;
        this.active = active;
        this.person = person;
    }

    public String getWork_position() {
        return work_position;
    }
    public void setWork_position(String work_position) {
        this.work_position = work_position;
    }

    public String getArea_of_activity() {
        return area_of_activity;
    }
    public void setArea_of_activity(String area_of_activity) {
        this.area_of_activity = area_of_activity;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
}