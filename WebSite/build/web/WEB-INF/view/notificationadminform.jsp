<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<f:form action="saveNotification.htm" commandName="notification"  >
    <table border="1" align="center">
        <tr><td colspan="2">Notification/New Entry</td></tr>
        <tr><td>Subject:</td><td><f:textarea path="subject"/></td></tr>
        <tr><td>Description:</td><td><f:textarea path="description"/></td></tr>
        <tr><td colspan="2" align="center"><button type="submit">Save</button></td></tr>
        <h3><strong>${err}</strong></h3>
    </table>
</f:form>