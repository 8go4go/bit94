package kr.heartof.auction.service.foruser;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.auction.service.foruser.dao.QnaDAOImpl;
import kr.heartof.auction.service.util.PageUtil;
import kr.heartof.auction.vo.BoardVO;

public class QnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PageUtil util;
    public QnaServlet() {
        super();
        util = new PageUtil(PageUtil.PAGE_30, PageUtil.BLOCKPAGE_5);
        util.setDAO(new QnaDAOImpl());
    }
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Content-Type", "text/html;charset=UTF-8");
		int currentPage = util.getCurrentPageFromClinet(request);
		int total = util.getTotalFromBoardData();
		int totalPage = util.getTotalPage();
		List<BoardVO> sendList = util.getRequestBoardList(currentPage);;
			
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/foruser/qna.jsp");
		request.setAttribute("list", sendList);
		request.setAttribute("total", total);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("start", util.getStart(request));
		request.setAttribute("end", util.getEnd(request));
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
