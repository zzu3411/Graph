package zzu.web.servlet;

import net.sf.json.JSONArray;
import zzu.domin.Curriculum;
import zzu.service.CurriculumService;
import zzu.service.CurriculumServiceImp;
import zzu.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CurriculumServlet")
public class CurriculumServlet extends BaseServlet {


    //找到当前所有的课程 通过Ajax返回前端 json
    public  String findAllCurriculum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        List<Curriculum> curriculumList = new ArrayList<>();

        CurriculumService curriculumService = new CurriculumServiceImp();

        curriculumList = curriculumService.findAll();


        for (Curriculum c:curriculumList){
            System.out.println("课程信息: " + c.toString());
        }


        String jsonArray = JSONArray.fromObject(curriculumList).toString();
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().print(jsonArray);

        return null;
    }
}
