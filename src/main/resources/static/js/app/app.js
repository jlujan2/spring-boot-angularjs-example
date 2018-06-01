'use strict'
var demoApp = angular.module('demo', ['ui.bootstrap', 'demo.controllers',
    'demo.services'
]);
demoApp.constant("CONSTANTS", {
    getUserByIdUrl: "/users/{id}",
    getAllUsers: "/users",
    saveUser: "/users"
});