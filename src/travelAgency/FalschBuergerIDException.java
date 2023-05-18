package travelAgency;

public class FalschBuergerIDException extends RuntimeException {
	public FalschBuergerIDException(String msg) {
		super(msg);
	}
	public FalschBuergerIDException() {
		super();
	}
}
