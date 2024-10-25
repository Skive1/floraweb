
const menuLi = document.querySelectorAll('.admin-sidebar-content > ul > li > a');

for (let index = 0; index < menuLi.length; index++) {
  menuLi[index].addEventListener('click', (e) => {
    e.preventDefault();

    // Get the clicked submenu
    const clickedSubMenu = e.target.parentNode.querySelector('ul');

    // Close all submenus (except the clicked one)
    const allSubMenus = document.querySelectorAll('.admin-sidebar-content > ul > li > ul');
    allSubMenus.forEach(item => {
      if (item !== clickedSubMenu) {
        item.style.height = '0px';
      }
    });

    // Toggle the clicked submenu
    if (clickedSubMenu.style.height === '0px') {
      clickedSubMenu.style.height = clickedSubMenu.scrollHeight + 'px';
    } else {
      clickedSubMenu.style.height = '0px';
    }
  });
}



// Trong file JavaScript của productList.html:
const activeTab = localStorage.getItem('activeTab');
const activeLink = document.querySelector(`a:contains("${activeTab}")`);
if (activeLink) {
  activeLink.classList.add('active');
}

function togglePassword() {
    const passwordInput = document.getElementById("myPassword");
    const eyeIcon = document.querySelector('.fa fa-eye');

    // Sử dụng một biến để theo dõi trạng thái
    let isPasswordShown = false;

    // Đảo ngược trạng thái và cập nhật kiểu nhập liệu
    isPasswordShown = !isPasswordShown;
    passwordInput.type = isPasswordShown ? 'text' : 'password';

    // Cập nhật icon dựa trên trạng thái
    eyeIcon.classList.toggle('fa-eye');
    eyeIcon.classList.toggle('fa-eye-slash');
}

// Gắn sự kiện click vào cả ô mật khẩu và icon
passwordInput.addEventListener('click', togglePassword);
eyeIcon.addEventListener('click', togglePassword);
