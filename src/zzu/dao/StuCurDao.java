package zzu.dao;

import zzu.domin.Curriculum;

import java.sql.SQLException;
import java.util.List;

public interface StuCurDao {
    List<Curriculum> findStuCur(Integer studentId) throws SQLException;

    Curriculum findMemo(Integer loginStudentID, Integer curriculumId) throws SQLException;
}
