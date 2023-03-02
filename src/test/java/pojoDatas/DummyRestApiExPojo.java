package pojoDatas;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

//id burada tanımlı variacle olmadogo için actual datayı alırken hata veriyor. bunun için ignore anatasyonunu yazıyoruz

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyRestApiExPojo {



    private String status;
    private  DummyRestApiPojo data;
    private String message;


    public DummyRestApiExPojo() {
    }

    public DummyRestApiExPojo(String status, DummyRestApiPojo data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyRestApiPojo getData() {
        return data;
    }

    public void setData(DummyRestApiPojo data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyRestApiReqPojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
