package edu.alpha.ems.exception;

@SuppressWarnings("serial")
public class DepartmentNotFoundException extends RuntimeException {
	private String message;

	public DepartmentNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
