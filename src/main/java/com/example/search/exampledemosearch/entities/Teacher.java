package com.example.search.exampledemosearch.entities;

import com.touchngo.abt.utils.entities.MasterEntity;
import lombok.Data;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Indexed
@Entity
@Table(name = "teacher")
public class Teacher extends MasterEntity {

    @Field(termVector = TermVector.YES)
    private String firstName;

    @Field(termVector = TermVector.YES)
    private String lastName;

    @Field(termVector = TermVector.YES)
    private Integer age;


}
