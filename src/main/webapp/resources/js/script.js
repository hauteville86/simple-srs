/**
 * 
 */


document.addEventListener("DOMContentLoaded", function(event) {
	
	function changeSrsStatus(event) {
		console.log('SrsStatus is going to be changed');
		console.log(document.querySelector("#back").attributes);
		document.querySelector("#back").style.color = "black";
		$("#srs-buttons").show();
//		$("#srs-button-1").show();
//		$("#srs-button-2").show();
//		$("#srs-button-3").show();
//		$("#srs-button-4").show();
		$("#go-to-next-button").hide();
	}
	
	document.querySelector("#go-to-next-button").addEventListener("click", changeSrsStatus);
});
