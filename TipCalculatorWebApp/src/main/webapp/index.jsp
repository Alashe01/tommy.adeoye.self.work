<%-- 
    Document   : index
    Created on : Sep 13, 2016, 10:34:27 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tip Calculator Web Application</h1> <br/>
        
        <form action="TipCalCulatorServlet" method="POST">
            Enter a dollar amount here ($): <br/>
            
            <input type="number" name="dollarAmt" /><br/>
            Enter Tip percentage %: <br/> 
            
            <input type="number" name="tipAmt"/> <br/>
            
            <input type="submit" value="Calculate" />
        
    </form>
        
    </body>
</html>
