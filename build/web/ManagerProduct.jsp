<%-- 
    Document   : ManagerProduct
    Created on : Dec 28, 2020, 5:19:02 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>MANAGE PRODUCT</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;                
            }

        </style>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title" style="background-color: orange"  >
                    <div class="row">
                        <div class="col-sm-6">
                            <h2 style="color: white">MANAGE PRODUCT</h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                            <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
                        </div>
                    </div>
                </div>
                <c:set var="currentP" value="${param.pageNum != null ? param.pageNum : 1}">

                </c:set>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll">
                                    <label for="selectAll"></label>
                                </span>
                            </th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Image</th>
                            <th>Price</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${listProduct}" begin="0" end="5" var="o" varStatus="counter">
<<<<<<< HEAD
                        <param name ="IdStore" value="${o.id}">
                        <c:set var="lastIdStore" value="${o.storeId}" scope="page"/> 
                        <tr>                          
                            <!--                                EDIT SẢN PHẨM TẠI ĐÂY-->                          
                            <td>${counter.count}</td>                            
                            <td>${o.name}</td>
                            <td>${o.type}</td>
                            <td>
                                <img src="${o.img}">
                            </td>
                            <td>${o.price}</td>
                            <td>                       
                                <a href="editProductManagement"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                <a href="DelManagement?proId=${o.id}&storeId=${o.storeId}&page=${currentP}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                            </td>
                        </tr>
                    </c:forEach>
=======
                            <param name ="IdStore" value="${o.storeId}">
                            <c:set var="lastIdStore" value="${o.storeId}" scope="page"/> 
                            <tr>
                                <td>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                        <label for="checkbox1"></label>
                                    </span>
                                    <!--                                EDIT SẢN PHẨM TẠI ĐÂY-->
                                </td>
                                <td>${counter.count}</td>
                                <td>${o.storeId}</td>
                                <td>${o.name}</td>
                                <td>
                                    <img src="${o.imageURL}">
                                </td>
                                <td>${o.price} VNĐ</td>
                                <td>
                                    <a href="#editEmployeeModal"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="DelProManagementServlet?proId=${o.productId}&page=${currentP}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
>>>>>>> main
                    </tbody>
                </table>

                <div class="clearfix">
                    <div class="hint-text">Showing all</div>
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="#">Previous</a></li>
                            <c:forEach begin="1" end="${endP}" var="i">
                            

                            <li class="page-item" ><a href="ProductManagementServlet?index=${i}" class="active rounded" >${i}</a></li>  




                        </c:forEach>
                        <li class="page-item"><a href="#" class="page-link">Last</a></li>
                    </ul>
                </div>


            </div>
            <a href="#"><button type="button" class="btn btn-primary">BACK TO STORE</button>

        </div>
        <!-- Add Products -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="add" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>${lastIdStore}</label>
                                <input name="id" type="text" class="form-control" required>
                                
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                <input name="name" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Condition</label>
                                <input name="type" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input name="price" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Quantity</label>
                                <textarea name="quantity" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Image Link</label>
                                <textarea name="imageURL" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <select name="type" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${listType}" var="o">
                                        <option value="${o.type}">${o.type}</option>
                                    </c:forEach>
                                </select>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Edit Product HTML -->
        <div id="editEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Name</label>
                                <input type="textE" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Type</label>
                                <input type="typeE" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Condition</label>
                                <textarea name ="conditionE" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Detail</label>
                                <textarea name ="detailE" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input name="priceE" type="number" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Quantity</label>
                                <input type="number" name="quantityE" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image Link</label>
                                <textarea name="imageE" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <select name="categoryE" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${listCate}" var="o">
                                        <option value="${o.categoryId}">${o.category}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-info" value="Save">
                            </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Delete Modal HTML -->
        <div id="deleteEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">						
                            <h4 class="modal-title">Delete Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <p>Are you sure you want to delete these Records?</p>
                            <p class="text-warning"><small>This action cannot be undone.</small></p>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-danger" value="Delete">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </a>
    <script src="js/manager.js" type="text/javascript"></script>
</body>
</html>