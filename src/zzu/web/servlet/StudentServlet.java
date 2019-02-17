package zzu.web.servlet;

import zzu.domin.Student;
import zzu.service.StudentService;
import zzu.service.StudentServiceImp;
import zzu.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import zzu.domin.Curriculum;
import zzu.service.CurriculumService;
import zzu.service.CurriculumServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StudentServlet extends BaseServlet {

    public  String studentLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        Integer studentId = Integer.parseInt(request.getParameter("studentId").trim());
        String passWord = request.getParameter("passWord");
        System.out.println("用户名密码： " + studentId + "  " + passWord);
        StudentService studentService = new StudentServiceImp();
        Student student = studentService.findOneStudent( studentId,  passWord);
        if(student != null){

            //1.自动登录
            String autoLogin = request.getParameter("autoLogin");
            if("1".equals(autoLogin)){
                Cookie autoLoginCookie = new Cookie("autoLoginCookie", student.getID()+"@"+student.getPassWord());
                autoLoginCookie.setPath("/");
                autoLoginCookie.setMaxAge(60*60*24*7);
                response.addCookie(autoLoginCookie);
                System.out.println("选择自动登录");
            }else{
                Cookie autoLoginCookie = new Cookie("autoLoginCookie", "");
                autoLoginCookie.setPath("/");
                autoLoginCookie.setMaxAge(0);
                response.addCookie(autoLoginCookie);

            }

            CurriculumService curSer = new CurriculumServiceImp();
            List<Curriculum> currList= curSer.findStuCur(studentId);

            //记录登录时间
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String startDate = df.format(new Date());// new Date()为获取当前系统时间
            request.getSession().setAttribute("startDate", startDate);
            System.out.println("setsession startDate: " + startDate);

            request.getSession().setAttribute("StuCur", currList);
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
