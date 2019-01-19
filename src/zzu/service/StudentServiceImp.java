package zzu.service;

import zzu.dao.StudentDao;
import zzu.dao.StudentDaoImp;
import zzu.domin.Student;

import java.sql.SQLException;

public class StudentServiceImp implements StudentService {
    @Override
    public Student findOneStudent(Integer studentId, String passWord) throws SQLException {
        StudentDao studentDao = new StudentDaoImp();
        return studentDao.findOneStudent(studentId,  passWord);
    }
}
