/**
 * JavaScript for decklist
 */

// Get the modal
var modal = document.getElementById('modal-content');

// Get the button that opens the modal
var btn = document.querySelector("#add-deck-btn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
btn.onclick = function() {
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
}

/*document.addEventListener("DOMContentLoaded", function(event) {
	
	var formBase = document.createElement("form");
	formBase.setAttribute('id', 'add-deck-form');
	$("#add-deck-form").hide();
	
	function hideFormBase(event) {
		$("#add-deck-form").hide();
	}
	
	function fireAddDeckForm(event) {
		console.log('Fire addDeck form...');
		
		if($("#add-deck-form").data("hidden", true))
		{
			
			formBase.setAttribute('modelAttribute', 'deck');
			formBase.setAttribute('method', "post");
			formBase.setAttribute('action', "/addDeck");
			
			var name = document.createElement("input")
			name.setAttribute('type', 'text');
			name.setAttribute('name', 'Name:');
			
			var language = document.createElement("input")
			language.setAttribute('type', 'text');
			language.setAttribute('name', 'Language:');
			
			var comment = document.createElement("input")
			comment.setAttribute('type', 'text');
			comment.setAttribute('name', 'Comment:');
			
			var submitPart = document.createElement("input");
			submitPart.setAttribute('id', 'add-deck-submit-button');
			submitPart.setAttribute('type', 'submit');
			submitPart.setAttribute('value', 'Add deck');
			
			formBase.appendChild(name);
			formBase.appendChild(language);
			formBase.appendChild(comment);
			formBase.appendChild(submitPart);
			
			$("#add-deck-form").show();
			
			document.getElementsByTagName('body')[0].appendChild(formBase);
		}
		else
		{
			$("#add-deck-form").show();
		}
		
	}
	
	console.log($("testview-deck-buttons"))
	
	document.querySelector("#add-deck-btn").addEventListener("click", fireAddDeckForm);
	
});*/