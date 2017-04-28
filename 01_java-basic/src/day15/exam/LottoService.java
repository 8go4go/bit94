package day15.exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoService {
	private boolean isExit = false;
	private Scanner sc;
	private List<Lotto> list;
	private List<String> registList = new ArrayList<String>();
	private BufferedWriter fw = null;
	private BufferedReader fr = null;
	
	public LottoService(String fileName) throws IOException {
		sc = new Scanner(System.in);
		list = new ArrayList<Lotto>();
		fw = new BufferedWriter(new FileWriter(new File(fileName), true));
		fr = new BufferedReader(new FileReader(new File(fileName)));
		createLotto();
	}
	
	private void showMenu() {
		System.out.println("---------------------------------");
		System.out.println("로또(LOTTO) 관리자 시스템");
		System.out.println("---------------------------------");
		System.out.println("1. 각 회별 로또 번호 보기");
		System.out.println("2. 번호별 당첨된 횟수 보기");
		System.out.println("3. 당첨 번호 등록");
		System.out.println("4. 종료                          ");
		System.out.println("---------------------------------");
	}
	
	private void createLotto() throws IOException {
		String data = "";
		for(int i=0; i< 45; i++) {
			list.add(new Lotto(i+1));
		}
		
		while ((data = fr.readLine()) != null) {
			registList.add(data);

			String[] numStr = data.split(" ");
			
			for(Lotto l : list) {
				for (int i = 1; i < numStr.length; i++) {
					if (l.getNum() == Integer.parseInt(numStr[i])) {
						l.addCount();
					}
				}
			}
		}
	}
	
	private int getInputInt() {
		return Integer.parseInt(sc.nextLine());
	}
	
	private String getInput() {
		return sc.nextLine();
	}
	
	public void service() throws IOException {
		while(!isExit) {
			showMenu();
			int menu = getInputInt();
			switch(menu) {
			case 1:
				allView();
				break;
			case 2:
				viewDetail();
				break;
			case 3:
				register();
				break;
			case 4:
				exit();
				break;
			}
		}
	}

	private void exit() throws IOException {
		// TODO Auto-generated method stub
		System.out.print("종료하시겠습니까? (취소 : N, 종료 : 엔터) : ");
		String choice = getInput();
		if(choice.compareToIgnoreCase("N") == 0){
			System.out.println("취소하였습니다.");
			return;
		}
		
		System.out.println("종료되었습니다.");
		isExit = true;
		if(sc != null) {
			sc.close();
			fw.close();
			fr.close();
		}
	}

	private void register() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("------------------------------------------------");
		System.out.println("로또 당첨 번호 등록");
		System.out.println("------------------------------------------------");
		System.out.print("회차 :");
		String count = getInput();
		System.out.print("당첨번호 : ");
		String num = getInput();
		
		boolean isCan = true;
		for(String s : registList) {
			if(s.startsWith(count)) {
				System.out.println("이미 등록된 회차입니다.");
				isCan = false;
				break;
			}
		}
		
		if(isCan) {
			StringBuffer sb = new StringBuffer();
			sb.append(count).append(" ").append(num);
			registList.add(sb.toString());
			
			String[] numStr = num.split(" ");
			
			for(Lotto l : list) {
				for(int i=0; i<numStr.length;i++) {
					if(l.getNum() == Integer.parseInt(numStr[i]))
						l.addCount();
				}
			}
			
			fw.write("\n");
			fw.flush();
			fw.write(sb.toString());
			fw.flush();
		}
	}

	private void viewDetail() {
		// TODO Auto-generated method stub
		System.out.println("------------------------------------------------");
		System.out.println("번호별 당첨 횟수");
		System.out.println("------------------------------------------------");
		int sp = 0;
		if(list.size() > 0) {
			for(Lotto l : list) {
				sp++;
				System.out.printf("%d번:%d회\t", l.getNum(), l.getCount());
				
				if(sp % 5 == 0) {
					sp = 0;
					System.out.println();
				}
			}
		} else
			System.out.printf("등록된 로또 번호가 없습니다.\n");
	}

	private void allView() {
		// TODO Auto-generated method stub
		System.out.println("------------------------------------------------");
		System.out.println("각 회별 로또 번호");
		System.out.println("------------------------------------------------");
		if(registList.size() > 0) {
			System.out.printf("총 %d\n", registList.size());
			for(int i = registList.size() - 1; i >= 0; i--) {
				String temp[] = registList.get(i).split(" ");
				System.out.printf("%s회. %s %s %s %s %s\n", temp[0],temp[1],temp[2],temp[3],temp[4],temp[5]);
			}
		} else
			System.out.printf("등록된 로또 번호가 없습니다.\n");
	}
}
