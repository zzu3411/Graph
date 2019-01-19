package zzu.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import zzu.domin.Curriculum;
import zzu.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class CurriculumDaoImp implements CurriculumDao {
    @Override
    public List<Curriculum> findAll() throws SQLException {

        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from kg_curriculum";

        return  queryRunner.query(sql, new BeanListHandler<Curriculum>(Curriculum.class));
    }
}
