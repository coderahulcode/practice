<%-- 
    Document   : CreateExam2
    Created on : May 9, 2014, 11:49:02 AM
    Author     : Harpreet
--%>


<%@page import="abc.Examination"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Exam</title>
    </head>
    <body>
        <%
            String type=request.getParameter("submit");
            if(type.equals("Previous"))
            {
                int index = (Integer)session.getAttribute("index");
                if(index==0)
                {
                 session.setAttribute("index",9);
                }
                else
                {
                session.setAttribute("index", index-1);
                }
                response.sendRedirect("NewExam2.jsp");
            }
            else if(type.equals("Next"))
            {
                int index = (Integer)session.getAttribute("index");
                if(index==9)
                {
                    
                    session.setAttribute("index",0);
                }
                else
                {
                session.setAttribute("index", index+1);
                }
                response.sendRedirect("NewExam2.jsp");
            }
            else
            {
                int index = (Integer)session.getAttribute("index");
                ArrayList<Examination> paper =(ArrayList) session.getAttribute("paper");
                String answer=request.getParameter("answer");
                System.out.println(";;;;;;;;;;;;;;;;;;;;;;;answer;;;;;;;;;;;;;;;;;;;;;"+answer);
                if(answer==null)
                {
                paper.get(index).useranswer ="null";
                }
                else
                {
                paper.get(index).useranswer =answer;
                }
                if(index==9)
                {
                    
                    session.setAttribute("index",0);
                }
                else
                {
                session.setAttribute("index", index+1);
                }
                response.sendRedirect("NewExam2.jsp");
            }
        %>
    </body>
</html>

