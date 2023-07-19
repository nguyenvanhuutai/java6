var app  = angular.module("app",[]);
app.controller("ctrl", function($scope, $http) {
    $scope.import = (files) => {
      var confirmImport = confirm("Bạn có muốn import file Excel?");
      if (confirmImport) {
        var reader = new FileReader();
        reader.onloadend = async () => {
          var workbook = new ExcelJS.Workbook();
          await workbook.xlsx.load(reader.result);
          const worksheet = workbook.getWorksheet("data");
          if (!worksheet) {
            alert("Tên worksheet không đúng. Vui lòng sửa lại tên worksheet.");
            return;
          }

         
          worksheet.eachRow((row, index) => {
            if (index > 1) {
              let student = {
                email: row.getCell(1).value,
                fullname: row.getCell(2).value,
                marks: +row.getCell(3).value,
                gender: true && row.getCell(4).value,
                country: row.getCell(5).value
              };
  
              let url = "http://localhost:8081/rest/students";
              $http.post(url, student)
                .then(resp => {
                  console.log("Success", resp.data);
                })
                .catch(error => {
                  console.log("Error", error);
                });
            }
          });
        };
  
        reader.readAsArrayBuffer(files[0]);
      }
    };
  });
  