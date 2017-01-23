app.config(function($routeProvider, $httpProvider) {

	$routeProvider.when('/home', {
		templateUrl : 'home.html',
		controller : 'home',
		controllerAs: 'controller'
	}).when('/getresults', {
		templateUrl : 'Results.html',
		controller : 'resultsCtrl'		
	}).when('/login', {
		templateUrl : 'login.html',
		controller : 'navigation',
		controllerAs: 'controller'
	}).when('/suiteform', {
		templateUrl : 'suiteform.html',
		controller : 'suiteformCtrl'
		//controllerAs: 'controller'
	}).when('/suitedrag', {
		templateUrl : 'suitedrag.html',
		controller : 'suitdragCtl',
		controllerAs: 'controller'
	}).otherwise('/');

	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

});



