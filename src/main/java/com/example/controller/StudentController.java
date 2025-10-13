package com.example.controller;

import com.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) { this.service = service; }

    @GetMapping
    public String list(@RequestParam(required = false) String q, Model model) {
        model.addAttribute("students", service.findAll(q));
        model.addAttribute("q", q == null ? "" : q);
        return "students/list";
    }

    @GetMapping("/new")
    public String newForm() { return "students/new"; }

    @PostMapping
    public String create(@RequestParam String name,
                         @RequestParam String surname,
                         @RequestParam int exam) {
        service.add(name, surname, exam); // оценка проставится автоматически
        return "redirect:/students";
    }
}
