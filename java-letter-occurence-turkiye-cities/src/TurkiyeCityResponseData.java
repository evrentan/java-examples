public class TurkiyeCityResponseData {
    private String name;

    public TurkiyeCityResponseData() {
    }

    public TurkiyeCityResponseData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TurkiyeCityResponseData{" +
                "name='" + name + '\'' +
                '}';
    }
}
