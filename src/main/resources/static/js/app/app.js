'use strict'
var demoApp = angular.module('demo', ['ui.bootstrap', 'demo.controllers',
    'demo.services'
]);
demoApp.constant("CONSTANTS", {
    getUserByIdUrl: "/users/",
    getAllUsers: "/users",
    saveUser: "/users",
    deleteUser: "/users/"
});