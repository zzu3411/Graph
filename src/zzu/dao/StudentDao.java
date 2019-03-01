package zzu.dao;

import zzu.domin.Student;

import java.sql.SQLException;

public interface StudentDao {
    Student findOneStudent(Integer studentId, String passWord) throws SQLException;

    Student studentById(Integer studnetId) throws SQLException;
}
