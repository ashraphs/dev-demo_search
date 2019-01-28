package com.example.search.exampledemosearch.controllers;

import com.example.search.exampledemosearch.entities.Teacher;
import com.example.search.exampledemosearch.repositories.TeacherRepository;
import com.example.search.exampledemosearch.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SearchService searchService;

    /**
     * Using JPA Query to search the field
     *
     * @param name
     * @return
     */
    @GetMapping("/teacher/{name}")
    public ResponseEntity<Object> findTeacherNameUsingJpaQuery(@PathVariable("name") final String name) {

        if (name == null)
            return ResponseEntity.badRequest().build();

        List<Teacher> teacherList = teacherRepository.findByFirstNameOrLastName(name, name);
        return ResponseEntity.ok(teacherList);
    }

    /**
     * Using Hibernate Search to search the field name
     *
     * @param name
     * @return
     */
    @GetMapping("/teacher/search/{name}")
    public ResponseEntity<Object> findTeacherNameUsingHibernateSearch(@PathVariable("name") final String name) {

        return ResponseEntity.ok(searchService.searchTeacher(name));
    }

    @PostMapping("/teacher")
    public ResponseEntity<Object> addVehicle(@RequestBody Teacher request) {

        if (request == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Teacher newTeacher = new Teacher();
        newTeacher.setFirstName(request.getFirstName());
        newTeacher.setLastName(request.getLastName());
        newTeacher.setAge(request.getAge());
        newTeacher = teacherRepository.save(newTeacher);

        return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
    }


}
