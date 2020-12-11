<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2> Czy chcesz usunac autora ${author.fullName} ??</h2>

<input type="hidden" name="toRemoveId" value="${author.id}">

<form:form method="post"
           modelAttribute="author">
    <form:hidden path="id" />
    <button type="submit" value="yes" name="confirmed">TAK</button>
    <button type="submit" value="no" name="confirmed">NIE</button>
</form:form>