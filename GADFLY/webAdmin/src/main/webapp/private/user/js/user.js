/*******************************************************************************
 * Description : Manage User Author : Hasanka Chandrasekara
 ******************************************************************************/

function UI_ManageUser() {
	this.gridHTML = $("<table id='userGrid'></table>");
	this.gridPagerHTML = $("<div id='userGridPager'></div>");
	this.userGrid = null;
	this.ready = function() {
		initializedUI();
		parent.UI_HomePage.hideProgress();
	};
	
	initializedUI = function() {
		$("input[type=submit], a, button").button().click(function(event) {
			event.preventDefault();
		});
		$("#btnSearch").on("click", searchBtnClick);
		$("#btnAddUser").on("click",addNewClick);
		$("#btnEditUser").on("click",editButtonClick);
		$(".basicPanel").decoratePanel();
		changeFieldsStatus(true);
		initButtons();
		searchUsers();
	};
	
	searchUsers = function() {
		constarctGrid();
		UI_ManageUser.userGrid = $("#userGrid").jqGrid(
				{
					datatype : "json",
					height : 230,
					autowidth : true,
					colNames : [  'userId','Title','First Name','Last Name','User Name','Email','Phone Number','Role', 'Status','password' ],
					colModel : [ 
					             {name :'userId', hidden : true}, 
					             {name :'title',index : 'title',width : "10%",align : "center",sortable:true},
					             {name :'firstName',index : 'firstName',width : "10%",align : "center",sortable:true},
					             {name :'lastName',index : 'lastName',width : "10%",align : "center",sortable:true},
					             {name :'userName',index : 'userName',width : "15%",align : "center",sortable:true},
					             {name :'email',index : 'email',width : "15%",align : "center",sortable:true},
					             {name :'phoneNumber',index : 'phoneNumber',width : "10%",align : "center",sortable:true},
					             {name :'role',index : 'role',width : "10%",align : "center",sortable:true},
					             {name :'status',index : 'status',width : "10%",align : "center",sortable:true}	,
					             {name :'password', hidden : true}, 
					          ],
					imgpath : "",
					pager : jQuery('#userGridPager'),
					viewrecords : true,
					loadonce:true,
					rowNum : 10,
					jsonReader : {
						root : "userList",
						page : "page",
						total : "total",
						records : "records",
						repeatitems : false,
						id : "0"
					},
					onSelectRow : function(rowid) {
						var rowData = $("#userGrid").getRowData(rowid);
						gridRowClick(rowData);
					},
					loadComplete : function (data) {
						$("#userGrid").setGridParam({datatype:"local"});
					}
				});

	};
	
	constarctGrid = function() {
		$("#showUsers").empty()
		$("#showUsers").append(UI_ManageUser.gridHTML.clone(),UI_ManageUser.gridPagerHTML.clone());
	};
	
	searchBtnClick = function() {
		clearFields();
		initButtons();
		clearGrid();
		changeFieldsStatus(true);
		data = {"userName":function(){return $("#searchUserName").val();},
				"firstName":function(){ return $("#searchFirstName").val();},
				"status":function(){return $("#searchStatus").val();}
		};
		$("#userGrid").setGridParam({datatype:"json",url:"searchUsers",page:0,postData:data});
		$("#userGrid").trigger("reloadGrid");
	};
	
	changeFieldsStatus = function(status){
		if(status){
			$("#title").attr("disabled", "disabled"); 
			$("#firstName").attr("disabled", "disabled"); 
			$("#lastName").attr("disabled", "disabled"); 
			$("#status").attr("disabled", "disabled"); 
			$("#email").attr("disabled", "disabled"); 
			$("#role").attr("disabled", "disabled"); 
			$("#phoneNo").attr("disabled", "disabled"); 
			$("#userName").attr("disabled", "disabled"); 
			$("#password").attr("disabled", "disabled"); 
		}else{
			$("#title").removeAttr("disabled"); 
			$("#firstName").removeAttr("disabled"); 
			$("#lastName").removeAttr("disabled"); 
			$("#status").removeAttr("disabled"); 
			$("#email").removeAttr("disabled");
			$("#role").removeAttr("disabled");
			$("#phoneNo").removeAttr("disabled");
			$("#userName").removeAttr("disabled");
			$("#password").removeAttr("disabled");
		}
	};
	
	initButtons = function () {
		$("#btnEditUser").attr("disabled", "disabled"); 
		$("#save").attr("disabled", "disabled"); 
	};

	clearFields = function () {
		$("#title").val(""); 
		$("#firstName").val(""); 
		$("#lastName").val(""); 
		$("#status").val(""); 
		$("#email").val(""); 
		$("#role").val(""); 
		$("#phoneNo").val(""); 
		$("#userName").val(""); 
		$("#password").val(""); 
		$("#passwordConfirm").val(""); 
		$("#hdnUserId").val("")
	};
	
	gridRowClick = function (rowData) {
		$("#title").val(rowData.title); 
		$("#firstName").val(rowData.firstName); 
		$("#lastName").val(rowData.lastName); 
		$("#status").val(rowData.status); 
		$("#email").val(rowData.email); 
		$("#role").val(rowData.role); 
		$("#phoneNo").val(rowData.phoneNumber); 
		$("#userName").val(rowData.userName); 
		$("#password").val(rowData.password); 
		$("#passwordConfirm").val(rowData.password); 
		$("#hdnUserId").val(rowData.userId);
		$("#btnEditUser").removeAttr("disabled");
	};
	
	clearGrid =  function () {
		$("#userGrid").clearGridData();
	};
	
	addNewClick = function () {
		clearFields();
		changeFieldsStatus(false);
		$("#save").removeAttr("disabled");
		$("#btnEditUser").attr("disabled", "disabled"); 
	};
	
	editButtonClick = function () {
		changeFieldsStatus(false);
		$("#save").removeAttr("disabled");
	};
	
	saveButtonClick = function() {
		
	};
	
	
}
parent.UI_HomePage.showProgress();
var UI_ManageUser = new UI_ManageUser();
UI_ManageUser.ready();