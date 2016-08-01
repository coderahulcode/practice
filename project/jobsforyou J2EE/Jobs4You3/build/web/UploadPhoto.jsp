<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Profile Picture Upload</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header2.jsp" %>
             
            <div id="main">
        <h2> Upload a photo..</h2>
        <form action="UploadPhoto2.jsp" enctype="multipart/form-data" method="post">
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
