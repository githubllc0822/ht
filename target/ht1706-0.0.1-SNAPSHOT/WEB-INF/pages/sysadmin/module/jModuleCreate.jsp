<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户新增</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="save"><a href="#" onclick="formSubmit('save','_self');this.blur();">保存</a></li>
	<li id="back"><a href="#" onclick=" window.history.go(-1)">返回</a></li>
	
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    模块新增
  </div> 
  
<div>

 moduleId;
parentModule;
name;
ctype;
 state;
 orderNo
 remark;
<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<tr class="odd">
		<td>父模块:</td>
		<td>
			<select name="parentModule.moduleId">
			<c:forEach items="${moduleList }" var="m">
				
				<option value="${m.moduleId }">${m.name }</option>
			</c:forEach>
			</select>
		</td>
		<td>模块名：</td>
		<td><input  type="text" name="name"/></td>
	</tr>
	<tr class="odd">
		<td>ctype类型:</td>
		<td>
			<select name="ctype" style="width:122px">
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
			</select>
		</td>
	</tr>
	<tr class="odd">
		<td>状态:</td>
		<td>
			<input type="radio" name="state" value="1"/>启用
			<input type="radio" name="state" value="0"/>关闭
		</td>
		<td>序列号orderno</td>
		<td>
			<input type="text" name="orderNo" >
		</td>
		<td>备注remark</td>
		<td>
			<textarea rows="100" cols="200"  name="remark"></textarea>
		</td>
		
	</tr>

	

	

	

	
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

