package model.service;

import model.entity.Rating;

import java.util.List;

public interface RatingService {
    void create(Rating rating);

    Rating findById(int id);

    List<Rating> findAll();

    void update(Rating entity);

    void delete(int id);

    void setmark(Integer studentId, Integer subjectId, Integer assessment);
}

