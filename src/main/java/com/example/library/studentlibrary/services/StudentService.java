package com.example.library.studentlibrary.services;

import com.example.library.studentlibrary.models.Card;
import com.example.library.studentlibrary.models.Student;
import com.example.library.studentlibrary.repositories.CardRepository;
import com.example.library.studentlibrary.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {


    @Autowired
    CardService cardService4;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    StudentRepository studentRepository4;

    public Student getDetailsByEmail(String email) {
        Student student = studentRepository4.findByEmailId(email);

        return student;
    }

    public Student getDetailsById(int id) {
        Student student1 = studentRepository4.findById(id).get();

        return student1;
    }

    public void createStudent(Student student) {
        studentRepository4.save(student);
    }

    public void updateStudent(Student student) {
        studentRepository4.updateStudentDetails(student);
    }


    public void deleteStudent(int id) {
        studentRepository4.deleteById(id);
        cardService4.deactivateCard(id);
    }
}