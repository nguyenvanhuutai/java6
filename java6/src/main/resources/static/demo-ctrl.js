let host ="http://localhost:8081/rest";
const app = angular.module("app",[]);
app.controller("ctrl",function($scope,$http){

    $scope.form={};
    $scope.items=[];
    $scope.reset= () =>{
        $scope.form = {gender:true,country:'VN'}; 
        $scope.key = null;
    };
    $scope.load_all= () =>{
         var url = `${host}/students`;
        //var url = host+'/students.json';
        $http({
            method: 'GET',
            url: url
          }).then(resp => {
            $scope.items = resp.data;
            console.log("Success",resp)
          }).catch(error=>{
            console.log("Error",error)
          });
    };
    $scope.edit= (email) =>{
        var url = `${host}/students/${email}`;
        //var url = host+'/students.json';
        $http({
            method: 'GET',
            url: url
          }).then(resp => {
            $scope.form = resp.data;
            console.log("Success",resp)
          }).catch(error=>{
            console.log("Error",error)
          });
    };
    $scope.create= () =>{
        var item = angular.copy($scope.form);
        var url = `${host}/students`;
        $http({
            method: 'post',
            url: url,
            data:item
          }).then(resp => {
            $scope.items.push(item);
            $scope.reset();   
            console.log("Success",resp)
          }).catch(error=>{
            console.log("Error",error)
          });
    };
    $scope.update= () =>{
        var item = angular.copy($scope.form);
        var url = `${host}/students/${$scope.form.email}`;
        $http({
            method: 'put',
            url: url,
            data: item
          }).then(resp => {
            var index = $scope.items.findIndex(item => item.email == $scope.form.email);
            $scope.items[index] = resp.data;
            console.log("Success",resp)
            console.log("Index",index)
          }).catch(error=>{
            console.log("Error",error)
          });
    };
    $scope.delete= (email) =>{
        var url = `${host}/students/${email}`;
        //var url = host+'/students.json';
        $http({
            method: 'delete',
            url: url
          }).then(resp => {
            var index = $scope.items.findIndex(item => item.email == $scope.form.email);
            $scope.items.splice(index,1)
            $scope.reset();
            console.log("Success",resp)
          }).catch(error=>{
            console.log("Error",error)
          });
    };


    // thực hiện
    $scope.reset();
    $scope.load_all();

})
