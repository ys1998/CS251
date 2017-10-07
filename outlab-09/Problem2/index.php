<html>
<head>
	<style type="text/css">
	body {
		background-color: rgb(160,160,160);
	}
	input {
		width: 100%;
	}
	select {
		width:100%;
	}
	.form {
		display: none;
		padding: 1em;
		margin: 1em auto;
		border: 1px solid rgb(0,0,0);
		box-shadow: 0em 0em 0.5em rgba(0,0,0,0.5) inset;
		width: 20em;
		background-color: rgb(240,240,240);			
	}
</style>
<body>
	<script type="text/javascript">
		function showEvent(){
			var sel=document.getElementById("selectedChoice");
			var choice=sel.options[sel.selectedIndex].value;
			var forms=document.getElementsByClassName("form");
			for (var i = 0; i < forms.length; i++) {
				var f=forms.item(i);
				if(f.id==choice){
					f.style.display="inline-block";
				}
				else{
					f.style.display="none";
				}
			}
			
		}
		function submitQuery(){
			var forms=document.getElementsByClassName("form");
			for (var i = 0; i < forms.length; i++) {
				var f=forms.item(i);
				if(f.style.display=="inline-block"){
					var f=f.getElementsByTagName("form");
					f=f.item(0); f.submit();
					break;
				}
			}
		}
	</script>
	<div style="width:22em; position:relative; top:3em; padding:1em; border: 2px solid rgb(0,0,0); margin: auto auto; box-shadow: 0em 0em 1em rgba(0,0,0,0.5); background-color: white">
		<p>Select the action you want to perform :</p>
		<select id="selectedChoice" onchange="showEvent();">
			<option value="add" selected>Add new event</option>
			<option value="delete">Delete event by EVENT_ID</option>
			<option value="update">Update event by EVENT_ID</option>
			<option value="display_all">Display all existing events</option>
			<option value="display_date">Display events by date</option>
		</select>


		<br>
		<div class="form" id="add">
			<form action="process.php" method="POST">
				<input type="hidden" name="choice" value="add">
				<input type="text" name="date" placeholder="Enter date [YYYY-MM-DD]"><br><br>
				<input type="text" name="st_time" placeholder="Enter start time [HH:MM:SS]"><br><br>
				<input type="text" name="end_time" placeholder="Enter ending time [HH:MM:SS]"><br><br>
				<input type="text" name="desc" placeholder="Enter brief description" maxlength="100">
			</form>
		</div>
		<div class="form" id="delete">
			<form action="process.php" method="POST">
				<input type="hidden" name="choice" value="delete">
				<span>Enter EVENT_ID to delete : <input type="number" name="event_id" value="1"></span>
			</form>
		</div>
		<div class="form" id="update">
			<form action="process.php" method="POST">
				<input type="hidden" name="choice" value="update">
				<span>Enter EVENT_ID to update : <br><input type="number" name="event_id" value="1"></span><br><br>
				<input type="text" name="date" placeholder="Enter new date [YYYY-MM-DD]"><br><br>
				<input type="text" name="st_time" placeholder="Enter new start time [HH:MM:SS]"><br><br>
				<input type="text" name="end_time" placeholder="Enter new ending time [HH:MM:SS]"><br><br>
				<input type="text" name="desc" placeholder="Enter new description" maxlength="100">
			</form>
		</div>
		<div class="form" id="display_date">
			<form action="process.php" method="POST">
				<input type="hidden" name="choice" value="display_date">
				<input type="text" name="date" placeholder="Enter date [YYYY-MM-DD]">
			</form>
		</div>
		<div class="form" id="display_all">
			<form action="process.php" method="POST">
				<input type="hidden" name="choice" value="display_all">
				<span>No fields to fill. Click on "Submit query" to view all events.</span>
			</form>
		</div>
		<input type="button" onclick="submitQuery();" value="Send query">
	</div>
	<script type="text/javascript">
		showEvent();
	</script>
</body>
</html>