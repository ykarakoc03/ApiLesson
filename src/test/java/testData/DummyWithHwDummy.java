package testData;

import java.util.HashMap;

public class DummyWithHwDummy {

    int status;

    int id;
    String employee_name;
    int employee_salary;
    int employee_age;
    String profile_image;

    String message;


    public DummyWithHwDummy(int status,
                            int id,
                            String employee_name,
                            int employee_salary,
                            int employee_age,
                            String profile_image,
                            String message) {
        this.status = status;
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
        this.message = message;
    }

public HashMap<String,Object> dataMap(){

    HashMap<String,Object> expetedData = new HashMap<>();
    expetedData.put("status",status);
    expetedData.put("id",id);
    expetedData.put("employee_name",employee_name);
    expetedData.put("employee_salary",employee_salary);
    expetedData.put("employee_age",employee_age);
    expetedData.put("profile_image",profile_image);
    expetedData.put("message",message);

    return expetedData;

}

    @Override
    public String toString() {
        return "DummyWithHwDummy{" +
                "status=" + status +
                ", id=" + id +
                ", employee_name='" + employee_name + '\'' +
                ", employee_salary=" + employee_salary +
                ", employee_age=" + employee_age +
                ", profile_image='" + profile_image + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
