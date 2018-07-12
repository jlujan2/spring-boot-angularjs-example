'use strict'
var module = angular.module('login',['ngRoute']);

/*module.config(['$routeProvider', function($routeProvider){
	
	$routeProvider
		.when('/home', {
			templateUrl: 'home',
			controller: 'UserController'
		})
		.when('/page', {
			templateUrl: 'page.html'
		})
		.when('/login', {
			templateUrl: 'login.html'
		})
		.otherwise({
			redirectTo: '/login'
		})
		
}]);*/


module.controller("LoginController",
	function($scope, $location) {
	$scope.user = {
		name:null,
		password:null
	};
	
	$scope.login = function() {
		
		if($scope.user.name == 'admin' && $scope.user.password == 'admin') {
			console.log("in login");
			$location.path('/home');
		}
		
	}
});