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
                    <%@include file="common/top_menu_login.jsp" %>
                </td>
            </tr>
            <tr height="400" align="top">
                <td valign="top">

                    <table border="1" height="400" align="center" style="max-height: 200px;overflow: scroll;">
                        <tr>
                            <td colspan="6" align="center">
                                Query List
                            </td>
                        </tr>
                        <tr>
                            <td>SR.</td>
                            <td>QUERY</td>
                            <td>ASKED BY</td>
                            <td>ANSWERED BY</td>
                            <td>CURRENT ANSWER</td>
                            <td>YOUR ANSWER</td>
                            <td>ACTION</td>

                        </tr>
                        <c:forEach items="${queryList}" var="q" varStatus="status">
                            <tr>
                                <f:form action="updateQuery.htm?qid=${q.queryId}" commandName="qry">
                                <td>${status.count}</td>
                                <td>${q.query}</td>
                                <td>${q.submitedBy}</td>
                                <td>${q.answeredBy}</td>
                                <td >${q.answer}</td>
                                    <td><f:textarea path="answer"></f:textarea></td>
                                    <td><button type="submit" >Save</button></td>
                                </f:form>
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
