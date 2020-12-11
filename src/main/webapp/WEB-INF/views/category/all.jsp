<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="/categoryForm/add">Dodaj kategorie</a>
<c:forEach items="${categories}" var="category">
    <h3>${category.name}</h3>
    <h5>${category.description}</h5>
    <a href="/categoryForm/edit?toEditId=${category.id}">Edytuj</a>
    <a href="/categoryForm/remove?toRemoveId=${category.id}">Usun</a>
</c:forEach>