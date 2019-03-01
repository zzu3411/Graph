package zzu.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import zzu.domin.Student;
import zzu.utils.JDBCUtils;

import java.sql.SQLException;

public class StudentDaoImp implements StudentDao{
    @Override
    public Student findOneStudent(Integer studentId, String passWord) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from kg_student where ID = ?  and passWord = ?";
        return queryRunner.query(sql ,new BeanHandler<Student>(Student.class),studentId,passWord);
    }

    @Override
    public Student studentById(Integer studnetId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from kg_student where ID = ? ";
        return queryRunner.query(sql ,new BeanHandler<Student>(Student.class),studnetId);
    }
}
