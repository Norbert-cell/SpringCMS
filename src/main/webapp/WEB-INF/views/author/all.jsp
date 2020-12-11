<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="/authorForm/add">Dodaj autora</a><br/>
<c:forEach items="${authors}" var="author">
    <h3>${author.fullName}</h3>
    <a href="/authorForm/edit?toEditId=${author.id}">Edytuj</a>
    <a href="/authorForm/remove?toRemoveId=${author.id}">Usun</a><br/>
    <---------------------------><br/>

</c:forEach>