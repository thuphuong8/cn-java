<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Thời gian hiện tại</title>
</head>
<body>
    <h2>Chọn định dạng thời gian</h2>
    <form action="time" method="post">
        <input type="text" name="format" placeholder="HH:mm:ss hoặc dd/MM/yyyy" />
        <input type="submit" value="Hiển thị" />
    </form>

    <c:if test="${not empty time}">
        <h3>Thời gian hiện tại: <c:out value="${time}" /></h3>
    </c:if>

    <c:if test="${param.error == 'invalidFormat'}">
        <p style="color:red;">Định dạng không hợp lệ!</p>
    </c:if>
</body>
</html>
