'use strict'
angular.module('demo.services', []).factory('UserService', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    service.getUserById = function(userId) {
        var url = CONSTANTS.getUserByIdUrl + userId;
        return $http.get(url);
    }
    service.getAllUsers = function() {
        return $http.get(CONSTANTS.getAllUsers);
    }
    service.saveUser = function(userDto) {
        return $http.post(CONSTANTS.saveUser, userDto);
    }
    service.deleteUser = function(id) {
    	var url = CONSTANTS.deleteUser + id
    	return $http.delete(url);
    }
    return service;
}]);