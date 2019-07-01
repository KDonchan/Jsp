<%-- 
    Document   : secAdd
    Created on : 2019/07/01, 13:43:37
    Author     : j-knakagami2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String errMsg="",secId="",secName="";
    if(request.getAttribute("r_errMsg")!=null){
        errMsg = (String)request.getAttribute("r_errMsg");
        request.removeAttribute("r_errMsg");
        secId = request.getParameter("secId");
        secName = request.getParameter("secName");
    }
    %>
<form action="SecAdd" method="post">
    <div class="inputLine">
        <div class="inputHead">部署ID:</div>
        <div class="input"><input typ="text" name="secId" value="<%=secId%>"/></div>
        <%=errMsg%>
    </div>
    <div class="inputLine">
        <div class="inputHead">部署名：</div>
        <div class="input"><input type="text" name="secName" value="<%=secName%>"/></div>
    </div>
    <div class="inputLine">
        <input type="submit" value="登録"/>
    </div>
</form>