package day15.exam;

import java.io.FileNotFoundException;

//#####################
//### 상품 관리 시스템 ###
//#####################
public class ProductMain {
	public static void main(String[] args) throws FileNotFoundException {
		ProductService ps = new ProductService("data/product.txt");
		ps.service();
	}
}
