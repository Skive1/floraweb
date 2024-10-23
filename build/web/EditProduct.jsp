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
        <title>EDIT PAGE</title>
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
            <div>
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="confirmEdit" id="myForm" method="post">
                            <div class="modal-header">						
                                <!--                                <h4 class="modal-title">Add Product</h4>
                                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>-->
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                <input type="hidden" name="idE" value="${ProductId}">  
                                <input type="hidden" name="storeId" value="${StoreId}">
                                </div>
                                <div class="form-group">
                                    <label>Name</label>
<<<<<<< HEAD
<<<<<<< HEAD
                                    <input name="nameE" value="${detail.name}" type="text" maxlength="20" class="form-control" required>
=======
                                    <input name="nameE" value="${detail.name}" type="text" maxlength="20" placeholder="Nhập tối đa 20 ký tự" class="form-control" required>
>>>>>>> parent of 80956c2 (Update (2) 23/10)
                                </div>
                                <div class="form-group">
                                    <label>Type</label>
                                    <input name="typeE" value="${detail.type}" type="text" maxlength="15" placeholder="Nhập tối đa 15 ký tự" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Condition</label>
                                    <input name="conditionE" value="${detail.condition}" type="text" maxlength="20" placeholder="Nhập tối đa 20 ký tự" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Detail</label>
<<<<<<< HEAD
                                    <input name="detailE" value="${detail.detail}" type="text" maxlength="20" class="form-control" required>
=======
                                    <input name="nameE" value="${detail.name}" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Type</label>
                                    <input name="typeE" value="${detail.type}" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Condition</label>
                                    <input name="conditionE" value="${detail.condition}" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Detail</label>
                                    <input name="detailE" value="${detail.detail}" type="text" class="form-control" required>
>>>>>>> main
=======
                                    <input name="detailE" value="${detail.detail}" type="text" maxlength="20" placeholder="Nhập tối đa 20 ký tự" class="form-control" required>
>>>>>>> parent of 80956c2 (Update (2) 23/10)
                                </div>
                                <div class="form-group">
                                    <label>Price</label>
                                    <input name="priceE" value="${detail.price}" type="number" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Quantity</label>
                                    <input type="number" name="quantityE" value="${detail.quantity}" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Image Link</label>
                                    <input name="imageE" value="${detail.img}" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Category</label>
                                    <select name="categoryE" class="form-select" aria-label="Default select example">
                                        <c:forEach items="${ListCat}" var="o">
                                            <option value="${o.categoryId}">${o.category}</option>
                                        </c:forEach>
                                    </select>
                                </div>	
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Edit">
                            </div>
                            <div id="modal-alert" class="modal-alert" style="display: none;">
                                <div class="modal-alert-fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content-alert" style="width: 50%; margin: 30% auto">                                            
                                            <p style="font-size: 18px; color: darkblue;">Bạn có chắc chắn muốn sửa đổi sản phẩm?</p>                                           
                                            <button type="submit" class="btn btn-primary-alert" style="padding: 15px 45px;">Có</button> 
                                            <button type="button" class="btn btn-secondary-alert" data-dismiss="alert">Không</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
            const editButton = document.querySelector('.btn-success');
            const confirmModal = document.getElementById('modal-alert');
            const confirmNoButton = document.querySelector('.btn-secondary-alert');
            const confirmYesButton = document.querySelector('.btn-primary-alert');

            editButton.addEventListener('click', (event) => {
                event.preventDefault(); // Ngăn chặn submit mặc định
                confirmModal.style.display = 'block';
            });

            confirmNoButton.addEventListener('click', () => {
                confirmModal.style.display = 'none';
            });

            confirmYesButton.addEventListener('click', () => {
                // Gửi dữ liệu đến servlet (ví dụ bằng form hoặc AJAX)
                const form = document.createElement('form');
                form.method = 'POST';
                form.action = 'confirmEdit';
               
                document.body.appendChild(form);
                form.submit();
            })
            
    ;
        </script>
        <script src="alertPackage/alertJs.js" type="text/javascript"></script>
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>