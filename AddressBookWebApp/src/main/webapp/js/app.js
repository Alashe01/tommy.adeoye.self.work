/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

console.log("Test Area");

//A page can't be manipulated safely until the document is "ready." 
//jQuery detects this state of readiness for you. Code included inside $( document ).ready()
//will only run once the page Document Object Model (DOM) is ready for JavaScript code to execute
$(document).ready(function () {

    console.log("Ready!");

    $('#CreateAddressButton').on('click', function (e) {

        e.preventDefault();

        var myAddress = {
            id: $('#idCreate').val(),
            firstName: $('#firstNameCreate').val(),
            lastName: $('#lastNameCreate').val(),
            streetAddress: $('#streetAddressCreate').val(),
            city: $('#cityCreate').val(),
            state: $('#stateCreate').val(),
            zipCode: $('#zipCodeCreate').val(),
        };

        var myAddressData = JSON.stringify(myAddress);
        console.log(contextRoot);

        $.ajax({
            url: contextRoot + "/address",
            type: "POST",
            data: myAddressData,
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function (data, status) {

                var tableRow = buildAddressRow(data);

                console.log(tableRow);

                $('#addressTable').append($(tableRow));

                $('#idCreate').val();
                $('#firstNameCreate').val('');
                $('#lastNameCreate').val('');
                $('#streetAddressCreate').val('');
                $('#cityCreate').val('');
                $('#stateCreate').val('');
                $('#zipCodeCreate').val('');

            },
            error: function (data, status) {

                console.log("ERROR");

                var errors = data.responseJSON.errors;
                $.each(errors, function (index, error) {
                    if(error.fieldName == "firstName"){
//                    $('#add-contact-validation-errors').append(error.fieldName + ":" + error.message + "<br />");
                        $('#add-firstName-validation-errors').append(error.fieldName + ":" + error.message + "<br />");
                    }

                });

            }

        });

    });

    $('#viewAddressModal').on('shown.bs.modal', function (e) {

        var link = $(e.relatedTarget);

        var addressId = link.data('address-id');

        $.ajax({
            url: contextRoot + "/address/" + addressId,
            type: "GET",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json")
            },
            success: function (data, status) {
                $('#viewFirstName').text(data.firstName);
                $('#viewLastName').text(data.lastName);
                $('#viewStreetAddress').text(data.streetAddress);
                $('#viewCity').text(data.city);
                $('#viewState').text(data.state);
                $('#viewZipCode').text(data.zipCode);
            },
            error: function (data, status) {
                alert("CONTACT NOT FOUND");
            }
        });


    });

    $('#editAddressModal').on('shown.bs.modal', function (e) {

        var link = $(e.relatedTarget);

        var addressId = link.data('address-id');

        $.ajax({
            url: contextRoot + "/address/" + addressId,
            type: "GET",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json")
            },
            success: function (data, status) {
                $('#editId').val(data.id);
                $('#editFirstName').val(data.firstName);
                $('#editLastName').val(data.lastName);
                $('#editStreetAddress').val(data.streetAddress);
                $('#editCity').val(data.city);
                $('#editState').val(data.state);
                $('#editZipCode').val(data.zipCode);
            },
            error: function (data, status) {
                alert("ADDRESS NOT ON FILE");
            }
        });


    });

    $('#editAddressButton').on('click', function (e) {

        e.preventDefault();

        var myAddress = {
            id: $('#editId').val(),
            firstName: $('#editFirstName').val(),
            lastName: $('#editLastName').val(),
            streetAddress: $('#editStreetAddress').val(),
            city: $('#editCity').val(),
            state: $('#editState').val(),
            zipCode: $('#editZipCode').val()
        };

        var myAddressData = JSON.stringify(myAddress);
        console.log(contextRoot);
        //check to see if this prints out in the console before you proceed\.

        $.ajax({
            url: contextRoot + "/address/" + myAddress.id,
            type: "PUT",
            data: myAddressData,
            dataType: "json",
            beforeSend: function (xhr) {

                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");

            },
            success: function (data, status) {

                var tableRow = buildAddressRow(data);



                $('#address-row-' + data.id).replaceWith($(tableRow));
                $('#editAddressModal').modal('hide');
                console.log(data.firstName);
            },
            error: function (data, status) {
                console.log("ERROR OCCURED!");
            }

        });

    });

    $('#deleteAddressModal').on('shown.bs.modal', function (e) {

        var link = $(e.relatedTarget);

        var addressId = link.data('address-id');

        $.ajax({
            url: contextRoot + "/address/" + addressId,
            type: "GET",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
            },
            success: function (data, status) {
                $('#deleteId').val(data.id);
                $('#deleteFirstName').text(data.firstName);
                $('#deleteLastName').text(data.lastName);
                $('#deleteStreetAddress').text(data.streetAddress);
                $('#deleteCity').text(data.city);
                $('#deleteState').text(data.state);
                $('#deleteZipCode').text(data.zipCode);
            },
            error: function (data, status) {
                alert("CONTACT NOT FOUND");
            }
        });


    });

    $('#deleteAddressButton').on('click', function (e) {

        e.preventDefault();

        var link = (e.relatedTarget);

        var addressId = $('#deleteId').val();

        var myAddress = {
            id: $('#deleteId').val(),
            firstName: $('#deleteFirstName').text(),
            lastName: $('#deleteLastName').text(),
            streetAddress: $('#deleteStreetAddress').text(),
            city: $('#deleteCity').text(),
            state: $('#deleteState').text(),
            zipCode: $('#deleteZipCode').text()
        };

        var myAddressData = JSON.stringify(myAddress);
        console.log(contextRoot);

        $.ajax({
            url: contextRoot + "/address/" + addressId,
            type: "DELETE",
            data: myAddressData,
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-type", "application/json");
            },
            success: function (data, status) {


                $('#address-row-' + addressId).remove();
                $('#deleteAddressModal').modal('hide');
//
//              $('#addressTable').remove($(tableRow));


//                $('#deleteFirstName').val(data.firstName);
//                $('#deleteLastName').val(data.lastName);
//                $('#deleteStreetAddress').val(data.streetAddress);
//                $('#deleteCity').val(data.city);
//                $('#deleteState').val(data.state);
//                $('#deleteZipCode').val(data.zipCode);

            },
            error: function (data, status) {

                console.log("UNABLE TO DELETE DATA");
            }

        });

    });




    $('#viewAddressModal').on('hidden.bs.modal', function () {
        $('#viewFirstName').text('');
        $('#viewLastName').text('');
        $('#viewStreetAddress').text('');
        $('#viewCity').text('');
        $('#viewState').text('');
        $('#viewZipCode').text('');

    });

    function buildAddressRow(data) {
        var tableRow = '\
                    <tr id="address-row-' + data.id + '"> \n\\n\
                    <td>' + data.id + ' </td>\n\
                    <td><a data-address-id="' + data.id + '" data-toggle="modal" data-target="#viewAddresssModal">' + data.firstName + ' ' + data.lastName + '</a></td> \n\\n\
                    <td></td>\n\
                    <td><a data-address-id="' + data.id + '" data-toggle="modal" data-target="#editAddressModal">Edit info</a></td> \n\
                    <td><a data-addrress-id="' + data.id + '" data-toggle="modal" data-target="#deleteAddressModal">Delete info</a></td> \n\
                    </tr>';

        return tableRow;

    }



});
