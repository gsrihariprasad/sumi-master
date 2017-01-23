app.controller('suiteformCtrl', function($scope, $filter, $http,shareDataService) {
	$scope.groupName="";
	$scope.welcome = {};
	$scope.resdata = {};
	$scope.testForm = {};
	$scope.testForm.testCaseFormInputData = [];
	$scope.inputName = "inputnama";
	$scope.inputdata = "inputdata";
	$scope.environment=[];
	$scope.urls=[];
	$scope.env=[];
	$scope.driverPath=[];
	//$scope.thinkworks = msg;
    $scope.executedaytime="";
	 $scope.thinkworks= shareDataService.getList();
	console.log( $scope.thinkworks);
	console.log(JSON.stringify($scope.thinkworks));
	 $scope.reqdatasend=[];
	$http.get("getEnvironment").success(
				function(response) {					
					$scope.environment = response;			
					
					angular.forEach($scope.environment, function(value, key) {						
						angular.forEach(value, function(value1, key1) {						
						if(key1=="url"){							
							$scope.urls.push(
								value1
						)
						}
						if(key1=="environment"){							
							$scope.env.push(
								value1
						)
						}
                        
                  });
   
                  });
                  console.log(JSON.stringify($scope.urls));
				}).error(function(response) {
			 console.log(response);
		});
	$scope.onSubmit = function() {

		$http.get("testForm").success(
				function(response) {
					 console.log(response);
					$scope.resdata = response;
				}).error(function(response) {
			 console.log(response);
		}

		)
	}

	/* *************start method  *****************  */
	 $scope.submit = function(groupname,executedaytime,driverPath){
		
		 $scope.reqdatasend=$scope.reqdata;	
	
	
		 var reqsend= JSON.stringify($scope.reqdatasend);
		$scope.reqsend12={"testcasesbindings" : JSON.parse(reqsend),"groupName":groupname,"executedaytime":$scope.executedaytime,"driverPath":driverPath};

		var mystst=JSON.stringify($scope.reqsend12);
		 var reqsendinitial= JSON.parse(mystst);
	       
	   
	
		 $http.post("suiteformsubit",
					mystst).success(function(response) {
				
				$scope.resdata = response;
			}).error(function(response) {
				 console.log(response);
			})
	 }
	/********************post end****************************************/
	 
	 
	$scope.myVar = "";
	$scope.names=$scope.thinkworks;

	
	$scope.reqdata=[];
	
	$scope.addID = function (pagename,myVar){		
		 $scope.finalnames=$scope.names[0];
		for(var i=0;i<=$scope.finalnames.length-1;i++){
		
		 if( myVar==true && $scope.finalnames[i].pageName==pagename ){		 		
		$scope.reqdata.push($scope.finalnames[i]);
		
			}  
			
		
		
	}}
	$scope.onblur_check_groupname = function() {
		
$http.get('validation/{'+$scope.groupName+'}/').success(function(data) {
   if(data)
    document.getElementById("gname").innerHTML =" group name already  exist :"+ data;
   else
	    document.getElementById("gname").innerHTML ="";
   return false;
});
		//var gname=$scope.groupName;
		
	}
	
	  /* ************ SAVE METHOD **************   */
	
	$scope.onsave = function() {		
		$scope.testForm.testCaseFormInputData.push({
			"inputName" : $scope.inputName,
			"inputdata" : $scope.inputdata
		});

		$http.post("saveAndRunTestcases/saveTestCases",
				JSON.stringify($scope.testForm)).success(function(response) {
			 console.log(response);
			$scope.resdata = response;
		}).error(function(response) {
			 console.log(response);
		}

		)
	}
	  /* ************ END SAVE METHOD **************   */
	
	
	/*  *********start MEthod  **************  */
	$scope.onblurchangevalue = function (key,value,$index,objectvalues){		
		
		var element = document.getElementById(value).value;
		loop1: for(var i=0; i<=20;i++){
		
		loop2: for(k in $scope.reqdata[i].pageInputs){
			 $scope.reqdata[i].pageInputs[k];
		if(k==key){			
			$scope.reqdata[i].pageInputs[k]=element;			
			break loop1;
		}
		
	}}		
		 
	}
	
	
	 /*   ****** END THIS METHOD ********** */
	
});
