package com.example.Eduinstitute.service;

import com.example.Eduinstitute.model.Course;
import com.example.Eduinstitute.model.User;
import com.example.Eduinstitute.repositry.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Userservice {

    @Autowired
    Userrepository userrepository;

    public User getUserById(String uemail) throws Exception {
        Optional<User> user = userrepository.findById(uemail);
        {
            if (user.isPresent())

                return user.get();
        }
        return new User();
    }
}
