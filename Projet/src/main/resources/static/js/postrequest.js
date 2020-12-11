$( document ).ready(function() {
	
	// SUBMIT FORM
    $("#customerForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		customerPost();
	});
    
    
    function customerPost(){
    	
    	// PREPARE FORM DATA
    	var formData = {
    		email : $("#email").val(),
    	}
    	
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : window.location + "api/customer/save",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if(result.status == "Done"){
					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Votre email a bien été enregistré <br>" +
												"Votre email = " +
												result.data.email);
				}else{
					$("#postResultDiv").html("<strong>Error</strong>");
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
    	// Reset FormData after Posting
    	resetData();

    }
    
    function resetData(){
    	$("#email").val("");
    }

	function ticketPost(customer, vol) {
    	alert(vol);

		// PREPARE FORM DATA
		var formData = {
			customer: customer,
			vol: vol,
		}

		// DO POST
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: window.location + "api/ticket/save",
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function (result) {
				if (result.status == "Done") {
					alert('Votre reservation a bien été enregistré')
					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
						"Votre email a bien été enregistré <br>")

				} else {
					$("#postResultDiv").html("<strong>Error</strong>");
				}
				console.log(result);
			},
			error: function (e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
	}

	setTimeout(function () {
		$.each(document.getElementsByName("ticketForm"), function () {
			$(this).click(function(event) {

				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ticketPost($(this).closest("tr").find("select").prop('selectedIndex'), $(this).attr('form'));
			});

		});
	},100);
})