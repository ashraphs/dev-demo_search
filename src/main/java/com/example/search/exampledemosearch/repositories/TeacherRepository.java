package com.example.search.exampledemosearch.repositories;

import com.example.search.exampledemosearch.entities.Teacher;

import java.util.List;

public interface TeacherRepository extends MasterEntityRepository<Teacher> {

    List<Teacher> findByFirstNameOrLastName(String firstName, String lastName);

}
