package zzu.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import zzu.domin.ClassInnerLink;
import zzu.domin.StudentCurriculum;
import zzu.domin.StudentTime;
import zzu.domin.knowledgePoint;
import zzu.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class ShowResultDaoImp implements ShowResultDao {
    @Override
    public List<StudentTime> findSingleDuration(Integer studentID , Integer curriculumID) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM kg_studenttime WHERE studentId = ? AND curriculumId = ?";
        return queryRunner.query(sql, new BeanListHandler<StudentTime>(StudentTime.class),studentID,curriculumID);
    }

    @Override
    public List<StudentTime> findTotalDuration(Integer studentID) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM kg_studenttime WHERE studentId = ?";
        return queryRunner.query(sql, new BeanListHandler<StudentTime>(StudentTime.class),studentID);
    }

    @Override
    public List<StudentCurriculum> findStudentCurriculum(Integer curriculumId, Integer classNo) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM kg_studentcurriculum where curriculumId =? AND classNo =? ";

        return queryRunner.query(sql, new BeanListHandler<StudentCurriculum>(StudentCurriculum.class), curriculumId, classNo);
    }

    @Override
    public List<StudentTime> findLoginTimes(Integer studnetId, Integer curriculumId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM kg_studenttime WHERE studentId = ? AND curriculumId = ?";
        return queryRunner.query(sql, new BeanListHandler<StudentTime>(StudentTime.class),studnetId,curriculumId);
    }

    @Override
    public List<StudentCurriculum> findStudentCurriculum(Integer studentId, Integer curriculumId, Integer classNo) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM kg_studentcurriculum where curriculumId =? AND classNo =? AND studnetId = ?";

        return queryRunner.query(sql, new BeanListHandler<StudentCurriculum>(StudentCurriculum.class), curriculumId, classNo, studentId);
    }

    @Override
    public List<ClassInnerLink> findLinks(Integer studentId, Integer curriculumnId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM kg_classinnerlink where curriculumId =? AND  studentId = ?";
        return queryRunner.query(sql, new BeanListHandler<ClassInnerLink>(ClassInnerLink.class), curriculumnId, studentId);
    }

    @Override
    public List<knowledgePoint> findDatas(Integer studentId, Integer curriculumId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM kg_knowledgepoint where curriculumId =? AND  studentId = ?";
        return queryRunner.query(sql, new BeanListHandler<knowledgePoint>(knowledgePoint.class), curriculumId, studentId);
    }
}
