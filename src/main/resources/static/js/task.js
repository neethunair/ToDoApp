var app = angular.module("todoApp", []);
app.controller("TodoListController", function ($scope, $http) {
	
	/*angular.element(document).ready(function () {
		$http.get("/pendingTasks").then(function (response) {
	        var resList = response.data.records;
	    });
	});*/
	
	
	$scope.data = {};
	
	var todoList = this;
	todoList.todos = [];
   
    $scope.AddTask = function () {
      
    	$scope.data = $.param({
    		taskName : $scope.taskName
    	});
    
        var config = {
            headers : {
               'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
            }
        }

        $http.post('/addTask', $scope.data, config)
        .then(function (response, status, headers, config) {
        	var data = response.data;
        	todoList.todos.push({text:data.name,taskId:data.id, done:false });
           
        })
        .catch(function (data, status, header, config) {
          //to do
        });
    };

    
    todoList.remaining = function() {
        var count = 0;
        angular.forEach(todoList.todos, function(todo) {
          count += todo.done ? 0 : 1;
        });
        return count;
      };
      
      $scope.DeleteTask = function () {
    	  $scope.data = $.param({
      		taskId : this.todo.taskId
      	});
    	
    	  var config = {
    	            headers : {
    	               'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
    	            }
    	   }
    	  
    	  $http.post('/deleteTask', $scope.data, config)
          .then(function (response, status, headers, config) {
          	var data = response.data;
          
          })
          .catch(function (data, status, header, config) {
            //to do
          });
      };
      
      
      $scope.DoneTask = function () {
    	  $scope.data = $.param({
      		taskId : this.todo.taskId
      	});
    	 
    	  var config = {
    	            headers : {
    	               'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
    	            }
    	   }
    	  
    	  $http.post('/doneTask', $scope.data, config)
          .then(function (response, status, headers, config) {
          	var data = response.data;
          	
          })
          .catch(function (data, status, header, config) {
            //to do
          });
      };
      
      
      $scope.showAllTasks = function () {
    	  $http.get("/pendingTasks").then(function (response) {
  	       // var resList = response.data;
  	    });
      }
});