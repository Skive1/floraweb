/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(document).ready(function () {
    var notificationQueue = []; // Hàng đợi thông báo
    var isShowing = false; // Kiểm tra trạng thái có đang hiển thị thông báo hay không

    function showNextNotification() {
        if (notificationQueue.length > 0 && !isShowing) {
            isShowing = true; // Đánh dấu trạng thái đang hiển thị
            var message = notificationQueue.shift(); // Lấy thông báo đầu tiên ra khỏi hàng đợi

            $('#snackbar').text(message); // Đảm bảo cập nhật đúng nội dung thông báo
            $('#snackbar').addClass('show'); // Hiển thị snackbar

            setTimeout(function () {
                $('#snackbar').removeClass('show'); // Ẩn snackbar
                $('#snackbar').text(''); // Xóa nội dung thông báo

                isShowing = false; // Đánh dấu là không còn hiển thị thông báo nữa
                showNextNotification(); // Gọi lại để hiển thị thông báo tiếp theo nếu có
            }, 3000); // Thời gian hiển thị thông báo (3 giây)
        }
    }

    // Hàm kiểm tra thông báo và đẩy vào hàng đợi
    function checkNotifications() {
        $.ajax({
            url: '/checkNotifications',
            method: 'GET',
            success: function (data) {
                console.log('Dữ liệu trả về:', data);
                if (Array.isArray(data) && data.length > 0) {
                    data.forEach(function (notification) {
                        notificationQueue.push(notification.message); // Thêm thông báo vào hàng đợi
                    });
                    showNextNotification(); // Bắt đầu hiển thị thông báo
                } else {
                    console.log('Không có thông báo chưa đọc.');
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error('Lỗi khi gọi AJAX:', textStatus, errorThrown);
            }
        });
    }

    // Gọi kiểm tra thông báo định kỳ
    setInterval(checkNotifications, 5000); // Kiểm tra thông báo mỗi 5 giây
});

// Gọi hàm khi tài liệu đã sẵn sàng
$(document).ready(function () {
    checkNotifications();
});