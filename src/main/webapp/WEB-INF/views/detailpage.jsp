<div ng-controller="DetailCtrl as main">
	<h4>Showing details for <span ng-bind="main.stationName"></span> </h4>
	<span>Go back to <a href="#!">Station List</a></span>
	<hr>
	<div ng-init="main.load()">
	    <span>total {{main.stations.length}} record(s) found</span><br>
		<div ng-repeat="station in main.stations">
			<table>
			 <tr>
			 	<td>Station Name</td>
			 	<td>{{station.stationName}}</td>
			 </tr>
			 
			 <tr>
			 	<td>Province</td>
			 	<td>{{station.province}}</td>
			 </tr>
			 
			 <tr>
			 	<td>Date</td>
			 	<td>{{station.date | date}}</td>
			 </tr>
			 
			  <tr>
			 	<td>Mean Temp.</td>
			 	<td>{{station.meanTemp}}</td>
			 </tr>
			 
			  <tr>
			 	<td>Highest Monthly Max Temp.</td>
			 	<td>{{station.highestMonthlyMaxiTemp}}</td>
			 </tr>
			 
			  <tr>
			 	<td>Lowest Monthly Min Temp.</td>
			 	<td>{{station.lowestMonthlyMinTemp}}</td>
			 </tr>
			 
			</table>
			<br>
		</div>
	</div>
</div>