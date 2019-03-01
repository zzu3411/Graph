package zzu.domin;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class TeacherCurriculum {
    private Integer ID;
    private Integer teacherId;
    private Integer curriculumId;
    private Integer classNo;
    private Integer flag;
    private String  memo;
    private Integer valid;

    @Override
    public String toString() {
        return "TeacherCurriculum{" +
                "ID=" + ID +
                ", teacherId=" + teacherId +
                ", curriculumId=" + curriculumId +
                ", classNo=" + classNo +
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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
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
