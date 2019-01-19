package zzu.dao;

import zzu.domin.Curriculum;

import java.sql.SQLException;
import java.util.List;

public interface CurriculumDao {

    //查询当前的所有课程
    List<Curriculum> findAll() throws SQLException;

}
