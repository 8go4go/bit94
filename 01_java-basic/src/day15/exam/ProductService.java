package day15.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ProductService {
	private boolean isExit = false;
	private Scanner sc;
	private List<Product> list;
	public ProductService(String fileName) throws FileNotFoundException {
		sc = new Scanner(new File(fileName));
		list = new ArrayList<Product>();
		loadData();
	}
	
	private void loadData() {
		while(sc.hasNext()) {
			String[] temp = sc.nextLine().split(":");
			Product p = new Product();
			p.setProductCompany(temp[0]);
			p.setProduct(temp[1]);
			p.setProductNum(temp[2]);
			p.setPrice(Long.parseLong(temp[3]));
			list.add(p);
		}
		sc.close();
		sc = new Scanner(System.in);
	}
	
	private void showMenu() {
		System.out.println("---------------------------------");
		System.out.println("상품관리 시스템                  ");
		System.out.println("---------------------------------");
		System.out.println("1. 전체 검색                     ");
		System.out.println("2. 금액 검색                     ");
		System.out.println("3. 상품명 검색                   ");
		System.out.println("4. 종료                          ");
		System.out.println("---------------------------------");
	}
	
	private long getInputLong() {
		return Long.parseLong(sc.nextLine());
	}
	
	private int getInputInt() {
		return Integer.parseInt(sc.nextLine());
	}
	
	private String getInput() {
		return sc.nextLine();
	}
	
	public void service() {
		while(!isExit) {
			showMenu();
			int menu = getInputInt();
			switch(menu) {
			case 1:
				allSearch();
				break;
			case 2:
				searchPrice();
				break;
			case 3:
				searchName();
				break;
			case 4:
				exit();
				break;
			}
		}
	}
	
	public void allSearch() {
		System.out.println("------------------------------------------------");
		System.out.println("\t제조회사\t상품명\t상품번호\t가격");
		System.out.println("------------------------------------------------");
		for(Product p : list) {
			System.out.printf("\t%s\t%s\t%s\t%d\n", p.getProductCompany(), p.getProduct(), p.getProductNum(), p.getPrice());
		}
		System.out.println("------------------------------------------------");
	}
	
	public void searchPrice () {
		System.out.println("------------------------------------------------");
		System.out.println("금액으로 검색");
		System.out.println("------------------------------------------------");
		System.out.print("낮은 금액 : ");
		long low = getInputLong();
		System.out.print("높은 금액 : ");
		long high = getInputLong();
		System.out.println("------------------------------------------------");
		System.out.println("\t제조회사\t상품명\t상품번호\t가격");
		System.out.println("------------------------------------------------");
		int foundCount = 0;
		for(Product p : list) {
			if(low <= p.getPrice() && high >= p.getPrice()) {
				System.out.printf("\t%s\t%s\t%s\t%d\n", p.getProductCompany(), p.getProduct(), p.getProductNum(), p.getPrice());
				foundCount++;
			}
		}		
		
		if(foundCount == 0)
			System.out.println("검색된 상품 정보가 없습니다.");
		System.out.println("------------------------------------------------");
	}
	
	public void searchName() {
		System.out.println("------------------------------------------------");
		System.out.println("상품명으로 검색");
		System.out.println("------------------------------------------------");
		System.out.print("상품명 : ");
		String name = getInput();
		
		System.out.println("------------------------------------------------");
		System.out.println("\t제조회사\t상품명\t상품번호\t가격");
		System.out.println("------------------------------------------------");
		int foundCount = 0;
		for(Product p : list) {
			if(p.getProduct().contains(name)) {
				System.out.printf("\t%s\t%s\t%s\t%d\n", p.getProductCompany(), p.getProduct(), p.getProductNum(), p.getPrice());
				foundCount++;
			}
		}		
		
		if(foundCount == 0)
			System.out.println("검색된 상품 정보가 없습니다.");
		System.out.println("------------------------------------------------");
		
	}
	
	public void exit() {
		System.out.print("종료하시겠습니까? (취소 : N, 종료 : 엔터) : ");
		String choice = getInput();
		if(choice.compareToIgnoreCase("N") == 0){
			System.out.println("취소하였습니다.");
			return;
		}
		
		System.out.println("종료되었습니다.");
		isExit = true;
		if(sc != null)
			sc.close();
	}
}
