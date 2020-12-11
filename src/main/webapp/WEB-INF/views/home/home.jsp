<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>

<h2>Lista artykułów</h2>
<c:forEach items="${fiveArticle}" var="article">
    <br/>
    -----------------
    <br/>
    <h3>Tytuł: ${article.title}</h3>
    <h5>Autor: ${article.author.fullName}</h5>
    <h5>Kategorie: ${article.categories}</h5>
    <h5>Treść: ${article.content}</h5>
    <h5>Utworzono: ${article.createdOn}</h5>
    <h5>Aktualizacja: ${article.updatedOn}</h5>
    <br/>
    <a href="/article/update?toEditId${article.id}">Edytuj</a>
    <a href="/article/delete?toRemoveId${article.id}">Usun</a>
    <br/>
    -----------------
    <br/>
</c:forEach>
</body>