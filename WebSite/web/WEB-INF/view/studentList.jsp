<%-- 
    Document   : loginSuccess
    Created on : 19 Jun, 2015, 3:30:36 PM
    Author     : VarunAg
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
            <tr>
                <td height="400" valign="top" align="center">
                    <h3>Users List</h3>
                     

                    <table border="1">
                        <tr>
                            <td>ENRNO.</td>
                            <td>FIRSTNAME</td>
                            <td>LASTNAME</td>
                            <td>CONTACT</td>
                            <td>EMAIL</td>
                            <td>SEMESTER</td>
                            <td>LSTATUS</td>
                            <td>VSTATUS</td>
                            <td>Confirm</td>
                            <td>Delete</td>
                        </tr>
                           <c:forEach items="${students}" var="s" >
                            <tr>
                                <td>${s.scholarNumber}</td>
                                <td>${s.firstName}</td>
                                <td>${s.lastName}</td>
                                <td>${s.phone}</td>
                                <td>${s.email}</td>
                                <td>${s.semester}</td>
                                <td>${s.lStatus}</td>
                                <td>${s.vStatus}</td>
                                <s:url var="confirmStudent" value="/confirmStudent.htm?studentId=${s.studentId}" />
                                <s:url var="deleteStudent" value="/deleteStudent.htm?studentId=${s.studentId}"/>
                                <td><a href="${confirmStudent}"><img src="<%=request.getContextPath()%>/images/edit.png"></a></td>
                                <td><a href="javascript:void(0)" onclick="deleteConfirm('${deleteStudent}');">
                                    <img src="<%=request.getContextPath()%>/images/del.png"></a></td>
                            </tr>
                        </c:forEach>
                    </table>

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
