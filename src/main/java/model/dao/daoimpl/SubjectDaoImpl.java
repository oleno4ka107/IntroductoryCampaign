package model.dao.daoimpl;

import model.dao.SubjectDao;
import model.dao.mapper.SubjectMapper;
import model.entity.Subject;
import org.apache.log4j.Logger;
import model.dao.queriesManager.QueriesResourceManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SubjectDaoImpl implements SubjectDao {
    private Logger logger = Logger.getLogger(SubjectDaoImpl.class);
    private Connection connection;

    public SubjectDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Subject entity) {
        try (PreparedStatement statement = connection.prepareStatement(QueriesResourceManager.getProperty("insert.subject"));
        ) {

            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.execute();
            logger.info("Subject create ");
        } catch (SQLException e) {
            logger.info("Subject was not created ", e);
        }


    }

    @Override
    public Subject findById(int id) {
        try (PreparedStatement statement = connection.prepareStatement(QueriesResourceManager.getProperty("subject.find.by.id"));
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Subject subject = null;
            if (resultSet.next()) {
                SubjectMapper subjectMapper = new SubjectMapper();
                subject = subjectMapper.extractFromResultSet(resultSet);
            }
            return subject;

        } catch (SQLException e) {
            logger.info("Subject do not find", e);
        }
        return null;
    }

    @Override
    public List<Subject> findAll() {
        try (PreparedStatement statement = connection.prepareStatement(QueriesResourceManager.getProperty("subject.find.all"));
        ) {
            ResultSet resultSet = statement.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while (resultSet.next()) {
                subjects.add(new SubjectMapper().extractFromResultSet(resultSet));

            }
            return subjects;

        } catch (SQLException e) {
            logger.error("Subject find all", e);
        }
        return null;
    }

    @Override
    public void update(Subject entity) {
        try (PreparedStatement statement = connection.prepareStatement(QueriesResourceManager.getProperty("subject.update"));
        ) {
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getId());
            statement.execute();
        } catch (SQLException e) {
            logger.error("Subject update ", e);
        }


    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(QueriesResourceManager.getProperty("subject.delete"));
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Subject delete ", e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error("Close ", e);
        }
    }
}