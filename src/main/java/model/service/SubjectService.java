package model.service;

import model.entity.Subject;

import java.util.List;

public interface SubjectService {
    void create(Subject student);

    Subject findById(int id);

    List<Subject> findAll();

    void update(Subject entity);

    void delete(int id);
}
