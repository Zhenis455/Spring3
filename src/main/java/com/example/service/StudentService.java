package com.example.service;

import com.example.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final List<Student> storage = new ArrayList<>();
    private final AtomicLong seq = new AtomicLong(1);

    public List<Student> findAll(String q) {
        if (q == null || q.isBlank()) return storage;
        String s = q.toLowerCase();
        return storage.stream()
                .filter(st -> (st.getName()+" "+st.getSurname()).toLowerCase().contains(s))
                .collect(Collectors.toList());
    }

    public Student add(String name, String surname, int exam) {
        String mark = grade(exam);
        Student s = new Student(seq.getAndIncrement(), name, surname, exam, mark);
        storage.add(s);
        return s;
    }

    public Optional<Student> findById(Long id) {
        return storage.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    private String grade(int exam) {
        if (exam >= 90) return "A";
        if (exam >= 75) return "B";
        if (exam >= 60) return "C";
        if (exam >= 50) return "D";
        return "F";
    }
}
