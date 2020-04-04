<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="trainStation" >

<head>
    <meta charset="UTF-8">
    <title>Landing Page</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
</head>

<body >
<p><a href="#/!">Main</a></p>
<a href="#!detail">Detail</a>
<div ng-view></div>

</body>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/angular-datatables/2.1.0/angular-datatables.js"></script>

<script type="text/javascript">
    var app = angular.module("trainStation", ["ngRoute"]);
    app.config(function($routeProvider) {
        $routeProvider
        .when("/", {
            templateUrl : "/tablePage",
            controller:"TableCtrl"
        })
        .when("/detail", {
            templateUrl : "/detailPage",
            controller:"DetailCtrl"
        });
    });
    app.controller("DetailCtrl", function($scope) {
        $scope.products = ["Milk", "Bread", "Cheese"];
    });
    app.controller("TableCtrl", function(DTOptionsBuilder, DTColumnBuilder) {
    	
    });
    
    
</script>

</html>