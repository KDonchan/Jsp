<%-- 
    Document   : secDisp
    Created on : 2019/07/01, 13:43:53
    Author     : j-knakagami2
--%>

<%@page import="data.Sec"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="a_data" class="bean.JspBean" scope="application"/>
<%
    for(Sec a : a_data.getSecs()){
        out.println("<div>部署ID:" + a.getSecId() + 
                "　部署名：" + a.getSecName() + "</div>");
    }
%>
