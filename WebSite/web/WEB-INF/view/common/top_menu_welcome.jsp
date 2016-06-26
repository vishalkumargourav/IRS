<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<s:url var="login" value="/welcomeForm.htm"/>
<s:url var="aboutUs" value="/aboutUs.htm"/>
<s:url var="help" value="/help.htm"/>
<s:url var="loginStudent" value="/welcomeStudentLogin.htm"/>
 <a href="${login}">Login</a> |  <a href="${aboutUs}">AboutUs</a> | <a href="${help}">Help</a>
 |<a href="${loginStudent}">Student_Login</a>