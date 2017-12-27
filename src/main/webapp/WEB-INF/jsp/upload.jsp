<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/14
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>


<form  id="form" action="multiupload.xhtml" method="post" enctype="multipart/form-data">

    <input id="music" type="file" name="music"/>
    <input type="submit">
</form>

</body>
</html>
