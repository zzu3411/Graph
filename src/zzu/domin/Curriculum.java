package zzu.domin;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class Curriculum {
    private Integer  ID ;
    private String curriculumName;
    private String curriculumEnglishName;
    private String curriculumDescription;
    private Integer credit;
    private Integer period;
    private Integer experimentPeriod	;
    private String curriculumCategory	;
    private Integer flag	;
    private String memo	;
    private Integer valid	;

    public Curriculum(Integer ID, String curriculumName, String curriculumEnglishName, String curriculumDescription, Integer credit, Integer period, Integer experimentPeriod, String curriculumCategory, Integer flag, String memo, Integer valid) {
        this.ID = ID;
        this.curriculumName = curriculumName;
        this.curriculumEnglishName = curriculumEnglishName;
        this.curriculumDescription = curriculumDescription;
        this.credit = credit;
        this.period = period;
        this.experimentPeriod = experimentPeriod;
        this.curriculumCategory = curriculumCategory;
        this.flag = flag;
        this.memo = memo;
        this.valid = valid;
    }

    public Curriculum() {
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "ID=" + ID +
                ", curriculumName='" + curriculumName + '\'' +
                ", curriculumEnglishName='" + curriculumEnglishName + '\'' +
                ", curriculumDescription='" + curriculumDescription + '\'' +
                ", credit=" + credit +
                ", period=" + period +
                ", experimentPeriod=" + experimentPeriod +
                ", curriculumCategory='" + curriculumCategory + '\'' +
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

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public String getCurriculumEnglishName() {
        return curriculumEnglishName;
    }

    public void setCurriculumEnglishName(String curriculumEnglishName) {
        this.curriculumEnglishName = curriculumEnglishName;
    }

    public String getCurriculumDescription() {
        return curriculumDescription;
    }

    public void setCurriculumDescription(String curriculumDescription) {
        this.curriculumDescription = curriculumDescription;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getExperimentPeriod() {
        return experimentPeriod;
    }

    public void setExperimentPeriod(Integer experimentPeriod) {
        this.experimentPeriod = experimentPeriod;
    }

    public String getCurriculumCategory() {
        return curriculumCategory;
    }

    public void setCurriculumCategory(String curriculumCategory) {
        this.curriculumCategory = curriculumCategory;
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
