package kodlamaio.northwind.core.utilities.results;


import lombok.Data;

@Data
public class DataResult<L> extends Result {

    private L data;

    public DataResult(boolean success, String message, L data) {
        super(success, message);
        this.data = data;
    }

    public DataResult(boolean success, L data) {
        super(success);
        this.data = data;
    }
}
