package pojoDatas;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

//usuşmama durumunda nadiren kullanılır
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestCoApiPojo {


    /*
        {
    "id": 724790,
    "name": "Adheesh Chopra",
    "email": "adheesh_chopra@schamberger-langosh.biz",
    "gender": "male",
    "status": "active"
}
     */

    private int id;
    private String name;
    private String email;
    private String gende;
    private String status;


    public GoRestCoApiPojo() {
    }

    public GoRestCoApiPojo(int id, String name, String email, String gende, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gende = gende;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGende() {
        return gende;
    }

    public void setGende(String gende) {
        this.gende = gende;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GoRestCoApiPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gende='" + gende + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
