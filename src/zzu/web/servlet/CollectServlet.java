package zzu.web.servlet;

import com.sun.deploy.net.HttpRequest;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import zzu.domin.Student;
import zzu.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "CollectServlet")
public class CollectServlet extends BaseServlet {

    //解析前端返回的json 存储知识点与知识点间的联系
    public  String collectData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student loginStudent = (Student) request.getSession().getAttribute("loginStudent");
        System.out.println("当前用户session：" + loginStudent.toString());

        //获取前端传递过来的json 进行处理
        String json = request.getParameter("json");

        Map<String,Map> map = new HashMap<>();

        Map<Integer,Map> nodeMap = map.get("nodeMap");
        Map<String[] , Double> lineMap = map.get("lineMap");

        //存储知识点
        Set<Integer> nodeMapKey = nodeMap.keySet();
        for(Integer n:nodeMapKey){
            String nodeName = (String) nodeMap.get(n).get("nodeName");
            Integer nodeWeight = Integer.parseInt( (String) nodeMap.get(n).get("nodeWeight")) ;
            String nodeConcept = (String) nodeMap.get(n).get("nodeConcept");
            //存储

        }

        //存储知识点关联表
        Set<String[]> lineMapKey = lineMap.keySet();
        for (String[] line:lineMapKey){
            String fromName = line[0];
            String toName = line[1];
            Double weight = lineMap.get(line);
            //存储
        }


        return null;
    }
}
