<%@page import="DBPKG.DTO"%>
<%@page import="DBPKG.DAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
DAO dao = DAO.getInstance();
DTO vo = new DTO();
int stubun = Integer.parseInt(request.getParameter("stubun"));
String stuname = request.getParameter("stuname");
String stuaddr = request.getParameter("stuaddr");
String stuphone = request.getParameter("stuphone");
String stubirth = request.getParameter("stubirth");


vo.setStubun(stubun);
vo.setStuname(stuname);
vo.setStuaddr(stuaddr);
vo.setStuphone(stuphone);
vo.setStubirth(stubirth);
int row = dao.update(vo);
%>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script>
function foo(){
var row = '<%=row%>';

if(row != 0){
	alert('<%=stuname%>'+"님이 수정되었습니다.");
	location.href="index.jsp";
}else{
	alert("수정오류");
	location.href="edit.jsp";
}
}
</script>
<body onload ="javascript:foo();">

</body>
</html>