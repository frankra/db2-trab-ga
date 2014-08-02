'use strict';

/**
 * @ngdoc function
 * @name yoAngularJsApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the yoAngularJsApp
 */
angular.module('yoAngularJsApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
