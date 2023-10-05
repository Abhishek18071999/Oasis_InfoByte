<%-- Display the result message from the Servlet --%>
<% String resultMessage = (String)request.getAttribute("resultMessage"); %>

<%-- Display the result message if available --%>
<% if (resultMessage != null && !resultMessage.isEmpty()) { %>
    <div class="alert alert-info">
        <strong>Result:</strong><br>
        <%= resultMessage %>
    </div>
<% } %>
