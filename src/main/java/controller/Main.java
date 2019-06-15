package controller;

import model.service.StudentService;
import model.service.impl.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        System.out.println(studentService.findById(49));
    }
}
