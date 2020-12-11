<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2>Dodawanie Autora</h2>

<form:form method="post" modelAttribute="author">
    <form:hidden path="id"/> <br/>
    Imie: <form:input path="firstName"/> <br/>
    Nazwisko: <form:input path="lastName"/> <br/>
    <input type="submit" value="Wyslij">
</form:form>
<a href="/authorForm">Wroc</a>

</body>