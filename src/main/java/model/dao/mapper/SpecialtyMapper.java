package model.dao.mapper;

import model.entity.Specialty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class SpecialtyMapper implements ObjectMapper<Specialty> {
    @Override
    public Specialty extractFromResultSet(ResultSet rs) throws SQLException {
        Specialty specialty = new Specialty();
        specialty.setId(rs.getInt("specialty_id"));
        specialty.setTitle(rs.getString("title"));
        return specialty;
    }

    @Override
    public Specialty makeUnique(Map<Integer, Specialty> cache, Specialty specialty) {
        cache.putIfAbsent(specialty.getId(), specialty);
        return cache.get(specialty.getId());
    }
}
