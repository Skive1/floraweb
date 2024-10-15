const modal = document.getElementById('modal-alert');
const btnClose = document.querySelectorAll('.btn'); // Lấy tất cả các nút đóng


function showModal() {
  modal.style.display = 'flex';
}


function hideModal() {
  modal.style.display = 'none';
}


window.onclick = function(event) {
  if (event.target === modal) {
    hideModal();
  }
};
const btnCo = modal.querySelector('.btn-co');
    btnCo.addEventListener('click', () => {
        window.location.href = 'thanhcong.html'; 
    });
    //Press "KHÔNG' BUTTON EVENT
    const btnKhong = modal.querySelector('.btn-secondary-alert');
    btnKhong.addEventListener('click', () => {
        modal.style.display = 'none';
    });

const showModalBtn = document.querySelector('.show-modal');
showModalBtn.addEventListener('click', showModal);


btnClose.forEach(btn => {
  btn.addEventListener('click', hideModal);
});