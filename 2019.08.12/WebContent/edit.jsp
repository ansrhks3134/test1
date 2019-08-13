<%@page import="DBPKG.DTO"%>
<%@page import="DBPKG.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
DAO dao = DAO.getInstance();
DTO vo = new DTO();
int stubun = Integer.parseInt(request.getParameter("stubun"));
vo = dao.search(stubun);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.na > li{list-style:none; float:left; margin:5px;}
.bo > li{list-style:none;}
td{text-align:center;}
table{margin: auto;}
</style>
<script>

	function send(){
		var phone = frm.stuphone.value;
		var phone1 = /^\d{3}-\d{3,4}-\d{4}$/;
		var phone2 = /^\d{3}\d{3,4}\d{4}$/;
		//var phone1 =  "/[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/gi";	//-/g : 글로벌 (전체)
		if(frm.stubun.value==""){
			alert("학번을 입력하세요");
			frm.stubun.focus();
			return;
		}
		if(frm.stuname.value==""){
			alert("이름을 입력하세요");
			frm.stuname.focus();
			return;
		}
		if(frm.stuaddr.value==""){
			alert("주소를 입력하세요");
			frm.stuaddr.focus();
			return;
		}
		if(phone==""){
			alert("전화번호를 입력하세요");
			frm.stuphone.focus();
			return;
		}

		if(frm.stubirth.value==""){
			alert("생년월일을 입력하세요");
			frm.stubirth.focus();
			return;
		}
		frm.action="edit_pro.jsp";
		frm.submit();
	}
</script>
<body>
<div style="text-align:center; background-color:green;"><h3>학사관리 프로그램 Ver 1.0</h3></div>
<nav>
	<ul class="na">
		<li><a href="write.jsp">학생등록</a></li>
		<li>학생목록 조회/수정</li>
		<li>학생성적조회</li>
		<li>홈으로</li>	
	</ul>
</nav>
<br><br><br>
<form name="frm" method="post">
<table border="1">

	<tr>
		<td colspan="2">학생정보등록</td>
	</tr>
	<tr>
		<td>학번</td>
		<td><input type="text" name="stubun" value="<%=vo.getStubun()%>"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="stuname" value="<%=vo.getStuname()%>"></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input type="text" name="stuaddr" value="<%=vo.getStuaddr()%>"></td>
	</tr>
	<tr>
		<td>전화</td>
		<td><input type="text" name="stuphone" value="<%=vo.getStuphone()%>"></td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td><input type="text" name="stubirth" value="<%=vo.getStubirth()%>"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="button" value="[등록]" onclick="send()">&nbsp;[조회]</td>
	</tr>	
</table>
	</form>
<footer>
<div style="text-align:center; background-color:green;">HRDKOREA Copyright@2016 All rights reserve. Human Resources Development Service Development Service of Korea</div>
</footer>
</body>
</html>