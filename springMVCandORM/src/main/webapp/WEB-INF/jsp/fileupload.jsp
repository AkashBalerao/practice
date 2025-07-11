<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
<h2>Upload File</h2>
<form:form method="POST" action="upload" enctype="multipart/form-data" >
    <input type="file" name="file"/>
    <input type="submit" value="Upload"/>
</form:form>
</body>
</html>