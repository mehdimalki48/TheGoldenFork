<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

 <head>
    <meta charset="utf-8">
    <title>Home Page</title>
    
    <!--  CSS -->
    <link href="./css/crud.css">
    <link href="./css/style.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
    
</head>


<body>

<div class="container">

	<c:import url="NavBar.jsp"> </c:import>
	
	<div class="container text-center mt-3">
	<h3>
       <a href="#" class="logo logo-admin"><img src="assets/images/logo.png" height="250" alt="logo"></a>
    </h3>
	
	<div class="panel-body container">
          <form method="post" enctype="multipart/form-data">
              <table style="width: 85%;">
              	<tr>
              		<td><label for="titre">Title:</label></td>
              		<td><input type="text" name="titre" id="titre" class="form-control mb-3"/></td>
              	</tr>
              	<tr>
              		<td><label for="categorie">Category:</label></td>
              		<td>
              			<select name="category" class="form-control mb-3">
              				<c:forEach items="${model.list_menu_types}" var="item">
              					<option value="${item.menu_type_id}">${item.type_name}</option>
              				</c:forEach>
              			</select>
              		</td>
              	</tr>
              	<tr>
              		<td><label for="ingredients">Ingredients:</label></td>
              		<td><textarea name="ingredients" id="ingredients" class="form-control  mb-3"> </textarea></td>
              	</tr>
              	<tr>
              		<td><label for="price">Price:</label></td>
              		<td><input type="text" name="price" id="price" class="form-control  mb-3"/></td>
              	</tr>
              	<tr>
              		<td><label for="image">Menu's Image:</label></td>
              		<td><input type="file" name="image" id="image" class="form-control mb-3" accept="image/png, image/jpeg"/></td>
              	</tr>

              </table>
		          <input type="submit" name="action" value="Enregistrer le menu" class="btn btn-primary mt-5" style="background-color: #d29f31; border: 1px solid white;"/>
              </form>
      </div>
      
	
	<div class="container">
    <div class="box">
        <div class="col-md-12">
            <div class="col-md-3 pull-right form-group has-feedback searchbox">
                <input type="text" class="form-control has-feedback-left" placeholder="Search here" >
            </div>
            <div class="pull-right">
                <button type="button" class="btn" style="background-color: #d19e30"><span class="fa fa-plus" aria-hidden="true"></span> ADD</button>
                <button type="button" class="btn" style="background-color: #d19e30"><span class="fa fa-trash-o" aria-hidden="true"></span> Delete</button>
            </div>
        </div>
        <table class="table table-striped">
            <thead>
                <th><input type="checkbox" ></th>
                <th>ID</th>
                <th>Name</th>
                <th>Ingredients</th>
                <th>Status</th>
                <th>Price</th>
                <th>Menu Type</th>
                <th></th>
                <th></th>
            </thead>
            <tbody>
            <c:forEach items="${model.list_menus}" var="item">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${item.menu_id}</td>
                    <td>${item.menu_name}</td>
                    <td>${item.ingredients}</td>
                    <td>${item.menu_status}</td>
                    <td>${item.price}</td>
                    <td>${item.menuType.type_name}</td>
                    <td>
                        <span class="fa fa-edit" aria-hidden="true"><br><small>Edit</small></span>
                    </td>
                    <td>
                        <span class="fa fa-trash" aria-hidden="true"><br><small>Delete</small></span>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        
    </div>
</div>
	
	</div>
</div>






</body>
</html>
    
    