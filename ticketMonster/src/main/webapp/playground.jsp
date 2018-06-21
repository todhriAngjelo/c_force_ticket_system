<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JPA Playground</title>
        <script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
    </head>
    <body>
        <h1>JPA Playground</h1>
        <form action="./PlaygroundServlet" method="POST">
	        <input type="submit" name="action" value="GETALL" />
	        <input type="submit" name="action" value="GETALL_LAZY" />
	        <input type="submit" name="action" value="SEARCH" />
	        <input type="submit" name="action" value="SEARCH_SINGLE" />
        </form>        
        <br>
		<pre class="prettyprint">
			${result}
		</pre> 
    </body>
</html>
