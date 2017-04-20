package day09;

public class DogMain {
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		Dog dog2 = new Dog("쫑");
		Dog dog3 = new Dog(3);
		Dog dog4 = new Dog("메리", 2);
		
		dog1.info();
	    dog2.info();
        dog3.info();
        dog4.info();
	}
}