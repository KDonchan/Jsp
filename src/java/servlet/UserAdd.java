/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.JspBean;
import data.Emp;
import java.io.IOException;
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
@WebServlet(name = "UserAdd", urlPatterns = {"/UserAdd"})
public class UserAdd extends HttpServlet {

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
        String nextPage="index.jsp?r_contentPage=";
        String contentPage="userAdd.jsp";
        String wId = request.getParameter("empId");
        String wPass = request.getParameter("empPass");
        String wName = request.getParameter("empName");
        String wKana = request.getParameter("empKana");
        String wSec = request.getParameter("empSec");
        Emp aEmp = new Emp(wId, wPass, wName, wKana, wSec);
        JspBean data = null;
        if(application.getAttribute("a_data")!=null)
            data = (JspBean)application.getAttribute("a_data");
        else{
            data = new JspBean();
            application.setAttribute("a_data", data);
        }
        request.removeAttribute("r_errMsg");
        if(data.empIdDupCheck(wId)){
            request.setAttribute("r_errMsg", "登録済みの社員IDです");
        }else{
            data.empAdd(aEmp);
            contentPage="login.jsp";
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
