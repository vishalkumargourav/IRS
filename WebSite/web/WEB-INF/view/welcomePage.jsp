<%-- 
    Document   : welcomePage
    Created on : 19 Jun, 2015, 12:43:56 PM
    Author     : VarunAg
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>
    </head>
    <body>
        <table  width="80%" border="1" align="center">
            <tr>
                <td height="30" align="center">
                    <%@include file="common/header.jsp" %>
                </td>
            </tr>
            <tr>
                <td height="20">
                    <%@include file="common/top_menu_welcome.jsp" %>
                </td>
            </tr>
            <tr>
                  <td height="400" valign="top" align="center">
                    <br/>
               <f:form action="adminLogin.htm" commandName="adminCommand">
        <table border="1" >
            <tr>
                <td colspan="2"><strong>Login Form</strong></td>
            </tr>
            <tr>
                <td >UserName</td>
                <td><f:input path="userName" required="true"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><f:password path="password" required="true"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Login"></td>
            </tr>
        </table>
                  <strong> ${err}</strong>
    </f:form>
                  </td>
        </tr>
         <tr>
                <th height="20"><strong>
                        <%@include file="common/footer.jsp" %></strong>
                </th>
            </tr>
    </table>

</body>
</html>
