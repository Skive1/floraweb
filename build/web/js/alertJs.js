const btnThanhToan = document.getElementById('btnThanhToan');
const modal = document.getElementById('modal');

btnThanhToan.addEventListener('click', () => {
    const modalContent = `
    <div class="modal-content">
      <h5 class="modal-title" id="exampleModalLabel">Xác nhận thanh toán</h5>
      <p>Bạn có chắc chắn muốn thanh toán?</p>
      <button class="btn btn-primary btn-co">Có</button>
      <button class="btn btn-secondary">Không</button>
    </div>
  `;

    modal.innerHTML = modalContent;

    modal.style.display = 'block';
    //Press "CÓ' BUTTON EVENT
    const btnCo = modal.querySelector('.btn-co');
    btnCo.addEventListener('click', () => {
        window.location.href = 'thanhcong.html'; // Thay thế 'thanhcong.html' bằng URL mong muốn
    });
    //Press "KHÔNG' BUTTON EVENT
    const btnKhong = modal.querySelector('.btn-secondary');
    btnKhong.addEventListener('click', () => {
        modal.style.display = 'none';
    });
});

// CLOSE EVENT WITH OUTSIDE CLICK
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
};
