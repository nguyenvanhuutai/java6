let host ="http://localhost:8081/rest";
const app = angular.module("app",[]);
app.controller("ctrl",function($scope,$http){

   var url = "http://localhost:8081/rest/files/images"
   $scope.url = (filename) => {
        return `${url}/${filename}`
   } 


   $scope.list = () => {
        $http.get(url).then(resp =>{
            $scope.filenames = resp.data;
        }).catch(error =>{
            console.log("Error",error);
        })
   }
   $scope.upload = (files) => {

    var form = new FormData();
    for(var i = 0; i < files.length; i++){
        form.append("files",files[i]);
    }

    $http.post(url,form,{
        transformRequest: angular.identity,
        headers: {'Content-type':undefined}
    }).then(resp =>{
        $scope.filenames.push(...resp.data);   
    }).catch(error =>{
        console.log("Error",error);
    })  


   }

   $scope.delete = (filename) => {
        $http.delete(`${url}/${filename}`).then(resp =>{
            let i = $scope.filenames.findIndex(name => name = filename);
            $scope.filenames.splice(i,1);   
        }).catch(error =>{
            console.log("Error",error);
        })  
   }

   $scope.list();
})
