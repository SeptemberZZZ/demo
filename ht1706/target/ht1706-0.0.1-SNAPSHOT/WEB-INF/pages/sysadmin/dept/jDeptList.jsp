<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>部门列表</title>
</head>

<body>
<form name="icform" method="post" >

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<shiro:hasPermission name="部门-查看">
		<li id="view"><a href="#" onclick="formSubmit('toview','_self');this.blur();">查看</a></li>
	</shiro:hasPermission>	
	<shiro:hasPermission name="部门-新增">
		<li id="new"><a href="#" onclick="formSubmit('tocreate','_self');this.blur();">新增</a></li>
	</shiro:hasPermission>	
	<shiro:hasPermission name="部门-修改">
		<li id="update"><a href="#" onclick="formSubmit('toupdate','_self');this.blur();">修改</a></li>
	</shiro:hasPermission>	
	<shiro:hasPermission name="部门-删除">
		<li id="delete"><a href="#" onclick="formSubmit('delete','_self');this.blur();">删除</a></li>
	</shiro:hasPermission>	
	<shiro:hasPermission name="部门-启用">
		<li id="new"><a href="#" onclick="formSubmit('start','_self');this.blur();">启用</a></li>
	</shiro:hasPermission>	
	<shiro:hasPermission name="部门-停用">
		<li id="new"><a href="#" onclick="formSubmit('stop','_self');this.blur();">停用</a></li>
	</shiro:hasPermission>	
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    部门列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('deptId',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">编号</td>
		<td class="tableHeader">上级</td>
		<td class="tableHeader">名称</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${deptList}" var="d" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'">
		<td><input type="checkbox" name="deptId" value="${d.deptId}"/></td>
		<td>${status.index+1}</td>
		<td>${d.deptId}</td>
		<td>${d.parentDept.deptName}</td>
		<td><a href="dept/toview?id=${d.deptId}">${d.deptName}</a></td>
		<td>
			<c:if test="${d.state==1}"><a href="stop?deptId=${d.deptId}"><font color="green">启用</font></a></c:if>
			<c:if test="${d.state==0}"><a href="start?deptId=${d.deptId}"><font color="red">停用</font></a></c:if>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

