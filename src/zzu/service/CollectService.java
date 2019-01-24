package zzu.service;

import zzu.domin.Curriculum;

import java.sql.SQLException;

public interface CollectService  {
    void saveNode(String nodeName, String nodeConcept,Double nodeWeight, Integer loginStudentID, Integer curriculumId) throws SQLException;

    void addLine( String nodeA, String nodeB, Double weigh, Integer loginStudentID, Integer curriculumId) throws SQLException;

    void clean(Integer loginStudentID) throws SQLException;

    void updateStuCurMemo(Integer loginStudentID, Integer curriculumId ,String memo) throws SQLException;

    Curriculum findMemo(Integer loginStudentID, Integer curriculumId) throws SQLException;
}
