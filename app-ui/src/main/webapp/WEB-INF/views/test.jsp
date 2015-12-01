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
                      <jsp:param name="activepage" value="tests"/>
                  </jsp:include>
              </ul>
            </div>

            <!-- PAGE CONTENT -->
            <div class="col-md-9">
              <h3>${title}</h3>
              <form:form method="POST" role="form" commandName="test">
                  <form:hidden path="id" />

                  <div class="form-group">
                    <label for="name">Test:</label>
                    <form:input class="form-control" path="name" placeholder="Enter name" />
                  </div>

                  <button type="submit" class="btn btn-default">Save</button>
                  <a class="btn btn-default" href="<c:url value="/tests" />">Cancel</a>

              </form:form>
            </div>
        </div>

        <!--  PAGE FOOTER  -->
        <jsp:include page="components/footer.jsp" />

    </div>
</body>
</html>
