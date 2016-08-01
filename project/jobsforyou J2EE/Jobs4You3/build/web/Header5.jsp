<script>
    function goheader(e)
    {
       if(e.keyCode ===13)
       {
           var name = document.getElementById("search").value;
           window.location.href="OurRecruiters.jsp?search="+name;
       }

    }
</script>
    <table id="Table_01" width="980" height="136" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td colspan="3">
                    <img src="images/header_01.png" width="980" height="8" alt=""></td>
            </tr>
            <tr>
                <td rowspan="2">
                    <img src="images/header_02.png" width="17" height="128" alt=""></td>
                <td>
                    <a href="AdminHome.jsp"><img src="images/header_03.png" width="113" height="123" alt=""></a></td>
                <td rowspan="2">
                    <img src="images/header_04.png" width="850" height="128" alt=""></td>
            </tr>
            <tr>
                <td>
                    <img src="images/header_05.png" width="113" height="5" alt=""></td>
            </tr>
            <div  style="position:absolute">
                <input type="text" id="search" style=" margin-left: 690px;  margin-top:80px;" class="textbox" onkeyup="goheader(event)"placeholder="Search Company"/>
                
            </div>
        </table>
<%@include file="index_2.html" %>