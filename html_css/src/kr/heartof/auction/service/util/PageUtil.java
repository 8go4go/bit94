package kr.heartof.auction.service.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.heartof.auction.service.foruser.dao.QnaDAO;
import kr.heartof.auction.vo.BoardVO;

public class PageUtil {
	// 한 화면에 보여질 게시물 갯수 정보
	public static final int PAGE_10 = 10;
	public static final int PAGE_20 = 20;
	public static final int PAGE_30 = 30;
	
	public static final int BLOCKPAGE_5 = 5;
	public static final int BLOCKPAGE_10 = 10;
	public static final int BLOCKPAGE_15 = 15;
	
	private int viewCount;
	private int showBlockPageCount;
	private QnaDAO dao;
	public PageUtil(int showBlockPageCount) {
		this(PAGE_10, showBlockPageCount);
	}
	
	public PageUtil(int viewCount, int showBlockPageCount) {
		this.viewCount = viewCount;
		this.showBlockPageCount = showBlockPageCount;
	}
	
	public int getShowBlockPageCount() {
		return showBlockPageCount;
	}
	
	
	
	public int getTotalBlcok() {
		int totalPage = getTotalPage();
		if(totalPage > showBlockPageCount) {
			return totalPage / showBlockPageCount + (totalPage % showBlockPageCount  > 0 ? 1 : 0);
		} else {
			return 1;
		}
	}
	
	public int getCurrentPageFromClinet(HttpServletRequest request) {
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		return currentPage;
	}
	
	public int getTotalPage() {
		int total = getTotalFromBoardData();
		if(total > viewCount) {
			int totalPage = total / viewCount + (total % viewCount > 0 ? 1 : 0);
			return totalPage;
		} else {
			return 1;
		}
	}
	
	public int getViewCount() {
		return viewCount;
	}
	
	public int getTotalFromBoardData() {
		return dao.getBoardTotal();
	}
	
	public List<BoardVO> getRequestBoardList(int currentPage) {
		return dao.getBoardList(currentPage, viewCount);
	}
	
	public void setDAO(QnaDAO dao) {
		this.dao = dao;
	}

	public int getStart(HttpServletRequest request) {
		int currentPage = getCurrentPageFromClinet(request);
		int i = 1;
		for(; i < getTotalBlcok() + 1 ; i++) {
			if(showBlockPageCount * i > currentPage) {
				return showBlockPageCount * (i - 1) + 1;
			}
		}
		return 0;
	}

	public int getEnd(HttpServletRequest request) {
		int currentPage = getCurrentPageFromClinet(request);
		int i = 1;
		for(; i < getTotalBlcok() + 1 ; i++) {
			if(showBlockPageCount * i > currentPage) {
				if(getTotalPage() < showBlockPageCount * i)
					return getTotalPage();
				else
					return showBlockPageCount * i;
			}
		}
		return 0;
	}
}
