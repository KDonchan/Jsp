<%-- 
    Document   : user
    Created on : 2019/07/01, 15:54:16
    Author     : j-knakagami2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="s_loginUser" type="bean.EmpBean" scope="session"/>

ID:<%=s_loginUser.getEmpId()%>　名前：<%=s_loginUser.getEmpName()%>　よみ：<%=s_loginUser.getEmpKana()%>　部署ID：<%=s_loginUser.getEmpSec()%>