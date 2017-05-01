package day15.exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ServiceUser {
	public static int MAILINDEX = 1;
	private Map<Integer, Mail> rMail = new HashMap<Integer, Mail>();
	private Map<Integer, Mail> sMail = new HashMap<Integer, Mail>();
	private Map<Integer, Mail> tMail = new HashMap<Integer, Mail>();
	
	private String rMailFile;
	private String sMailFile;
	private String tMailFile;
	private String maxFile;
	
	private User usr;
	public ServiceUser(User usr) throws IOException {
		this.usr = usr;
		
		rMailFile = "data/"+ usr.getEmail() +"/"+ "r.txt";
		sMailFile = "data/"+ usr.getEmail() +"/"+ "s.txt";
		tMailFile = "data/"+ usr.getEmail() +"/"+ "t.txt";
		maxFile = "data/"+ usr.getEmail() +"/"+ "m.txt";
		
		
		if(!new File(maxFile).exists()) new File(maxFile).createNewFile(); 
		BufferedReader fr = new BufferedReader(new FileReader(new File(maxFile)));
		String data ="";
		while((data = fr.readLine()) != null) {
		}
		MAILINDEX = (data != null) && (data.length() > 0) ? Integer.parseInt(data) : 0;
		fr.close();
		
		load();
	}
	
	public void sendMail(Mail mail) throws IOException {
		sMail.put(mail.getNum(), mail);
		writeFileTo(mail, "data/"+ mail.getReciver() +"/"+ "r.txt");  // rMailFile
	}
	
	public Map<Integer, Mail> getSendMail() throws IOException {
		load();
		return sMail;
	}
	
	public Map<Integer, Mail> getRecMail() throws IOException {
		load();
		return rMail;
	}
	
	public Map<Integer, Mail> getTrashMail() throws IOException {
		load();
		return tMail;
	}
	
	private void writeFileTo(Mail mail, String path) throws IOException {
		BufferedReader fr = new BufferedReader(new FileReader(new File(path)));
		String data ="";
		int index = 0;
		while((data = fr.readLine()) != null) {
			++index;
		}
		fr.close();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), true));
		StringBuffer sb = new StringBuffer();
		sb.append(index + 1).append(":");
		sb.append(mail.getIsCheck()).append(":");
		sb.append(mail.getSender()).append(":");
		sb.append(mail.getReciver()).append(":");
		sb.append(mail.getTitle()).append(":");
		sb.append(mail.getContent()).append(":");
		sb.append(mail.getDate()).append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private void writeNewFile(Mail mail, String path, boolean isOver) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), !isOver));
		StringBuffer sb = new StringBuffer();
		sb.append(mail.getNum()).append(":");
		sb.append(mail.getIsCheck()).append(":");
		sb.append(mail.getSender()).append(":");
		sb.append(mail.getReciver()).append(":");
		sb.append(mail.getTitle()).append(":");
		sb.append(mail.getContent()).append(":");
		sb.append(mail.getDate()).append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public void transhMail(String judge, Integer removeIndex) throws IOException {
		if(judge.compareTo("s") == 0) {
			tMail.put(removeIndex, sMail.remove(removeIndex));
		} else if(judge.compareTo("r") == 0){
			tMail.put(removeIndex, rMail.remove(removeIndex));
		} else {
			tMail.remove(removeIndex);
		}
	}
	
	public void saveFile() throws IOException {
		Set<Integer> keys = rMail.keySet();
		boolean isOver = true;
		for (Integer key : keys) {
			Mail m = rMail.get(key);
			if(m != null) {
				writeNewFile(m, rMailFile, isOver);
				isOver = false;
			}
		}
		
		isOver = true;
		keys = sMail.keySet();
		for (Integer key : keys) {
			Mail m = sMail.get(key);
			if(m != null) {
				writeNewFile(m, sMailFile, isOver);
				isOver = false;
			}
		}
		
		isOver = true;
		keys = tMail.keySet();
		for (Integer key : keys) {
			Mail m = tMail.get(key);
			if(m != null) {
				writeNewFile(m, tMailFile, isOver);
				isOver = false;
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(maxFile)));
		bw.write(String.valueOf(MAILINDEX));
		bw.flush();
		bw.close();
	}
	
	private Map<Integer, Mail> loadToMap (String file) throws IOException {
		if(!new File(file).exists()) new File(file).createNewFile(); 
		
		BufferedReader fr = new BufferedReader(new FileReader(new File(file)));
		String data ="";
		Map<Integer, Mail> map = new HashMap<Integer, Mail>();
		int index = 1;
		while((data = fr.readLine()) != null) {
			String[] datas = data.split(":");
			Mail mail = new Mail(index++, datas[2], datas[3], datas[4], datas[5], datas[6]);
			System.out.println("load : " + mail.toString());
			map.put(mail.getNum(), mail);
		}
		fr.close();
		
		return map;
	}
	
	private void load() throws IOException {
		File dir = new File("data/"+usr.getEmail());
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		rMail = loadToMap(rMailFile);		
		sMail = loadToMap(sMailFile);		
		tMail = loadToMap(tMailFile);
	}
}
