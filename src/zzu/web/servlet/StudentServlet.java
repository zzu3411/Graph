package zzu.web.servlet;

import zzu.domin.Student;
import zzu.service.StudentService;
import zzu.service.StudentServiceImp;
import zzu.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class StudentServlet extends BaseServlet {

    public  String studentLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        Integer studentId = Integer.parseInt(request.getParameter("studentId"));
        String passWord = request.getParameter("passWord");
        System.out.println(studentId + "  " + passWord);
        StudentService studentService = new StudentServiceImp();
        Student student = studentService.findOneStudent( studentId,  passWord);
        if(student != null){
            System.out.println(student.toString());
            request.getSession().setAttribute("loginStudent", student);
            return "/pointCollect.jsp";

        }else{
            System.out.println("查询为空！");
            request.setAttribute("msg", "用户名或密码错误");

        }

        return "/login.jsp";
    }
    public  String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/login.jsp";
    }
}
