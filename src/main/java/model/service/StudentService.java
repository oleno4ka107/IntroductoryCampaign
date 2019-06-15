package model.service;

import model.entity.Student;

import java.util.List;

public interface StudentService {
    void create(Student student);

    Student findById(int id);

    List<Student> findAll();

    void update(Student entity);

    void delete(int id);

    void setMarks(Student student);

    Student findByEmail(String email);

    Student loginUser(String login, String password);

    void setSpecialty(Integer specialtyId, Student student);

    List<Student> receivedStudents(Integer specialtyId);

}
