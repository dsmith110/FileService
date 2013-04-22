package FileService;

/**
 *
 * @author Dan Smith
 */
public class InvalidFilePathException extends Exception {
    private static final String ERR_MSG = "Invalid file path found";

    public InvalidFilePathException() {
        super(ERR_MSG);
    }

    public InvalidFilePathException(String message) {
        super(ERR_MSG);
    }

    public InvalidFilePathException(String message, Throwable cause) {
        super(ERR_MSG, cause);
    }

}
