package model.service;

import model.dao.StudentDao;
import model.dao.daoimpl.DaoFactory;
import model.dao.daoimpl.RatingDaoImpl;
import model.entity.Rating;
import model.entity.Student;
import model.service.impl.RatingServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RatingServiceTest {
    @InjectMocks
    private RatingServiceImpl ratingService;
    private Rating rating;
    private Student student;
    @Mock
    private RatingDaoImpl ratingDao;
    @Mock
    private DaoFactory daoFactory;
    @Mock
    private StudentDao studentDao;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        rating = new Rating(1, 2, 3);
        rating.setId(1);
        student = new Student();
        student.setId(3);
        when(ratingDao.findById(1)).thenReturn(rating);
        when(ratingDao.findAll()).thenReturn(Collections.singletonList(rating));

        when(daoFactory.createRatingDao()).thenReturn(ratingDao);
        when(daoFactory.createStudentDao()).thenReturn(studentDao);
        when(studentDao.findByEmail("email")).thenReturn(student);


    }


    @Test
    public void getById() {
        Rating ratingServiceById = ratingService.findById(1);

        assertEquals(rating, ratingServiceById);
    }

    @Test
    public void getAll() {
        List<Rating> ratingServiceById = ratingService.findAll();

        assertEquals(rating, ratingServiceById.get(0));
    }

    @Test
    public void create() {
        Rating rating = new Rating(1, 2, 3);
        rating.setId(2);

        ratingService.create(rating);

        verify(ratingDao, times(1)).create(rating);
    }

    @Test
    public void update() {
        Rating rating = new Rating(2, 2, 2);
        rating.setId(2);
        ratingService.update(rating);
        verify(ratingDao, times(1)).update(rating);
    }

    @Test
    public void delete() {
        ratingService.delete(2);
        verify(ratingDao, times(1)).delete(2);
    }

    @Test
    public void setmark() {
        ratingService.setmark(1, 1, 10);

        verify(studentDao, times(1)).findByEmail("email");


    }

}