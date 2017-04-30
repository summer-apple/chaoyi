<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>





<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">

<%@ include file="meta.jsp" %>
<%@ include file="css.jsp" %>



<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->


</head>
<body class="page-body">

	

	<div class="page-container">
		<!-- add class "sidebar-collapsed" to close sidebar by default, "chat-visible" to make chat appear always -->

		<!-- Add "fixed" class to make the sidebar fixed always to the browser viewport. -->
		<!-- Adding class "toggle-others" will keep only one menu item open at a time. -->
		<!-- Adding class "collapsed" collapse sidebar root elements and show only icons. -->

		<%@ include file="side-bar.jsp"%>
		<div class="main-content">

			<%@ include file="top-bar.jsp"%>

			<div class="page-title">

			<div class="title-env">
					<h1 class="title">新闻类型管理</h1>
					<p class="description">query and create new news type</p>
				</div>

				<div class="breadcrumb-env">

					<ol class="breadcrumb bc-1">
						<li><a href="javascript:void(0);"><i class="fa-home"></i>主页</a></li>
						<li><a href="javascript:void(0);">新闻管理</a></li>
						<li class="active"><strong>新闻类型管理</strong></li>
					</ol>

				</div>

			</div>


<!--主体部分开始-->


			<div class="panel panel-default">
		
				<div class="row">
					<div class="col-sm-12">
						<a href="javascript:;" onclick="jQuery('#modal-6').modal('show', {backdrop: 'static'});" class="btn btn-primary btn-single btn-sm add-new-btn" style="float:left; margin-right:10px;">新建新闻类型</a>
						<h5>主页展示权重排名前五项的新闻类型</h5>
					</div>
				</div>	

				<br>
				
				<div class="row">
					<div class="col-sm-12">
						<table id="qry-table" class="table table-bordered table-striped table-condensed table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>名称</th>
												<th>权重</th>
												<th>操作</th>
											</tr>
										</thead>
										
										<tbody>
											
										</tbody>
						</table>
					</div>
				</div>
				

			</div>

<!--主体部分结束-->
			<%@ include file="footer.jsp"%>
		</div>

		

	</div>


	<div class="page-loading-overlay">
		<div class="loader-2"></div>
	</div>
<!--新增表单开始-->
	<div class="modal fade" id="modal-6" aria-hidden="true" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title">新增-编辑 新闻类型</h4>
				</div>
				
				<div class="modal-body">
				
				<form id="add-form" role="form" class="form-horizontal" action="" method="post">
					<input type="hidden" name="id" id="id" value="0">
					<div class="row">
						<div class="col-md-12">
							
							<div class="form-group">
								<label for="name" class="control-label">类型名称</label>
								
								<input name="name" type="text" class="form-control" id="name" placeholder="建议4个汉字...">
							</div>	
							
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							
							<div class="form-group">
								<label for="weight" class="control-label">权 重</label>
								
								<input name="weight" type="number" min="0" max="10" class="form-control" id="weight" placeholder="0-10数字，越小越靠前，首页展示前五个">
						</div>
							
						</div>
							
					</div>
					<div class="modal-footer">
										<button type="button" class="btn btn-white cancel-btn" data-dismiss="modal">取 消</button>
										<button id="add-btn" type="submit" class="btn btn-info">保 存</button>
					</div>

				</form>
					
					
					
				</div>
				
				
			</div>
		</div>
	</div>
<!--新增表单结束-->


<div class="modal fade" id="modal-1" aria-hidden="true" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title">操作提示</h4>
				</div>
				
				<div class="modal-body">
					确定要删除该条内容吗？该操作不可撤销！
				</div>
				
				<div class="del-id"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-white del-confirm-btn" data-dismiss="modal">删除</button>
					<button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
					
				</div>
			</div>
		</div>
	</div>

	<%@ include file="script.jsp" %>
	<script type="text/javascript">
	$().ready(function(){
//首次进入时刷新
		qry();
//查询方法
		function qry(){
            $.ajax({
                url:'newstype/qry',
                type:'post',
                dataType:'json',
                success:function(data){
                    $("#qry-table tbody").empty();
                	$.each(data, function(i, item) {
                		 $("#qry-table tbody").append(
                		"<tr id='tr-"+ item.id +"'>"+
						"	<td class='td-id'>"+item.id+"</td>"+
						"	<td class='td-name'>"+item.name+"</td>"+
						"	<td class='td-weight'>"+item.weight+"</td>"+
						"	<td><a class='btn btn-primary btn-single btn-sm' onclick=edit("+item.id+")>编辑</a><a class='btn btn-primary btn-single btn-sm' onclick=del("+item.id+")>删除</a></td>"+
						"</tr>"
                		 );
                  	});
                }
            });
		}

//添加
	$("#add-form").validate({
							rules: {
								name: {
									required: true,
									maxlength:8
								},
								
								weight: {
									required: true,
									number:true,
									max:10,
									min:0
								}
							},
							
							messages: {
								name: {
									required: '必填项目',	
									maxlength:'最多8个汉字'
								},
								
								weight: {
									required: '必填项目',
									number:'必须为非负整数',
									max:'最大值为10',
									min:'最小值为0'
								}
							},
							
							// Form Processing via AJAX
							submitHandler: function(form)
							{
								var $url ='';

								if ($("#id").val()==0) {
									$url ='newstype/add';
								}else{
									$url ='newstype/update';
								}

								$("#add-form").ajaxSubmit({
					                url:$url,
					                type:'post',
					                dataType:'json',
					                success:function(data){
					                    if (data!=0) {
					                    	alert("保存成功...");
					                    	$("#add-form")[0].reset();
					                    	$("#id").val(0);
					                    	$(".cancel-btn").click();
					                    	qry();
					                    }else{
					                    	alert("保存出错，该类型已存在...");
					                    	qry();
					                    };
					                }
					            });
							}
						});


//删除

	window.del = function(id){
		$(".del-id").html(id);
		jQuery('#modal-1').modal('show', {backdrop: 'fade'});
	}

	$(".del-confirm-btn").click(function(){
		var $id = $(".del-id").html();
			$.ajax({
                url:'newstype/del?id='+$id,
                type:'post',
                dataType:'json',
                success:function(data){
                	if (data==true) {
                    	alert("删除成功...");
                   		qry(true);
                    }else{
                    	alert("无法删除...");

                    }
                   
                }
            });		
	});

//编辑

	window.edit = function(id){

		$(".add-new-btn").click();

		var item = $("#tr-"+id);
		$("#id").val(id);
		$("#name").val(item.find(".td-name").html());
		$("#weight").val(item.find(".td-weight").html());
	}


	});
	</script>
</body>
</html>