<%-- 
    Document   : index
    Created on : 2019/06/17, 13:28:01
    Author     : j-knakagami2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String wNavPage="nav.jsp";
    String wContentPage="login.jsp";
    if(request.getParameter("r_contentPage")!=null)
        wContentPage = request.getParameter("r_contentPage");
    if(session.getAttribute("s_contentPage")!=null){
        wContentPage = (String)session.getAttribute("s_contentPage");
        session.removeAttribute("s_contentPage");
    }
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/mainStyle.css"/>
        <title>トップページ</title>
    </head>
    <body>
        <div class="nav">
            <jsp:include page="<%=wNavPage%>"/>
        </div>
        
        <div class="content">
            <jsp:include page="<%=wContentPage%>"/>
        </div>
    </body>
</html>
