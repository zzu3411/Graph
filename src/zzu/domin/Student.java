package zzu.domin;

import javax.print.attribute.IntegerSyntax;

public class Student {

    private Integer ID;
    private String name;
    private String passWord;
    private Integer sex;
    private String age;
    private String specialty;
    private Integer flag;
    private String memo;
    private Integer valid;

    public Student(Integer ID, String name, String passWord, Integer sex, String age, String specialty, Integer flag, String memo, Integer valid) {
        this.ID = ID;
        this.name = name;
        this.passWord = passWord;
        this.sex = sex;
        this.age = age;
        this.specialty = specialty;
        this.flag = flag;
        this.memo = memo;
        this.valid = valid;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", sex=" + sex +
                ", age='" + age + '\'' +
                ", specialty='" + specialty + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
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
