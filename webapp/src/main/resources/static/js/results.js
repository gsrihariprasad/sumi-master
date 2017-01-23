
app.filter("resultstatus" ,function(){
	
	return function(resultstatus){
	   
             switch(resultstatus){
				case 1:
				      return "SuccessFully Completed";
				case 2:
                      return "Failed TEST Case" 				
				default:
                       return " Skipped TEST Failed Test"				
			 }	   
		
	}	
	
}).controller('resultsCtrl', function($scope,$filter, $http) {
   $http.get("results").then(function (response) {
        $scope.results = response.data;
    });
	
	
});
