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
<p><a href="#/!">Main</a></p>
<a href="#!detail">Detail</a>
<div ng-view></div>

</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.9/angular.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-route/1.7.9/angular-route.min.js"></script>


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
        });
    }).controller("DetailCtrl", function($scope) {
        $scope.products = [];
    }).controller("TableCtrl", function($scope) {
    	
    });
    
    
</script>

</html>