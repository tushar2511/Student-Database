<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 style="text-align: center; background-color: orange">Student Registration</h1>
<br>
<form action='/index/add' method='post'>
 
    <table>
 
        <tr>
            <td><b>Name</b></td> 
            <td><input type='text' name='name'  required/></td>
        </tr>
 
        <tr>
            <td><b>Address</b></td>
            <td><input type='text' name='address' required/></td>
            
        </tr>
        
        <tr>
            <td><b>Subject</b></td>
            <td><input type='text' name='subject' required/></td>
        </tr>
        
        <tr>
            <td><b>Contact No.</b></td>
            <td><input type='text' name='mobilePhone' required/></td><br>
        </tr>
 
 
        <tr>
            <td></td>
            <td>
                <button type="submit" style="background-color: #87CEEB; margin: 5px 0;" >Enroll</button>
            </td>
        </tr>
 
    </table>
    <b><c:out value="${danger}"></c:out></b>
</form>



<h3>List of Students</h3>
<br>
<table>

    <thead>
      <tr>
        <th><b>Name</b></th>
        <th><b>Address</b></th>
        <th><b>Subject</b></th>
        <th><b>Contact No.</b></th>
        <th><b>Transactions</b></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="lou">
			<tr>
				<td><c:out value="${lou.id}"></c:out></td>
				<td><c:out value="${lou.name}"></c:out></td>
				<td><c:out value="${lou.address}"></c:out></td>
				<td><c:out value="${lou.subject}"></c:out></td>
				<td><c:out value="${lou.mobilePhone}"></c:out></td>

				<td><a href="/index/${lou.id}/edit">
						<button type="submit" class="btn btn-primary">Edit </button>
				</a></td>
				<td><a href="/index/${lou.id}/delete">
						<button type="submit" style="background-color: red" >Delete </button>
				</a></td>
			</tr>

		</c:forEach>
    </tbody>
  </table>
</div>