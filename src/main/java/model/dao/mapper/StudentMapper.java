package model.dao.mapper;

import model.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class StudentMapper implements ObjectMapper<Student> {
    @Override
    public Student extractFromResultSet(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("user_id"));
        student.setNameUa(rs.getString("user_name_ua"));
        student.setNameEn(rs.getString("user_name_en"));
        student.setSurnameUa(rs.getString("user_surname_ua"));
        student.setSurnameEn(rs.getString("user_surname_en"));
        student.setEmail(rs.getString("user_email"));
        student.setPassword(rs.getString("user_email"));
        student.setRole(rs.getInt("user_role"));
        student.setSpecialty_id(rs.getInt("user_specialty_id"));
        student.setSumOfaccessment(rs.getInt("user_assessment_sum"));

        return student;
    }

    @Override
    public Student makeUnique(Map<Integer, Student> cache, Student student) {

        cache.putIfAbsent(student.getId(), student);
        return cache.get(student.getId());
    }
}
