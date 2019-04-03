package zzu.service;

import com.sun.org.apache.bcel.internal.generic.NEW;
import zzu.dao.ShowResultDao;
import zzu.dao.ShowResultDaoImp;
import zzu.dao.StudentDao;
import zzu.dao.StudentDaoImp;
import zzu.domin.ClassInnerLink;
import zzu.domin.knowledgePoint;
import zzu.domin.Student;
import zzu.domin.StudentCurriculum;
import zzu.domin.StudentTime;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ShowResultServiceImp implements ShowResultService {
    @Override
    public double findSingleDuration(Integer studentID, Integer curriculumID) throws ParseException, SQLException {
        ShowResultDao showResultDao = new ShowResultDaoImp();
        List<StudentTime> res = showResultDao.findSingleDuration(studentID ,curriculumID);
        Date startDate = null;
        Date endDate = null;
        double miao = 0, fen = 0, hour = 0, totalHour = 0;
        for (StudentTime s:res) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            startDate= formatter.parse(s.getStartTime());
            endDate = formatter.parse(s.getEndTime());
            miao=(endDate.getTime()-startDate.getTime())/1000;//除以1000是为了转换成秒
            hour=(miao/60)/60;  //  多少小时
            totalHour = totalHour + hour;
        }
        System.out.println("单科总时长" + totalHour);
        return totalHour;

    }

    @Override
    public double findTotalDuration(Integer studentID) throws SQLException, ParseException {
        ShowResultDao showResultDao = new ShowResultDaoImp();
        List<StudentTime> res = showResultDao.findTotalDuration(studentID);
        Date startDate = null;
        Date endDate = null;
        double miao = 0, fen = 0, hour = 0, totalHour = 0;
        for (StudentTime s:res) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            startDate= formatter.parse(s.getStartTime());
            endDate = formatter.parse(s.getEndTime());
            miao=(endDate.getTime()-startDate.getTime())/1000;//除以1000是为了转换成秒
            fen= miao/60;   // 多少分
            hour=(miao/60)/60;  //  多少小时
            totalHour = totalHour + hour;
        }
        System.out.println("总时长" + totalHour);
        return totalHour;
    }

    //处理要展示的信息，学生登录次数、学生学习时长、学生提交次数
    @Override
    public List showTimesDuration(Integer curriculumId, Integer classNo) throws SQLException, ParseException {
        List<Object> res = new ArrayList<>();
        List<StudentCurriculum> studentCurriculumList = new ArrayList<>();
        ShowResultDao showResultDao = new ShowResultDaoImp();
        studentCurriculumList = showResultDao.findStudentCurriculum(curriculumId,classNo);
        Student student = null;
        StudentDao studentDao = new StudentDaoImp();

        List<StudentTime> studentTimes = new ArrayList<>();

        for (StudentCurriculum sc:studentCurriculumList){
            Map<String,String> single = new HashMap<>();
            student = studentDao.studentById( sc.getStudentId() ) ;
            //存储学号
            single.put("studentId",  String.valueOf(sc.getStudentId()));
            //存储姓名
            student = studentDao.studentById(sc.getStudentId()) ;
            single.put("name", student.getName());
            //存储学习时长
            double duration = findSingleDuration(sc.getStudentId(), curriculumId);
            single.put("duration",String.valueOf( String.format("%.2f" , duration)) );
            //存储登录次数
            studentTimes = showResultDao.findLoginTimes( sc.getStudentId(),  curriculumId);
            single.put("loginTimes", String.valueOf(studentTimes.size()));
            //存储提交次数
            single.put("commitTimes",  String.valueOf( sc.getEditTime() ));
            res.add(single);
        }
        return res;
    }

    @Override
    public Map findLinksPoints(Integer studentId, Integer curriculumId) throws SQLException {

        List< Map<String,String> > links = new ArrayList();
        //查询links
        ShowResultDao showResultDao = new ShowResultDaoImp();
        List<ClassInnerLink> classInnerLinkList = showResultDao.findLinks(studentId,curriculumId);
        for (ClassInnerLink c:classInnerLinkList){
            Map<String,String> link = new HashMap();
            link.put("source", c.getKnowledgePointA());
            link.put("target", c.getKnowledgePointB());
            link.put("ralate",  String.format("%.2f" , c.getKnowledgeLinkWeight() )) ;
            links.add(link);
        }


        Map<String,Object> itemStyle = new HashMap<>();
        itemStyle.put("color", "'#00ff00'");
        List<knowledgePoint> knowledgePoints = showResultDao.findDatas(studentId , curriculumId);
        List< Map<String,Object> > data = new ArrayList<>();
        for (knowledgePoint   k:knowledgePoints ){
            Map<String,Object> dataSingle = new HashMap<>();
            dataSingle.put("name", k.getKnowledgePointName());
            dataSingle.put("concept", k.getKnowledgePointConcept());
            dataSingle.put("weight", String.format("%.2f" , k.getKnowledgePointLinkWeight() ));
            dataSingle.put("symbolSize", "[80,80]");
            dataSingle.put("itemStyle", itemStyle);
            System.out.println("knowledgePoint: " + k.toString());
            data.add(dataSingle);
        }
        Map<String , Object> res = new HashMap<>();
        res.put("data", data);
        res.put("links", links);
        return res;
    }
}
