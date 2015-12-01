<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
        <jsp:include page="components/header.jsp"  />

        <div class="row">
            <!-- LEFT MENU -->
            <div class="col-md-3">
              <ul class="nav nav-pills nav-stacked">
                  <jsp:include page="components/groups.jsp">
                      <jsp:param name="activepage" value="students"/>
                  </jsp:include>
              </ul>
            </div>

            <!-- PAGE CONTENT -->
            <div class="col-md-9">
              <h3>${title}</h3>
              <form:form method="POST" role="form" commandName="student">
                  <form:hidden path="id" />

                  <div class="form-group">
                    <label for="firstName">First Name:</label>
                    <form:input class="form-control" path="firstName" placeholder="Enter first name" />
                  </div>
                  <div class="form-group">
                    <label for="lastName">Last Name:</label>
                    <form:input class="form-control" path="lastName" placeholder="Enter last name" />
                  </div>
                  <div class="form-group">
                    <label for="userName">User Name:</label>
                    <form:input class="form-control" path="userName" placeholder="Enter user name" />
                  </div>

                  <button type="submit" class="btn btn-default">Save</button>
                  <a class="btn btn-default" href="<c:url value="/students" />">Cancel</a>

              </form:form>
            </div>
        </div>

        <!--  PAGE FOOTER  -->
        <jsp:include page="components/footer.jsp" />

    </div>
</body>
</html>
