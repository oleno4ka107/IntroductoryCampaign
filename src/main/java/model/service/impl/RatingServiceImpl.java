package model.service.impl;

import model.dao.RatingDao;
import model.dao.StudentDao;
import model.dao.daoimpl.DaoFactory;
import model.entity.Rating;
import model.entity.Student;
import model.service.RatingService;
import org.apache.log4j.Logger;

import java.util.List;

public class RatingServiceImpl implements RatingService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger logger = Logger.getLogger(RatingServiceImpl.class);


    @Override
    public void create(Rating rating) {
        try (RatingDao ratingDao = daoFactory.createRatingDao()) {
            ratingDao.create(rating);
            logger.info("Rating user = %d");
        }
    }

    @Override
    public Rating findById(int id) {
        try (RatingDao ratingDao = daoFactory.createRatingDao()) {
            Rating rating = ratingDao.findById(id);
            logger.info("Find rating by id ");
            return rating;
        }
    }

    @Override
    public List<Rating> findAll() {
        try (RatingDao ratingDao = daoFactory.createRatingDao()) {
            List<Rating> ratings = ratingDao.findAll();
            logger.info("Find all ratings ");

            return ratings;
        }
    }

    @Override
    public void update(Rating entity) {
        try (RatingDao ratingDao = daoFactory.createRatingDao()) {
            logger.info("Rating update %d");
            ratingDao.update(entity);
        }
    }

    @Override
    public void delete(int id) {
        try (RatingDao ratingDao = daoFactory.createRatingDao()) {
            logger.info("delece rating");
            ratingDao.delete(id);
        }
    }

    @Override
    public void setmark(Integer studentId, Integer subjectId, Integer assessment) {
        try (RatingDao ratingDao = daoFactory.createRatingDao();
             StudentDao studentDao = daoFactory.createStudentDao()) {
            Student student = studentDao.findById(studentId);
            Rating rating = new Rating(assessment, subjectId, student.getId());
            ratingDao.create(rating);
            logger.info("set marks");
        }
    }
}
