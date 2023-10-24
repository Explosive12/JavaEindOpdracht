package nl.com.wimmusic.Exception;

public class CantFindDatabaseFileException extends RuntimeException{
    public CantFindDatabaseFileException(String message) {
        super(message);
    }

    public CantFindDatabaseFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public CantFindDatabaseFileException(Throwable cause) {
        super(cause);
    }
}
