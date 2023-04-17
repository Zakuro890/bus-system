<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="servlet.DeleteServlet" %>
    <%@ page import="model.Bean" %>
    <%@ page import="dao.EmployeeDAO" %>
    
    
    <% Bean bean=(Bean)request.getAttribute("bean");%>
    <% EmployeeDAO empDao=new EmployeeDAO(); %> 
   
    
    <% 
      int    Resarve =bean.getResarve();
      String  Name   =bean.getName();
      String  Tel    =bean.getTel();
       int    Dating =bean.getDating();
      String  Drive  =bean.getDrive();
      String  Route  =bean.getRoute();
      String  Seanum =bean.getSeanum();
    %>
    
   <!--<% //Bean //bean=(Bean)request.getAttribute("Bean"); %>-->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"  type="text/css" href="css/Delete.css">
<title>予約削除画面</title>
</head>
<body>
<h1>バスシステム</h1>
<div class="box_con">
<form action="DeleteServlet" method="post" name="Delete_form"> 
<table>
  <tr><th>予約ID:  </th><td><%=Resarve%><td></tr>
  <tr><th>氏 名:   </th><td><%=Name %><td></tr>
  <tr><th>電話番号:</th><td><%=Tel%><td></tr>
  <tr><th>日 付 :  </th><td><%=Dating %><td></tr>
  <tr><th>車 種 :  </th><td><%=Drive %><td></tr>
  <tr><th>目的地:  </th><td><%=Route %><td></tr>
  <tr><th>席番号:  </th><td><%=Seanum %><td></tr>
</table>
<!-- <input href="Select.jsp" type="submit" value=" 削除 " >-->
<!-- <input type="submit" value="削除"> -->
<button onclick="<% empDao.delete(bean); %>" >削除</button>
</form>
</div>
</body>
</html>