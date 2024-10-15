const modal = document.getElementById('modal-alert');
const btnClose = document.querySelectorAll('.btn'); // Lấy tất cả các nút đóng

// Hiển thị modal (ví dụ khi click vào một nút)
function showModal() {
  modal.style.display = 'static';
}

// Ẩn modal
function hideModal() {
  modal.style.display = 'none';
}

// Đóng modal khi click ngoài
window.onclick = function(event) {
  if (event.target === modal) {
    hideModal();
  }
};

    //Press "KHÔNG' BUTTON EVENT
    const btnKhong = modal.querySelector('.btn-secondary-alert');
    btnKhong.addEventListener('click', () => {
        modal.style.display = 'none';
    });
// Ví dụ: Hiển thị modal khi click vào nút có class "show-modal"
const showModalBtn = document.querySelector('.show-modal');
showModalBtn.addEventListener('click', showModal);

// Đóng modal khi click vào nút đóng
btnClose.forEach(btn => {
  btn.addEventListener('click', hideModal);
});