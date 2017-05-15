<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="myPath" value="${pageContext.request.contextPath}" />



<c:import url="/jsp/common/header.jsp" />
<c:import url="/jsp/common/gnb.jsp" />
<c:import url="/jsp/common/lnb.jsp" />

<style type="text/css">
#left, #center, #right {
	display: inline-block;
	zoom: 1;
	padding: 5px;
	vertical-align: middle;
}

#left {
	width: 32px;
}

#center {
	width: 632px;
}

#right {
	width: 32px;
}

td:NTH-CHILD(odd){
	font-size: 14px;
	color: #E7E5E5;
	padding: 15px;
	margin:15px;
	border-radius: 12px;
	-webkit-border-radius: 12px;
	-moz-border-radius: 12px;
	box-shadow: 2px 2px 3px #666666;
	-webkit-box-shadow: 2px 2px 3px #666666;
	-moz-box-shadow: 2px 2px 3px #666666;
	background: #8B8B8B;
	background: linear-gradient(top, #A9A9A9, #7A7A7A);
	background: -ms-linear-gradient(top, #A9A9A9, #7A7A7A);
	background: -webkit-gradient(linear, left top, left bottom, from(#A9A9A9),
		to(#7A7A7A));
	background: -moz-linear-gradient(top, #A9A9A9, #7A7A7A);
	text-shadow: 2px 2px 3px #000000;
	z-index: 999;
} 

</style>
<script type="text/javascript">
	function view(index) {
		var els = document.getElementsByClassName("answer");
		for(var i=0; i < els.length ; i++) {
			if(i == index - 1)
				els[i].style = 'display:block';
			else
				els[i].style = 'display:none';
		}	
	}
</script>
<div id="contentwrap">
	<div id="content">
		<div id="left" class="over_container"></div>

		<div id="center" class="over_container">
			<h1 style="font-size: 16px; text-align: center;">F.A.Q</h1>
			<hr>
			<table id="table_board" class="list">
				<colgroup>
					<col width="632px">
				</colgroup>
				<tbody>
					<tr onmouseover="view(1);">
						<td>Q. 회원가입을 했는데 야후옥션(이베이)에서 입찰이 안되요.</td>
					</tr>
				</tbody>
				<tbody>
					<tr class="answer" style='display:none'>
						<td>
							A. 패스카트에서 야후옥션/이베이 경매 대행 서비스를 이용하기 위해서는 '보증금'이 필요합니다.<br>
   							또한 보증금 금액에 따라 입찰 금액이 제한될 수 있습니다.<br>
   							자세한 사항은 도움말 > 비용 및 결제 안내 > 보증금 에서 확인 가능합니다.<br>
						</td>
					</tr>
				</tbody>
				<tbody>
					<tr onmouseover="view(2);">
						<td>Q. 회원 등급별 혜택과 등업 방법이 궁금해요. </td>
					</tr>
				</tbody>
				<tbody>
					<tr class="answer" style='display:none'>
						<td>
							A. 패스카트에서는 회원 등급에 따라 대행수수료, 환율 혜택 등 여러가지 혜택을 제공하고 있습니다.<br>
							<br>
							회원 등급은 일반, 브론즈, 실버, 골드, VIP로 나뉘어 있으며, 거래완료 건수 또는 대행수수료의 합계가 등업 조건에 만족되면 자동으로 등업처리 됩니다.<br>
							<br>
							자세한 사항은 도움말 > 회원안내 > 회원 등급 에서 확인 가능합니다.<br> 
						</td>
					</tr>
				</tbody>
				<tbody>
					<tr onmouseover="view(3);">
						<td>Q. 회원탈퇴 하고 싶어요.</td>
					</tr>
				</tbody>
				<tbody>
					<tr class="answer" style='display:none'>
						<td>
							A. 마이페이지 > 회원 전용 메뉴 > 회원 탈퇴 를 통해 탈퇴가 가능합니다. <br>
							<br>
							단, 진행중인 주문건이 있거나 보증금이 남아있을 시에는 탈퇴가 되지 않습니다.<br>
							거래를 모두 완료해주시고, 보증금을 전액 환불해 주신 뒤 탈퇴신청 해주시길 바랍니다.<br>
							<br>
							또한, 탈퇴 후에는 패스카트를 이용할 수 없습니다.<br>
							회원정보와 누적된 마일리지 내역은 모두 삭제되며, 이전에 사용하시던 ID로는 재가입이 불가능하오니 이점 유의하여 주시길 바랍니다.<br>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="right" class="over_container"></div>
	</div>
</div>
<c:import url="/jsp/common/footer.jsp" />