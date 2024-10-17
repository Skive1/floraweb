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
