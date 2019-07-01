/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.JspBean;
import data.Sec;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author j-knakagami2
 */
@WebServlet(name = "SecAdd", urlPatterns = {"/SecAdd"})
public class SecAdd extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext application = request.getServletContext();
        String nextPage = "index.jsp?r_contentPage=";
        String contentPage="secAdd.jsp";
        String wId = request.getParameter("secId");
        String wName = request.getParameter("secName");
        JspBean data = null;
        if(application.getAttribute("a_data")!=null){
            data = (JspBean)application.getAttribute("a_data");
        }else{
            data = new JspBean();
            application.setAttribute("a_data", data);
        }
        if(!data.secIdDupCheck(wId)){ //secId重複なし
            Sec aSec = new Sec(wId, wName);
            data.secAdd(aSec);
            contentPage = "login.jsp";
        }else{ //secId重複あり
            request.setAttribute("r_errMsg", "登録済みの部署IDです");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage + contentPage);
        dispatcher.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
