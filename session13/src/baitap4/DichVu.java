package baitap4;

public class DichVu {
    private int service_id;
    private int patient_id;
    private String service_name;

    public DichVu(int service_id, int patient_id, String service_name) {
        this.service_id = service_id;
        this.patient_id = patient_id;
        this.service_name = service_name;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    @Override
    public String toString() {
        return "DichVu{" +
                "service_id=" + service_id +
                ", service_name='" + service_name + '\'' +
                '}';
    }
}
