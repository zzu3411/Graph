package zzu.test;

import org.apache.commons.dbutils.QueryRunner;
import zzu.utils.JDBCUtils;

import java.sql.SQLException;

public class insertData {
    public static void  insertStuCur() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into kg_studentcurriculum (studentId, curriculumId) values (?,?)";
        for (int i = 1 ;i <6 ; i++){
            for (int j=1 ; j < 17 ; j++){
                queryRunner.update(sql,i,j);
            }
        }
    }
}
