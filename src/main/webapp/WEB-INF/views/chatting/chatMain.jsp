<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>

</head>
<body>
	
	
	<script type="text/javascript">
		function chat() {
		  
	        let uniqueName = "chatbot_" + Date.now(); // Date.now()가 있어 계속 새로운 창이 생긴다.
	        window.open("chatRoom", uniqueName, "width=640,height=400");
		}

		function openChatBot() {
			window.open("chatBot", "chatbot",
					"width=400,height=400,menubar=no");
		}
	</script>
	
	<!-- 메뉴바 -->
    <jsp:include page="../common/menubar.jsp"/>
    
    <div class="content" style="padding: 10px 40px 40px 40px; height: 500px;">
        <div class="innerOuter" style="padding: 0% 30% 0% 0%">
            <h2>실시간 채팅</h2>
            * 상대방에게 불쾌감을 줄 수 있는 표현은 삼가해 주세요.
			<br><br>
			<button class="btn btn-primary" onclick="chat()">실시간 채팅 참여</button>
			<button class="btn btn-primary" onclick="openChatBot()">챗봇과 대화</button>

        </div>
    </div>


    <!-- 푸터바 -->
    <jsp:include page="../common/footer.jsp"/>
    
</body>
</html>