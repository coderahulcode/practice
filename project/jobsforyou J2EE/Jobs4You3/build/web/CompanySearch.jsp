<%-- 
    Document   : CompanySearch
    Created on : May 12, 2014, 9:55:41 AM
    Author     : Harpreet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
         <link href="All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Company</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header.jsp" %>
             
            <div id="main">
        
        <table calss="CSSTableGenerator" border="1">
            <form action="SearchCompany2.jsp" method="post">
           <tr>
               <td>
                   Search company:
               </td>
               <td>
                  <input type="text" name="search"/>
               </td>
               <td>
                  <input type="submit" value="Search"/>
               </td>
           </tr>
        </table>
            </form>
        </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
