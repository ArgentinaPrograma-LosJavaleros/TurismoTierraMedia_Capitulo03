package app;

@SuppressWarnings("serial")
public class NoExisteTematicaException extends Exception {

	public NoExisteTematicaException() {}

	public NoExisteTematicaException(String message) {
		super(message);
	}

	public NoExisteTematicaException(Throwable cause) {
		super(cause);
	}

	public NoExisteTematicaException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoExisteTematicaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
