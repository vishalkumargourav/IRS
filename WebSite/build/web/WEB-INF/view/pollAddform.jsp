<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<f:form action="savePoll.htm" commandName="pollCommand"  >
    <table border="1" align="center">
        <tr><td colspan="2">Poll Entry Form</td></tr>
        <tr><td>Question:</td><td><f:textarea path="question" required="true"/></td></tr>
                    <tr>
                <td>STATUS</td>
                <td><f:radiobutton path="status" value="Open"/>&nbsp;Open&nbsp;&nbsp;<f:radiobutton path="status" value="Close"/>&nbsp;Close</td>
            </tr>
  
        <tr><td>Option1:</td><td><f:textarea path="option1" required="true"/></td></tr>
        <tr><td>Option2:</td><td><f:textarea path="option2" required="true"/></td></tr>
        <tr><td>Option3:</td><td><f:textarea path="option3" required="true"/></td></tr>
        <tr><td>Option4:</td><td><f:textarea path="option4" required="true"/></td></tr>
        <tr><td colspan="2" align="center"><button type="submit">Save</button></td></tr>
        <h3><strong>${err}</strong></h3>
    </table>
</f:form>