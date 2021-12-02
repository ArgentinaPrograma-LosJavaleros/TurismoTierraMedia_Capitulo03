package app;

@SuppressWarnings("serial")
public class NoExisteAtraccionException extends Exception {

	public NoExisteAtraccionException() {}

	public NoExisteAtraccionException(String message) {
		super(message);
	}

	public NoExisteAtraccionException(Throwable cause) {
		super(cause);
	}

	public NoExisteAtraccionException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoExisteAtraccionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
