package model.dao.daoimpl;

import model.dao.SpecialtyDao;
import model.dao.mapper.SpecialtyMapper;
import model.entity.Specialty;
import org.apache.log4j.Logger;
import model.dao.queriesManager.QueriesResourceManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialtyDaoImpl implements SpecialtyDao {
    private Logger logger = Logger.getLogger(SpecialtyDaoImpl.class);
    private Connection connection;

    public SpecialtyDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Specialty entity) {
        try (PreparedStatement statement = connection.prepareStatement(QueriesResourceManager.getProperty("insert.specialty"))
        ) {
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getTitle());
            statement.execute();

        } catch (SQLException e) {
            logger.error("Specialty don`t create ", e);
        }
    }

    @Override
    public Specialty findById(int id) {
        try (PreparedStatement statement = connection.prepareStatement(QueriesResourceManager.getProperty("specialty.find.by.id"))
        ) {
            Specialty specialty = null;
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                SpecialtyMapper specialtyMapper = new SpecialtyMapper();
                specialty = specialtyMapper.extractFromResultSet(resultSet);
            }

            return specialty;
        } catch (SQLException e) {
            logger.error("Cannot find Specialty by id $d", e);
        }
        return null;
    }

    @Override
    public List<Specialty> findAll() {
        try (PreparedStatement statement = connection.prepareStatement(QueriesResourceManager.getProperty("specialty.find.all"))
        ) {
            ResultSet resultSet = statement.executeQuery();
            List<Specialty> specialties = new ArrayList<>();
            while (resultSet.next()) {
                specialties.add(new SpecialtyMapper().extractFromResultSet(resultSet));
            }

            return specialties;

        } catch (SQLException e) {
            logger.error("Find all specialty error", e);
        }
        return null;
    }

    @Override
    public void update(Specialty entity) {
        try (PreparedStatement statement = connection.prepareStatement(QueriesResourceManager.getProperty("specialty.update"))
        ) {
            statement.setString(1, entity.getTitle());
            statement.setInt(2, entity.getId());
            statement.execute();

        } catch (SQLException e) {
            logger.error("update", e);
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(QueriesResourceManager.getProperty("specialty.delete"))
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            logger.error("delete", e);
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
