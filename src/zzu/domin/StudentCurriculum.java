package zzu.domin;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class StudentCurriculum {
    private Integer ID;
    private Integer studentId;
    private Integer curriculumId;
    private Integer editTime;
    private Integer grade;
    private Integer flag;
    private String memo;
    private Integer valid;

    @Override
    public String toString() {
        return "StudentCurriculum{" +
                "ID=" + ID +
                ", studentId=" + studentId +
                ", curriculumId=" + curriculumId +
                ", editTime=" + editTime +
                ", grade=" + grade +
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

    public Integer getEditTime() {
        return editTime;
    }

    public void setEditTime(Integer editTime) {
        this.editTime = editTime;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
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
