package com.example.Eduinstitute.service;

import com.example.Eduinstitute.model.Course;
import com.example.Eduinstitute.repositry.Courserepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Courseservice {

    @Autowired
    Courserepository courserepository;

    public Course getCourseById(Long cid) throws Exception {
        Optional<Course> course = courserepository.findById(cid);
        {
            if (course.isPresent())

                return course.get();
        }
        return new Course();
    }

//    public Course getCourseByflag(Long cflag) throws Exception {
//        Optional<Course> course = courserepository.findById(cflag);
//        {
//            if (course.isPresent())
//
//                return course.get();
//        }
//        return new Course();
//    }

    public Course updateCourse(Course course)
    {
        if(course.getCid()  == null)
        {
            course = courserepository.save(course);

            return course;
        }
        else
        {
            Optional<Course> employee = courserepository.findById(course.getCid());

            if(employee.isPresent())
            {
                Course cnewcourse= employee.get();
                cnewcourse.setConame(course.getConame());
                cnewcourse.setCsdate(course.getCsdate());
                cnewcourse.setCduration(course.getCduration());
                cnewcourse.setCid(course.getCid());

                cnewcourse = courserepository.save(cnewcourse);

                return cnewcourse;
            } else {
                course = courserepository.save(course);

                return course;
            }
        }
    }

    public List<Course> getActiveCourse() {
        return courserepository.activecourses("1");

    }
}