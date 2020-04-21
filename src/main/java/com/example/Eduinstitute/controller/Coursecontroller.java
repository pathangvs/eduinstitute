package com.example.Eduinstitute.controller;

import com.example.Eduinstitute.model.Course;
import com.example.Eduinstitute.repositry.Courserepository;
import com.example.Eduinstitute.service.Courseservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class Coursecontroller {

    @Autowired
    Courserepository courserepository;

    @Autowired
    Courseservice courseservice;

    @GetMapping("/newhome/login/admin1")
    //@ResponseBody
    public String saveCourse (@Param("cid") Long cid,@Param("coname") String coname,@Param("cduration") String cduration,@Param("csdate") String csdate,@Param("cbrief")String cbrief,@Param("cdetail") String cdetail,@Param("cflag")String cflag){

        Course course= new Course();
        course.setCid(cid);
        course.setConame(coname);
        course.setCduration(cduration);
        course.setCsdate(csdate);
        course.setCbrief(cbrief);
        course.setCdetail(cdetail);
        course.setCflag(cflag);

        courserepository.save(course);
        return "Entered Successfully ";
    }

    @PostMapping("/newhome/login/admin")
    //@ResponseBody
    public String saveCourse1(@ModelAttribute Course course){
        courserepository.save(course);
        return "admin";
    }

    @PostMapping("/newhome/login/admin2")
    //@ResponseBody
    public String saveCourse2(@ModelAttribute Course course){
        courserepository.save(course);
        return "coursedetails";
    }

    @GetMapping("/newhome/login/admin/coursedetails")
    //@ResponseBody
    public String getCourse (Model model){
        model.addAttribute( "course",courserepository.findAll());
        return "coursedetails";
    }

    @GetMapping("/newhome/newcourse")
    //@ResponseBody
    public String getCourse1 (Model model){
        List entity=courseservice.getActiveCourse();
        model.addAttribute("activecourse",entity);
        return "newcourse";
    }

    @GetMapping("/newhome")
    //@ResponseBody
    public String getCourse2 (Model model) throws Exception{
        List entity=courseservice.getActiveCourse();
        model.addAttribute("activecourse",entity);
        return "newhome";
    }
//    @GetMapping("/home/login/admin/coursedetail/{cid}")
//    public String getcoursedetails(Model model, @PathVariable("cid") String id){
//        Optional<Course> c = courserepository.findById(Long.parseLong(id));
//        if(c.isPresent()){
//            model.addAttribute("coursedetail",c.get());
//        }
//        return "coursedetail";
//    }

    @GetMapping("/delete/{cid}")
    public String deletecourse(Model model, @PathVariable("cid") String id){
        courserepository.deleteById(Long.parseLong(id));
        return "forward:/newhome/login/admin/coursedetails";
    }

    @RequestMapping(path = {"/newhome/login/admin/coursedetail/{cid}"})
    public String updateCourse(Model model, @PathVariable("cid") Optional<Long> cid) throws Exception {
        if (cid.isPresent()) {
            Course entity = courseservice.getCourseById(cid.get());
            model.addAttribute("course", entity);
        } else {
            model.addAttribute("course", new Course());
        }
        return "coursedetail";
    }

//    @RequestMapping(path = {"/newhome/newcourse/contact/{cid}"})
//    public String getCourses(Model model, @PathVariable("cid") Optional<Long> cid) throws Exception {
//        if (cid.isPresent()) {
//            Course entity = courseservice.getCourseById(cid.get());
//            model.addAttribute("course", entity);
//        } else {
//            model.addAttribute("course", new Course());
//        }
//        return "/newhome/newcourse/contact";
//    }



    @GetMapping("/newhome/login/admin/activecourse")
    public String activecourse( Model model) throws Exception    {
        // List<Course> entity=service.getAllCourses();
        ///   List entity=service.getCourseBycflag();
        // Course course1=new Course();
        //List<Course> list=courserepository.findAll();

        // Course cnewcourse= list.getClass();
        //if(list.contains(course1.getCflag()))

        List entity=courseservice.getActiveCourse();

        model.addAttribute("activecourse",entity);
        return "activecourse";
    }


    @GetMapping("/newhome/login/admin/coursedetail/activate/{cid}")
    public String activate(@PathVariable ("cid") Optional<Long> id) throws Exception{
        if (id.isPresent()) {
            Course entity = courseservice.getCourseById(id.get());
            // entity.setCflag(Long.parseLong("1"));
            entity.setCflag(("1"));
            courserepository.save(entity);
            return "forward:/newhome/login/admin/coursedetails";
        }
        else
            return "sorry this course is not activated";
    }

    @GetMapping("/newhome/login/admin/coursedetail/deactivate/{cid}")
    public String deactivate(@PathVariable ("cid") Optional<Long> id) throws Exception{
        if (id.isPresent()) {
            Course entity = courseservice.getCourseById(id.get());
            //entity.setCflag(Long.parseLong("0"));
            entity.setCflag((""));
            courserepository.save(entity);
            return "forward:/newhome/login/admin/coursedetails";
        }
        else
            return "sorry this course is not deactivated";
    }
}
