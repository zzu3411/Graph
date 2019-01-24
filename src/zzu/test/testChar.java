package zzu.test;

import org.apache.commons.dbutils.QueryRunner;
import zzu.utils.JDBCUtils;

import java.sql.SQLException;

public class testChar {
    public static  void testCharCH() throws SQLException {
    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    String sql = "update kg_studentcurriculum SET memo='测试中文字符' where studentId=1 and curriculumId=?";
    queryRunner.update(sql,12);

    }
}
