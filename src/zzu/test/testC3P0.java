package zzu.test;

import org.apache.commons.dbutils.QueryRunner;
import zzu.utils.JDBCUtils;

import java.sql.SQLException;

public class testC3P0 {
    public static void main(String[] args) throws SQLException {
        QueryRunner  queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into testuser values(sid,?,?,?)";
        Object [] params = {"test01","pass","男"};
        queryRunner.update(sql,params);
    }
}
