package zzu.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import zzu.domin.Curriculum;
import zzu.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class StuCurDaoImp implements StuCurDao{
    @Override
    public List<Curriculum> findStuCur(Integer studentId) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "SELECT cur.ID,cur.curriculumName,stu.memo FROM kg_studentcurriculum stu LEFT JOIN  kg_curriculum cur ON stu.curriculumId=cur.ID WHERE stu.studentId=? ORDER BY cur.ID ";

        return queryRunner.query(sql ,new BeanListHandler<Curriculum>(Curriculum.class),studentId);
    }

    @Override
    public Curriculum findMemo(Integer studentId, Integer curriculumId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "select * from kg_studentcurriculum where studentId = ?  and curriculumId = ?";

        return queryRunner.query(sql ,new BeanHandler<Curriculum>(Curriculum.class),studentId,curriculumId);
    }
}
