var app=angular.module('automation', [ 'ngRoute']);

app.service('shareDataService', function() {
	  var myList = [];
	  var addList = function(newObj) {
		  myList=null;
		  myList=[];
	      myList.push(newObj);
	  }

	  var getList = function(){
	      return myList;
	  }
      var makeNullList = function(){
	        myList =null;
	     

	  }
	  return {
	    addList: addList,
	    getList: getList
		
	  };

	});