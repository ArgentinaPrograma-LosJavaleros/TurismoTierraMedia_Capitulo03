package app;

@SuppressWarnings("serial")
public class NoExistePromocionException extends Exception {

	public NoExistePromocionException() {}

	public NoExistePromocionException(String message) {
		super(message);
	}

	public NoExistePromocionException(Throwable cause) {
		super(cause);
	}

	public NoExistePromocionException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoExistePromocionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
