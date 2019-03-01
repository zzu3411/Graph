package zzu.service;

import zzu.dao.TeacherDao;
import zzu.dao.TeacherDaoImp;
import zzu.domin.Teacher;
import zzu.domin.TeacherCurriculum;

import java.sql.SQLException;
import java.util.List;

public class TeacherServiceImp implements TeacherService {
    @Override
    public Teacher findTeacher(Integer teacherId, String passWord) throws SQLException {

        TeacherDao teacherDao = new TeacherDaoImp();
        return teacherDao.findTeacher(teacherId, passWord);
    }

    @Override
    public List<TeacherCurriculum> findCurricumClass(Integer teacherId) throws SQLException {
        TeacherDao teacherDao = new TeacherDaoImp();
        return teacherDao.findCurricumClass(teacherId);
    }
}
