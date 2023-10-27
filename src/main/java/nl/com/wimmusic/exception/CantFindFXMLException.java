package nl.com.wimmusic.exception;

public class CantFindFXMLException extends RuntimeException {
  public CantFindFXMLException(String message) {
    super(message);
  }

  public CantFindFXMLException(String message, Throwable cause) {
    super(message, cause);
  }

  public CantFindFXMLException(Throwable cause) {
    super(cause);
  }
}
