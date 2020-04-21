package com.example.Eduinstitute.repositry;

import com.example.Eduinstitute.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Courserepository extends JpaRepository <Course,Long>{
    //Jpql language
    @Query("select c from Course c where c.cflag=?1")
    List<Course> activecourses(String flag);


}
