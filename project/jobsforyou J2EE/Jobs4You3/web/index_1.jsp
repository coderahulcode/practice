
<link rel='stylesheet' type='text/css' href='styles_1.css' />
<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
<script type='text/javascript' src='menu_jquery.js'></script>
<%
int username22=(Integer)session.getAttribute("id");

%>
<div id='cssmenu'>
    <ul>
        <li class='active'><a href='CompanySearchStudent.jsp'><span>Search</span></a></li>
        
        <li class='has-sub'><a href='#'><span>Exam</span></a>
            <ul>
                <li><a href='NewExam.jsp'><span>Take Exam</span></a></li>
                <li><a href='DownloadPapers.jsp'><span>Download Exam Papers</span></a></li>
                <li class='has-sub last'><a href='ViewResults.jsp'><span>View Previous Result</span></a></li>
            </ul>
        </li>
        <li><a href='ViewProfile.jsp'><span>View Profile</span></a></li>
        <li><a href='Messages.jsp' onclick="go1('<%=username22%>')"><span>Messages</span></a></li>
        <li class='has-sub last'><a href='#'><span>Uploads</span></a>
            <ul>
                <li><a href='UploadResumeStudent.jsp'><span>Upload Resume</span></a></li>
                <li class='last'><a href='UploadPhotoStudent.jsp'><span>Upload Picture</span></a></li>
            </ul>
        </li>
        <li><a href='StudentLogout.jsp'><span>Logout</span></a></li>
    </ul>
</div>
