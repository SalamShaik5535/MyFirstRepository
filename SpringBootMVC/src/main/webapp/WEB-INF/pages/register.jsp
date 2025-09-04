<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Hello This is Register Page</h1>
<div align="center">
    <form action="./login" method="post">
        NAME:<input type="text" name="name" placeholder="Enter name"><br/><br/>
        ROLE:<input type="text" name="role" placeholder="Enter role"><br/><br/>
        SALARY:<input type="number" name="salary" placeholder="Enter salary"><br/><br/>
        ADDRESS:<input type="text" name="addrs" placeholder="Enter addrs"><br/><br/>
        <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>