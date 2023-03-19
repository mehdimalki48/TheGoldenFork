<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

 <head>
    <meta charset="utf-8">
    <title>Home Page</title>
    
    <!--  CSS -->
    <link rel="stylesheet" href="./css/crud.css" />
    <link rel="stylesheet" href="./css/style.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" />
    
<!--     <script type="text/javascript" src="./js/jquery.js"></script> -->
<!--     <script type="text/javascript" src="./js/jquery.ui.js"></script> -->
<!--     <script type="text/javascript" src="./js/script.js"></script> -->
    
    
</head>


<body>

<div class="container">

	<%@include file="./NavBar.jsp"%>

	<div class="container text-center mt-3">
	<h3>
       <a href="#" class="logo logo-admin"><img src="assets/images/logo.png" height="250" alt="logo"></a>
    </h3>
	
	<div class="panel-body container">
          <form method="post" enctype="multipart/form-data">
              <table style="width: 85%;">
              	<tr>
              		<td><label for="titre">Type Name:</label></td>
              		<td><input type="text" name="titre" id="titre" class="form-control"/></td>
              	</tr>
              	
              	<tr >
              		<td ><label for="description">Description:</label></td>
              		<td><textarea name="description" id="description" class="form-control mt-3"> </textarea></td>
              	</tr>
              	

              </table>
		          <input type="submit" name="action" value="Enregistrer le type de menu" class="btn btn-primary mt-5" style="background-color: #d29f31; border: 1px solid white;"/>
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
                <th>Type Name</th>
                <th>Description</th>
                <th></th>
                <th></th>
            </thead>
            <tbody>
<!--                 <tr class="text-center "> -->
<!--                     <td><input type="checkbox"></td> -->
<!--                     <td class="text-center ">#TODO</td> -->
<!--                     <td class="text-center ">#TODO</td> -->
<!--                     <td class="text-center ">#TODO</td> -->
<!--                     <td> -->
<!--                         <span class="fa fa-edit" aria-hidden="true"><br><small>Edit</small></span> -->
<!--                     </td> -->
<!--                     <td> -->
<!--                         <span class="fa fa-trash" aria-hidden="true"><br><small>Delete</small></span> -->
<!--                     </td> -->
<!--                 </tr> -->
                <c:forEach items="${model.list_menu_types}" var="menutype">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${menutype.menu_type_id}</td>
                    <td>${menutype.type_name}</td>
                    <td>${menutype.description}</td>
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
    