<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>部门列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="save"><a href="#" onclick="formSubmit('save','_self');this.blur();">保存</a></li>
	<li id="back"><a href="#" onclick="window.history.go(-1)">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    员工新增
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<tr class="odd">
		<td>用户名:</td>
		<td><input type="text" name="username"></td>
		<td>密码</td>
		<td><input type="password" name="password"></td>	
	</tr>
	<tr class="odd">
		<td>所属部门:</td>
		<td>
			<select name="dept.deptId" style="width:200px;">
				<option value="0">---请选择部门---</option>
				<c:forEach items="${deptList}" var="d">
					<option value="${d.deptId}">${d.deptName}</option>
				</c:forEach>
			</select>
		</td>
		<td>上级领导:</td>
		<td>
			<select name="userInfo.manager.userInfoId" style="width:200px;">
				<option value="0">请选择上级领导/无上级</option>
				<c:forEach items="${managerList}" var="m">
					<option value="${m.userInfoId}">${m.name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr class="odd">
		<td>真实姓名:</td>
		<td><input type="text" name="userInfo.name"></td>	
		<td>身份证号:</td>
		<td><input type="text" name="userInfo.cardNo"></td>	
	</tr>
	<tr class="odd">
		<td>入职日期:</td>
		<td><input type="text" name="userInfo.joinDate"
		onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"></td>	
		<td>薪资:</td>
		<td><input type="text" name="userInfo.salary"></td>	
	</tr>
	<tr class="odd">
		<td>出生日期:</td>
		<td><input type="text" style="width:152px;" name="userInfo.birthday"
	   		onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/></td>	
		<td>性别:</td>
		<td>
			<input type="radio" name="userInfo.gender" value="男">男
			<input type="radio" name="userInfo.gender" value="女">女
			<input type="radio" name="userInfo.gender" value="其他">其他
		</td>	
	</tr>
	<tr class="odd">
		<td>岗位描述:</td>
		<td><input type="text" name="userInfo.station"></td>	
		<td>联系方式:</td>
		<td><input type="text" name="userInfo.telephone"></td>	
	</tr>
	<tr class="odd">
		<td>用户级别:</td>
		<td>
			<select name="userInfo.userLevel" style="width:220px;">
				<option value="1">总经理</option>
				<option value="2">副总</option>
				<option value="3">部门经理</option>
				<option value="4" selected="selected">普通用户</option>
			</select>
		</td>	
		<td>排序号:</td>
		<td><input type="text" name="userInfo.orderNo"></td>	
	</tr>
	<tr class="odd">
		<td>状态</td>
		<td>
			<input type="radio" name="state" value="1">启用
			<input type="radio" name="state" value="2">停用
		</td>	
	</tr>
	<tr class="odd" >
		<td>备注</td>
		<td colspan="3">
			<textarea style="height:80px;width:100%" name="userInfo.remark"></textarea>
		</td>	
	</tr>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

