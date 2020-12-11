<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2>Dodawanie kategorii</h2>

<form:form method="post" modelAttribute="category">
    <form:hidden path="id"/> <br/>
    Nazwa: <form:input path="name"/> <br/>
    Opis: <form:input path="description"/> <br/>
    <input type="submit" value="Wyslij">

</form:form>

</body>