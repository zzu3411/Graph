package zzu.service;

import zzu.dao.CollectDao;
import zzu.dao.CollectDaoImp;
import zzu.dao.StuCurDao;
import zzu.dao.StuCurDaoImp;
import zzu.domin.Curriculum;
import zzu.domin.StudentTime;

import java.sql.SQLException;
import java.util.List;

public class CollectServiceImp implements CollectService {
    @Override
    public void saveNode(String nodeName, String nodeConcept,Double nodeWeight, Integer loginStudentID, Integer curriculumId) throws SQLException {
        CollectDao collectDao = new CollectDaoImp();
        collectDao.saveNode(nodeName, nodeConcept, nodeWeight, loginStudentID, curriculumId);
    }

    @Override
    public void addLine(String nodeA, String nodeB, Double weight, Integer loginStudentID, Integer curriculumId) throws SQLException {
        CollectDao collectDao = new CollectDaoImp();
        collectDao.addLine(nodeA,nodeB,weight,loginStudentID,curriculumId);
    }

    @Override
    public void clean(Integer loginStudentID, Integer curriculumId) throws SQLException {
        CollectDao collectDao = new CollectDaoImp();
        //清理知识点表
        collectDao.cleanNode(loginStudentID, curriculumId);
        //清理知识点关联表
        collectDao.cleanLine(loginStudentID, curriculumId);

    }

    @Override
    public void updateStuCurMemo(Integer loginStudentID, Integer curriculumId, String memo) throws SQLException {
        CollectDao collectDao = new CollectDaoImp();
        collectDao.updateStuCurMemo(loginStudentID, curriculumId, memo);
    }

    @Override
    public Curriculum findMemo(Integer loginStudentID, Integer curriculumId) throws SQLException {
        StuCurDao stuCurDao = new StuCurDaoImp();
        return stuCurDao.findMemo(loginStudentID, curriculumId);
    }

    @Override
    public List<StudentTime> findStudentTime(Integer studentID, Integer curriculumID) throws SQLException {
        CollectDao collectDao = new CollectDaoImp();
        return collectDao.findStudentTime(studentID,curriculumID);

    }

    @Override
    public void addStudentTime(Integer loginStudentID, Integer curriculumId, String startDate, String savetDate) throws SQLException {
        CollectDao collectDao = new CollectDaoImp();
        collectDao.addStudentTime(loginStudentID,curriculumId,startDate,savetDate);
    }

    @Override
    public void updateStudentTime(Integer ID, String savetDate) throws SQLException {
        CollectDao collectDao = new CollectDaoImp();
        collectDao.updateStudentTime(ID,savetDate);
    }
}
