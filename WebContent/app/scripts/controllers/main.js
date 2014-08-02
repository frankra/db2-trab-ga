'use strict';

/**
 * @ngdoc function
 * @name yoAngularJsApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the yoAngularJsApp
 */
angular.module('yoAngularJsApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
