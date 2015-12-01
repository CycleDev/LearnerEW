<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%!
  public String isActive(String activepage, String currentpage)
  {
    if(activepage != null && activepage.equals(currentpage))
      return "active";
    else
      return "";
  }
%>

<ul class="nav nav-pills nav-stacked">
  <c:forEach var="group" items="${groups}">
    <li>
      <a href="<c:url value="/words" />"><s:message code="${group.name}" /></a>
    </li>
  </c:forEach>
</ul>
