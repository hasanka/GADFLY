<!--
	*********************************************************
		Description		: Manage User
		Author			: Hasanka Chandrasekara
	*********************************************************	
-->
<!DOCTYPE html>

<html>
<head>

<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta http-equiv="x-ua-compatible" content="IE=8" />
<meta http-equiv='pragma' content='no-cache' />
<meta http-equiv='cache-control' content='no-cache' />
<meta http-equiv="expires" content="-1" />
<title>MaxAero</title>
<link rel='stylesheet' type='text/css' href='../../themes/ui.jqgrid.css'>
<link href="../../themes/cello.all.css" rel="stylesheet" type="text/css" />
</head>
</head>
<body>
	<div id="divMainPageOuter ">
		<div id="divMainPageContent" class="body-con">
			
			<div id="searchRole" role="Search User" class="basicPanel  ">
				<table style="width: 100%;">
					<tr>
						<td width="5%"><label for="User Name">User Name</label></td>
						<td width="15%"><input type="text" id="searchUserName" style="width: 50%;" /></td>
						<td width="5%"><label for="First Name">First Name</label></td>
						<td width="15%"><input type="text" id="searchFirstName" style="width: 50%;" /></td>
						<td width="5%"><label for="Status">Status</label></td>
						<td width="15%"><select id="searchStatus" name="searchStatus"> <option value="">---select---</option> <option value="ACT">Active</option> <option value="INA">In-Active</option></select></td>
						<td width="40%" align="right"><button id="btnSearch" >Search</button></td>
					</tr>
				</table>
				<div style="width: 100%;">
					<div style="width: 100%;" id="showUsers"></div>
					<div>
						<table style="width: 100%;">
							<tr>
								<td align="left">
										<button id="btnAddUser">Add New</button>
										<button id="btnEditUser">Edit</button>
							</tr>
						</table>
					</div>
				</div>

			</div>
			
			<div id="addEditUsers" role="Add/Edit Users" class="basicPanel ">
					<form id="addEditUserFrom">
						<input type="hidden" id="userID" name="userID" />

						<table class="tableLayout" style="width: 100%;" id="userInfo">
							<tr>
								<td width="12%">
									<label for="Title">Title</label>
								</td>
								<td width="18%">
									<div class="errormsg" id="v_allowSpecials_title">Invalid Characters Title</div>
									<input type="text" id="title" name="title"/>
								</td>
								<td width="12%">
									<label for="First Name">First Name</label>
									<span class="mandatory">*</span>
								</td>
								<td width="18%">
									<div class="errormsg" id="v_mandatory_firstName">First Name is Mandatory</div>
									<div class="errormsg" id="v_allowSpecials_firstName">Invalid Characters In First Name</div> 
									<input type="text" id="firstName" name="firstName" class="v_mandatory" />
								</td>

								<td width="12%">
									<label for="Last Name">Last Name</label> 
									<span class="mandatory">*</span></td>
								<td width="18%">
									<div class="errormsg" id="v_mandatory_lastName">Last Name is Mandatory</div>
									<div class="errormsg" id="v_allowSpecials_lastName">Invalid	Characters In Last Name</div> <input type="text" id="lastName"
									name="lastName" class="v_mandatory" />
								</td>
								<td width="12%">
									<label for="Status">Status</label><span class="mandatory">*</span>
								</td>
								<td width="18%">
									<div class="errormsg" id="v_mandatory_status">Status is Mandatory</div>
									 <select id="status" name="status" class="v_mandatory">
										<option value="ACT">Active</option>
										<option value="INA">In-Active</option>
									</select>
								</td>
							</tr>
							<tr>
								<td width="12%"><label for="Email Address">Email
										Address</label> <span class="mandatory">*</span>
								</td>
								<td width="18%">
									<div class="errormsg" id="v_mandatory_email">Email is Mandatory</div>
									<div class="errormsg" id="v_Email_email">Invalid Email Address</div> 
									<input type="text" id="email" name="email" class="v_mandatory v_Email" />
								</td>
								<td width="12%"><label for="Roles">Role</label><span class="mandatory">*</span>
								</td>
								<td width="18%">
									<div class="errormsg" id="v_mandatory_role">Role is Mandatory</div>
									 <select id="role" name="role" class="v_mandatory">
									 		<option value="Role One">Role One</option>
									 		<option value="Role Two">Role Two</option>
									 </select>
								</td>
								<td width="12%"><label for="PhoneNi">Phone No</label></td>
								<td width="18%">
								<div class="errormsg"id="v_numericOnly_phoneNo">Invalid number format</div>
									<div class="errormsg" id="v_noDecimals_phoneNo">Invalid number format</div>
									<input type="text" id="phoneNo" name="phoneNo" maxlength="15" class="v_numericOnly v_noDecimals" />
								</td>
								<td width="12%"></td>
								<td width="18%">
									
								</td>
							</tr>
							<tr>
								<td width="12%"><label for="User Name">User Name 
										</label> <span class="mandatory">*</span></td>
								<td width="18%">
									<div class="errormsg" id="v_mandatory_userName">User Name is Mandatory</div>
									<input type="text" id="userName" name="userName" class="v_mandatory" />
								</td>
								<td width="12%"><label for="Password">Password</label><span class="mandatory">*</span></td>
								<td width="18%">
									<div class="errormsg" id="v_mandatory_password">Password is Mandatory</div> 
									<input type="password" id="password" name="password" class="v_mandatory" />
								</td>
								<td width="12%"><label for="PhoneNi">Confirm Password</label><span class="mandatory">*</span></td>
								<td width="18%">
									<div class="errormsg" id="v_mandatory_passwordConfirm">Password MisMatch</div>
									<input type="password" id="passwordConfirm" name="passwordConfirm" class="v_mandatory" />
								</td>
								<td width="12%">
									<input type="hidden" id="hdnUserId">
								</td>
								<td width="18%" align="right">
									
									
								</td>
							</tr>
							<tr>
								<td width="12%"></td>
								<td width="18%"></td>
								<td width="12%"></td>
								<td width="18%"></td>
								<td width="12%"></td>
								<td width="18%"></td>
								<td width="12%"></td>
								<td width="18%" align="right"></td>
							</tr>
						</table>
						<table style="width: 100%;">
							<tr>
								<td align="right"><button id="clear">Clear </button>
									<button id="save">Save </button>
								</td>
							</tr>
						</table>
					</form>
			</div>
		</div>
	</div>
	<!-- common javascript libs   -->
	<script type="text/javascript" src="../../javascript/jquery/jquery.js"></script>
	<script type="text/javascript" src="../../javascript/jquery/jquery.ui.js"></script>
	<script type="text/javascript" src="../../javascript/dglibs/dg.jquery.decorator.js"></script>
	<script type="text/javascript" src="../../javascript/dglibs/dg.browsers.js"></script>
	<script type="text/javascript" src="../../javascript/dglibs/dg.statusbar.js"></script>
	<script type="text/javascript" src="../../javascript/jquery/jNotify.jquery.js"></script>
	<script type="text/javascript" src="../../javascript/dglibs/dg.common.js"></script>
	<script type="text/javascript" src="../../javascript/jquery/i18n/grid.locale-en.js"></script>
	<script type="text/javascript" src="../../javascript/jquery/jquery.jqGrid.min.js"></script>
	<script type="text/javascript" src="../../javascript/dglibs/dg.jquery.validator.js"></script>
	<!-- page specific javascript logic  -->
	<script type="text/javascript" src="../../private/user/js/user.js"></script> 
</body>
</html>
