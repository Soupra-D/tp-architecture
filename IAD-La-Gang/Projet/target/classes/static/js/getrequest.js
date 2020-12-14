$( document ).ready(function() {





	// GET REQUEST
	$("#getAllCustomerId").click(function(event){
		event.preventDefault();
		ajaxGet();
	});
	var airport = null;
	var vol = null;

	loadVol();
	loadCustomerDropdown();


	
	// DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : window.location + "api/customer/all",
			success: function(result){
				if(result.status == "Done"){
					$('#getResultDiv ul').empty();
					$.each(result.data, function(i, customer){
						var customer = "- Customer with Id = " + i + ", firstname = " + customer.firstname + ", lastName = " + customer.lastname + "<br>";
						$('#getResultDiv .list-group').append(customer)
			        });
					console.log("Success: ", result);
				}else{
					$("#getResultDiv").html("<strong>Error</strong>");
					console.log("Fail: ", result);
				}
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}

	function loadAirport(){
		$.ajax({
			type : "GET",
			url : window.location + "api/aeroport/all",
			success: function(json) {
				airport = json.data;
			}
		});
	}

	function loadCustomerDropdown(){
		$.ajax({
			type : "GET",
			url : window.location + "api/customer/all",
			success: function(json) {
				$.each(json.data, function (i, value) {
					var elements = document.getElementsByName('customerDropdown');
					for (var i = 0; i < elements.length; i++) {
						$('<option></option>', {text: value.email}).attr('value', value).appendTo(elements[i]);
					}
					$('<option></option>', {text: value.email}).attr('value', value).appendTo($("#customerToDisplay"));
				});
			}
		});
	}

	function loadVol(){
		loadAirport();
		$.ajax({
			type: "GET",
			url: window.location + "api/vol/all",
			success: function (json) {
				$.each(json.data, function (i, value) {
					vol = json.data;
					$('<tr scope="col"></tr>').append(
						$('<td class="text-center"></td>').text(airport[value.depart].code + " (" + airport[value.depart].nom + ")"),
						$('<td class="text-center"></td>').text(airport[value.arrive].code + " (" + airport[value.arrive].nom + ")"),
						$('<td class="text-center"></td>').text(value.date),
						$('<td class="text-center"></td>').text(value.prix + "€"),
						$('<td class="text-center"></td>').text(value.disponibilite),
						$('<td></td>').append($('<select name="customerDropdown" class="form-control"></select>').attr("form", i)),
						$('<td></td>').append($('<button class="btn btn-primary" type="submit"></button>').text('Reserver').attr({ form:i,  name:"ticketForm" })))
					.appendTo('#volTable');
				});
			}
		});
	}

	$("#customerForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		setTimeout(function () {

			$.each(document.getElementsByName("customerDropdown"), function () {
				$(this).empty();
			});

			event.preventDefault();
			loadCustomerDropdown();
		},100);
	});




	$("#displayTicketForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		loadCustomerTicket(	$("#customerToDisplay").prop('selectedIndex'));

	});




	function loadCustomerTicket(customer){
		console.log('hello');
		$('#ticketTable').empty();
		$.ajax({
			type: "POST",
			url: window.location + "api/ticket/bycustomer",
			data: { customer: parseInt(customer) },
			success: function (json) {
				console.log(json.data);

				$.each(json.data, function (i, value) {
					var depart = parseInt(vol[value.vol].depart);
					var arrive = parseInt(vol[value.vol].arrive);
					console.log(airport);
					console.log(depart);
					console.log(airport[depart].code);
					$('<tr scope="col"></tr>').append(
						$('<td class="text-center"></td>').text(airport[depart].code + " (" + airport[depart].nom + ")"),
						$('<td class="text-center"></td>').text(airport[arrive].code + " (" + airport[arrive].nom + ")"),
						$('<td class="text-center"></td>').text(vol[value.vol].date),
						$('<td class="text-center"></td>').text(vol[value.vol].prix+ "€"))
						.appendTo('#ticketTable');
				});
			},
			error: function (e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
	}
	// DO POST

})