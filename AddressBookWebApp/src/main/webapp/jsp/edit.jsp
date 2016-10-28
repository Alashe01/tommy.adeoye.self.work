<%-- 
    Document   : edit
    Created on : Sep 15, 2016, 11:07:58 AM
    Author     : apprentice
--%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Edit Address</h1>
         <sf:form commandName="address" action="${pageContext.request.contextPath}/address/edit" method="POST">
           
            <input type= "hidden" name= "id" value= "${address.id}" />
            First Name: <sf:input placholder ="First Name" type="text" path="firstName" value="${address.firstName}" /><sf:errors path="firstName" /> <br />
              Last Name: <sf:input type="text" path="lastName" value="${address.lastName}" /> <sf:errors path="lastName"/> <br />
              Street Address: <sf:input type="text" path="streetAddress" value="${address.streetAddress}"/> <sf:errors path="streetAddress"/><br />
              City: <sf:input type="text" path="city" value="${address.city}"/> <sf:errors path="city"/><br />
              State: <sf:input type="text" path="state" value="${address.state}"/> <sf:errors path="state"/><br />
             Zip Code: <sf:input type="text" path="zipCode" value="${address.zipCode}"/> <sf:errors path="zipCode"/> <br />
              
              <input type ="submit" value="Save" />
              
        </sf:form>
        
            
        
    </body>
</html>
