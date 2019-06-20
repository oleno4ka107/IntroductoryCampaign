//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package model.dao.daoimpl;

import model.dao.RatingDao;
import model.dao.mapper.RatingMapper;
import model.entity.Rating;
import org.apache.log4j.Logger;
import model.dao.queriesManager.QueriesResourceManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RatingDaoImpl implements RatingDao {
    private Logger logger = Logger.getLogger(RatingDaoImpl.class);
    private Connection connection;

    public RatingDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public void create(Rating entity) {
        try (PreparedStatement statement = connection.prepareStatement(QueriesResourceManager.getProperty("insert.rating"))) {
            statement.setInt(1, entity.getAssessment());
            statement.setInt(2, entity.getSubjectId());
            statement.setInt(3, entity.getSubjectId());
            statement.execute();

        } catch (SQLException var3) {
            this.logger.info(" Rating do not create", var3);
        }

    }

    public Rating findById(int id) {
        try (PreparedStatement statement = connection.prepareStatement(QueriesResourceManager.getProperty("rating.find.by.id"))) {
            Rating rating = null;
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                RatingMapper ratingMapper = new RatingMapper();
                rating = ratingMapper.extractFromResultSet(resultSet);
            }

            return rating;
        } catch (SQLException var6) {
            logger.info("Rating do not find by id ", var6);
            return null;
        }
    }

    public List<Rating> findAll() {
        try (PreparedStatement statement = connection.prepareStatement(QueriesResourceManager.getProperty("rating.find.all"))) {
            ResultSet resultSet = statement.executeQuery();
            ArrayList ratings = new ArrayList();

            while (resultSet.next()) {
                ratings.add((new RatingMapper()).extractFromResultSet(resultSet));
            }

            return ratings;
        } catch (SQLException var4) {
            logger.info("Cannot find All", var4);
            return null;
        }
    }

    public void update(Rating entity) {
        try (PreparedStatement statement = connection.prepareStatement(QueriesResourceManager.getProperty("rating.update"))) {
            statement.setInt(1, entity.getAssessment());
            statement.setInt(2, entity.getSubjectId());
            statement.setInt(3, entity.getStudentId());
            statement.setInt(4, entity.getId());
            statement.execute();

        } catch (SQLException var3) {
            logger.info("Rating do not update E", var3);
        }

    }

    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(QueriesResourceManager.getProperty("rating.delete"))) {
            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException var3) {
            logger.info("Rating don`t delete ");
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
