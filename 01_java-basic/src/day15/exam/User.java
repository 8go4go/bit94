package day15.exam;

import java.io.IOException;

public class User {
	private String email;
	private String password;
	private String hint;
	private String name;
	private String gender;
	private String phone;
	private String lastLogTime;
	
	public User(String email, String password, String hint, 
			String name, String gender, String phone, String lastLogTime) throws IOException {
		this.email = email;
		this.password = password;
		this.hint = hint;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.lastLogTime = lastLogTime;
	}

	
	/**
	 * @return the email
	 */
	String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the hint
	 */
	String getHint() {
		return hint;
	}

	/**
	 * @param hint
	 *            the hint to set
	 */
	void setHint(String hint) {
		this.hint = hint;
	}

	/**
	 * @return the name
	 */
	String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the phone
	 */
	String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	void setPhone(String phone) {
		this.phone = phone;
	}

	public String contentForWrite() {
		StringBuffer sb = new StringBuffer();
		sb.append(email).append(":");
		sb.append(password).append(":");
		sb.append(name).append(":");
		sb.append(gender).append(":");
		sb.append(phone).append(":");

		return sb.toString();
	}

	/**
	 * @return the lastLogTime
	 */
	String getLastLogTime() {
		return lastLogTime;
	}

	/**
	 * @param lastLogTime
	 *            the lastLogTime to set
	 */
	void setLastLogTime(String lastLogTime) {
		this.lastLogTime = lastLogTime;
	}
}
