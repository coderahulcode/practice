<!DOCTYPE html>
<html>
<head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
	<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />
	<meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1' />
	<link rel='stylesheet' type='text/css' href='styles_3.css' />
	<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
	<script type='text/javascript' src='menu_jquery_1.js'></script>
</head>
<body>
<div id='cssmenu'>
<ul>
   <li><a href='SelectCollege.jsp'><span>Select Colleges</span></a></li>
   <li class='has-sub'><a href='#'><span>Placement Drive</span></a>
      <ul>
         <li><a href='FilterStudent.jsp'><span>Filter Students</span></a></li>
         <li class='last'><a href='ViewMyPD.jsp'><span>View Previous Drives</span></a></li>
      </ul>
   </li>
   <li><a href='ViewMyPD.jsp'><span>Add Message</span></a></li>
   <li class='has-sub'><a href='#'><span>Personal Details</span></a>
      <ul>
         <li><a href='CompanyProfile.jsp?id=<%=(Integer)session.getAttribute("id")%>'><span>View My Details</span></a></li>
      </ul>
   </li>
   <li class=''><a href='Contact.jsp'><span>Contact Us</span></a></li>
   <li class=''><a href='RecruiterLogout.jsp'><span>Logout</span></a></li>
</ul>
</div>
</body>
</html>