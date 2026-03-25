package baitap4;

import java.util.List;

public class BenhNhanDTO {
    private int patient_id;
    private String name;
    private String gender;
    private List<DichVu> dsDichVu;

    public BenhNhanDTO(int patient_id, String name, String gender, List<DichVu> dsDichVu) {
        this.patient_id = patient_id;
        this.name = name;
        this.gender = gender;
        this.dsDichVu = dsDichVu;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<DichVu> getDsDichVu() {
        return dsDichVu;
    }

    public void setDsDichVu(List<DichVu> dsDichVu) {
        this.dsDichVu = dsDichVu;
    }

    @Override
    public String toString() {
        return "BenhNhanDTO{" +
                "patient_id=" + patient_id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dsDichVu=" + dsDichVu +
                '}';
    }
}
