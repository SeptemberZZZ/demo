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
	<li id="update"><a href="#" onclick="formSubmit('update','_self');this.blur();">保存</a></li>
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
		<td><input type="text" name="username" value="${user.username}"></td>
		<td>
		<input type="hidden" name="userId" value="${user.userId }">
		<input type="hidden" name="password" value="${user.password }">
		</td>
	</tr>
	<tr class="odd">
		<td>所属部门:</td>
		<td>
			<select name="dept.deptId" style="width:200px;">
				<option value="0">---请选择部门---</option>
				<c:forEach items="${deptList}" var="d">
					<option value="${d.deptId}" <c:if test="${d.deptId==user.dept.deptId}">selected="selected"</c:if>>${d.deptName}</option>
				</c:forEach>
			</select>
		</td>
		<td>上级领导:</td>
		<td>
			<select name="userInfo.manager.userInfoId" style="width:200px;">
				<option value="0">请选择上级领导/无上级</option>
				<c:forEach items="${managerList}" var="m">
					<option value="${m.userInfoId}" <c:if test="${m.userInfoId==user.userInfo.manager.userInfoId}">selected="selected"</c:if>>${m.name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr class="odd">
		<td>真实姓名:</td>
		<td><input type="text" name="userInfo.name" value="${user.userInfo.name }"></td>	
		<td>身份证号:</td>
		<td><input type="text" name="userInfo.cardNo" value="${user.userInfo.cardNo }"></td>	
	</tr>
	<tr class="odd">
		<td>薪资:</td>
		<td><input type="text" name="userInfo.salary" value="${user.userInfo.salary }"></td>	
		<td>性别:</td>
		<td>
			<input type="radio" name="userInfo.gender" value="男" <c:if test="${ user.userInfo.gender == '男'}">checked="checked"</c:if>>男
			<input type="radio" name="userInfo.gender" value="女" <c:if test="${ user.userInfo.gender == '女'}">checked="checked"</c:if>>女
			<input type="radio" name="userInfo.gender" value="其他">其他
		</td>	
	</tr>
	<tr class="odd">
		<td>岗位描述:</td>
		<td><input type="text" name="userInfo.station" value="${user.userInfo.station }"></td>	
		<td>联系方式:</td>
		<td><input type="text" name="userInfo.telephone" value="${user.userInfo.telephone }"></td>	
	</tr>
	<tr class="odd">
		<td>用户级别:</td>
		<td>
			<select name="userInfo.userLevel" style="width:220px;">
				<option value="1" <c:if test="${user.userInfo.userLevel == '1'}">selected="selected"</c:if>>总经理
				<option value="2" <c:if test="${user.userInfo.userLevel == '2'}">selected="selected"</c:if>>副总</option>
				<option value="3" <c:if test="${user.userInfo.userLevel == '3'}">selected="selected"</c:if>>部门经理</option>
				<option value="4" <c:if test="${user.userInfo.userLevel == '4'}">selected="selected"</c:if>>普通用户</option>
			</select>
		</td>	
		<td>排序号:</td>
		<td><input type="text" name="userInfo.orderNo" value="${user.userInfo.orderNo }"></td>	
	</tr>
	<tr class="odd">
		<td>状态</td>
		<td>
			<input type="radio" name="state" value="1" <c:if test="${ user.state == 1}">checked="checked"</c:if>>启用
			<input type="radio" name="state" value="0" <c:if test="${ user.state == 0}">checked="checked"</c:if>>停用
		</td>	
	</tr>
	<tr class="odd" >
		<td>备注</td>
		<td colspan="3">
			<textarea style="height:80px;width:100%" name="userInfo.remark" >${user.userInfo.remark}</textarea>
		</td>	
	</tr>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

