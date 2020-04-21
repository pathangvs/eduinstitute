package com.example.Eduinstitute.controller;

import com.example.Eduinstitute.model.Course;
import com.example.Eduinstitute.model.User;
import com.example.Eduinstitute.repositry.Courserepository;
import com.example.Eduinstitute.repositry.Userrepository;
import com.example.Eduinstitute.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class Usercontroller {

    @Autowired
    Userrepository userrepository;
    Userservice userservice;

    @PostMapping("/newhome/login/signup")
    //@ResponseBody
    public String saveUser1(@ModelAttribute User user) {
        user.setUid(Long.parseLong("1"));
        userrepository.save(user);
        return "login";
    }


//    @PostMapping("/newhome/signuppass")
//    //@ResponseBody
//    public String saveUser2(@ModelAttribute User user) {
//        userrepository.save(user);
//        return "login";
//    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

//    @GetMapping("/newhome")
//    public String home2() {
//        return "newhome";
//    }

    @GetMapping("/newhome/newcourse/contact")
    public String contact() { return "contact"; }

    @GetMapping("/newhome/newcourse/login")
    public String login() {
        return "login";
    }

    @GetMapping("/newhome/login/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/newhome/login/userhome")
    public String user(){
        return "userhome";
    }

    @GetMapping("/newhome/login/user/changepassword")
    public String changepassword(){
        return "changepassword";
    }

    @GetMapping("/newhome/login/forgotpassword")
    public String forgotpassword(){
        return "forgotpassword";
    }

    @GetMapping("/newhome/login/admin/userdetails")
    public String getUser(Model model){
        model.addAttribute( "user",userrepository.findAll());
        return "userdetails";
    }


    @GetMapping("/newhome/login/forgotpassword/{uemail}")
//updation display seems not to be working
    public  String forgetpassword(@PathVariable("uemail") Optional<String> mail, Model model) throws Exception
    {
        if (mail.isPresent()) {
            User entity = userservice.getUserById(mail.get());

            model.addAttribute("user", entity);
        } else {
            model.addAttribute("user", new User());
        }
        return "forgotpassword";
    }

//    @GetMapping("/test")
////    @ResponseBody
//    public String test(){
//        System.out.println("______________");
//        return "newhome" ;
//    }

//    @GetMapping("/delete/{uemail}")
//    public String deleteUser(Model model, @PathVariable("uemail") String mail) {
//        userrepository.deleteById((mail));
//        return "forward:/newhome/login/admin/enquirydetails";
//    }
}
