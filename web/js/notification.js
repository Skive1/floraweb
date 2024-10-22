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
                console.log('Dữ liệu trả về:', data); // In ra dữ liệu trả về
                if (Array.isArray(data) && data.length > 0) {
                    data.forEach(function (notification, index) {
                        setTimeout(function () {
                            $('#snackbar').text(notification.message);
                            $('#snackbar').addClass('show');
                            setTimeout(function () {
                                $('#snackbar').removeClass('show');
                            }, 3000); // Hiển thị trong 3 giây
                        }, index * 3500); // Đảm bảo mỗi thông báo hiển thị cách nhau 3.5 giây (3000ms hiển thị + 500ms cho hiệu ứng)
                    });
                } else {
                    console.log('Không có thông báo chưa đọc.');
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error('Lỗi khi gọi AJAX:', textStatus, errorThrown);
            }
        });
    }, 5000); // 5000ms = 5 giây
}

// Gọi hàm khi tài liệu đã sẵn sàng
$(document).ready(function () {
    checkNotifications();
});