package zzu.web.servlet;

import net.sf.json.JSONArray;
import zzu.domin.Student;
import zzu.service.ShowResultService;
import zzu.service.ShowResultServiceImp;
import zzu.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

@WebServlet(name = "ShowResultServlet")
public class ShowResultServlet extends BaseServlet {

    //显示教师所教课程与班级
    public void showClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {

        Integer curriculumId = 1;
        Integer classNo = 1;
        List<Object> res = new ArrayList<>();
        ShowResultService resultService = new ShowResultServiceImp();
        res = resultService.showTimesDuration(curriculumId, classNo);
        for (Object r:res){
            System.out.println(r.toString());
        }
        System.out.println("JSON: " + JSONArray.fromObject(res).toString());
    }


    //查询所选班级全部同学的登录次数，提交次数，总登录时长
    //参数：curriculumId、classNo
    public void showTimesDuration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
//        Integer curriculumId = Integer.valueOf(request.getParameter("curriculumId").trim());
  //      Integer classNo = Integer.valueOf(request.getParameter("classNo").trim());
        Integer curriculumId = 1;
        Integer classNo = 1;
        List<Object> res = new ArrayList<>();
        ShowResultService resultService = new ShowResultServiceImp();
        res = resultService.showTimesDuration(curriculumId, classNo);
        for (Object r:res){
            System.out.println(r.toString());
        }
        System.out.println("JSON: " + JSONArray.fromObject(res).toString());
    }

    //展示 知识点与关联关系
    public void showDataLinks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        Integer studentId = 1;
        Integer curriculumId = 6;
        ShowResultService resultService = new ShowResultServiceImp();
        Map<String , Object> res = resultService.findLinksPoints(studentId, curriculumId);
        System.out.println("data links JSON: " + JSONArray.fromObject(res).toString());

    }

    //学生查询 单门课程 的 学习时长
    public void showSingleDuration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        Student loginStudent = (Student) request.getSession().getAttribute("loginStudent");
        Integer studentID = loginStudent.getID();
        Integer curriculumId = Integer.valueOf(request.getParameter("curId"));
        double totalHour = findSingleDuration(studentID,curriculumId);
    }

    //学生自己查询 所有课程 的 总学习时长
    public void showTotalDuration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
        Student loginStudent = (Student) request.getSession().getAttribute("loginStudent");
        Integer studentID = loginStudent.getID();
        double totalHour = findTotalDuration(studentID);
    }

    //老师查询 单个同学 本门课程 的学习时间
    public void showStudentDuration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
        Student loginStudent = (Student) request.getSession().getAttribute("loginStudent");
        request.getParameter("");
        Integer studentID = loginStudent.getID();
        double totalHour = findTotalDuration(studentID);
    }

    private double findSingleDuration(Integer studentID, Integer curriculumId) throws ParseException, SQLException {
        ShowResultService showResultService = new ShowResultServiceImp();
        return showResultService.findSingleDuration(studentID,curriculumId);
    }

    private double findTotalDuration(Integer studentID) throws SQLException, ParseException {
        ShowResultService showResultService = new ShowResultServiceImp();
        return showResultService.findTotalDuration(studentID);
    }

}
