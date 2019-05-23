package ca.by.project_x.exception;


public class GenericBackendException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GenericBackendException() {
		super();
	}

	public GenericBackendException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GenericBackendException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenericBackendException(String message) {
		super(message);
	}

	public GenericBackendException(Throwable cause) {
		super(cause);
	}

}
