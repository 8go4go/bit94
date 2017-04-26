package kr.heartof.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.heartof.board.vo.BoardVO;

public class BoardDAO {
	private SqlSessionTemplate session;
	public void setSqlSessionTemplate(SqlSessionTemplate session) {
		this.session = session; 
	}
	
	public void selectList(){
		List<BoardVO> list = session.selectList("kr.heartof.board.mybatis.BoardMapper.selectList");
		System.out.println("---------------------------");
		System.out.println("번호\t제목\t글쓴이");
		System.out.println("---------------------------");
		if(list != null || list.size() > 0)
			for(BoardVO vo : list) {
				System.out.printf("%d\t%s\t%s\n", vo.getNo(), vo.getTitle(), vo.getWriter());
			}
		else
			System.out.println("게시물이 존재하지 않습니다.");
	}
	
	public void selectOne(int num) {
		BoardVO vo = session.selectOne("kr.heartof.board.mybatis.BoardMapper.selectOne", num);
		if(vo != null) {
			System.out.println("번호 : " + vo.getNo());
			System.out.println("제목 : " + vo.getTitle());
			System.out.println("글쓴이 : " + vo.getWriter());
			System.out.println("내용 : " + vo.getContent());
		} else {
			System.out.println("게시물이 존재하지 않습니다.");
		}
		
	}
	
	public void insert(String title, String content, String writer) {
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		
		int result = session.insert("kr.heartof.board.mybatis.BoardMapper.insert", vo);
		System.out.println(result > 0 ? "글등록이 완료 되었습니다." : "글등록이 실패하였습니다.");
		
	}
	
	public void update(int num, String title, String content, String writer) {
		BoardVO vo = new BoardVO();
		vo.setNo(num);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		int result = session.update("kr.heartof.board.mybatis.BoardMapper.update", vo);
		
		System.out.println(result > 0 ? "글수정이 완료 되었습니다." : "글수정이 실패하였습니다.");
	}
	
	public void delete(int no) {
		int result = session.delete("kr.heartof.board.mybatis.BoardMapper.delete", no);
		System.out.println(result > 0 ? "글삭제가 완료 되었습니다." : "글삭제가 실패하였습니다.");
	}
}
