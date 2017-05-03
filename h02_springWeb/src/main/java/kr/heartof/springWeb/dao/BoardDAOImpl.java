package kr.heartof.springWeb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import kr.heartof.springWeb.vo.BoardVO;

public class BoardDAOImpl implements BoardDAO{
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<BoardVO> list() {
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		
		 List<BoardVO> list = jdbcTemplate.query("select NO, title, writer, content, reg_date from tb_board order by NO desc", new RowMapper<BoardVO>() {
			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO v = new BoardVO();
				v.setNo(rs.getInt(1));
				v.setTitle(rs.getString(2));
				v.setWriter(rs.getString(3));
				v.setContent(rs.getString(4));
				v.setReg_date(rs.getDate(5));
				return v;
			}
		 });
		return list;
	}

	@Override
	public BoardVO detail(BoardVO vo) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<BoardVO> list = jdbcTemplate.query("select NO, title, writer, content, reg_date from tb_board where no = " + vo.getNo(), new RowMapper<BoardVO>() {
			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO v = new BoardVO();
				v.setNo(rs.getInt(1));
				v.setTitle(rs.getString(2));
				v.setWriter(rs.getString(3));
				v.setContent(rs.getString(4));
				v.setReg_date(rs.getDate(5));
				return v;
			}
			
		});
		return list.get(0);
	}

	@Override
	public boolean insert(BoardVO vo) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int result = jdbcTemplate.update("insert into tb_board (no, title, content, writer) values (tb_board_seq.nextval, ?, ?, ?)", 
				new Object[]{vo.getTitle(), vo.getContent(), vo.getWriter()});
		return result == 0 ? false : true;
	}

	@Override
	public boolean modify(BoardVO vo) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int result = jdbcTemplate.update("update tb_board set title = ?, content = ?, writer = ? where no = ?", 
				new Object[]{vo.getTitle(), vo.getContent(), vo.getWriter(), vo.getNo()});
		return result == 0 ? false : true;
	}

	@Override
	public boolean delete(BoardVO vo) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int result = jdbcTemplate.update("delete from tb_board where no = " + vo.getNo());
		return result == 0 ? false : true;
	}
}
