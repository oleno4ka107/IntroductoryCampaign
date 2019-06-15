package model.service.impl;

import model.dao.StudentDao;
import model.dao.daoimpl.DaoFactory;
import model.dao.daoimpl.StudentDaoImpl;
import model.entity.Student;
import model.service.StudentService;
import org.apache.log4j.Logger;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger logger = Logger.getLogger(StudentDaoImpl.class);


    @Override
    public void create(Student student) {
        try (StudentDao studentDao = daoFactory.createStudentDao()) {

            studentDao.create(student);
            logger.info("Create user = %d");
        }
    }

    @Override
    public Student findById(int id) {
        try (StudentDao studentDao = daoFactory.createStudentDao()) {
            Student student = studentDao.findById(id);
            logger.info("Find student by id ");
            return student;
        }
    }


    @Override
    public List<Student> findAll() {
        try (StudentDao studentDao = daoFactory.createStudentDao()) {

            List<Student> students = studentDao.findAll();
            logger.info("Find all students ");

            return students;
        }
    }

    @Override
    public void update(Student entity) {
        try (StudentDao studentDao = daoFactory.createStudentDao()) {

            logger.info("User update %d");
            studentDao.update(entity);

        }
    }

    @Override
    public void delete(int id) {
        try (StudentDao studentDao = daoFactory.createStudentDao()) {

            logger.info("delece user");
            studentDao.delete(id);
        }
    }

    @Override
    public void setMarks(Student student) {
        try (StudentDao studentDao = daoFactory.createStudentDao()) {

            logger.info("set marks");
            studentDao.setSumMarks(student);
        }
    }

    @Override
    public Student findByEmail(String email) {
        try (StudentDao studentDao = daoFactory.createStudentDao()) {

            logger.info("find email");
            Student student = studentDao.findByEmail(email);
            return student;
        }
    }

    @Override
    public Student loginUser(String login, String password) {
        try (StudentDao studentDao = daoFactory.createStudentDao()) {

            logger.info("get Login and password");
            Student student = studentDao.getByLoginAndPass(login, password);

            return student;
        }
    }

    @Override
    public void setSpecialty(Integer specialtyId, Student student) {
        try (StudentDao studentDao = daoFactory.createStudentDao()) {

            logger.info("set specialty to user");
            studentDao.setSpecialty(specialtyId, student);
        }
    }

    @Override
    public List<Student> receivedStudents(Integer specialtyId) {
        try (StudentDao studentDao = daoFactory.createStudentDao()) {

            logger.info("received students list");
            return studentDao.findReceivedStudents(specialtyId);
        }
    }


}
