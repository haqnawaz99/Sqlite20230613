package haqnawaz.org.sqlitedatabase;

public class StudentM {
    private String name;
    private String semester;
    private Boolean isEnrolled;

    public StudentM(String name, String semester, Boolean isEnrolled) {
        this.name = name;
        this.semester = semester;
        this.isEnrolled = isEnrolled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Boolean getEnrolled() {
        return isEnrolled;
    }

    public void setEnrolled(Boolean enrolled) {
        isEnrolled = enrolled;
    }
}
