package kr.heartof.auction.service.foruser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.auction.service.foruser.dao.QnaDAO;
import kr.heartof.auction.service.foruser.dao.QnaDAOImpl;
import kr.heartof.auction.service.util.PageUtil;
import kr.heartof.auction.vo.foruser.BoardVO;

public class QnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PageUtil util;
    private QnaDAO dao;
    public QnaServlet() {
        super();
        util = new PageUtil();
        dao = new QnaDAOImpl();
    }
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Content-Type", "text/html;charset=UTF-8");
		int currentPage = util.getCurrentPage(request);
		List<BoardVO> list = getBoardData(currentPage);
		int total = dao.getBoardTotal();
		
		int totalPage = util.getTotalPage(total);
		
		List<BoardVO> sendList = null;
		if(currentPage != totalPage) {
			sendList = arraycopy(list, (currentPage - 1) * 10, 10);
		} else { 
			sendList = arraycopy(list, (currentPage - 1) * 10, total % 10);
		}
			
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/foruser/qna.jsp");
		request.setAttribute("list", sendList);
		request.setAttribute("total", 56);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private List<BoardVO> getBoardData(int currentPage) {
		return dao.getBoardList();
	}
	
	private List<BoardVO> arraycopy(List<BoardVO> source, int startIndex, int count) {
		List<BoardVO> sendList = new ArrayList<BoardVO>();
		for(int i = startIndex; i < source.size() ; i++) {
			if(count-- > 0) {
				sendList.add(source.get(i));
			} else {
				break;
			}
		}
		return sendList;
	}
}
