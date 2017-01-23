
document.addEventListener("dragstart", function(event) {  
    event.dataTransfer.setData("Text", event.target.id);    
   
    document.getElementById("demo").innerHTML = "";   
   
    event.target.style.opacity = "0.4";
});
document.addEventListener("drag", function(event) {
    document.getElementById("demo").style.color = "red";
});

document.addEventListener("dragend", function(event) {
    document.getElementById("demo").innerHTML = "";
    event.target.style.opacity = "1";
});

document.addEventListener("dragenter", function(event) {
    if ( event.target.className == "droptarget" ) {
        event.target.style.border = "3px dotted red";
    }
});

document.addEventListener("dragover", function(event) {
    event.preventDefault();
});

document.addEventListener("dragleave", function(event) {
    if ( event.target.className == "droptarget" ) {
        event.target.style.border = "";
    }
});

document.addEventListener("drop", function(event) {
    event.preventDefault();
    if ( event.target.className == "droptarget" ) {
        document.getElementById("demo").style.color = "";
        event.target.style.border = "";
        var data = event.dataTransfer.getData("Text");
        event.target.appendChild(document.getElementById(data));
    }
});
  app.controller('suitdragCtl', function($scope, $filter, $http,$location,shareDataService) {
	  $scope.resdata = [];
	$http.get("testForm").success(
				function(response) {
					 console.log(response);
					$scope.resdata = response;
				}).error(function(response) {
			 console.log(response);
		});
		
    $scope.submit=function(){
		$scope.newresdata=[];
	var xy=document.getElementById("droppedData");
	var y=xy.getElementsByClassName("Column ng-binding");
	 var i;
	 var j=0;
	 for (i = 0; i < y.length; i++) {     
		
		angular.forEach($scope.resdata, function(value, key) {
			if(y[i].innerHTML===value.pageName){			
			$scope.newresdata[j]=value;
			j=j+1;			
			}else{
				//alert(key + ':else ' + value.pageName);
			}
        });
    }
	 console.log($scope.newresdata[0]+"");
	
/**angular.forEach($scope.newresdata, function(value, key) {
	 console.log("final request: "+JSON.stringify($scope.newresdata));
});
**/
$http.post("testcasesubmitreq",
				JSON.stringify($scope.newresdata)).success(function(response) {			
			$scope.resdata = response;
			//shareDataService.makeNullList();
			  shareDataService.addList($scope.resdata);
			$location.url('/suiteform');
		}).error(function(response) {
			 console.log(response);
		}
	)};
	
	

});