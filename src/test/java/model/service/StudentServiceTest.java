package model.service;

import model.dao.daoimpl.DaoFactory;
import model.dao.daoimpl.StudentDaoImpl;
import model.entity.Student;
import model.service.impl.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class StudentServiceTest {
    @InjectMocks
    private StudentServiceImpl studentService;
    @Mock
    private StudentDaoImpl studentDao;
    @Mock
    private DaoFactory daoFactory;

    private Student student;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        student = new Student();
        student.setId(0);
        when(daoFactory.createStudentDao()).thenReturn(studentDao);
        when(studentDao.findById(0)).thenReturn(student);
        when(studentDao.findAll()).thenReturn(Collections.singletonList(student));
        when(studentDao.findByEmail("email")).thenReturn(student);
        when(studentDao.getByLoginAndPass("login", "password")).thenReturn(student);
        when(studentDao.findReceivedStudents(1)).thenReturn(Collections.singletonList(student));
    }

    @Test
    public void create() {
        Student student = new Student();
        student.setId(2);
        studentService.create(student);
        verify(studentDao, times(1)).create(student);
    }


    @Test
    public void findById() {
        Student studentServiceById = studentService.findById(0);
        assertEquals(student, studentServiceById);
    }

    @Test
    public void findAll() {
        List<Student> studentList = studentService.findAll();
        assertEquals(student, studentList.get(0));
    }

    @Test
    public void update() {
        Student student = new Student();
        student.setId(2);
        studentService.update(student);
        verify(studentDao, times(1)).update(student);
    }

    @Test
    public void delete() {
        studentService.delete(2);
        verify(studentDao, times(1)).delete(2);
    }

    @Test
    public void setMarks() {
        studentService.setMarks(student);
        verify(studentDao, times(1)).setSumMarks(student);

    }

    @Test
    public void findByEmail() {
        Student findStudent = studentService.findByEmail("email");
        verify(studentDao, times(1)).findByEmail("email");
        assertEquals(student, findStudent);
    }

    @Test
    public void loginUser() {
        Student student = studentService.loginUser("login", "password");
        verify(studentDao, times(1)).getByLoginAndPass("login", "password");
        assertEquals(student, this.student);
    }

    @Test
    public void setSpecialty() {
        studentService.setSpecialty(1, student);
        verify(studentDao, times(1)).setSpecialty(1, student);
    }

    @Test
    public void receivedStudents() {
        List<Student> studentList = studentService.receivedStudents(1);
        verify(studentDao, times(1)).findReceivedStudents(1);
        assertEquals(student, studentList.get(0));
    }
}