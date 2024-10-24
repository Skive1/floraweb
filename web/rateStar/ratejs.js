function submitRating() {
    const rating = document.querySelector('input[name="rating"]:checked').value;
    // Sử dụng AJAX để gửi dữ liệu đến Servlet
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'yourServletUrl');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onload = () => {
      if (xhr.status === 200) {
        console.log('Đã gửi đánh giá thành công:', rating);
        // Thực hiện các hành động khác sau khi gửi thành công (ví dụ: hiển thị thông báo)
      } else {
        console.error('Lỗi khi gửi đánh giá:', xhr.statusText);
      }
    };
    xhr.send(`rating=${rating}`);
  }