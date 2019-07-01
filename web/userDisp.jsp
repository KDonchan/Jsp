<%-- 
    Document   : userDisp
    Created on : 2019/06/17, 14:11:00
    Author     : j-knakagami2
--%>

<%@page import="data.Sec"%>
<%@page import="data.Emp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="a_data" class="bean.JspBean" scope="application"/>
        <title>社員一覧</title>
    </head>
    <body>
        <%
            for(Emp a : a_data.getEmps()){
                out.println("<p>ID:" + a.getEmpId() + "　ﾊﾟｽﾜｰﾄﾞ：" +
                        a.getEmpPass() + "　名前：" + a.getEmpName() +
                        "　よみ：" + a.getEmpKana() + "　部署：<select>" );
                String selected = "";
                for(Sec aSec : a_data.getSecs()){
                    if(aSec.getSecId().equals(a.getEmpSec()))
                        selected = "selected";
                    else
                        selected = "";
                    out.println("<option value=\"" + aSec.getSecId()+
                            "\" " + selected + ">" + aSec.getSecName() +
                            "</option>");
                }
                out.println("</select>");
            }
            
            %>
            <p><a href="index.jsp">トップページへ</a></p>
    </body>
</html>
