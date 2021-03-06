<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- JSTL -->

${config.headStr}

${config.layuiStr}

<!-- 加入移动布局 -->
<meta name="viewport"	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no" />
<!-- 加入移动布局 -->

<!--添加  vue.js 支持加载-->
<script src="${pageContext.request.contextPath}/static/vue/vue.min.js"></script>
<!--添加  vue.js 支持加载-->

<script>
$(function(){
	if("${memo.memoFenLeiId}"!=""){
		$("#memoFenLeiId").val("${memo.memoFenLeiId}");
	}
});


var save_url = '${save_url}';
function save(){
	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
	
	var memoFenLeiId = $("#memoFenLeiId").val();
	
	$.post(save_url,{
		title:app.title,
		orderNo:app.orderNo,
		content:app.content,
		memoFenLeiId:memoFenLeiId
		},function(result){
		if(result.success){
			//调用 父窗口的  关闭所有窗口 并且刷新 页面
			window.parent.closeDlg(result.msg);
		}else{
			layer.closeAll();//关闭loading
			layer.msg(result.msg);
		}
	},'json');
}


</script>
<style>
html, body {
}
.layui-form-item {
    margin-bottom: 3px;
}
</style>
</head>
<body id="app">

<div style="padding: 10px;">
	<div class="layui-form layui-form-pane">
	
		<div class="layui-form-item">
	    <label class="layui-form-label">分类</label>
	    <div class="layui-input-block">
	      <select id="memoFenLeiId"  >
	      	<c:forEach var="memoFenLei" items="${memoFenLeiList}" >
	      		<option value="${memoFenLei.id}">${memoFenLei.name }</option>
	      	</c:forEach>
	      </select>
	    </div>
	  </div>
  		
	
	  <div class="layui-form-item">
	    <label class="layui-form-label">标题</label>
	    <div class="layui-input-block">
		      <input type="text" id="title" autocomplete="off" value="${memo.title }" v-model="title" placeholder="请输入  标题" class="layui-input">
	    </div>
	  </div>
	  
	  <div class="layui-form-item">
	    <label class="layui-form-label">排序号</label>
	    <div class="layui-input-block">
		      <input type="text"  autocomplete="off" value="${memo.orderNo }" v-model="orderNo" placeholder="请输入  排序号" class="layui-input">
	    </div>
	  </div>
	  
	  
	  <div class="layui-form-item layui-form-text">
	    <label class="layui-form-label">内容</label>
	    <div class="layui-input-block">
	      <textarea style="    height: 454px;" placeholder="请输入内容" class="layui-textarea" v-model="content">${memo.content}</textarea>
	    </div>
	  </div>
	  
	  </div>
	  
	<div class="site-demo-button" style="margin-top: 20px;">
	  <button id="save" onclick="save()" class="layui-btn site-demo-layedit" data-type="content">${btn_text }</button>
	</div>
	
</div>


<script>
layui.use([ 'laydate', 'laypage', 'layer', 'table', 'carousel',
		'upload', 'element' ], function() {
	var laydate = layui.laydate //日期
	, laypage = layui.laypage //分页
	layer = layui.layer //弹层
	, table = layui.table //表格
	, carousel = layui.carousel //轮播
	, upload = layui.upload //上传
	, element = layui.element; //元素操作
});
</script>
<script>
var app = new Vue({
	el : '#app',
	data : {
	}
});
 
</script>


</body>
</html>