package baitap5;

public class Patient {
    private int id;
    private String fullName;
    private String departmentTreat;
    private int days;

    public Patient(int id, String fullName, String departmentTreat, int days) {
        this.id = id;
        this.fullName = fullName;
        this.departmentTreat = departmentTreat;
        this.days = days;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartmentTreat() {
        return departmentTreat;
    }

    public void setDepartmentTreat(String departmentTreat) {
        this.departmentTreat = departmentTreat;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", departmentTreat='" + departmentTreat + '\'' +
                ", days=" + days +
                '}';
    }
}
