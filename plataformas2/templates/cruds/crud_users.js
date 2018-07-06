$(function(){
    var url = "/users";


    $("#grid").dxDataGrid({
        dataSource: DevExpress.data.AspNet.createStore({
            key: "id",
            loadUrl: url ,
            insertUrl: url ,
            updateUrl: url ,
            deleteUrl: url ,
            onBeforeSend: function(method, ajaxOptions) {
                ajaxOptions.xhrFields = { withCredentials: true };
            }
        }),
        editing: {
            allowUpdating: true,
            allowDeleting: true,
            allowAdding: true
        },
        remoteOperations: {
            sorting: true,
            paging: true
        },
        paging: {
            pageSize: 12
        },
        pager: {
            showPageSizeSelector: true,
            allowedPageSizes: [8, 12, 20]
        },
        columns: [{
            dataField: "id",
            dataType: "number",
            allowEditing: false
        }, {
            dataField: "position"
        }, {
            dataField: "username"
        }, {
            dataField: "password"
        }, {
            dataField: "email"
        }, {
            dataField: "question"
        }, {
            dataField: "answer"
        }, {
            dataField: "datetime",
            allowEditing: false
        }, {
            dataField: "joined",
            allowEditing: false
        }, {
            dataField: "votes",
            allowEditing: false
        }, ],
    }).dxDataGrid("instance");
});