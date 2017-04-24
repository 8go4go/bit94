package day11.exam;

public class CardPayment extends Payment{
	private String cardNumber;
	private String cardPassword;
	private int montlyInstallment;
	public CardPayment(String shopName, String productName, long productPrice, 
			String cardNumber, String cardPassword, int monthlyInstallment) {
		super(shopName, productName, productPrice);
		// TODO Auto-generated constructor stub
		this.cardNumber = cardNumber;
		this.cardPassword = cardPassword;
		this.montlyInstallment = monthlyInstallment;
	}

	@Override
	public void pay() {
		if(montlyInstallment < 1 || productPrice < 1) {
			try {
				throw new PaymentException("가격이나 할부개월수가 잘못되었습니다.");
			} catch (PaymentException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "CardPayment [cardNumber=" + cardNumber + ", cardPassword=" + cardPassword + ", montlyInstallment="
				+ montlyInstallment + ", shopName=" + shopName + ", productName=" + productName + ", productPrice="
				+ productPrice + "]";
	}
}
