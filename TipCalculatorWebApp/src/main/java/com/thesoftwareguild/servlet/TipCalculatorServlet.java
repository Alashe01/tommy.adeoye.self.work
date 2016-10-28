/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@WebServlet(name = "TipCalculatorServlet", urlPatterns = {"/TipCalculatorServlet"})
public class TipCalculatorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
////        response.setContentType("text/html;charset=UTF-8");
////        try (PrintWriter out = response.getWriter()) {
////            /* TODO output your page here. You may use following sample code. */
////            out.println("<!DOCTYPE html>");
////            out.println("<html>");
////            out.println("<head>");
////            out.println("<title>Servlet TipCalculatorServlet</title>");            
////            out.println("</head>");
////            out.println("<body>");
////            out.println("<h1>Servlet TipCalculatorServlet at " + request.getContextPath() + "</h1>");
////            out.println("</body>");
////            out.println("</html>");
//        }
//    }

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
        
        RequestDispatcher re = request.getRequestDispatcher("index.jsp");
        re.forward(request, response);
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
       
        
        double dollarVal = parseDouble(request.getParameter("dollarAmt")); 
        
        double tipPercent = parseDouble(request.getParameter("tipAmt"));
        
        double tipTotal = dollarVal * (tipPercent/100);
        
        double total = (dollarVal + tipTotal);
        
        String msg1 = " ";
        String msg = " ";
        String msg2 =" ";
        String msg3 = " ";
        
        msg1 = "Amount: $"+dollarVal;
        msg3 = "Tip %: " + tipPercent;
        msg = "Tip: $" + tipTotal;
        msg2= "Total: $"+ total;
        
        request.setAttribute("message", msg);
        request.setAttribute("message0", msg2);
        request.setAttribute("message1", msg1);
        request.setAttribute("message2", msg3);
        
        RequestDispatcher re = request.getRequestDispatcher("response.jsp");
        re.forward(request, response);
        
        
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
