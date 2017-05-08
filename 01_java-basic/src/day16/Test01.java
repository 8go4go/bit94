package day16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.149:1521:XE", "hr", "1234");
		
		PreparedStatement stmt = con.prepareStatement("insert into tb_board (no, title, writer, content, reg_date) values (tb_board_seq.nextVal,?,?,?, sysdate)");
		
		stmt.setString(1, "안녕 타이틀");
		stmt.setString(2, "안녕 이름");
		stmt.setString(3, "안녕 내용");
		
		System.out.println(stmt.execute());
	}
}
