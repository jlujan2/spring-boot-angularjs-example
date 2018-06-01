'use strict'
var module = angular.module('demo.controllers', []);
module.controller("UserController", ["$scope", "UserService",
    function($scope, UserService) {
        $scope.user = {
            userId: null,
            userName: null,
            userLastName: null 
        };
        UserService.getUserById(1).then(function(value) {
            console.log(value.data);
        }, function(reason) {
            console.log("error occured");
        }, function(value) {
            console.log("no callback");
        });
        $scope.saveUser = function() {
        	console.log($scope.user);
            UserService.saveUser($scope.user).then(function() {
                console.log("works");
                UserService.getAllUsers().then(function(value) {
                    $scope.allUsers = value.data;
                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });
                $scope.user = {
                    userId: null,
                    userName: null,
                    userLastName: null
                };
            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });
        }
        $scope.deleteUser = function(id) {
        	UserService.deleteUser(id).then(function() {
                console.log("works");
                UserService.getAllUsers().then(function(value) {
                    $scope.allUsers = value.data;
                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });
        	}, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });
        	console.log(id);
        }
    }
]);