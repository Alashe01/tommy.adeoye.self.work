<%-- 
    Document   : delete
    Created on : Sep 15, 2016, 11:08:22 AM
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
        < <h1>Delete Address</h1>
        
        <form action="${pageContext.request.contextPath}/address/delete/${address.id}" method="POST">
            
        First Name: ${address.firstName}<br />
        Last Name: ${address.lastName}<br />
        Street Address: ${address.streetAddress}<br />
        City: ${address.city}<br />
        State: ${address.state}<br />
        Zip Code: ${address.zipCode}<br />
        

        
        <input type ="submit" value="Confirm delete" />
        
        </form>
    </body>
</html>
