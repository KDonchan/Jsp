<%-- 
    Document   : userAdd
    Created on : 2019/06/17, 14:40:17
    Author     : j-knakagami2
--%>

<%@page import="data.Sec"%>
<%@page import="bean.JspBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String errMsg ="",empId="",empName="",empKana="",empSec="";
    JspBean data = null;
    if(application.getAttribute("a_data")!=null){
        data = (JspBean)application.getAttribute("a_data");
    }else{
        data = new JspBean();
        application.setAttribute("a_data", data);
    }
    if(request.getAttribute("r_errMsg")!=null){
        errMsg = (String)request.getAttribute("r_errMsg");        
        request.removeAttribute("r_errMsg");
        empId=request.getParameter("empId");
        empName=request.getParameter("empName");
        empKana=request.getParameter("empKana");
        empSec = request.getParameter("empSec");
    }
    
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/mainStyle.css"/>

        <title>社員登録</title>
    </head>
    <body>
        <form action="UserAdd" method="post">
            <div class="inputLine">
                <div class="inputHead">社員ID</div>
                <div class="input"><input type="text" name="empId" value="<%=empId%>" required="true"/></div>
                <%=errMsg%>
            </div>
            
            <div class="inputLine">
                <div class="inputHead">ﾊﾟｽﾜｰﾄﾞ</div>
                <div class="input"><input type="password" name="empPass" required="true"/></div>
            </div>
            <div class="inputLine">
                <div class="inputHead">名前</div>
                <div class="input"><input type="text" name="empName" value="<%=empName%>"/></div>
            </div>
            
            <div class="inputLine">
                <div class="inputHead">よみ</div>
                <div class="input"><input type="text" name="empKana" value="<%=empKana%>"/></div>
            </div>
            
            <div class="inputLine">
                <div class="inputHead">部署</div>
                <div class="input">
                    <select name="empSec" >
                        <%
                            for(Sec a : data.getSecs()){
                        %>
                        <option value="<%=a.getSecId()%>" ><%=a.getSecName()%></option>
                        <%
                            }
                            %>
                    </select>
                </div>
            </div>
            
            <div class="inputLine">
                <input type="submit" value="登録"/>
            </div>
        </form>
    </body>
</html>
