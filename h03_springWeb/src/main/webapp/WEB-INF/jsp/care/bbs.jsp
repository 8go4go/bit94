<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../common/header.jsp"></jsp:include>
<div class="panel panel-primary kanban-col">
	<div class="panel-heading">
		DOING <i class="fa fa-2x fa-plus-circle pull-right"></i>
	</div>
	<div class="panel-body">
		<div id="DOING" class="kanban-centered">

			<article class="kanban-entry grab" id="item5" draggable="true">
				<div class="kanban-entry-inner">

					<div class="kanban-label">
						<h2>
							<a href="#">Art Ramadani</a> <span>posted a status update</span>
						</h2>
						<p>Tolerably earnestly middleton extremely distrusts she boy
							now not. Add and offered prepare how cordial two promise. Greatly
							who affixed suppose but enquire compact prepare all put. Added
							forth chief trees but rooms think may.</p>
					</div>
				</div>
			</article>

			<article class="kanban-entry grab" id="item6" draggable="true">
				<div class="kanban-entry-inner">
					<div class="kanban-label">
						<h2>
							<a href="#">Job Meeting</a>
						</h2>
						<p>
							You have a meeting at <strong>Laborator Office</strong> Today.
						</p>
					</div>
				</div>
			</article>

		</div>
	</div>
	<div class="panel-footer">
		<a href="#">Add a card...</a>
	</div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>