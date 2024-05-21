package projects.exception;

public class dbexception extends RuntimeException {
	public dbexception (String message ) { super(message);}
	public dbexception (Throwable cause ) { super(cause);}
	public dbexception (String message, Throwable cause ) { super(message,cause);}

}
