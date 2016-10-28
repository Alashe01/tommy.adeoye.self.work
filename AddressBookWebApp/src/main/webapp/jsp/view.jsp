<%-- 
    Document   : view
    Created on : Sep 15, 2016, 11:08:11 AM
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
         <h1>View Addresses</h1>
        
        First Name: ${address.firstName}<br/>
        Last Name: ${address.lastName}<br />
        Street Address: ${address.streetAddress}<br />
        City: ${address.city}<br />
        State: ${address.state}<br />
        Zip Code: ${address.zipCode}<br />
    
    </body>
</html>
