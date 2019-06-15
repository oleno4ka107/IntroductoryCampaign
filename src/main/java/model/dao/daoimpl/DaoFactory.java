package model.dao.daoimpl;

import model.dao.RatingDao;
import model.dao.SpecialtyDao;
import model.dao.StudentDao;
import model.dao.SubjectDao;
import org.apache.log4j.Logger;

public abstract class DaoFactory {
    protected static Logger logger = Logger.getLogger(DaoFactory.class);
    private static DaoFactory daoFactory;

    public abstract StudentDao createStudentDao();

    public abstract RatingDao createRatingDao();

    public abstract SpecialtyDao createSpecialtyDao();

    public abstract SubjectDao createSubjectDao();

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }
        logger.info("dao factory");
        return daoFactory;
    }
}
