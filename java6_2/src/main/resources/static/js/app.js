const app = angular.module("app",[]);
app.controller("ctrl",function($scope,$http){

  $http.get("/rest/employeeRole").then(resp =>{
    $scope.db = resp.data;
    console.log(resp.data)
  })

  $scope.index_of = function (username,role){
        console.log(username)
        console.log(role)
    return $scope.db.authorities.findIndex(a => a.employee.username == username && a.role.id == role)
  }

  $scope.update = (username,role) =>{
    console.log(username)
    console.log(role)
    var index = $scope.index_of(username,role);
    if(index >= 0){
      var id = $scope.db.authorities[index].id;
      alert(id)

      $http.delete(`/rest/employeeRole/${id}`).then(resp =>{
        $scope.db.authorities.splice(index,1);
      })
    }else{
      var authority = {
        employee:{username: username},
        role:{id:role}
      };
      $http.post('/rest/employeeRole',authority).then(resp =>{
        $scope.db.authorities.push(resp.data);
      });
    }

  }

    
})
