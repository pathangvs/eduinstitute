package com.example.Eduinstitute.repositry;

import com.example.Eduinstitute.model.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Enquiryrepository extends JpaRepository<Enquiry,String>{
}