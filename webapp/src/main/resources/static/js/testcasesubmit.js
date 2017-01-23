app.controller('testcasesubmiCtrl', function($scope, $filter, $http,shareDataService) {
	$scope.groupName="";
	$scope.welcome = {};
	$scope.resdata = {};
	$scope.testForm = {};
	$scope.testForm.testCaseFormInputData = [];
	$scope.inputName = "inputnama";
	$scope.inputdata = "inputdata";
	$scope.thinkworks = msg;
$scope.executedaytime="";
	// $scope.thinkworks= shareDataService.getList();	 
	
	 $scope.reqdatasend=[];
	
	$scope.onSubmit = function() {
		$http.get("testForm").success(
				function(response) {
					 console.log(response);
					$scope.resdata = response;
				}).error(function(response) {
			
		}

		)
	}

	/* *************start method  *****************  */
	 $scope.submit = function(groupname,executedaytime){		
		 
		 $scope.reqdatasend=$scope.reqdata;		
		 var reqsend= JSON.stringify($scope.reqdatasend);
		$scope.reqsend12={"testcasesbindings" : JSON.parse(reqsend),"groupName":groupname,"executedaytime":$scope.executedaytime};

		var mystst=JSON.stringify($scope.reqsend12);
		 var reqsendinitial= JSON.parse(mystst);      
	  
		 $http.post("testcasesubmitrequest",
					mystst).success(function(response) {				
				$scope.resdata = response;
			}).error(function(response) {				
			})
	 }
	/********************post end****************************************/
	 
	 
	$scope.myVar = "";
	$scope.names=msg;

	
	$scope.reqdata=[];
	
	$scope.addID = function (pagename,myVar){		
		for(var i=0;i<=2;i++){
		
		 if( myVar==true && $scope.names[i].pageName==pagename ){	 
		
		$scope.reqdata.push($scope.names[i]);	
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
		loop1: for(var i=0; i<=10;i++){
		
		loop2: for(k in $scope.reqdata[i].pageInputs){
			
            $scope.reqdata[i].pageInputs[k];
		if(k==key){
			
			$scope.reqdata[i].pageInputs[k]=element;
			console.log($scope.reqdata[i].pageInputs[k]);
			break loop1;
		}
		
	}}
			
		 
	}
	
	
	 /*   ****** END THIS METHOD ********** */
	
});
