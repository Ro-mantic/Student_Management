package pojo;

public class Account {
    private String Stu_id;
    private String name;
    private String class_id;
    private String Dor_id;

    public String getStu_id() {
        return Stu_id;
    }

    public void setStu_id(String stu_id) {
        Stu_id = stu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getDor_id() {
        return Dor_id;
    }

    public void setDor_id(String dor_id) {
        Dor_id = dor_id;
    }

    @Override
    public String toString() {
        return
                "Stu_id='" + Stu_id + '\'' +
                ", name='" + name + '\'' +
                ", class_id='" + class_id + '\'' +
                ", Dor_id='" + Dor_id + '\'' + "\n";
    }
}
