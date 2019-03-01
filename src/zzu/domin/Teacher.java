package zzu.domin;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class Teacher {
    private Integer ID;
    private String teacherName;
    private String passWord;
    private Integer teacherSex;
    private Integer teacherAge;
    private String teacherSpecialty;
    private String professionalTitle;
    private Integer flag;
    private String memo;
    private Integer valid;

    @Override
    public String toString() {
        return "Teacher{" +
                "ID=" + ID +
                ", teacherName='" + teacherName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", teacherSex=" + teacherSex +
                ", teacherAge=" + teacherAge +
                ", teacherSpecialty='" + teacherSpecialty + '\'' +
                ", professionalTitle='" + professionalTitle + '\'' +
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(Integer teacherSex) {
        this.teacherSex = teacherSex;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getTeacherSpecialty() {
        return teacherSpecialty;
    }

    public void setTeacherSpecialty(String teacherSpecialty) {
        this.teacherSpecialty = teacherSpecialty;
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
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
