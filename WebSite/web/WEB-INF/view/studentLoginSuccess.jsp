<%-- 
    Document   : loginSuccess
    Created on : 19 Jun, 2015, 3:30:36 PM
    Author     : VarunAg
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Admin</title>
    </head>
    <body>
       <table border="1"  width="80%" align="center">
            <tr>
                <td height="30" align="center">
                    <%@include file="common/header_student.jsp" %>
                </td>
            </tr>
           <tr>
                <td height="20">
                    <%@include file="common/top_menu_studentlogin.jsp" %>
                </td>
            </tr>
            <tr height="400" align="center">
                <td>HI ${students.getFirstName()} ${students.getLastName()}</td>
            </tr>
            
            <tr>
                <th height="20"><strong>
                        <%@include file="common/footer.jsp" %></strong>
                </th>
            </tr>
         
    </table>
   

    </body>
</html>
