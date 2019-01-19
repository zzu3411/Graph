package zzu.utils;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsonUtils {
    public  Map<String, Map> main(String json) {
        //String json = StaticData.jsonData;

        JSONObject jsonObject = JSONObject.fromObject(json);
        Map<String, Object> map = (Map<String, Object>) JSONObject.toBean(jsonObject, Map.class);



//        处理节点 id,"text(知识点名称)","loc"   nodeMap(id,"(text)知识点name")
        List<Object> nodeList = (List<Object>) map.get("nodeDataArray");
        Map<Integer,Map> nodeMap = new HashMap();
        for (Object node:nodeList){
            JSONObject jsonObject1 = JSONObject.fromObject(node);
            Map<String, Object> map1 = (Map<String, Object>) JSONObject.toBean(jsonObject1, Map.class);

            Integer id = (Integer) map1.get("id");
            String nodeName =  ((String)map1.get("text")).trim() ;
            String nodeWeight = ((String)map1.get("nodeWeight")).trim();
            String nodeConcept =  ((String)map1.get("nodeConcept")).trim();

            Map<String , String> nodeValues = new HashMap<>();
            nodeValues.put("nodeName", nodeName);
            nodeValues.put("nodeWeight", nodeWeight);
            nodeValues.put("nodeConcept", nodeConcept);

            nodeMap.put(id, nodeValues);
        }
        System.out.println( nodeMap.toString() );



//        处理线 "from","to","text(关联值)"  linemap(String[] {fromName,toName} , Double 关联值)
        List<Object> LineList = (List<Object>) map.get("linkDataArray");
        Map<String[] , Double> lineMap = new HashMap<>();
        for (Object l:LineList){
            JSONObject jsonObject1 = JSONObject.fromObject(l);
            Map<String, Object> map1 = (Map<String, Object>) JSONObject.toBean(jsonObject1, Map.class);
            String[] fromTo = new String[2];
            Integer i = Integer.parseInt (  (map1.get("from")).toString().trim()  )  ;
            fromTo[0] = (String) nodeMap.get(i).get("nodeName");
            Integer j = Integer.parseInt (  (map1.get("to")).toString().trim()  );
            fromTo[1] =  (String)  nodeMap.get(j).get("nodeName") ;
//            Integer weight = Integer.parseInt (  (map1.get("text")).toString().trim()  )  ;
            Double weight = 0.5;
            lineMap.put(fromTo, weight);
        }

        Set<String[]> set = lineMap.keySet();
        for (String[] s:set){
            System.out.print("  From: " + s[0]);
            System.out.print("  To: " + s[1]);
            System.out.print("  weight: " + lineMap.get(s));
            System.out.println();
        }


        Map<String,Map> returnMap = new HashMap<>();
        returnMap.put("nodeMap", nodeMap);
        returnMap.put("lineMap", lineMap);

        return returnMap;
    }
}
