    var app = angular.module("trainStation", ["ngRoute"]).config(function($routeProvider) {
        $routeProvider
        .when("/", {
            templateUrl : "/tablePage",
            controller:"TableCtrl"
        })
        .when("/detail", {
            templateUrl : "/detailPage",
            controller:"DetailCtrl"
        }).otherwise({
            templateUrl : "/tablePage",
            controller:"TableCtrl"
        });
    }).controller("DetailCtrl", function($scope,$routeParams,$http) {
    	var self = this;
    	self.stationName = $routeParams.stationName;
    	self.stations = [];
    	self.load = function(){
    		 $http.get("/trainStationDetail?stationName="+self.stationName).then(function(response){
    			 self.stations = response.data.data;
    		 });
    	}
    	
    }).controller("TableCtrl", function($scope,$http) {
    	var self = this;
    	self.clear = function(){
    		$('#min').val("");
    		$('#max').val("");
    		$("#max").trigger("change");
    	}
    });
    
    