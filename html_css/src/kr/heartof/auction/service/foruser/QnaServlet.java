package kr.heartof.auction.service.foruser;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.auction.vo.foruser.BoardVO;

public class QnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QnaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		
//		List<BoardVO> list = new ArrayList<BoardVO>();
//		
//		for(int i=10; i > 0 ; i--) {
//			BoardVO vo = new BoardVO();
//			vo.setBOARD_NO(i+1);
//			vo.setCONT("forEach는 다음과 같은 속성을 가진다.<br>"+
//					   "items : forEach가 순회할 Collection 개체를 지정한다. <br>"+
//					   "begin : 반복문의 시작값을 설정한다.<br>" + 
//					   "end : 반복문의 종료값을 설정한다.<br>" +
//					   "step : 반복문의 증가값을 설정한다.<br>" +
//					   "var : 반복문의 순회시 해당하는 값을 담을 변수를 설정한다.<br>" +
//					   "varStatus : 변수의 상태를 담을 변수를 설정한다.<br>"+
//					   "<br>"+
//					   "기본적으로 forEach는 begin 과 end 속성만 설정해주면 동작하며 그 외 속성은 추가적인 옵션이다. 물론 이 두 부분만 설정됬을때는 세부적인 제어가 불가능 하고 step은 기본값으로 1이 작용한다");
//			vo.setFILE_NM("1.png");
//			vo.setFILE_PATH(request.getContextPath() + "/resource/img/");
//			vo.setREVIEW_CNT(100);
//			vo.setTITLE("[ JSTL ] 반복과 관련된 태그 (forEach, forToken )");
//			vo.setUSERID("8go4go");
//			vo.setREG_DATE(new Date());
//			list.add(vo);
//		}
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/foruser/qna.jsp");
//		request.setAttribute("list", list);
//		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		for(int i=10; i > 0 ; i--) {
			BoardVO vo = new BoardVO();
			vo.setBOARD_NO(i+1);
			vo.setCONT("forEach는 다음과 같은 속성을 가진다.<br>"+
					   "items : forEach가 순회할 Collection 개체를 지정한다. <br>"+
					   "begin : 반복문의 시작값을 설정한다.<br>" + 
					   "end : 반복문의 종료값을 설정한다.<br>" +
					   "step : 반복문의 증가값을 설정한다.<br>" +
					   "var : 반복문의 순회시 해당하는 값을 담을 변수를 설정한다.<br>" +
					   "varStatus : 변수의 상태를 담을 변수를 설정한다.<br>"+
					   "<br>"+
					   "기본적으로 forEach는 begin 과 end 속성만 설정해주면 동작하며 그 외 속성은 추가적인 옵션이다. 물론 이 두 부분만 설정됬을때는 세부적인 제어가 불가능 하고 step은 기본값으로 1이 작용한다");
			vo.setFILE_NM("1.png");
			vo.setFILE_PATH(request.getContextPath() + "/resource/img/");
			vo.setREVIEW_CNT(100);
			vo.setTITLE("[ JSTL ] 반복과 관련된 태그 (forEach, forToken )");
			vo.setUSERID("8go4go");
			vo.setREG_DATE(new Date());
			list.add(vo);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/foruser/qna.jsp");
		request.setAttribute("list", list);
		dispatcher.forward(request, response);
	}

}