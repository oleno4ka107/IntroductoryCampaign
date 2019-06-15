package model.dao.mapper;

import model.entity.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class SubjectMapper implements ObjectMapper<Subject> {
    @Override
    public Subject extractFromResultSet(ResultSet rs) throws SQLException {
        Subject subject = new Subject();
        subject.setId(rs.getInt("subject_id"));
        subject.setName(rs.getString("name"));
        return subject;
    }

    @Override
    public Subject makeUnique(Map<Integer, Subject> cache, Subject subject) {
        cache.putIfAbsent(subject.getId(), subject);
        return cache.get(subject.getId());
    }
}
