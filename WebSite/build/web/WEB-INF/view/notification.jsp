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
        <script type="text/javascript">
            function deleteConfirm(del_url){
                var status=confirm("Do you want to delete this contact?");
                if(status){
                    window.location=del_url;
                }
            }
        </script>
    </head>
    <body>
        <table border="1"  width="80%" align="center">
            <tr>
                <td height="30" align="center">
                    <%@include file="common/header.jsp" %>
                </td>
            </tr>
            <tr>
                <td height="20">
                    <%@include file="common/top_menu_login.jsp" %>
                </td>
            </tr>
            <tr height="400" align="top">
                <td valign="top">
                    <%@include file="notificationadminform.jsp" %>

                    <table border="1" height="400" align="center" style="max-height: 200px;overflow: scroll;">
                        <tr>
                            <td colspan="6" align="center">
                                Notification List/Search
                            </td>
                        </tr>
                        <tr>
                            <td>SR.</td>
                            <td>SUBJECT</td>
                            <td>DESCRIPTION</td>
                            <td>DATE</td>
                            <td>ADDEDBY</td>
                            <td>ACTION</td>
                        </tr>
                        <c:forEach items="${notificationList}" var="s" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${s.subject}</td>
                                <td>${s.description}</td>
                                <td>${s.date}</td>
                                <td>${s.addedby}</td>
                                <s:url var="deleteNotification" value="/deleteNotification.htm?notId=${s.notificationId}"/>
                                <td><a href="javascript:void(0)" onclick="deleteConfirm('${deleteNotification}');">
                                        <img src="<%=request.getContextPath()%>/images/del.png"></a></td>
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
