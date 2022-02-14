$(document).ready(function () {

    var table = $('#modelTable')
        .DataTable({
            "ordering": true,
            "searching": false,
            "paging": false,
            "processing": false,
            "sAjaxSource": "/cars",
            "sAjaxDataProp": "",
            "order": [[0, "asc"]],
            "datatype": 'json',
            "aoColumns": [
                {"mData": "id"},
                {"mData": "modelName"},
                {"mData": "modelType"},
                {"mData": "modelLine"},
                {"mData": "from"},
                {"mData": "to"},
                {"mData": "engineType"},
                {"mData": "enginePower"},
                {"mData": "wheelsType"},
                {"mData": "wheelsSize"},
            ],
        })


    var $table = $('#modelTable')
    $('#submitBtn').click(function (){

        var $inputValue = $("#carSearchInput").val();
        console.log($inputValue)
        $.ajax({
            url:"http://localhost:8080/cars/"+$inputValue+"/model",
        }).then ( function( json, textStatus, jqXHR ) {
            console.log(json)
            $table.bootstrapTable("destroy").bootstrapTable({data: json})

        });

    })
});






