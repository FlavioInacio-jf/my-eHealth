package javas.errors;

public class CustomError extends Error {
    public CustomError(String title, String detail) {
        super(title + ": " + detail);
    }
}
