package model.service;

import model.dao.daoimpl.DaoFactory;
import model.dao.daoimpl.SpecialtyDaoImpl;
import model.entity.Specialty;
import model.service.impl.SpecialtyServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpecialtyServiceTest {
    @InjectMocks
    private SpecialtyServiceImpl specialtyService;
    @Mock
    private SpecialtyDaoImpl specialtyDao;
    @Mock
    private DaoFactory daoFactory;
    private Specialty specialty;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        specialty = new Specialty(0, "name");
        when(daoFactory.createSpecialtyDao()).thenReturn(specialtyDao);
        when(specialtyDao.findById(0)).thenReturn(specialty);
        when(specialtyDao.findAll()).thenReturn(Collections.singletonList(specialty));

    }

    @Test
    public void getById() {
        Specialty specialtyServiceById = specialtyService.findById(0);
        assertEquals(specialty, specialtyServiceById);
    }

    @Test
    public void getAll() {
        List<Specialty> specialtyList = specialtyService.findAll();
        assertEquals(specialty, specialtyList.get(0));
    }

    @Test
    public void create() {
        Specialty specialty = new Specialty();
        specialty.setId(2);
        specialtyService.create(specialty);
        verify(specialtyDao, times(1)).create(specialty);
    }

    @Test
    public void update() {
        Specialty specialty = new Specialty();
        specialty.setId(2);
        specialtyService.update(specialty);
        verify(specialtyDao, times(1)).update(specialty);
    }

    @Test
    public void delete() {
        specialtyService.delete(2);
        verify(specialtyDao, times(1)).delete(2);
    }
}