package zzu.service;

import java.sql.SQLException;
import java.text.ParseException;

public interface ShowResultService {
    //查找学生单门课程学习时长
    double findSingleDuration(Integer studentID, Integer curriculumID) throws ParseException, SQLException;

    //查找学生所有学习时长
    double findTotalDuration(Integer studentID) throws SQLException, ParseException;

}
