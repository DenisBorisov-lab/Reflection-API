package personExample;

public enum Position {
    Junior("junior dev"),
    Middle("middle dev"),
    Senior("senior dev");


    private String message;

    Position(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
