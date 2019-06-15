package model.service;

import model.entity.Specialty;

import java.util.List;

public interface SpecialtyService {
    void create(Specialty specialty);

    Specialty findById(int id);

    List<Specialty> findAll();

    void update(Specialty entity);

    void delete(int id);


}
