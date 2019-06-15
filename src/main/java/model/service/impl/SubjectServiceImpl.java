package model.service.impl;

import model.dao.SubjectDao;
import model.dao.daoimpl.DaoFactory;
import model.entity.Subject;
import model.service.SubjectService;
import org.apache.log4j.Logger;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger logger = Logger.getLogger(SubjectServiceImpl.class);


    @Override
    public void create(Subject subject) {
        try (SubjectDao subjectDao = daoFactory.createSubjectDao()) {
            subjectDao.create(subject);
            logger.info("Create subject ");
        }
    }

    @Override
    public Subject findById(int id) {
        try (SubjectDao subjectDao = daoFactory.createSubjectDao()) {
            Subject subject = subjectDao.findById(id);
            logger.info("Find subject by id ");
            return subject;
        }
    }

    @Override
    public List<Subject> findAll() {
        try (SubjectDao subjectDao = daoFactory.createSubjectDao()) {
            List<Subject> subjects = subjectDao.findAll();
            logger.info("Find subject all ");

            return subjects;
        }
    }

    @Override
    public void update(Subject entity) {
        try (SubjectDao subjectDao = daoFactory.createSubjectDao()) {
            subjectDao.update(entity);
            logger.info("Subject update");

        }
    }

    @Override
    public void delete(int id) {
        try (SubjectDao subjectDao = daoFactory.createSubjectDao()) {
            subjectDao.delete(id);
            logger.info("Subject delete");
        }
    }
}
