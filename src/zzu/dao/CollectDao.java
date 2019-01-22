package zzu.dao;

import java.sql.SQLException;
import java.util.Map;

public interface CollectDao {
    void saveNode(String nodeName, String nodeConcept,Double nodeWeight, Integer loginStudentID ,Integer curriculumId) throws SQLException;

    void addLine( String nodeA, String nodeB, Double weigh, Integer loginStudentID, Integer curriculumId) throws SQLException;

    //清理知识点表
    void cleanNode(Integer loginStudentID) throws SQLException;
    //清理知识点关联表
    void cleanLine(Integer loginStudentID) throws SQLException;
}
