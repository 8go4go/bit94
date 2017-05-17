package kr.heartof.auction.service.util;

import javax.servlet.http.HttpServletRequest;

public class PageUtil {
	public static final int PAGE_10 = 10;
	public static final int PAGE_20 = 20;
	public static final int PAGE_30 = 30;
	
	private int viewCount;
	
	public PageUtil() {
		this(PAGE_10);
	}
	
	public PageUtil(int viewCount) {
		this.viewCount = viewCount;
	}
	
	public int getCurrentPage(HttpServletRequest request) {
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		return currentPage;
	}
	
	public int getTotalPage(int total) {
		int totalPage = total / viewCount + (total % viewCount > 0 ? 1 : 0);
		return totalPage;
	}
	
	public int getViewCount() {
		return viewCount;
	}
}
