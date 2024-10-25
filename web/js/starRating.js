/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.querySelectorAll('#starRating .fa').forEach(function(star) {
    star.addEventListener('click', function() {
        let ratingValue = this.getAttribute('data-value');
        document.getElementById('feedbackRatingValue').value = ratingValue;
        
        // Reset all stars to the empty state
        document.querySelectorAll('#starRating .fa').forEach(function(star) {
            star.classList.remove('fa-star');
            star.classList.add('fa-star-o');
        });

        // Highlight selected stars
        for (let i = 1; i <= ratingValue; i++) {
            document.querySelector('#starRating .fa[data-value="' + i + '"]').classList.add('fa-star');
            document.querySelector('#starRating .fa[data-value="' + i + '"]').classList.remove('fa-star-o');
        }
    });
});