<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<body>

	<%@include file="header.jsp"%>
	<div class="container" style="margin-left: 20%; padding-top: 5%"
		>
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="updateEntertainment" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insertEntertainment" method="post" enctype="multipart/form-data">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit Entertainment Resource Details
            		</c:if>
						<c:if test="${user == null}">
            			Add New Entertainment Resource Details
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label> Enteratianment Name</label> <input type="text"
						value="<c:out value='${user.cateringname}' />" class="form-control"
						name="cateringname" required="required">
				</fieldset>

				

				<fieldset class="form-group">
					<label> Catering Menu Details</label> <input type="text"
						value="<c:out value='${user.cateringmenudetails}' />" class="form-control"
						name="cateringmenudetails"  required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label> Working Days</label> <input type="text"
						value="<c:out value='${user.workingdays}' />" class="form-control"
						name="workingdays"  required="required">
				</fieldset>
				<fieldset class="form-group">
					<label> Location</label> <input type="text"
						value="<c:out value='${user.location}' />" class="form-control"
						name="location" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> Cost Details</label> <input type="file" class="form-control"
						name="file" >
				</fieldset>
				<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-dark">Save</button>
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>