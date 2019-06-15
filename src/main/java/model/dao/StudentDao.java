package model.dao;

import model.entity.Student;

import java.util.List;


public interface StudentDao extends GenericDao<Student> {
    Student getByLoginAndPass(String login, String password);

    void setSumMarks(Student student);

    Student findByEmail(String email);

    void setSpecialty(Integer specialtyId, Student student);

    List<Student> findReceivedStudents(Integer specialtyId);
}
