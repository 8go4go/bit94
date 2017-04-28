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

public class Exam07 {
	public static void main(String[] args) throws IOException{
		FileFinder f = new FileFinder("c:/java", "java", "System", "@");
		f.service();
	}
}

class FileFinder {
	private boolean isExit = false;
	private Scanner sc = new Scanner(System.in);
	private File findDir;
	private String extendedFileName;
	private String searchWord;
	private String delm;
	private List<String> seachResult = new ArrayList<String>();
	public FileFinder(String path, String extendedFileName, String searchWord, String delm) {
		findDir = new File(path);
		this.extendedFileName = extendedFileName;
		this.searchWord = searchWord;
		this.delm = delm; 
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
				print();
				break;
			case 2:
				saveFile();
				break;
			case 3:
				showSavedFile();
				break;
			case 4:
				exit();
				break;
			}
		}
	}
	
	private void showSavedFile() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(new File(findDir.getAbsolutePath() + "/result.txt")));
		String data="";
		StringBuffer sb = new StringBuffer();
		while((data = br.readLine()) != null) {
			sb.append(data).append("\n");
		}
		br.close();
		
		System.out.println(sb.toString());
	}

	private void saveFile() throws IOException {
		// TODO Auto-generated method stub
		String head = "------------------------------------------------";
		String searchDir = "검색할 디렉토리 : " + findDir.getAbsolutePath();
		String searchEx = "검색할 파일 확장자 : " + extendedFileName;
		String shWord = "검색할 단어 : " + searchWord;
		String sDelm = "검색된 단어 양옆에 표시할 문자 : " + delm;
		String resultFileName = "result.txt";
		String resultFileNameDesc = "검색 결과를 저장할 파일명 : " + resultFileName;
		System.out.println(head);
		System.out.println(searchDir);
		
		System.out.println(searchEx);
		System.out.println(shWord);
		System.out.println(sDelm);
		System.out.println(resultFileNameDesc);
		System.out.println(head);
		
		if(seachResult.size() > 0) {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(findDir.getAbsolutePath() +"/" +resultFileName), true));
			
			for(String s : seachResult) {
				bw.write(s);
			}
			bw.flush();
			bw.close();
			File resultFile = new File(findDir.getAbsolutePath() + "/result.txt");
			if(resultFile.exists())
				System.out.printf("%s 파일생성 완료되었습니다.\n", resultFile.getName());
			else
				System.out.printf("%s 파일생성 실패되었습니다.\n", resultFile.getName());
		} else {
			System.out.println("저장할 내용이 없습니다.");
		}
	}

	private String getExtendedFileName(File f) {
		int index = f.getName().indexOf(".");
		String returnStr = f.getName().substring(index+1, f.getName().length());
		return returnStr;
	}
	
	private void print() throws IOException{
		// TODO Auto-generated method stub
		String head = "------------------------------------------------";
		String searchDir = "검색할 디렉토리 : " + findDir.getAbsolutePath();
		String searchEx = "검색할 파일 확장자 : " + extendedFileName;
		String shWord = "검색할 단어 : " + searchWord;
		String sDelm = "검색된 단어 양옆에 표시할 문자 : " + delm;
		seachResult.add(head + "\n");
		seachResult.add(searchDir + "\n");
		seachResult.add(searchEx + "\n");
		seachResult.add(shWord + "\n");
		seachResult.add(sDelm + "\n");
		seachResult.add(head + "\n");
		
		System.out.println(head);
		System.out.println(searchDir);
		
		System.out.println(searchEx);
		System.out.println(shWord);
		System.out.println(sDelm);
		System.out.println(head);
		
		File[] list = findDir.listFiles();
		List<File> searchedList = new ArrayList<File>();
		for(File f : list) {
			if(f.isFile()) {
				String ef = getExtendedFileName(f);
				if(ef.compareToIgnoreCase(extendedFileName) == 0) {
					searchedList.add(f);
				}
			}
		}
		if(searchedList.size() > 0) {
			int foundCount = 0;
			for(File f : searchedList) {
				String fn = f.getName();
				seachResult.add("파일명 : " + fn + "\n");
				
				BufferedReader br = new BufferedReader(new FileReader(f));
				String data="";
				int atomCount = 0;
				while((data = br.readLine()) != null) {
					if(data.contains(searchWord)) {
						foundCount++;
						atomCount++;
						seachResult.add(data.replaceAll(searchWord, String.valueOf(delm+searchWord+delm)).trim() + "\n");
					}
				}
				br.close();
				if(atomCount < 1) {
					seachResult.add("결과가 없습니다.\n");
				}
				seachResult.add("\n");
				
			}
			if(foundCount > 0) {
				System.out.println(seachResult.toString());
			} else {
				seachResult.add("결과가 없습니다." + "\n");
			}
		} else
			System.out.println("결과가 없습니다.");
			
		
	}

	private void showMenu() {
		System.out.println("---------------------------------");
		System.out.println("1. 검색결과를 화면에 출력 ");
		System.out.println("2. 검색결과를 파일에 저장 ");
		System.out.println("3. 저장된 결과 보기");
		System.out.println("4. 종료                          ");
		System.out.println("---------------------------------");
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
		}
	}
}
