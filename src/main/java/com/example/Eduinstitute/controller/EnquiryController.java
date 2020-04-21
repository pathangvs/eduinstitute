package com.example.Eduinstitute.controller;


import com.example.Eduinstitute.model.Enquiry;
import com.example.Eduinstitute.repositry.Enquiryrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EnquiryController {

    @Autowired
    Enquiryrepository enquiryrepository;

    @GetMapping("/newhome/contact/enquiry1")
    public String saveEnquiry(@Param("ename")String ename,@Param("equalification") String equalification,
                            @Param("enumber") String enumber, @Param("eemail")String eemail, @Param("cid")Long cid){
        Enquiry enquiry = new Enquiry();
        enquiry.setEname(ename);
        enquiry.setEqualification(equalification);
        enquiry.setEnumber(enumber);
        enquiry.setEemail(eemail);
        enquiry.setCid(cid);

        enquiryrepository.save(enquiry);
        return "Saved Successfully";
    }

    @PostMapping("/newhome/contact/enquiry")
    //@ResponseBody
    public String saveEnuiry1(@ModelAttribute Enquiry enquiry){
        enquiryrepository.save(enquiry);
        return "contact";
    }

    @GetMapping("/newhome/login/admin/enquirydetails")
    //@ResponseBody
    public String getEnquiry (Model model){
        model.addAttribute( "enquiry",enquiryrepository.findAll());
        return "enquirydetails";
    }

    @GetMapping("/delete/{eemail}")
    public String deleteEnquiry(Model model, @PathVariable("eemail") String mail){
        enquiryrepository.deleteById((mail));
        return "forward:/newhome/login/admin/enquirydetails";
    }

}
