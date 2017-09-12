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
	<li id="back"><a href="#" onclick="window.history.go(-1)">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    部门查看
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<tr class="odd">
		<td>用户名:</td>
		<td>${user.username}</td>
		<td>所属部门:</td>
		<td>
			${user.dept.deptName}
		</td>	
	</tr>
	<tr class="odd">
		<td>真实姓名:</td>
		<td>${user.userInfo.name }</td>	
		<td>身份证号:</td>
		<td>${user.userInfo.cardNo }</td>	
	</tr>
	
	<tr class="odd">
		
		<td>上级领导:</td>
		<td>${user.userInfo.manager.name}
		</td>
		<td>入职日期:</td>
		<td><fmt:formatDate value="${user.userInfo.joinDate}"/></td>
	</tr>
	
	<tr class="odd">
		<td>岗位描述:</td>
		<td>${ user.userInfo.station}</td>	
		<td>薪资:</td>
		<td>${user.userInfo.salary}</td>	
	</tr>
	<tr class="odd">
		<td>出生日期:</td>
		<td><fmt:formatDate value="${user.userInfo.birthday}"/></td>	
		<td>性别:</td>
		<td>
			${user.userInfo.gender}
		</td>	
	</tr>
	<tr class="odd">
			
		<td>联系方式:</td>
		<td>${user.userInfo.telephone}</td>
		<td>用户级别:</td>
		<td>${user.userInfo.userLevel }</td>
	</tr>
	<tr class="odd">
		<td>状态</td>
		<td>${user.state }
		</td>
		<td>创建人</td>
		<td>${user.createBy }</td>
	</tr>
	<tr class="odd">
		<td>创建部门</td>
		<td>${user.createDept }
		</td>
		<td>创建时间</td>
		<td><fmt:formatDate value="${user.createTime}"/></td>
	</tr>
	<tr class="odd">
		<td>修改人</td>
		<td>${user.updateBy}
		</td>
		<td>修改时间</td>
		<td><fmt:formatDate value="${user.updateTime}"/></td>
	</tr>
	<tr class="odd" >
		<td>备注</td>
		<td colspan="3">
			${user.userInfo.remark}
		</td>	
	</tr>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

