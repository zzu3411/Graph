package zzu.service;

import zzu.dao.CurriculumDao;
import zzu.dao.CurriculumDaoImp;
import zzu.domin.Curriculum;

import java.sql.SQLException;
import java.util.List;

public class CurriculumServiceImp implements CurriculumService {
    @Override
    public List<Curriculum> findAll() throws SQLException {
        CurriculumDao curriculumDao = new CurriculumDaoImp();
        return curriculumDao.findAll();
    }
}
