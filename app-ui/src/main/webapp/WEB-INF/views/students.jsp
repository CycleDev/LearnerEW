<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Math Class</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <!--  PAGE HEADER  -->
        <jsp:include page="components/header.jsp" />

        <div class="row">
            <!-- LEFT MENU -->
            <div class="col-md-3">
                <jsp:include page="components/groups.jsp">
                    <jsp:param name="activepage" value="students"/>
                </jsp:include>
            </div>

            <!-- PAGE CONTENT -->
            <div class="col-md-9">
                <h3>Students</h3>

                <a href="<c:url value="/students/new" />">New</a>

                <table class="table table-hover">
                <thead>
                <tr>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>User Name</th>
                  <th/>
                  <th/>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${students}">
                  <tr>
                      <td><a href="<c:url value="/students/view?studentId=${student.id}" />"><c:out value="${student.userName}"/></a></td>
                      <td><c:out value="${student.firstName}"/></td>
                      <td><c:out value="${student.lastName}"/></td>
                      <td>
                          <a href="<c:url value="/students/edit?studentId=${student.id}" />">
                              <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                          </a>
                      </td>
                      <td>
                          <a href="<c:url value="/students/delete?studentId=${student.id}" />">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                          </a>
                      </td>
                  </tr>
                </c:forEach>
                </tbody>
                </table>
            </div>
        </div>

        <!--  PAGE FOOTER  -->
        <jsp:include page="components/footer.jsp" />

    </div>
</body>
</html>
