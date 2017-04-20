package day09.exam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class MultipartRequest {
	public static final String SKIP_STATEMENT = "------";
	public static final String CONTENT_DISPOSITION = "Content-Disposition";
	public static final String CONTENT_TYPE = "Content-Type";
	
//	public static final String REGEX_1 = "[name=\"]";
//	public static final String REGEX_2 = "[filename=\"]";
	
	private Vector<MultipartFile> files = new Vector<MultipartFile>();
	
	private Hashtable<String, String> params = new Hashtable<String, String>();
	
	private String path = null;
	public MultipartRequest(String path) throws IOException {
		this.path = path;
		parse();
	}
	
	public String getParameter(String id) {
		return params.get(id);
	}
	
	public MultipartFile[] getFiles() {
		MultipartFile[] mfiles = files.toArray(new MultipartFile[files.size()]);
		return mfiles;
	}
	
	private void parse() throws IOException {
		Scanner sc = new Scanner(new File(path));
		while(sc.hasNext()) {
			String data = sc.nextLine();
			
			StringBuffer sb = new StringBuffer();
			String key = null;
			String value = null;
			if(!data.contains(SKIP_STATEMENT)) {
				if(data.contains(CONTENT_DISPOSITION)) {
					String datas[] = data.split(";");
					
					key = datas[1].replaceAll("name=", "").replaceAll("\"", "");
					
					boolean isMakeFile = false;
					if(key.trim().compareTo("uploadfile") == 0 || key.trim().compareTo("uploadfile2") == 0) {
						key = datas[2].replaceAll("filename=", "").replaceAll("\"", "");
						isMakeFile = true;
					}
					
					while(true) {
						String innerData = sc.nextLine();
						if(innerData.contains(SKIP_STATEMENT)) break;
						if(innerData.contains(CONTENT_TYPE)) continue;
						sb.append(innerData+"\n");
					}
					
					if(isMakeFile) {
						files.addElement(new MultipartFile(key, sb.toString()));
					}
				}
				value = sb.toString();
				if(key != null)
					params.put(key.trim(), value);
			}
		}
		
		makeXml();
	}
	
	private void makeXml() throws IOException {
		FileOutputStream f = new FileOutputStream(new File("C:/git/01_java-basic/ioload/day09/pom.xml"));
		String OPEN ="<";
		String CLOSE = ">";
		String FINAL = "/";
		f.write(new String("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").getBytes());
		Set<String> keys = params.keySet();
		StringBuffer sb = new StringBuffer();
		sb.append(OPEN).append("Content").append(CLOSE).append("\n");
		for(String key : keys) {
			sb.append("\t").append(OPEN).append(key).append(CLOSE).append("\n");
			sb.append("\t").append(params.get(key)).append("\n");
			sb.append("\t").append(OPEN).append(key).append(FINAL).append(CLOSE).append("\n");
		}
		sb.append(OPEN).append("Content").append(FINAL).append(CLOSE).append("\n");
		
		f.write(sb.toString().getBytes());
		f.flush();
		f.close();
	}
}
