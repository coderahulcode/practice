<%-- 
    Document   : UploadResumeStudent
    Created on : May 14, 2014, 7:34:41 AM
    Author     : Harpreet
--%>
<!DOCTYPE html>

<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Upload Resume</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header4.jsp" %>
             
            <div id="main">
        <h2> Upload Your Resume</h2>
        <form action="UploadResume2.jsp" enctype="multipart/form-data" method="post">
           <input type="file" name="upload"/>
           <br>
           <br>
          <input type="submit" name="submit"/>
        </form>
        </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
