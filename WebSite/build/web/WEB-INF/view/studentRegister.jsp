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
        <title>Student Registration Form</title>
    </head>
    <body>
        <table  width="80%" border="1" align="center">
            <tr>
                <td height="30" align="center">
                    <%@include file="common/header_student.jsp" %>
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
               <f:form action="studentRegister.htm" commandName="studentCommand">
        <table border="1" >
            <tr>
                <td colspan="2"><strong>Registration Form</strong></td>
            </tr>
            <tr>
                <td >Scholar_Number</td>
                <td><f:input path="scholarNumber" required="true"/></td>
            </tr>
            <tr>
                <td>FirstName</td>
                <td><f:input path="firstName" required="true"/></td>
            </tr>
            <tr>
                <td>LastName</td>
                <td><f:input path="lastName" required="true"/></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><f:radiobutton path="gender" value="Male"/>&nbsp;Male&nbsp;&nbsp;<f:radiobutton path="gender" value="Female"/>&nbsp;Female</td>
            </tr>
            <tr>
                <td>Email</td>
                <td><f:input path="email" required="true"/></td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><f:input path="phone" required="true"/></td>
            </tr>
            <tr>
                <td>AlternatePhone</td>
                <td><f:input path="alternatePhone" required="true"/></td>
            </tr>
            <tr>
                <td>Semester</td>
                <td>
                    <f:select path="semester" required="true">
                        <f:option value="">--Select Semester--</f:option>
                        <f:options items="${semesterList}" itemLabel="sem" itemValue="sem"></f:options>
                    </f:select>
                </td>
            </tr>
            <tr>
                <td>Login</td>
                <td><f:input path="loginName" required="true"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><f:input path="password" required="true"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Register"></td>
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
