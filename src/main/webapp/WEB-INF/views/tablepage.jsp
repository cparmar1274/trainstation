<div style="margin-top: 5%" ng-controller="TableCtrl as table">
	<div class="panel">
		<div class="input-daterange">
			<span>Apply filter by Date&nbsp;</span> <input type="text" id="min"
				class="date-range-filter" data-date-format="mm/dd/yyyy"
				placeholder="Start Date..."> <input type="text" id="max"
				class="date-range-filter" data-date-format="mm/dd/yyyy"
				placeholder="End Date...">
			<button class="btn btn-sm btn-outline-success"
				ng-click="table.clear()">Clear</button>
		</div>
	</div>
	<hr>
	<div class="panel">
		<table id="stationListTable" class="display">
			<thead>
				<tr>
					<th>Station Name</th>
					<th>Province</th>
					<th>Date</th>
					<th>Mean Temp.</th>
					<th>Highest Monthly Max Temp.</th>
					<th>Lowest Monthly Min Temp.</th>
				</tr>
			</thead>
		</table>
	</div>
	<script type="text/javascript" src="/js/tablepage.js"></script>
</div>