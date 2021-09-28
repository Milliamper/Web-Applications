<html>
<head>
    <title>Calculator</title>
</head>
<body>
<%
//ha a servlettől jött, akkor van, ha elso kereses, akkor nincs
szamologepszervlet.resultDTO result =  request.getAttribute("result") ? (szamologepszervlet.resultDTO) request.getAttribute("result") : new szamologepszervlet.resultDTO();

String resultText = (result == null) ?
				"" : "result " + result.toString();
%>
<form method="post" action="szamologep.do">
    <input type="text" name="a" /><br>
    <input type="text" name="b" /><br>
    <select name="operator">
        <option value="+" /> +
        <option value="-" /> -
        <option value="*" /> *
        <option value="/" /> /
    </select><br>

<%= resultText %>
    <input type="submit" /><br>
</form>




</body>
</html>
