package zzu.service;

import zzu.domin.Curriculum;

import java.sql.SQLException;
import java.util.List;

public interface CurriculumService {
    List<Curriculum> findAll() throws SQLException;
}
