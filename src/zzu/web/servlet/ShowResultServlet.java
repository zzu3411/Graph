package zzu.web.servlet;

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

@WebServlet(name = "ShowResultServlet")
public class ShowResultServlet extends BaseServlet {
    //查询单个学生每门课程的学习时长
    public void showSingleDuration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        Student loginStudent = (Student) request.getSession().getAttribute("loginStudent");
        System.out.println("当前用户session：" + loginStudent.toString());
        Integer loginStudentID = loginStudent.getID();
        System.out.println(request.getParameter("curId"));
        Integer curriculumId = Integer.valueOf(request.getParameter("curId"));
        ShowResultService showResultService = new ShowResultServiceImp();
        double totalHour = showResultService.findSingleDuration(loginStudentID,curriculumId);
    }

    //查询单个学生课程的所有学习时长
    public void showTotalDuration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
        Student loginStudent = (Student) request.getSession().getAttribute("loginStudent");
        System.out.println("当前用户session：" + loginStudent.toString());
        Integer loginStudentID = loginStudent.getID();
        ShowResultService showResultService = new ShowResultServiceImp();
        double totalHour = showResultService.findTotalDuration(loginStudentID);
    }
}
