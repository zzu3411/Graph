package zzu.domin;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class ClassInnerLink {
    private Integer ID;
    private Integer studentId;
    private String knowledgePointA;
    private String knowledgePointB;
    private Double knowledgeLinkWeight;
    private Integer curriculumId;
    private Integer flag;
    private String memo;
    private Integer valid;

    @Override
    public String toString() {
        return "ClassInnerLink{" +
                "ID=" + ID +
                ", studentId=" + studentId +
                ", knowledgePointA='" + knowledgePointA + '\'' +
                ", knowledgePointB='" + knowledgePointB + '\'' +
                ", knowledgeLinkWeight=" + knowledgeLinkWeight +
                ", curriculumId=" + curriculumId +
                ", flag=" + flag +
                ", memo='" + memo + '\'' +
                ", valid=" + valid +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getKnowledgePointA() {
        return knowledgePointA;
    }

    public void setKnowledgePointA(String knowledgePointA) {
        this.knowledgePointA = knowledgePointA;
    }

    public String getKnowledgePointB() {
        return knowledgePointB;
    }

    public void setKnowledgePointB(String knowledgePointB) {
        this.knowledgePointB = knowledgePointB;
    }

    public Double getKnowledgeLinkWeight() {
        return knowledgeLinkWeight;
    }

    public void setKnowledgeLinkWeight(Double knowledgeLinkWeight) {
        this.knowledgeLinkWeight = knowledgeLinkWeight;
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}
