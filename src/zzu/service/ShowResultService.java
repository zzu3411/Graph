package zzu.service;

import zzu.domin.ClassInnerLink;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface ShowResultService {
    //查找学生单门课程学习时长
    double findSingleDuration(Integer studentID, Integer curriculumID) throws ParseException, SQLException;

    //查找学生所有学习时长
    double findTotalDuration(Integer studentID) throws SQLException, ParseException;

    //老师查询本班级同学的 登录次数、提交次数、登录时长
    public List<Object> showTimesDuration(Integer curriculumId, Integer classNo) throws SQLException, ParseException;

    //查询知识点与关联
    public Map findLinksPoints(Integer studentId , Integer curriculumnId) throws SQLException;

}
