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
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="alertPackage/alertCss.css" type="text/css"/>
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
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Edit <b>Product</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="edit" method="post">
                            <div class="modal-header">						
                                <!--                                <h4 class="modal-title">Add Product</h4>
                                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>-->
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>ID</label>
                                    <input value="" name="id" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Name</label>
                                    <input name="nameE" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Type</label>
                                    <input name="typeE" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Condition</label>
                                    <input name="conditionE" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Detail</label>
                                    <input name="detailE" type="text" class="form-control" required>
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
                                        <c:forEach items="" var="o">
                                            <option value=""></option>
                                        </c:forEach>
                                    </select>
                                </div>	
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
<!--            <div>
                <div id="modal-alert" class="modal-alert">
                    <div class="modal-alert-fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content-alert">
                                <h5 class="modal-title-alert" id="exampleModalLabel">Xác nhận thanh toán</h5>
                                <p>Bạn có chắc chắn muốn thanh toán?</p>
                                <button class="btn btn-primary-alert btn-co">Có</button>
                                <button class="btn btn-secondary-alert">Không</button>
                            </div>                      `
                        </div>
                    </div>
                </div>
            </div>-->
        </div>

        <script src="alertPackage/alertJs.js" type="text/javascript"></script>
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>