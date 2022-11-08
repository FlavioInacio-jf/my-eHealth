package javas.errors;

public class CustomError extends Exception {
    private String title;
    private String detail;

    public CustomError(String title, String detail) {
        super(title + ": " + detail);
    }
}
