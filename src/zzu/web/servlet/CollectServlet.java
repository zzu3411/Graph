package zzu.web.servlet;

import com.sun.deploy.net.HttpRequest;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import zzu.dao.CollectDaoImp;
import zzu.domin.Curriculum;
import zzu.domin.Student;
import zzu.service.*;
import zzu.test.StaticData;
import zzu.utils.JsonUtils;
import zzu.web.base.BaseServlet;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "CollectServlet")

public class CollectServlet extends BaseServlet {

    //解析前端返回的json 存储知识点与知识点间的联系
    public String collectData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        Student loginStudent = (Student) request.getSession().getAttribute("loginStudent");
        System.out.println("当前用户session：" + loginStudent.toString());
        Integer loginStudentID = loginStudent.getID();
        System.out.println(request.getParameter("curID"));
        Integer curriculumId = Integer.valueOf(request.getParameter("curID"));

        //每次提交都删除之前数据重新保存
        CollectService collectService = new CollectServiceImp();
        collectService.clean(loginStudentID);


        //知识点数据
        request.setCharacterEncoding("utf-8");
        String graph = request.getParameter("graph");
        String graphStr=new String(graph.trim().getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("Graph: " + graphStr);

        collectService = new CollectServiceImp();
        collectService.updateStuCurMemo(loginStudentID, curriculumId , graphStr);

        //获取前端传递过来的json 进行处理
        //String json = request.getParameter("json");

        //测试使用
        /*String json = StaticData.json;*/
//        String json = graphStr;

        Map<String,Map> test =JsonUtils.jsonResolve(graphStr);

        //存储知识点
        Map<Integer,Map> nodeMap = test.get("nodeMap");
        saveNode(nodeMap, loginStudentID, curriculumId);

        //存储关联表
        Map<String[],Double> lineMap = test.get("lineMap");
        saveLine(lineMap, loginStudentID, curriculumId);

        return "/pointCollect.jsp";
    }

    public void findMemo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Integer curId = Integer.valueOf(request.getParameter("curId"));
        Student loginStudent = (Student) request.getSession().getAttribute("loginStudent");
        Integer StuID = loginStudent.getID();

        CollectService collectService = new CollectServiceImp();
        Curriculum cur= collectService.findMemo(StuID, curId);
        PrintWriter out = response.getWriter();
        out.print(cur.getMemo());

    }

    public void saveLine(Map<String[],Double> nodeMap,Integer loginStudentID,Integer curriculumId) throws SQLException {
         Set<String[]> set = nodeMap.keySet();

         CollectService collectService = new CollectServiceImp();

         for (String[] s:set){
             String nodeA = s[0];
             String nodeB = s[1];
             Double weight =   (nodeMap.get(s)) ;
             collectService.addLine(nodeA,nodeB,weight,loginStudentID,curriculumId);
         }
    }

    public void saveNode( Map<Integer,Map> nodeMap,Integer loginStudentID ,Integer curriculumId) throws SQLException {
        Set<Integer> set = nodeMap.keySet();
        CollectService collectService =new CollectServiceImp();
        for (Integer s:set){
            System.out.println("nodeName: " + nodeMap.get(s));
            String nodeName =  (String) nodeMap.get(s).get("nodeName");
            String nodeConcept = (String) nodeMap.get(s).get("nodeConcept");
            Double nodeWeight = Double.parseDouble((String) nodeMap.get(s).get("nodeWeight"));
            System.out.println("nodeName: " + nodeName + "  nodeConcept: " + nodeConcept +"  nodeWeight: "  +nodeWeight);
            collectService.saveNode(nodeName, nodeConcept, nodeWeight, loginStudentID, curriculumId);
        }

    }

}
