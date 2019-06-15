package model.service.impl;

import model.dao.SpecialtyDao;
import model.dao.daoimpl.DaoFactory;
import model.entity.Specialty;
import model.service.SpecialtyService;
import org.apache.log4j.Logger;

import java.util.List;

public class SpecialtyServiceImpl implements SpecialtyService {
    DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger logger = Logger.getLogger(SpecialtyServiceImpl.class);


    @Override
    public void create(Specialty specialty) {
        try (SpecialtyDao specialtyDao = daoFactory.createSpecialtyDao()) {
            specialtyDao.create(specialty);
            logger.info("Create specialty = %d");
        }
    }

    @Override
    public Specialty findById(int id) {
        try (SpecialtyDao specialtyDao = daoFactory.createSpecialtyDao()) {

            Specialty specialty = specialtyDao.findById(id);
            logger.info("Find specialty by id ");
            return specialty;
        }
    }

    @Override
    public List<Specialty> findAll() {
        try (SpecialtyDao specialtyDao = daoFactory.createSpecialtyDao()) {

            List<Specialty> specialties = specialtyDao.findAll();
            logger.info("Find all specialty ");
            return specialties;
        }
    }

    @Override
    public void update(Specialty entity) {
        try (SpecialtyDao specialtyDao = daoFactory.createSpecialtyDao()) {

            logger.info("Specialty update %d");
            specialtyDao.update(entity);
        }
    }

    @Override
    public void delete(int id) {
        try (SpecialtyDao specialtyDao = daoFactory.createSpecialtyDao()) {

            logger.info("delete specialty");
            specialtyDao.delete(id);
        }
    }
}
