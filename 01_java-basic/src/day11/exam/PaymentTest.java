package day11.exam;

public class PaymentTest {

    public static void main(String[] args) throws PaymentException {
        
        CardPayment card1 = new CardPayment("11번가","Java책",17000,"123-432-111","0070",0);
        payProcess( card1 );        
        System.out.println("-------------------------------------");        
        CashPayment cash1 = new CashPayment("인터파크","에어컨",0,"198-32");
        payProcess( cash1 );
        System.out.println("-------------------------------------");    
    }
    
    public static void payProcess(Payment p) throws PaymentException {
        p.pay();
//        System.out.println(p);      
    }
}
