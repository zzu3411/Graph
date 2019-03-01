package zzu.dao;

import zzu.domin.ClassInnerLink;
import zzu.domin.StudentCurriculum;
import zzu.domin.StudentTime;
import zzu.domin.knowledgePoint;

import java.sql.SQLException;
import java.util.List;

public interface ShowResultDao {
    List<StudentTime> findSingleDuration(Integer studentID, Integer curriculumID) throws SQLException;

    List<StudentTime> findTotalDuration(Integer studentID) throws SQLException;

    List<StudentCurriculum>findStudentCurriculum(Integer curriculumId, Integer classNo) throws SQLException;

    List<StudentTime> findLoginTimes(Integer studnetId, Integer curriculumId) throws SQLException;

    List<StudentCurriculum>findStudentCurriculum(Integer studentId, Integer curriculumId, Integer classNo) throws SQLException;

    List<ClassInnerLink> findLinks(Integer studentId , Integer curriculumnId) throws SQLException;

    List<knowledgePoint> findDatas(Integer studentId , Integer curriculumId) throws SQLException;


}
