let host ="https://poly-java-6-66445-default-rtdb.firebaseio.com/";
const app = angular.module("app",[]);
app.controller("ctrl",function($scope,$http){

    $scope.form={};
    $scope.items={};
    $scope.reset= function(){
        $scope.form = {gender:true,country:'VN'}; 
        $scope.key = null;
    };
    $scope.load_all= function(){
         var url = `${host}/students.json`;
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
    $scope.edit= function(key){
        var url = `${host}/students/${key}.json`;
        //var url = host+'/students.json';
        $http({
            method: 'GET',
            url: url
          }).then(resp => {
            $scope.form = resp.data;
            $scope.key = key;
            console.log("Success",resp)
          }).catch(error=>{
            console.log("Error",error)
          });
    };
    $scope.create= function(){
        var item = angular.copy($scope.form);
        var url = `${host}/students.json`;
        $http({
            method: 'post',
            url: url,
            data:item
          }).then(resp => {
            $scope.key = resp.data.name; // chưa đối tượng name => key
            $scope.items[$scope.key] = item;
            $scope.reset();   
            console.log("Success",resp)
          }).catch(error=>{
            console.log("Error",error)
          });
    };
    $scope.update= function(){
        var item = angular.copy($scope.form);
        var url = `${host}/students/${$scope.key}.json`;
        //var url = host+'/students.json';
        $http({
            method: 'put',
            url: url,
            data: item
          }).then(resp => {
            $scope.items[$scope.key] = resp.data;
            console.log("Success",resp)
          }).catch(error=>{
            console.log("Error",error)
          });
    };
    $scope.delete= function(key){
        var url = `${host}/students/${key}.json`;
        //var url = host+'/students.json';
        $http({
            method: 'delete',
            url: url
          }).then(resp => {
            delete $scope.items[key];
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
