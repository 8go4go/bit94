package day11.exam;

public class CashPayment extends Payment{
	private String cashReceiptNumber;
	public CashPayment(String shopName, String productName, long productPrice
			,String cashReceiptNumber) {
		super(shopName, productName, productPrice);
		// TODO Auto-generated constructor stub
		this.cashReceiptNumber = cashReceiptNumber;
	}

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		if(productPrice < 1) {
			try {
				throw new PaymentException("가격이나 할부개월수가 잘못되었습니다.");
			} catch (PaymentException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "CashPayment [cashReceiptNumber=" + cashReceiptNumber + ", shopName=" + shopName + ", productName="
				+ productName + ", productPrice=" + productPrice + "]";
	}
}
