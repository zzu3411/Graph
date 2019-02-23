package zzu.web.servlet;

import com.sun.deploy.net.HttpRequest;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import zzu.dao.CollectDaoImp;
import zzu.domin.Curriculum;
import zzu.domin.Student;
import zzu.domin.StudentTime;
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
import java.security.PublicKey;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "CollectServlet")

public class CollectServlet extends BaseServlet {


    //解析前端返回的json 存储知识点与知识点间的联系
    public String collectData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        Student loginStudent = (Student) request.getSession().getAttribute("loginStudent");
        System.out.println("当前用户session：" + loginStudent.toString());
        Integer loginStudentID = loginStudent.getID();
        System.out.println(request.getParameter("curId"));
        Integer curriculumId = Integer.valueOf(request.getParameter("curId"));

        //每次提交都删除之前数据重新保存
        CollectService collectService = new CollectServiceImp();
        collectService.clean(loginStudentID, curriculumId);


        //知识点数据
        request.setCharacterEncoding("utf-8");
        String graph = request.getParameter("graph");
//        String graphStr=new String(graph.trim().getBytes("ISO-8859-1"), "UTF-8");
        String graphStr = graph.trim();
        System.out.println("Graph: " + graphStr);

//        collectService = new CollectServiceImp();
        collectService.updateStuCurMemo(loginStudentID, curriculumId , graphStr);





        Map<String,Map> test =JsonUtils.jsonResolve(graphStr);

        //存储知识点
        Map<Integer,Map> nodeMap = test.get("nodeMap");
        saveNode(nodeMap, loginStudentID, curriculumId);

        //存储关联表
        Map<String[],Double> lineMap = test.get("lineMap");
        saveLine(lineMap, loginStudentID, curriculumId);

        String startDate = (String) request.getSession().getAttribute("startDate");
        System.out.println("getsession startDate: " + startDate);

        saveDuration(startDate, loginStudentID, curriculumId);
        addEditTime(loginStudentID, curriculumId);



        return "/pointCollect.jsp";
    }

    //记录本次登录学习时间 登录--提交时间
    private void saveDuration(String startDate, Integer loginStudentID ,Integer curriculumId) throws SQLException {
        //记录提交时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String savetDate = df.format(new Date());// new Date()为获取当前系统时间

        //查询studnettime表是否有记录
        CollectService collectService = new CollectServiceImp();
        List<StudentTime> studentTimes = collectService.findStudentTime(loginStudentID, curriculumId);
        StudentTime studentTime = null;
        if (studentTimes.size()>0) {
            for (StudentTime s : studentTimes) {
                if (s.getStartTime().equals(startDate)){
                    studentTime = s;
                    break;
                }
            }
        }
        if ( studentTime == null ){
            //本次登录第一次提交 插入本次记录
            collectService.addStudentTime(loginStudentID,curriculumId,startDate,savetDate);
        }else{
            //修改最后提交时间
            collectService.updateStudentTime(studentTime.getID(),savetDate);
        }

        System.out.println("setsession startDate: " + startDate);
    }

    //记录课程提交次数
    private void addEditTime(Integer loginStudentID,Integer curriculumId) throws SQLException {
        CollectService collectService = new CollectServiceImp();
        int  editTime = collectService.findEditTime(loginStudentID,curriculumId) + 1;
        collectService.updateEditTime(loginStudentID,curriculumId,editTime);

    }

    public void findMemo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        request.setCharacterEncoding("UTF-8");
        Integer curId = Integer.valueOf(request.getParameter("curId"));
        Student loginStudent = (Student) request.getSession().getAttribute("loginStudent");
        Integer StuID = loginStudent.getID();

        CollectService collectService = new CollectServiceImp();
        Curriculum cur= collectService.findMemo(StuID, curId);
        response.setContentType("application/json; charset=utf-8");
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
