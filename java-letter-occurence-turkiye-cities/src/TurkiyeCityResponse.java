import java.util.List;

public class TurkiyeCityResponse {
    private String status;
    private List<TurkiyeCityResponseData> data;

    public TurkiyeCityResponse() {
    }

    public TurkiyeCityResponse(String status, List<TurkiyeCityResponseData> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TurkiyeCityResponseData> getData() {
        return data;
    }

    public void setData(List<TurkiyeCityResponseData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TurkiyeCityResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
