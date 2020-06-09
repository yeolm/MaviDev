
var app = angular.module('maviDev', []);

app.controller("myCtrl",function($scope,$http){
	$scope.newEntryHide = true;
	$scope.entriesHide = true;
	$scope.pageIndex = 0;
	$scope.acceptEntry = function(){			
		let region = 
		{
			"city":$scope.Il,
			"district":$scope.Ilce,
			"plaka":$scope.Plaka
		};
		$http.post("/saveRegion", region).then(function(response) {
			if (response.status != 200)
				alert("Duplicate or invalid region");
			
			$scope.newEntryHide = true;
			$scope.entriesHide = false;
			$http.get("/getRegions").then(function(responses) {
				$scope.regions = responses.data[0].content;
			});
		});
	}
	$scope.forward = function() {
		if ($scope.pageIndex < 2 )
			$scope.pageIndex++;
	}
	$scope.backward = function() {
		if ($scope.pageIndex > 0)
			$scope.pageIndex--;
	}
	$scope.$watch("pageIndex",function(news,old) {
		if ($scope.pageIndex == 2) {
			$scope.welcomeHide = true;
			$scope.newEntryHide = true;
			$scope.entriesHide = false;
			$scope.acceptEntry();
		}
		else if ($scope.pageIndex == 1) {
			$scope.welcomeHide = true;
			$scope.newEntryHide = false;
			$scope.entriesHide = true;
		}
		else {
			$scope.welcomeHide = false;
			$scope.newEntryHide = true;
			$scope.entriesHide = true;			
		}	
	});

})
