package model.service;

import model.dao.daoimpl.DaoFactory;
import model.dao.daoimpl.SubjectDaoImpl;
import model.entity.Specialty;
import model.entity.Subject;
import model.service.impl.SubjectServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SubjectServiceTest {
    @InjectMocks
    private SubjectServiceImpl subjectService;
    @Mock
    private SubjectDaoImpl subjectDao;
    @Mock
    private DaoFactory daoFactory;
    private Subject subject;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        subject = new Subject(0,"name");
        when(daoFactory.createSubjectDao()).thenReturn(subjectDao);
        when(subjectDao.findById(0)).thenReturn(subject);
        when(subjectDao.findAll()).thenReturn(Collections.singletonList(subject));

    }

    @Test
    public void getById()  {
        Subject subjectServiceById = subjectService.findById(0);
        assertEquals(subject, subjectServiceById);
    }
    @Test
    public void getAll()  {
        List<Subject> subjectList = subjectService.findAll();
        assertEquals(subject, subjectList.get(0));
    }
    @Test
    public void create()  {
        Subject specialty = new Subject();
        specialty.setId(2);
        subjectService.create(specialty);
        verify(subjectDao, times(1)).create(specialty);
    }

    @Test
    public void update() {
        Specialty specialty = new Specialty();
        specialty.setId(2);
        subjectService.update(subject);
        verify(subjectDao, times(1)).update(subject);
    }

    @Test
    public void delete() {
        subjectService.delete(2);
        verify(subjectDao, times(1)).delete(2);
    }

}