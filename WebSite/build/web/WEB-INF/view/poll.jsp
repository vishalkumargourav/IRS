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
                var status=confirm("Do you want to change the  status?");
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
                    <%@include file="pollAddform.jsp" %>

                    <table border="1" height="400" align="center" style="max-height: 200px;overflow: scroll;">
                        <tr>
                            <td colspan="8" align="center">
                                Poll List
                            </td>
                        </tr>
                        <tr>
                            <td>SR.</td>
                            <td>Question</td>
                            <td>Option1</td>
                            <td>Option2</td>
                            <td>Option3</td>
                            <td>Option4</td>
                            <td>STATUS</td>
                            <td>ACTION</td>
                        </tr>
                        <c:forEach items="${polls}" var="p" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${p.question}</td>
                                <td>${p.option1}</td>
                                <td>${p.option2}</td>
                                <td>${p.option3}</td>
                                <td>${p.option4}</td>
                                <td>${p.status}</td>
                                 <s:url var="toggleStatus" value="/changePollStatus.htm?polId=${p.pollId}"/>
                                <td><a href="javascript:void(0)" onclick="deleteConfirm('${toggleStatus}');">
                                        <img src="<%=request.getContextPath()%>/images/edit.png"></a></td>
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
