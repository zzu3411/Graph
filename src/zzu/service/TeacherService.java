package zzu.service;

import zzu.domin.Teacher;
import zzu.domin.TeacherCurriculum;

import java.sql.SQLException;
import java.util.List;

public interface TeacherService {
    Teacher findTeacher(Integer teacherId, String passWord) throws SQLException;

    List<TeacherCurriculum> findCurricumClass(Integer teacherId) throws SQLException;
}
