package kr.heartof.member.vo;

import java.util.Date;

import kr.heartof.common.vo.FileVO;

public class MemberVO {
	private String mem_id;
	private String userid;
	private String last_name;
	private String first_name;
	private String phone;
	private String mobile;
	private Date reg_date;
	private Date expired_date;
	private String password;
	private String zip_id;
	private String status_id;
	private String prof_id;
	private String email;
	
	/**
	 * @return the prof_id
	 */
	public String getProf_id() {
		return prof_id;
	}

	/**
	 * @param prof_id the prof_id to set
	 */
	public void setProf_id(String prof_id) {
		this.prof_id = prof_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public Date getExpired_date() {
		return expired_date;
	}

	public void setExpired_date(Date expired_date) {
		this.expired_date = expired_date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getZip_id() {
		return zip_id;
	}

	public void setZip_id(String zip_id) {
		this.zip_id = zip_id;
	}

	public String getStatus_id() {
		return status_id;
	}

	public void setStatus_id(String status_id) {
		this.status_id = status_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
