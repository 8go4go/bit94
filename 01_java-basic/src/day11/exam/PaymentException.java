package day11.exam;

public class PaymentException extends Exception {
	public PaymentException(){}
	
	public PaymentException(String msg) {
		super(msg);
	}
}
