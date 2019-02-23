package zzu.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import zzu.domin.Curriculum;
import zzu.domin.StudentCurriculum;
import zzu.domin.StudentTime;
import zzu.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

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
    public void cleanNode(Integer loginStudentID, Integer curriculumId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "DELETE FROM kg_knowledgepoint WHERE studentId = ? AND curriculumId = ?";
        queryRunner.update(sql,loginStudentID, curriculumId);
    }

    @Override
    public void cleanLine(Integer loginStudentID, Integer curriculumId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "DELETE FROM kg_classinnerlink WHERE studentId = ? AND curriculumId = ?";
        queryRunner.update(sql,loginStudentID, curriculumId);
    }

    @Override
    public void updateStuCurMemo(Integer loginStudentID, Integer curriculumId , String memo) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "UPDATE kg_studentcurriculum SET memo = ? where studentId=? AND curriculumId=? ";
        queryRunner.update(sql,memo,loginStudentID,curriculumId);

    }

    @Override
    public List<StudentTime> findStudentTime(Integer studentID, Integer curriculumID) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
//        String sql = "SELECT * FROM kg_studenttime WHERE ID=(  SELECT MAX(ID) FROM kg_studenttime WHERE studentId=? AND curriculumId = ?  )";
        String sql = "SELECT * FROM kg_studenttime WHERE studentId=? AND curriculumId = ? ";
        return queryRunner.query(sql, new BeanListHandler<StudentTime>(StudentTime.class) , studentID, curriculumID);

    }

    @Override
    public void addStudentTime(Integer loginStudentID, Integer curriculumId, String startDate, String savetDate) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "INSERT INTO kg_studenttime (studentId,curriculumId,startTime, endTime) VALUES(?,?,?,?)";
        queryRunner.update(sql, loginStudentID,curriculumId,  startDate, savetDate);

    }

    @Override
    public void updateStudentTime(Integer ID, String savetDate) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "UPDATE kg_studenttime SET endTime=? WHERE ID = ?";
        queryRunner.update(sql,savetDate,ID);
    }

    @Override
    public StudentCurriculum findEditTime(Integer loginStudentID, Integer curriculumId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM kg_studentcurriculum WHERE studentId = ? AND curriculumId = ?";
        return queryRunner.query(sql, new BeanHandler<StudentCurriculum>(StudentCurriculum.class),loginStudentID, curriculumId);

    }

    @Override
    public void updateEditTime(Integer loginStudentID, Integer curriculumId, Integer editTime) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "update kg_studentcurriculum  set editTime = ? WHERE studentId = ? AND curriculumId = ?";
        queryRunner.update(sql, editTime, loginStudentID, curriculumId);
    }
}
