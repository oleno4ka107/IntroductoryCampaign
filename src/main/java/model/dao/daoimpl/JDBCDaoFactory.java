package model.dao.daoimpl;

import model.dao.RatingDao;
import model.dao.SpecialtyDao;
import model.dao.StudentDao;
import model.dao.SubjectDao;
import model.dao.connectionpool.ConnectionPool;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    private static Logger logger = Logger.getLogger(JDBCDaoFactory.class);
    private DataSource dataSource = ConnectionPool.getDataSource();

    @Override
    public StudentDao createStudentDao() {
        return new StudentDaoImpl(getConnection());
    }

    @Override
    public RatingDao createRatingDao() {
        return new RatingDaoImpl(getConnection());
    }

    @Override
    public SpecialtyDao createSpecialtyDao() {
        return new SpecialtyDaoImpl(getConnection());
    }

    @Override
    public SubjectDao createSubjectDao() {
        return new SubjectDaoImpl(getConnection());
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException ex) {
            logger.error("Failed establishing connection to database", ex);
            throw new RuntimeException(ex);
        }
    }
}
