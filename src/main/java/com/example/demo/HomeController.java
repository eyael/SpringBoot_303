package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

public class HomeController {
    @Autowired
    CourseRepository courseRepository;
    @RequestMapping("/")
    public String listJobs(Model model) {
        model.addAttribute("course", courseRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String jobForm(Model model){
        model.addAttribute("course", new Course());
        return "courseform";
    }
    @PostMapping("/process")
    public String processForm(@Valid Course course,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "courseform";
        }
        courseRepository.save(course);
        return "redirect:/";
    }

     @RequestMapping("/detail/{id}")
             public String showCourse(@PathVariable("id") long id, Model model)
     {
         model.addAttribute("course", CourseRepository.findOne(id))
     }

}
