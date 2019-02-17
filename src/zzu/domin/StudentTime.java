package zzu.domin;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.util.Date;

public class StudentTime {
    private Integer ID;
    private Integer curriculumId;
    private Integer  studentId;
    private String startTime;
    private String endTime;
//    private Time studyTime;
    private Integer flag;
    private String memo;
    private Integer valid;

    @Override
    public String toString() {
        return "StudentTime{" +
                "ID=" + ID +
                ", curriculumId=" + curriculumId +
                ", studentId=" + studentId +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
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

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
