
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<div style="text-align: center; margin-top: 200px">

	<form action="./passwordregister" method="post">
		<input id="password" type="text" name="password"
			placeholder="enter your password here"> <input type="submit"
			value="submit" disabled="disabled"/>

		<div>
			<div id="1" class="invalid">password must not be empty</div>
			<div id="2" class="invalid">password must not starts with digit
				or special character</div>
			<div id="3" class="invalid">password must have one capital</div>
			<div id="4" class="invalid">password must have one special char</div>
			<div id="5" class="invalid">password must have at-least 8
				characters</div>
		</div>
	</form>

</div>

<script>
	$("#password").on(
			"keyup",
			function() {
				let password = $(this).val();

				$.ajax({
					url : "./validatePassword",
					method : "POST",
					contentType : "application/json",
					data : JSON.stringify({
						password : password
					}),
					success : function(response) {
						let allValid = true;

						// update div colors based on the validation results
						for ( let ruleId in response) {
							if (response[ruleId]) {
								$("#" + ruleId).removeClass("invalid")
										.addClass("valid");
							} else {
								$("#" + ruleId).removeClass("valid").addClass(
										"invalid");
								allValid = false;
							}
						}

						// Enable/Disable submit button
						$("input[type='submit']").prop("disabled", !allValid);
					}
				});
			});
</script>



<style>
input {
	margin: 20px
}

.invalid {
	margin: 5px;
	color: red;
}

.valid {
	margin: 5px;
	color: green;
}
</style>