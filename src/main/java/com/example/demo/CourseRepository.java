package com.example.demo;


import org.springframework.data.repository.CrudRepository;

public class CourseRepository {
    public interface CourseRepository extends CrudRepository<Course,
            Long> {
    }

}

