<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户修改</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="save"><a href="#" onclick="formSubmit('update','_self');this.blur();">修改</a></li>
	<li id="back"><a href="#" onclick=" window.history.go(-1)">返回</a></li>
	
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    用户修改
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<tr class="odd">
		<td>用户名:</td>
		<td><input  type="text" name="username" value="${userList.get(0).username }"/></td>
		<td>密码:</td>
		<td><input  type="password" name="password" value="${userList.get(0).password }"/></td>
		<td>真实姓名：</td>
		<td><input  type="text" name="userInfo.name" value="${userList.get(0).userInfo.name }"/></td>
	</tr>
	<tr class="odd">
		<td>所属部门:</td>
		<td>
			<select name="dept.deptId" style="width:122px">	
					<c:forEach items="${list }" var="u">
						<option value="${u.deptId}">${u.deptName}</option>
					</c:forEach>			
					
			</select>
		</td>
	</tr>
	<tr class="odd">
		<td>身份证号:</td>
		<td><input  type="text" name="userInfo.cardNo" value="${userList.get(0).userInfo.cardNo }"/></td>
		<td>上级领导</td>
		<td>
			<select name="userInfo.manager.userInfoId" style="width:122px">
			
					<c:forEach items="${allUserList }" var="u">
						
						<option value="${u.userInfo.manager.userInfoId}">${u.userInfo.name}</option>
					</c:forEach>
			</select>
		</td>
	</tr>
	
	<!-- ... -->
	<tr class="odd">
		<td>入职日期:</td>
		<td>
			<input type="text" style="width:90px;" name="userInfo.birthday"
	   		onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});" value="<fmt:formatDate value="${userList.get(0).userInfo.createTime }"/>"/>
			
		</td>
		<td>薪资:</td>
		<td><input  type="text" name="userInfo.salary" value="${userList.get(0).userInfo.salary}"/></td>
	</tr>
	
	<tr class="odd">
		<td>生日:</td>
		<td>
			<input type="text" style="width:90px;" name="userInfo.birthday"
	   		onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});" value="<fmt:formatDate value="${userList.get(0).userInfo.birthday }"/>"/>
		</td>
		<td>性别:</td>
		<td>
		<input  type="radio" name="userInfo.gender" value="男" <c:if test="${userList.get(0).userInfo.gender=='男'}">checked='checked'</c:if>/>男
		<input  type="radio" name="userInfo.gender" value="女" <c:if test="${userList.get(0).userInfo.gender=='女'}">checked='checked'</c:if>/>女
		<input  type="radio" name="userInfo.gender" value="其他" <c:if test="${userList.get(0).userInfo.gender=='其他'}">checked='checked'</c:if>/>其他	
			
		</td>
	</tr>
	
	
	<tr class="odd">
		<td>岗位描述:</td>
		<td><input  type="text" name="userInfo.station" value="${userList.get(0).userInfo.station}"/></td>
		<td>电话:</td>
		<td><input  type="text" name="userInfo.telephone" value="${userList.get(0).userInfo.telephone}"/></td>
	</tr>
	
	<tr class="odd">
		<td>用户级别:</td>
		<td>
			<select name="userInfo.userLevel" style="width:121px">
					<option value="1">总经理</option>
					<option value="2">副总</option>
					<option value="3">部门经理</option>
					<option value="4">普通用户</option>
			</select>
		</td>
		<td>排序号:</td>
		<td><input  type="text" name="userInfo.orderNo" value="${userList.get(0).userInfo.orderNo}"/></td>
	</tr>
	
	<tr class="odd">
		<td>状态:</td>
		<td>
			<input type="radio" value="1" name="state" <c:if test="${userList.get(0).state=='1'}">checked='checked'</c:if>/>启用
			<input type="radio" value="0" name="state" <c:if test="${userList.get(0).state=='0'}">checked='checked'</c:if>/>停用
		</td>
		
	</tr>
	<tr class="odd">	
		<td>备注信息:</td>
		<td colspan="3">
			<input type="text" name="userInfo.remark" value="${userList.get(0).userInfo.remark}"/>
		</td>
	</tr>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

