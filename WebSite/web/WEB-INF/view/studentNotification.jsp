<%-- 
    Document   : loginSuccess
    Created on : 19 Jun, 2015, 3:30:36 PM
    Author     : VarunAg
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
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
            <tr height="400" align="top">
                <td valign="top">

                    <table border="1" height="400" align="center" style="max-height: 200px;overflow: scroll;">
                        <tr>
                            <td colspan="6" align="center">
                                Notification List
                            </td>
                        </tr>
                        <tr>
                            <td>SR.</td>
                            <td>SUBJECT</td>
                            <td>DESCRIPTION</td>
                            <td>DATE</td>
                            <td>ADDEDBY</td>
                           
                        </tr>
                        <c:forEach items="${notificationList}" var="s" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${s.subject}</td>
                                <td>${s.description}</td>
                                <td>${s.date}</td>
                                <td>${s.addedby}</td>
                           
                            </tr>
                        </c:forEach>


                    </table></td>
            </tr>



            <tr>
                <th height="20"><strong>
                        <%@include file="common/footer.jsp" %></strong>
                </th>
            </tr>

        </table>


    </body>
</html>
