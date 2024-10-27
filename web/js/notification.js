/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function checkNotifications() {
    setInterval(function () {
        $.ajax({
            url: 'checkNotifications',
            method: 'GET',
            success: function (data) {
                console.log('Dữ liệu trả về:', data);
                if (Array.isArray(data) && data.length > 0) {
                    data.forEach(function (notification, index) {
                        setTimeout(function () {
                            $('#snackbar').text(notification.message);
                            $('#snackbar').addClass('show');
                            setTimeout(function () {
                                $('#snackbar').removeClass('show');
                            }, 3000);
                        }, index * 3500);
                    });
                } else {
                    console.log('Không có thông báo chưa đọc.');
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error('Lỗi khi gọi AJAX:', textStatus, errorThrown);
            }
        });
    }, 5000);
}

$(document).ready(function () {
    checkNotifications();
});