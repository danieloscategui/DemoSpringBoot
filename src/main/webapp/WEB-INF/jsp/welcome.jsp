<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title id="Description">Data Binding to JSON data in jqxDataTable</title>
    <meta name="description" content="This sample demonstrates how we can bind jQWidgets DataTable widget to JSON Data by using jQWidgets DataAdapter plugin.">
    <link rel="stylesheet" href="jqwidgets/styles/jqx.base.css" type="text/css" />
    <link rel="stylesheet" href="jqwidgets/styles/jqx.ui-redmond.css" type="text/css" />
    <link rel="stylesheet" href="jqwidgets/styles/jqx.arctic.css" type="text/css" />
    <link rel="stylesheet" href="jqwidgets/styles/jqx.energyblue.css" type="text/css" />
    <link rel="stylesheet" href="jqwidgets/styles/jqx.glacier.css" type="text/css" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1 minimum-scale=1" />	
    <script type="text/javascript" src="scripts/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxcore.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxbuttons.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxscrollbar.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxdata.js"></script> 
    <script type="text/javascript" src="jqwidgets/jqxdatatable.js"></script> 
    <script type="text/javascript" src="scripts/demos.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
        	$.jqx.theme = 'glacier';
            //var url = "sampledata/beverages.txt";
            // prepare the data
            var source =
            {
                dataType: "json",
                dataFields: [
                    { name: 'fullName', type: 'string' },
                    { name: 'email', type: 'string' },
                    { name: 'phoneNumber', type: 'string' },
                    { name: 'hireDate', type: 'string' }
                ],
                id: 'id',
                url: 'employee/api'
            };

            var dataAdapter = new $.jqx.dataAdapter(source);

            $("#dataTable").jqxDataTable(
            {
                width: getWidth("dataTable"),
                pageable: true,
                pagerButtonsCount: 10,
                source: dataAdapter,
                columnsResize: true,
                columns: [
                  { text: 'Full Name', dataField: 'fullName', width: 250 },
                  { text: 'Email', dataField: 'email', width: 180 },
                  { text: 'Phone Number', dataField: 'phoneNumber', width: 120 },
                  { text: 'Hire Date', dataField: 'hireDate' }
              ]
            });
        });
    </script>
</head>
<body class='default'>
	 <p>Employee List</p>
     <div id="dataTable"></div>
</body>
</html>
