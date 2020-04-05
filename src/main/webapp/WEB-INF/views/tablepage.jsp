<div ng-controller="TableCtrl as table">
     <table id="example" class="display" style="width:100%">
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
<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": {
            "url": "/stations",
            "type": "GET"
        },
        "columns": [
            { "data": "stationName" },
            { "data": "province" },
            { "data": "date" },
            { "data": "meanTemp" },
            { "data": "highestMonthlyMaxiTemp" },
            { "data": "lowestMonthlyMinTemp" }
        ]
    } );
} );
</script>