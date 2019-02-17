package zzu.service;

import zzu.domin.Curriculum;
import zzu.domin.StudentTime;

import java.sql.SQLException;
import java.util.List;

public interface CollectService  {
    void saveNode(String nodeName, String nodeConcept,Double nodeWeight, Integer loginStudentID, Integer curriculumId) throws SQLException;

    void addLine( String nodeA, String nodeB, Double weigh, Integer loginStudentID, Integer curriculumId) throws SQLException;

    void clean(Integer loginStudentID,Integer curriculumId) throws SQLException;

    void updateStuCurMemo(Integer loginStudentID, Integer curriculumId ,String memo) throws SQLException;

    Curriculum findMemo(Integer loginStudentID, Integer curriculumId) throws SQLException;


    List<StudentTime> findStudentTime(Integer studentID, Integer curriculumID) throws SQLException;

    void addStudentTime(Integer loginStudentID,Integer curriculumId,String startDate,String savetDate) throws SQLException;

    void updateStudentTime(Integer ID, String savetDate) throws SQLException;


}
