package zzu.domin;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class knowledgePoint {
    private Integer ID;
    private Integer studentId;
    private Integer curriculumId;
    private Double knowledgePointLinkWeight;
    private String knowledgePointName;
    private String knowledgePointConcept;
    private Integer flag;
    private String memo;
    private Integer valid;

    @Override
    public String toString() {
        return "knowledgePoint{" +
                "ID=" + ID +
                ", studentId=" + studentId +
                ", curriculumId=" + curriculumId +
                ", knowledgePointLinkWeight=" + knowledgePointLinkWeight +
                ", knowledgePointName='" + knowledgePointName + '\'' +
                ", knowledgePointConcept='" + knowledgePointConcept + '\'' +
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

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Double getKnowledgePointLinkWeight() {
        return knowledgePointLinkWeight;
    }

    public void setKnowledgePointLinkWeight(Double knowledgePointLinkWeight) {
        this.knowledgePointLinkWeight = knowledgePointLinkWeight;
    }

    public String getKnowledgePointName() {
        return knowledgePointName;
    }

    public void setKnowledgePointName(String knowledgePointName) {
        this.knowledgePointName = knowledgePointName;
    }

    public String getKnowledgePointConcept() {
        return knowledgePointConcept;
    }

    public void setKnowledgePointConcept(String knowledgePointConcept) {
        this.knowledgePointConcept = knowledgePointConcept;
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
