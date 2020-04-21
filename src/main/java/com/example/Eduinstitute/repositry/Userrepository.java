package com.example.Eduinstitute.repositry;

import com.example.Eduinstitute.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository <User,String>{
}
