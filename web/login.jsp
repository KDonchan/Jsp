<%-- 
    Document   : login
    Created on : 2019/06/17, 13:46:48
    Author     : j-knakagami2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String errMsg="",empId = "";
    if(request.getAttribute("r_errMsg")!=null){
        errMsg = (String)request.getAttribute("r_errMsg");
        request.removeAttribute("r_errMsg");
        empId = request.getParameter("empId");
    }
    %>
<form action="Login">
    <div class="inputLine">
        <div class="inputHead">ID</div>
        <div class="input"><input type="text" name="empId" value="<%=empId%>"/></div>
        <%=errMsg%>
    </div>
    <div class="inputLine">
        <div class="inputHead">ﾊﾟｽﾜｰﾄﾞ</div>
        <div class="input"><input type="password" name="empPass"/></div>
    </div>
    <div class="inputLine">
        <input type="submit" value="ログイン"/>
    </div>
</form>
