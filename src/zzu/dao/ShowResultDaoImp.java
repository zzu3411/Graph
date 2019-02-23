package zzu.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import zzu.domin.StudentTime;
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
}
