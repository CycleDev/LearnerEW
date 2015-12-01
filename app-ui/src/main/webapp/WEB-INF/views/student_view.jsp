<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
              <ul class="nav nav-pills nav-stacked">
                  <jsp:include page="components/groups.jsp">
                      <jsp:param name="activepage" value="students"/>
                  </jsp:include>
              </ul>
            </div>

            <!-- PAGE CONTENT -->
            <div class="col-md-9">
              <h3>${title}</h3>
              <h4>${student.userName}</h4>
              <p>${student.firstName} ${student.lastName} </p>
            </div>
        </div>

        <!--  PAGE FOOTER  -->
        <jsp:include page="components/footer.jsp" />

    </div>
</body>
</html>
