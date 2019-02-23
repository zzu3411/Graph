package zzu.dao;

import zzu.domin.StudentTime;

import java.sql.SQLException;
import java.util.List;

public interface ShowResultDao {
    List<StudentTime> findSingleDuration(Integer studentID, Integer curriculumID) throws SQLException;

    List<StudentTime> findTotalDuration(Integer studentID) throws SQLException;
}
