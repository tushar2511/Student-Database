<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">

<h3>User Registration</h3>
<form action='/index/update' method='post'>
 
    <table class='table table-hover table-responsive table-bordered'>
 
        <tr>
            <td><b>Name</b></td>
            <td><input type='text' name='name' class='form-control' value="${user.name}" /></td>
        </tr>
 
        <tr>
            <td><b>Address</b></td>
            <td><input type='text' name='address' class='form-control' size="20" value="${user.address}" /></td>
            
        </tr>
        
        <tr>
            <td><b>Subject</b></td>
            <td><input type='text' name='subject' class='form-control' value="${user.subject}" /></td>
        </tr>
 
 			<input type='hidden' id='id' rows='5' class='form-control' name='id' value="${user.id}"/>
        <tr>
            <td></td>
            <td>
                <button type="submit" class="btn btn-primary">Update User Information</button>
            </td>
        </tr>
 
    </table>
</form>


</div>