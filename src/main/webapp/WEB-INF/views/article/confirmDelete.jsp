<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2> Czy chcesz usunac artykuł ${article.title} ??</h2>

<input type="hidden" name="toRemoveId" value="${article.id}">

<form:form method="post"
           modelAttribute="article">
    <form:hidden path="id" />
    <button type="submit" value="yes" name="confirmed">TAK</button>
    <button type="submit" value="no" name="confirmed">NIE</button>
</form:form>