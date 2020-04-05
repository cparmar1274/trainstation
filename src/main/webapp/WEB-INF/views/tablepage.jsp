<div ng-controller="TableCtrl as table" ng-init="table.read()"> 
	<h4> Train Station List </h4>
	<hr>
  <div class="row pull-right">
    <div class="input-group input-daterange">
      <input type="text" id="min" class="date-range-filter" data-date-format="mm/dd/yyyy" placeholder="From:">
      <div class="input-group-addon">to</div>
      <input type="text" id="max" class="date-range-filter" data-date-format="mm/dd/yyyy" placeholder="To:">
    </div>
  </div>
	<table id="stationListTable" class="display" >
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
	<script type="text/javascript">


$(document).ready(function() {
	
	$('.input-daterange input').each(function() {
		  $(this).datepicker('clearDates');
		});
	
    var table = $('#stationListTable').DataTable({
        "processing": true,
        "serverSide": true,
        "bFilter":false,
        "ajax": {
            "url": "/stations",
            "type": "GET",
            "data":function(data){
            	data.startDate = $('#min').val();
                data.endDate = $('#max').val();
            }
        },
        "columns": [
            { "data": "stationName" },
            { "data": "province" },
            { "data": "date" },
            { "data": "meanTemp" },
            { "data": "highestMonthlyMaxiTemp" },
            { "data": "lowestMonthlyMinTemp" }
        ],
        "columnDefs":[{
        	targets:[3],
        	render:function(data,type,row){
        		var meanTemp = data==undefined || data==null ? "not_avail" : data;
        		return '<a href="/#!/detail?stationName='+row.stationName+'">'+meanTemp+'</a>';
        	}
        },{targets:2, render:function(data){
            return moment(data).format('MM/DD/YYYY');
          }},{
        	  targets:[1,4,5],
        	  visible:false
          }]
    });
    
    // Event listener to the two range filtering inputs to redraw on input
        $('#min, #max').change(function () {
            table.draw();
        });
   
} );
</script>
</div>