package zzu.web.servlet;


import zzu.domin.Student;
import zzu.domin.Teacher;
import zzu.domin.TeacherCurriculum;
import zzu.service.*;
import zzu.web.base.BaseServlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import zzu.domin.Curriculum;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LoginServlet extends BaseServlet {

    public  String userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String loginStyle = request.getParameter("loginStyle").trim();

        //学生登录
        if (loginStyle.equals("student")){

            Integer studentId = Integer.parseInt(request.getParameter("loginId").trim());
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

        }else if (loginStyle.equals("teacher")){
            System.out.println("teacher login!");
            Integer teacherId = Integer.parseInt(request.getParameter("loginId").trim());
            String passWord = request.getParameter("passWord");
            System.out.println("账号:" + teacherId + " 密码: " + passWord);
            TeacherService teacherService = new TeacherServiceImp();
            Teacher teacher = teacherService.findTeacher( teacherId,  passWord);
            if(teacher != null){
                List<TeacherCurriculum> teacherCurriculumList = findCurriculumClass(teacherId);
                //记录 老师信息与老师所教课程 到session中
                request.getSession().setAttribute("teacherCurriculumList", teacherCurriculumList);
                request.getSession().setAttribute("loginTeacher", teacher);
                return "/showPoint.jsp";
            }

            else{
                System.out.println("查询为空！");
                request.setAttribute("msg", "用户名或密码错误");

            }

        }


        return "/login.jsp";
    }


    //查找教师所教课程与班级
    public List<TeacherCurriculum> findCurriculumClass(Integer teacherId) throws SQLException {
        TeacherService teacherService = new TeacherServiceImp();
        return teacherService.findCurricumClass(teacherId);
    }


    public  String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/login.jsp";
    }
}
