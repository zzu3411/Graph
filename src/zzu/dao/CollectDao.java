package zzu.dao;

import zzu.domin.StudentCurriculum;
import zzu.domin.StudentTime;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CollectDao {
    void saveNode(String nodeName, String nodeConcept,Double nodeWeight, Integer loginStudentID ,Integer curriculumId) throws SQLException;

    void addLine( String nodeA, String nodeB, Double weigh, Integer loginStudentID, Integer curriculumId) throws SQLException;

    //清理知识点表
    void cleanNode(Integer loginStudentID, Integer curriculumId) throws SQLException;
    //清理知识点关联表
    void cleanLine(Integer loginStudentID, Integer curriculumId) throws SQLException;

    void updateStuCurMemo(Integer loginStudentID, Integer curriculumId, String memo) throws SQLException;

    List<StudentTime> findStudentTime(Integer studentID, Integer curriculumID) throws SQLException;

    void addStudentTime(Integer loginStudentID,Integer curriculumId,String startDate,String savetDate) throws SQLException;

    void updateStudentTime(Integer ID, String savetDate) throws SQLException;

    StudentCurriculum findEditTime(Integer loginStudentID, Integer  curriculumId) throws SQLException;

    void updateEditTime(Integer loginStudentID,Integer curriculumId,Integer editTime) throws SQLException;
}
