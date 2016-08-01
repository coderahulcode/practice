<%@page import="abc.Examination"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <script type="text/javascript">
            function ti2()
            {
                var timer = sessionStorage.timer;
                var min = parseInt(((timer / 1000) / 60)).toString();
                var sec = parseInt(((timer / 1000) % 60)).toString();
                if (sec.length === 1)
                {
                    sec = "0" + sec;
                }
                if (min.length === 1)
                {
                    min = "0" + min;
                }
                document.getElementById("clock").innerHTML = min + ":" + sec;
                sessionStorage.timer-=1000;
                if(sessionStorage.timer<=0)
                {
                    window.location.href="FinishPage.jsp";
                }
            }
            function ti1()
            {
                setInterval(ti2,1000);
            }
            
        </script>
        <title>
            Examination
        </title>
    </head>

    <body onload="ti1()">
         <div id="all">
            <%@include file="Header4.jsp" %>
             
            <div id="main">
        
        <%
            ArrayList<Examination> paperal = (ArrayList) session.getAttribute("paper");
            int index = (Integer) session.getAttribute("index");
        %>
        <center><div id="paper" >
            <form action="CreateExam2.jsp" onsubmit="go(<%=index%>)" method="post">
                <table class="CSSTableGenerator">
                    <tr>
                        <td>Question:<%=(index + 1)%></td>
                        <td><%=paperal.get(index).question%></td>

                    </tr>
                    <tr>
                        <td>(a)</td>
                        <td><input type="radio" name="answer" value="<%=paperal.get((Integer) session.getAttribute("index")).a%>"
                                   <%
                                       if (paperal.get(index).useranswer.equals(paperal.get(index).a))
                                       {
                                   %>
                                   checked
                                   <%
                                       }
                                   %>
                                   /><%=paperal.get(index).a%></td>
                    </tr>
                    <tr>
                        <td>(b)</td>
                        <td><input type="radio" name="answer" value="<%=paperal.get(index).b%>"
                                   <%
                                       if (paperal.get(index).useranswer.equals(paperal.get(index).b))
                                       {
                                   %>
                                   checked
                                   <%
                                       }
                                   %>
                                   /><%=paperal.get((Integer) session.getAttribute("index")).b%></td>
                    </tr>
                    <tr>
                        <td>(c)</td>
                        <td><input type="radio" name="answer" value="<%=paperal.get(index).c%>"
                                   <%
                                       if (paperal.get(index).useranswer.equals(paperal.get(index).c))
                                       {
                                   %>
                                   checked
                                   <% }
                                   %>
                                   /><%=paperal.get((Integer) session.getAttribute("index")).c%></td>
                    </tr>
                    <tr>
                        <td>(d)</td>
                        <td><input type="radio" name="answer" value="<%=paperal.get(index).d%>"
                                   <%
                                       if (paperal.get(index).useranswer.equals(paperal.get(index).d))
                                       {
                                   %>
                                   checked
                                   <% }
                                   %>
                                   /><%=paperal.get((Integer) session.getAttribute("index")).d%></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="submit" value="Submit Answer"/></td>
                    </tr>
                </table>
            </form>
            <table>
                <tr>
                    <td><form action="CreateExam2.jsp"><input id="prev" type="submit" name="submit" value="Previous"/></form></td>
                    <td><form action="CreateExam2.jsp"><input id="next" type="submit" name="submit" value="Next"/></form></td>
                </tr>
            </table>
        </div>
        <div>
            <form action="ChangeIndex.jsp" method="post">
                <table>
                    <tr><td>
                            <input type="submit" id="q1" value="1" name="questionbt" style="width: 50px; height: 30px 
                                   <%
                                       if (!(paperal.get(0).useranswer.equals("null")))
                                       {
                                   %>
                                   ; background-color:yellow
                                   <%
                                       }
                                   %>
                                   "/>
                            <input type="submit" id="q2" value="2" name="questionbt" style="width: 50px; height: 30px
                                   <%
                                       if (!(paperal.get(1).useranswer.equals("null")))
                                       {
                                   %>
                                   ; background-color:yellow
                                   <%
                                       }
                                   %>
                                   "/>
                            <input type="submit" id="q3" value="3" name="questionbt" style="width: 50px; height: 30px
                                   <%
                                       if (!(paperal.get(2).useranswer.equals("null")))
                                       {
                                   %>
                                   ; background-color:yellow
                                   <%
                                       }
                                   %>
                                   "/>

                            <input type="submit" id="q4" value="4" name="questionbt" style="width: 50px; height: 30px
                                   <%
                                       if (!(paperal.get(3).useranswer.equals("null")))
                                       {
                                   %>
                                   ; background-color:yellow
                                   <%
                                       }
                                   %>
                                   "/>
                            <input type="submit" id="q5" value="5" name="questionbt" style="width: 50px; height: 30px
                                   <%
                                       if (!(paperal.get(4).useranswer.equals("null")))
                                       {
                                   %>
                                   ; background-color:yellow
                                   <%
                                       }
                                   %>
                                   "/>
                            <input type="submit" id="q6" value="6" name="questionbt" style="width: 50px; height: 30px
                                   <%
                                       if (!(paperal.get(5).useranswer.equals("null")))
                                       {
                                   %>
                                   ; background-color:yellow
                                   <%
                                       }
                                   %>
                                   "/>
                            <input type="submit" id="q7" value="7" name="questionbt" style="width: 50px; height: 30px
                                   <%
                                       if (!(paperal.get(6).useranswer.equals("null")))
                                       {
                                   %>
                                   ; background-color:yellow
                                   <%
                                       }
                                   %>
                                   "/>
                            <input type="submit" id="q8" value="8" name="questionbt" style="width: 50px; height: 30px
                                   <%
                                       if (!(paperal.get(7).useranswer.equals("null")))
                                       {
                                   %>
                                   ; background-color:yellow
                                   <%
                                       }
                                   %>
                                   "/>
                            <input type="submit" id="q9" value="9" name="questionbt" style="width: 50px; height: 30px<%
                                if (!(paperal.get(8).useranswer.equals("null")))
                                {
                                   %>
                                   ; background-color:yellow
                                   <%
                                       }
                                   %>
                                   "/>
                            <input type="submit" id="q10" value="10" name="questionbt" style="width: 50px; height: 30px;
                                   <%
                                       if (!(paperal.get(9).useranswer.equals("null")))
                                       {
                                   %>
                                   ; background-color:yellow
                                   <%
                                       }
                                   %>
                                   "/>
                        </td></tr>    
                </table> 
            </form>
        </div>
        <form action="FinishPage.jsp" method="post">
            <input type="submit" style="height: 100px; width: 100px; background-color:activecaption " value="Finish Exam" />
        </form>
        </center>   
                                   <table class="CSSTableGenerator"><tr><td><h1 id="clock"></h1></td></tr></table>
            </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
