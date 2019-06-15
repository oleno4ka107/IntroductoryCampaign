package model.dao.mapper;

import model.entity.Rating;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class RatingMapper implements ObjectMapper<Rating> {
    @Override
    public Rating extractFromResultSet(ResultSet rs) throws SQLException {
        Rating rating = new Rating();
        rating.setId(rs.getInt("rating_id"));
        rating.setStudentId(rs.getInt("user_id"));
        rating.setSubjectId(rs.getInt("subject_id"));
        rating.setAssessment(rs.getInt("assessment"));
        return rating;
    }

    @Override
    public Rating makeUnique(Map<Integer, Rating> cache, Rating rating) {
        cache.putIfAbsent(rating.getId(), rating);
        return cache.get(rating.getId());
    }
}
