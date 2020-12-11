<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2>Dodawanie artykułu</h2>

<form:form method="post" modelAttribute="article">
    <form:hidden path="id"/> <br/>
    Tytuł: <form:input path="title"/> <br/>
    Autor: <form:select path="author.id" items="${authors}" itemValue="id" itemLabel="fullName"/> <br/>
    Kategorie: <form:checkboxes path="categories" items="${categories}" itemLabel="name" itemValue="id"/><br/>
    Opis: <form:textarea path="content" cols="20" rows="15"/>
    <input type="submit" value="Wyslij">
</form:form>
<a href="/articleForm">Wroc</a>

</body>