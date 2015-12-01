<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>LearnEW</title>
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
                    <jsp:param name="activepage" value="1"/>
                </jsp:include>
            </div>

            <!-- PAGE CONTENT -->
            <div class="col-md-9">
                <h2>Math Class application:</h2>
                <ul>
                    <li>Back end: Spring MongoDB, Spring REST</li>
                    <li>Front end: Sping MVC, JSP, Bootstrap</li>
                </ul>
            </div>
        </div>

        <!--  PAGE FOOTER  -->
        <jsp:include page="components/footer.jsp" />

    </div>
</body>
</html>
