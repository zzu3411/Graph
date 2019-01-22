package zzu.dao;

import org.apache.commons.dbutils.QueryRunner;
import zzu.utils.JDBCUtils;

import java.sql.SQLException;

public class CollectDaoImp implements CollectDao {
    @Override
    public void saveNode(String nodeName, String nodeConcept, Double nodeWeight, Integer loginStudentID, Integer curriculumId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "INSERT INTO kg_knowledgepoint (knowledgePointName,knowledgePointConcept,knowledgePointLinkWeight,studentId, curriculumId) VALUES(?,?,?,?,?)";
        queryRunner.update(sql,nodeName,nodeConcept,nodeWeight,loginStudentID ,curriculumId) ;
    }

    @Override
    public void addLine(String nodeA, String nodeB, Double weight, Integer loginStudentID, Integer curriculumId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "INSERT INTO kg_classinnerlink (knowledgePointA, knowledgePointB, knowledgeLinkWeight, studentId, curriculumId) VALUES(?,?,?,?,?)";
        queryRunner.update(sql,nodeA,nodeB,weight,loginStudentID,curriculumId);
    }

    @Override
    public void cleanNode(Integer loginStudentID) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "DELETE FROM kg_knowledgepoint WHERE studentId = ?";
        queryRunner.update(sql,loginStudentID);
    }

    @Override
    public void cleanLine(Integer loginStudentID) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "DELETE FROM kg_classinnerlink WHERE studentId = ?";
        queryRunner.update(sql,loginStudentID);
    }
}
