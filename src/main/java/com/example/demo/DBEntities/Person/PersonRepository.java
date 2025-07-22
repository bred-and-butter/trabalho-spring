package com.example.demo.DBEntities.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, PersonId> {
    Person findByCpfAndCnpj(String cpf, String cnpj);
}
