package zzu.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import zzu.domin.Teacher;
import zzu.domin.TeacherCurriculum;
import zzu.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class TeacherDaoImp implements TeacherDao {
    @Override
    public Teacher findTeacher(Integer teacherId, String passWord) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from kg_teacher where ID = ?  and passWord = ?";
        return queryRunner.query(sql ,new BeanHandler<Teacher>(Teacher.class),teacherId,passWord);
    }

    @Override
    public List<TeacherCurriculum> findCurricumClass(Integer teacherId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from kg_teachercurriculum where teacherId = ?";
        return queryRunner.query(sql ,new BeanListHandler<TeacherCurriculum>(TeacherCurriculum.class),teacherId);
    }
}
