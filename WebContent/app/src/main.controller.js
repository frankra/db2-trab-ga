'use strict';

/**
 * @ngdoc function
 * @name yoAngularJsApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the yoAngularJsApp
 */
var mainController = angular.module('HomegroupApp', []);

    mainController.controller('MainController', function ($scope) {
    	console.log('a');
	    $scope.users = [
		                    {'name':'test1'},
		                    {'name':'test2'}
	                    
	                    ];
    });
