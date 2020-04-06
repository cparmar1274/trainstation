$(document).ready(function() {

    $('.input-daterange input').each(function() {
        $(this).datepicker('clearDates');
    });

    var table = $('#stationListTable').DataTable({
        "processing": true,
        "serverSide": true,
        "bFilter": false,
        "ordering": false,
        "ajax": {
            "url": "/stations",
            "type": "GET",
            "data": function(data) {
                data.startDate = $('#startDateId').val();
                data.endDate = $('#endDateId').val();
            }
        },
        "columns": [{
                "data": "stationName"
            },
            {
                "data": "province"
            },
            {
                "data": "date"
            },
            {
                "data": "meanTemp"
            },
            {
                "data": "highestMonthlyMaxiTemp"
            },
            {
                "data": "lowestMonthlyMinTemp"
            }
        ],
        "columnDefs": [{
            targets: [3],
            render: function(data, type, row) {
                var meanTemp = data == undefined || data == null ? "not_avail" : data;
                return '<a href="/#!/detail?stationName=' + row.stationName + '">' + meanTemp + '</a>';
            }
        }, {
            targets: 2,
            render: function(data) {
                return moment(data).format('MM/DD/YYYY');
            }
        }, {
            targets: [1, 4, 5],
            visible: false
        }]
    });

    $('#startDateId, #endDateId').change(function() {
        table.draw();
    });

});