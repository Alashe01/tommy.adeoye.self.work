<%-- 
    Document   : home
    Created on : Sep 15, 2016, 11:07:27 AM
    Author     : apprentice
--%>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <div class="container"  >
            <div class="text-left" id="content">
                <h2 class="text-left">CRAZY WEEKEND PERSONAL ADDRESS BOOK</h2>
                <hr>

                <ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
                    <li class="active"><a href="#" data-toggle="tab">Home</a></li>
                    <li><a href="" data-toggle="tab">Search</a></li>
                    <li><a href="" data-toggle="tab">List</a></li>
                    <li><a href="" data-toggle="tab">Stats</a></li>
                </ul>  

            </div>

            <br/>



            <div class="col-md-6">
                <h2> Add New Address </h2>  
                <table class="table">
                    <sf:form method="POST" commandName= "address" action="${pageContext.request.contextPath}/address/create" role="form"  class="form-horizontal-group">

                        <tr>
                        <div class="form-group">

                            <input type= "hidden" id="idCreate" />

                            <td> <label>First Name:</label></td> 
                            <td> <input type="text" path="firstName" id="firstNameCreate" placeholder="Enter First Name"  />
                                <div id="add-firstName-validation-errors"> </div>   
                            </td>
                        </div>
                        </tr>

                        <tr>   
                        <div class="form-group">
                            <td> <label>Last Name:</label></td>  
                            <td> <input type="text" path="lastName" id="lastNameCreate" placeholder="Enter Last Name"  /> 
                                <div id="add-lastName-validation-errors"> </div> 
                            </td>
                        </div>
                        </tr>

                        <tr>
                        <div class="form-group">
                            <td> <label>Street Address:</label></td> 
                            <td> <input type="text" path="streetAddress" id="streetAddressCreate"  placeholder="Enter Street Address Here" /> 
                                <div id="add-streetAddress-validation-errors"> </div>  
                            </td>
                        </div>
                        </tr>

                        <tr>
                        <div class="form-group">
                            <td> <label>City: </label></td>  
                            <td> <input type="text" path="city" id="cityCreate" placeholder="Enter your City"/> 
                                <div id="add-city-validation-errors"> </div>
                            </td>
                        </div>
                        </tr>

                        <tr>
                        <div class="form-group">
                            <td> <label>State: </label> </td>  
                            <td> <input type="text" path="state" id="stateCreate" placeholder="Enter your State(XX)"/> 
                                <div id="add-state-validation-errors"> </div>
                            </td>
                        </div>
                        </tr>

                        <tr>
                        <div class="form-group">
                            <td> <label>Zip Code: </label></td>  
                            <td> <input type="text" path="zipCode" id="zipCodeCreate" placeholder="Enter your ZipCode"/> 
                                <div id="add-zipCode-validation-errors"> </div> 
                            </td>
                        </div>
                        </tr>

                        <tr> 
                        <div class="form-group" class="align-right">
                            <td>
                                <input id= "CreateAddressButton" type ="submit" value="Create Address" />
                            </td>
                        </div>
                        </tr>
                    </sf:form>
                </table>
            </div>






            <div class="col-md-6">

                <h3> My Address List </h3>
                <table id= "addressTable" class="table">
                    <tr>
                        <th>Address Id</th>
                        <th>Address Name</th>

                        <!--<th>Edit</th>
                        <th>Delete</th>-->

                    </tr>

                    <c:forEach items= "${addressBook}" var="address">
                        <tr id="address-row-${address.id}">
                            <td>${address.id}</td>
                            <td><a data-address-id="${address.id}" data-toggle="modal" data-target="#viewAddressModal">${address.firstName} ${address.lastName}</td>
                            <td></td>
                            <td><a data-address-id="${address.id}" data-toggle="modal" data-target="#editAddressModal" > Edit info</a></td>
                            <td><a data-address-id="${address.id}" data-toggle="modal" data-target="#deleteAddressModal" > Delete info</a></td>
                        </tr>
                    </c:forEach>

                </table>

            </div>  





            <div class="modal fade" id="viewAddressModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Address Details</h4>
                        </div>
                        <div class="modal-body">
                            <table>
                                <tr>
                                    <th>First Name:</th>
                                    <td id="viewFirstName"></td>
                                </tr>
                                <tr>
                                    <th>Last Name:</th>
                                    <td id="viewLastName"> </td>
                                </tr>
                                <tr>
                                    <th>Street Address:</th>
                                    <td id="viewStreetAddress"> </td>
                                </tr>
                                <tr>
                                    <th>City:</th>
                                    <td id="viewCity" ></td>
                                </tr>
                                <tr>
                                    <th>State: </th>
                                    <td id="viewState"> </td>
                                </tr>
                                <tr>
                                    <th>Zip Code:</th>
                                    <td id="viewZipCode"> </td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>



            <div class="modal fade" id="editAddressModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Edit Address Information</h4>
                        </div>
                        <div class="modal-body">

                            <input type= "hidden" id="editId" />

                            <table>
                                <tr>
                                    <th>First Name:</th>
                                    <td><input type="text" id="editFirstName" /> </td>
                                </tr>
                                <tr>
                                    <th>Last Name:</th>
                                    <td><input type="text" id="editLastName" /> </td>
                                </tr>
                                <tr>
                                    <th>Street Address:</th>
                                    <td><input type="text" id="editStreetAddress"/> </td>
                                </tr>
                                <tr>
                                    <th>City:</th>
                                    <td><input type="text" id="editCity"/></td>
                                </tr>
                                <tr>
                                    <th>State:</th>
                                    <td><input type="text" id="editState"/> </td>
                                </tr>
                                <tr>
                                    <th>Zip Code:</th>
                                    <td><input type="text" id="editZipCode"/> </td>
                                </tr>
                            </table>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="editAddressButton" >Save changes</button>
                        </div>
                    </div>
                </div>
            </div>



            <div class="modal fade" id="deleteAddressModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Delete Address Information</h4>
                        </div>
                        <form>
                            <div class="modal-body">

                                <input type="hidden" id="deleteId"/>
                                <table>
                                    <tr>
                                        <th>First Name:</th>
                                        <td id="deleteFirstName" /> </td>
                                    </tr>
                                    <tr>
                                        <th>Last Name:</th>
                                        <td id="deleteLastName" /> </td>
                                    </tr>
                                    <tr>
                                        <th>Street Address:</th>
                                        <td id="deleteStreetAddress"/> </td>
                                    </tr>
                                    <tr>
                                        <th>City:</th>
                                        <td id="deleteCity"/></td>
                                    </tr>
                                    <tr>
                                        <th>State:</th>
                                        <td id="deleteState"/> </td>
                                    </tr>
                                    <tr>
                                        <th>Zip Code:</th>
                                        <td id="deleteZipCode"/> </td>
                                    </tr>
                                </table>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close Page</button>
                                <button type="button" class="btn btn-primary" id="deleteAddressButton" class="delete-link" >Confirm Delete</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>




        </div>




        <script>

            var contextRoot = "${pageContext.request.contextPath}";
        </script> 


        <script src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/app.js" /></script>

</body>

<footer>
    <div class="container">
        <center> <p class="text-muted">COPYRIGHT 1908-2016 TommyBots, LLC. ALL RIGHTS RESERVED.</p></center>
    </div>

</footer>


</html>
