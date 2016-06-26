<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<s:url var="home" value="/homeStudent.htm"/>

<s:url var="notification" value="/studentNotification.htm"/>
<s:url var="poll" value="/studentPoll.htm"/>
<s:url var="studentQuery" value="/studentQuery.htm"/>
<s:url var="logout" value="/StudentLoginPage.htm"/>
 <a href="${home}">Home</a>
 
 | <a href="${notification}">Notification</a>
 | <a href="${poll}">Poll</a>
 | <a href="${studentQuery}">Students_Query</a>
 | <a href="${logout}">Logout</a>
 
 
 
 