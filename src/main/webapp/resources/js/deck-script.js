/**
 * 
 */

// Get the modal for adding new card
var modal = document.getElementById('modal-addcard-content');

// Get the modal for statistics
var modalStatistics = document.getElementById('modal-statistics-content');

// Get the button that opens the modal
var add_card_link = document.querySelector("#add-card-link");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
add_card_link.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
    if (event.target == modalStatistics){
    	modalStatistics.style.display = "none";
    }
    
}


