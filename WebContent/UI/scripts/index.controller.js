var homegroupApp = angular.module('homegroupApp', []);

function fnIndexController($scope,$http) {
	
	$http.get('getAllUsers').success(function(data){
		console.log(data);	
		$scope.users = data;
	}).error(function(err){
		console.log(err);
	});
	


}
fnIndexController.$inject = ['$scope','$http'];

homegroupApp.controller('IndexController',fnIndexController);