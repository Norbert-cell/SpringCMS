<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="/articleForm/add">Dodaj artykul</a><br/>
<c:forEach items="${articles}" var="article">
    Tytuł:<h3>${article.title}</h3><br/>
    Autor: <h4>${article.author.fullName}</h4><br/>
    Kategorie:<br/>
    <c:forEach items="${article.categories}" var="category">
        <h4>${category.name}</h4><br/>
    </c:forEach>
    Opis: <h4>${article.content}</h4><br/>
    Utworzono: <h5>${article.createdOn}</h5><br/>
    Aktualizacja: <h5>${article.updatedOn}</h5><br/>
    <a href="/articleForm/edit?toEditId=${article.id}">Edytuj</a>
    <a href="/articleForm/remove?toRemoveId=${article.id}">Usun</a><br/>
    <---------------------------><br/>

</c:forEach>