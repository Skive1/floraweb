/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// const menuLi = document.querySelectorAll('.admin-sidebar-content > ul > li > a')

// for (let index = 0; index < menuLi.length; index++) {
//     menuLi[index].addEventListener('click', (e)=>{
//         e.preventDefault(); 
//          menuLi[index].parentNode.querySelector('ul').classList.add('active')
//          console.log(menuLi[index].parentNode.querySelector('ul'))
//     });
// }


const menuLi = document.querySelectorAll('.admin-sidebar-content > ul > li > a');

for (let index = 0; index < menuLi.length; index++) {
    menuLi[index].addEventListener('click', (e) => {
        e.preventDefault();

        const subMenu = menuLi[index].parentNode.querySelector('ul');

        // Kiểm tra xem ul đã có class active chưa
        if (subMenu.classList.contains('active')) {
            subMenu.classList.remove('active');
        } else {
            subMenu.classList.add('active');
        }
    });
}