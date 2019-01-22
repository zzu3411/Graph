package zzu.service;

import java.sql.SQLException;
import java.util.Map;

public interface CollectService  {
    void saveNode(String nodeName, String nodeConcept,Double nodeWeight, Integer loginStudentID, Integer curriculumId) throws SQLException;

    void addLine( String nodeA, String nodeB, Double weigh, Integer loginStudentID, Integer curriculumId) throws SQLException;

    void clean(Integer loginStudentID) throws SQLException;

}
