package day09.exam;

public class MultipartFile {
	private String name = null;
	private String content = null;
	
	public MultipartFile(String name, String content){
		this.name = name;
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getName() {
		return name;
	}
}
