<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="trainStation" >

<head>
    <meta charset="UTF-8">
    <title>Landing Page</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
</head>

<body >
<header>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Train Station</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#!">Home <span class="sr-only">(current)</span></a>
      </li>
    </ul>

  </div>
</nav>
</header>

<div class="container" ng-view></div>

</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.9/angular.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-route/1.7.9/angular-route.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script src="https://cdn.datatables.net/plug-ins/1.10.20/filtering/row-based/range_dates.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script type="text/javascript">
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
    	self.read = function(){
    		 /* $http.get("/read").then(function(response){
    			 response.data.data;
    		 }); */
    	}
    	
    });
    
    
</script>

</html>