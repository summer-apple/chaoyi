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
<style type="text/css">
#uploadifive-file_upload, #uploadifive-content_upload {
	background-color: #000;
	color: #FFF;
}
.content-line #uploadifive-file_upload,.content-line #uploadifive-content_upload {
	display: none !important;
}
.wangEditor-modal-container .wangEditor-modal{

margin-top:-3235px !important;

}
/* .wangEditor-modal-container .wangEditor-modal{
margin-top:-1420px !important;
} */
</style>


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
					<h1 class="title">合作管理</h1>
					<p class="description">query edit or create  cooperation</p>
				</div>

				<div class="breadcrumb-env">

					<ol class="breadcrumb bc-1">
						<li><a href="dashboard/home"><i class="fa-home"></i>主页</a></li>
						<li class="active"><strong>查询合作</strong></li>
					</ol>

				</div>

			</div>


<!--主体部分开始-->
			<div class="add-panel panel panel-default" style="display: none;">
						<div class="panel-heading">
							<h3 class="panel-title">新增合作</h3>
							<div class="panel-options">
								<a href="#" data-toggle="panel">
									<span class="collapse-icon">–</span>
									<span class="expand-icon">+</span>
								</a>
								<a href="javascript:void(0);" class="close-panel">
									×
								</a>
							</div>
						</div>
						<div class="panel-body">
							
							<form id="add-form" role="form" class="form-horizontal" action="" method="post">
								
								<input name="id" type="hidden" id="id">

								<div class="form-group">
									<label class="col-sm-2 control-label" for="name">姓&nbsp;&nbsp;&nbsp;名</label>
									
									<div class="col-sm-10">
										<input name="name" type="text" class="form-control" id="name" placeholder="10字以内">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label" for="position">职&nbsp;&nbsp;&nbsp;位</label>
									
									<div class="col-sm-10">
										<input name="position" type="text" class="form-control" id="position" placeholder="20字以内">
									</div>
									
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label" for="link">类&nbsp;&nbsp;&nbsp;型</label>
									
									<script type="text/javascript">
										jQuery(document).ready(function($)
										{
											$("#type").selectBoxIt().on('open', function()
											{
												// Adding Custom Scrollbar
												$(this).data('selectBoxSelectBoxIt').list.perfectScrollbar();
											});
										});
									</script>
									<div class="col-sm-10">
										<select name="type" class="form-control" id="type" style="display: none;">
											<option value="名誉学员">名誉学员</option>
											<option value="会员">会员</option>
										</select>
									</div>
								</div>
								
								
								<div class="form-group">
									<label class="col-sm-2 control-label">权&nbsp;&nbsp;&nbsp;重</label>
									
									<div class="col-sm-10">
										<input name="weight" type="number" min="0" max="10" class="form-control" id="weight" placeholder="0-10数字，越小越靠前，首页展示前五个">
									</div>
								</div>
								
								

								<div class="form-group">
									<label class="col-sm-2 control-label" for="headimg">头&nbsp;&nbsp;&nbsp;像</label>
									
									<div class="col-sm-2">
										<input id="file_upload" type="file" name="upload" style="display:none;" />
										<div id="tip-queue" style="display:none;"></div>
										<br>
										
									</div>
									<div class="col-sm-4 img-preview-warp">
										<div id="img-preview" class="img-preview" style="    display: inline-block; overflow: hidden;line-height: 1;">
										</div>

									</div>
									<div class="col-sm-4 img-show-warp">
										<div class="img-show">
										
										</div>	
									</div>

									
		
								</div>

								
								<div class="form-group">
									<label class="col-sm-2 control-label" for="headimg"></label>
									
									<div class="col-sm-10">
										<input name="headimg" type="text" class="form-control" id="headimg" placeholder="首图必须上传" readonly>
					
									</div>
								</div>
								

								<div class="form-group">
									<label class="col-sm-2 control-label" for="content">详&nbsp;&nbsp;&nbsp;情</label>
									<div class="col-sm-10 content-line">
										<input id="content_upload" type="file" name="upload" style="display:none;" />
										<div id="tip-queue-2" style="display:none;"></div>
										
										<div id="uploadContainer">
										    <input type="button" value="选择文件" id="btnBrowse"/>
										</div>

										<textarea name="content" id="content" style='height:500px;'></textarea>
										
									</div>
									
								</div>
								
								
								
								<div class="form-group">
									<div class="col-sm-6">
									</div>
									<div class="col-sm-2">
										<button id="add-btn" type="submit" class="btn btn-primary btn-single btn-sm">保 存</button>
										<button id="update-btn" type="submit" class="btn btn-primary btn-single btn-sm">更 新</button>
									</div>
								</div>
								
								
							</form>
							
						</div>
					</div>
<!--新增合作表单结束-->

			<div class="panel panel-default">
				
				<div class="row">
				<div class="col-sm-6">
						
	
						<form class="form-inline" id="qry-form" action="" method="post">
							<div class="row">
							<div class="form-group col-sm-4" style="min-width: 150px;">
									
									<script type="text/javascript">
										jQuery(document).ready(function($)
										{
											$("#qry-type").selectBoxIt().on('open', function()
											{
												// Adding Custom Scrollbar
												$(this).data('selectBoxSelectBoxIt').list.perfectScrollbar();
											});
										});
									</script>
									<div class="col-sm-12">
										<select name="type" class="form-control" id="qry-type" style="display: none;">
											<option value="名誉学员">名誉学员</option>
											<option value="会员">会员</option>
										</select>
									</div>
								</div>
							<div class="form-group"> 
								<input id="keyword" name="keyword" class="form-control" type="text" placeholder="关键字">
							</div>
							<div class="form-group">
								<button id="qry-btn" type="button" class="btn btn-primary btn-single btn-sm">查 询</button>
							</div>
							<div class="form-group"> 
								<input id="pageNo" name="pageNo" class="form-control" type="hidden" value="0" placeholder="页码">
							</div>
							<div class="form-group"> 
								<input id="pageSize" name="pageSize" class="form-control" type="hidden" value="10" placeholder="每页合作数">
							</div>

							<div class="form-group"> 
								<input id="amount" name="amount" class="form-control" type="hidden" placeholder="总页数">
							</div>
							</div>
						</form>
 
					</div>

					<div class="col-sm-6">
						<a href="javascript:void(0);" class="open-panel btn btn-primary btn-single btn-sm" style="float:left; margin-right:10px;">新建合作</a>
						<h5>主页展示权重排名前二十项的合作</h5>
					</div>
					
					
				
				</div>
				<br>
				
				<div class="row">
					<div class="col-sm-12">
						<table id="qry-table" class="table table-bordered table-striped table-condensed table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>类型</th>
												<th>头像</th>
												<th>姓名</th>
												<th>职位</th>
												<th>权重</th>
												<th>操作</th>
											</tr>
										</thead>
										
										<tbody>
											
										</tbody>
						</table>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<div class="pagination"></div>
					</div>				
				</div>
				

			</div>

<!--主体部分结束-->
			<!-- Main Footer -->
			<!-- Choose between footer styles: "footer-type-1" or "footer-type-2" -->
			<!-- Add class "sticky" to  always stick the footer to the end of page (if page contents is small) -->
			<!-- Or class "fixed" to  always fix the footer to the end of page -->
			<%@ include file="footer.jsp"%>
		</div>

		

	</div>


	<div class="page-loading-overlay">
		<div class="loader-2"></div>
	</div>

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




	<link rel="stylesheet" href="resources/js/select2/select2.css">
	<link rel="stylesheet" href="resources/js/select2/select2-bootstrap.css">
	<link rel="stylesheet" href="resources/js/cropper/cropper.min.css">

	<%@ include file="script.jsp" %>
	<script type="text/javascript" src="resources/js/jquery.pagination.js"></script>
	<script src="resources/js/jquery.uploadifive.js"></script>
<!-- 	<script src="resources/js/ckeditor/ckeditor.js"></script>
	<script src="resources/js/ckeditor/adapters/jquery.js"></script> -->

	<script src="resources/js/select2/select2.min.js"></script>
	<script src="resources/js/jquery-ui/jquery-ui.min.js"></script>
	<script src="resources/js/selectboxit/jquery.selectBoxIt.min.js"></script>
	<script src="resources/js/multiselect/js/jquery.multi-select.js"></script>

	<script src="resources/js/cropper/cropper.min.js"></script>



	<link rel="stylesheet" href="resources/js/wangEditor/css/wangEditor-1.3.12.css">
	<script src="resources/js/wangEditor/js/wangEditor-1.3.12.min.js"></script>


	<script type="text/javascript">
	$().ready(function(){

//首次进入时刷新
	qry(true);


//变更类型时刷新
$("#qry-type").change(function(){
	$("#pageNo").val(0);
	qry(true);
});



//字符计数器

function textCount(input,max){
	input.after('<div class="text-count">0/'+max+'</div>');

	input.keyup(function(){
		if (input.val().length==max || input.val().length>max) {
			input.val(input.val().substring(0,max));
		}
		input.next(".text-count").html(input.val().length+'/'+max);
	});
}

textCount($("#name"),10);
textCount($("#position"),20);


					
    //获取dom节点
    var $uploadContainer = $('#uploadContainer');

    var editor = $('#content').wangEditor({
        //重要：传入 uploadImgComponent 参数，值为 $uploadContainer
        'uploadImgComponent': $uploadContainer,
        'menuConfig': [
						    ['viewSourceCode'],
						    ['bold', 'underline', 'italic', 'foreColor', 'backgroundColor', 'strikethrough'],
						    ['blockquote', 'fontFamily', 'fontSize', 'setHead', 'list', 'justify'],
						    ['createLink', 'unLink', 'insertTable'],
						    ['insertImage', 'insertVideo', 'insertLocation','insertCode'],
						    ['undo', 'redo', 'fullScreen']
						]
    });

   

  	 //添加内容图片

 	  
  	  $('#content_upload').uploadifive({
  			'width'           : 75,                 // The width of the button
  			'height'          : 30,                 // The height of the button
  	        'auto' : true,   //取消自动上传 
  	        'uploadScript' : 'util/upload-image', //处理上传文件Action路径 
  	        'fileObjName'  : 'file',        //文件对象
	        'buttonText'   : ' 上传详情图片 ',   //按钮显示文字 
	        'queueID'      : 'tip-queue-2', //drug and drop box's ID 
	        'fileType'     : 'image/jpg,image/jpeg,image/png',   //允许上传文件类型 
	        'fileSizeLimit'   : '20MB',                  // Maximum allowed size of files to upload
	        'formData'     : {"folder":"cooperation"},//The other data want to send
	        'queueSizeLimit'  : 100,                  //The maximum number of files in drup and drop box 
            'simUploadLimit'  : 100,                  // The maximum number of files to upload at once
            'uploadLimit'     : 100,                  // The maximum number of files you can upload
	        'onUploadComplete' : function(file, data) { //文件上传成功后执行 
	        			var basePath = "<%=basePath%>";
						var url = basePath + $.parseJSON(data);
						editor.command(event, 'insertHTML', '<img src="' + url + '"/>');
						$(".content-line #real-input:first").remove();
	        	}
		});

	  	$(document).on("click","#btnBrowse",function(){
						$(".content-line #real-input:last").click();
					});



//查询方法
		function qry(initPageFlag){
            $.ajax({
                url:'cooperation/qry',
                data: {'pageNo':$('#pageNo').val(),'pageSize':$('#pageSize').val(),'type':$("#qry-type").val(),'keyword':$("#keyword").val()},
                type:'post',
                dataType:'json',
                success:function(data){
                    $("#qry-table tbody").empty();
                	$.each(data.list, function(i, item) {
                		 $("#qry-table tbody").append(
                		'<tr class="cooperation-'+item.id+'">'+
						'	<td class="cooperation-id">'+item.id+'</td>'+
						'	<td class="cooperation-type">'+item.type+'</td>'+
						'	<td class="cooperation-headimg"><a href="'+item.headimg+'"><img src="'+item.headimg+'" style="width:50px;"></a></td>'+
						'	<td class="cooperation-name">'+item.name+'</td>'+
						'	<td class="cooperation-position">'+item.position+'</a></td>'+
						'	<td class="cooperation-weight">'+item.weight+'</td>'+
						'	<td style="min-width:115px;"><a class="edit-btn btn btn-primary btn-single btn-sm" onclick="edit('+item.id+')">编辑</a><a class="btn btn-primary btn-single btn-sm" onclick=del('+item.id+')>删除</a></td>'+
						'</tr>'
                		 );

                		 $("#amount").val(data.amount);

		                	if(initPageFlag){
		                		$(".pagination").pagination(data.amount, { 
								  prev_text: '&laquo;', 
								  next_text: '&raquo;',
								  ellipse_text:"...", 
								  items_per_page: 1, 
								  num_display_entries: 6, 
								  current_page: 0, 
								  num_edge_entries: 2,
								  link_to:"javascript:void(0);",
						  callback:pageSelectCallback
									
								});
		                	}
                  	});
                }
            });
            
            
		}



//点击页码查询

		function pageSelectCallback(current_page, aa){
			$("#pageNo").val(current_page+1);
			 qry(false);
		}
	
//输入关键字查询

		$("#qry-btn").click(function(){
			qry(true);
		});		

//添加
	$("#add-form").validate({
							rules: {
								name: {
									required: true,
									maxlength:10
								},
								
								weight: {
									required: true,
									number:true,
									max:10,
									min:0
								},
								
								position: {
									required: true,
									maxlength:20
								},
								
								headimg: {
									required: true
								}
							},
							
							messages: {
								name: {
									required: '必填项目',	
									maxlength:'最多10个汉字'
								},
								
								weight: {
									required: '必填项目',
									number:'必须为非负整数',
									max:'最大值为10',
									min:'最小值为0'
								},

								position: {
									required: '必填项目',
									maxlength:'最多20个汉字'
								},
								
								headimg: {
									required: '必填项目'
								}
							},
							
							// Form Processing via AJAX
							submitHandler: function(form)
							{

								var $url ='';

								if ($("#id").val()==0) {
									$url ='cooperation/add';
								}else{
									$url ='cooperation/update';
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
					                    	qry(true);
					                    	$(".img-preview-warp").hide();
					                    	$(".add-panel").hide();
					                    }else{
					                    	alert("保存出错...");
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
                url:'cooperation/del?id='+$id,
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


//关闭新增商店面板
	$(".close-panel").click(function(){
		$(".add-panel").hide();
	});
//打开新增商店面板
	$(".open-panel").click(function(){
		$("#add-form")[0].reset();
		$("#img-preview").html("");
		$(".img-show-warp").html("");
		$(".img-show-warp").show();
		
		$(".add-panel .panel-title").html("新增合作");
		$("#add-btn").show();
		$("#update-btn").hide();

		$(".wangEditor-textarea").html("");

		$(".add-panel").show();

	});

//编辑
	window.edit = function(id){
		$("#add-form")[0].reset();
		$(".add-panel .panel-title").html("更新合作");
		
		$("#add-btn").hide();
		$("#update-btn").show();

		$.ajax({
                url:'cooperation/get-one?id='+id,
                type:'post',
                dataType:'json',
                success:function(data){
                	$("#id").val(data.id);
                	$("#name").val(data.name);
                	$("#position").val(data.position);
                	$("#weight").val(data.weight);
                	$("#content").val(data.content);
                	$(".wangEditor-textarea").html(data.content);
                	$("#headimg").val(data.headimg);

                	$(".img-preview-warp").hide();
                	$(".img-show-warp").html('<div class="img-show"><img src="'+data.headimg+'" style="width:100%;">').show();

                	$("#typeSelectBoxItText").attr("data-val",data.type).html(data.type);
                	$("#type").val(data.type);
                	//alert($("#add-form").find("#typeSelectBoxItOptions li[data-val='"+data.type+"']").attr("data-val"));
                	//$("#add-form").find("#typeSelectBoxItOptions li[data-val='"+data.type+"']").click();
                }
            });
		
		$(".add-panel").show();
	}//333



//添加首图

  	  $('#file_upload').uploadifive({
  			'width'           : 75,                 // The width of the button
  			'height'          : 30,                 // The height of the button
  	        'auto' : true,   //取消自动上传 
  	        'uploadScript' : 'util/upload-image', //处理上传文件Action路径 
  	        'fileObjName'  : 'file',        //文件对象
	        'buttonText'   : '上传头像',   //按钮显示文字 
	        'queueID'      : 'tip-queue', //drug and drop box's ID 
	        'fileType'     : 'image/jpg,image/jpeg,image/png',   //允许上传文件类型 
	        'fileSizeLimit'   : '20MB',                  // Maximum allowed size of files to upload
	        'formData'     : {"folder":"cooperation"},//The other data want to send
	        'queueSizeLimit'  : 100,                  //The maximum number of files in drup and drop box 
            'simUploadLimit'  : 100,                  // The maximum number of files to upload at once
            'uploadLimit'     : 100,                  // The maximum number of files you can upload
	        'onUploadComplete' : function(file, data) { //文件上传成功后执行 
	        	var url = $.parseJSON(data); 
	        	$(".img-show-warp").html('<div class="img-show"></div>').show();
	        	$(".img-show").html('<img src='+url+' style="width:100%;">');
	        	$(".img-show").after('<br><a id="crop-img" href="javascript:void(0);" class="btn btn-primary btn-single btn-sm"> 裁 剪 </a>');
	        	$(".img-preview-warp").show();

	        	$("#headimg").val(url);


//裁剪

						var preview_size = [200, 200],
							aspect_ratio = preview_size[0] / preview_size[1],
								
							$image = $(".img-show img"),
							$x = 0,
							$y = 0,
							$w = 0,
							$h = 0;
						
						// Plugin Initialization
						$image.cropper({
							aspectRatio: aspect_ratio,
							preview: '#img-preview',
							done: function(data)
							{
								$x = data.x;
								$y = data.y;
								$w = data.width;
								$h = data.height;
							}
						});
						
						// Preview Image Setup (based on defined crop width and height
						$("#img-preview").css({
							width: preview_size[0],
							height: preview_size[1]
						});
							
						$("#crop-img").on('click', function(ev)
						{
							ev.preventDefault();
							$.ajax({
								url:'util/crop',
								data:{"x":$x,"y":$y,"w":$w,"h":$h,"url":$("#headimg").val()},
								dataType:'json',
								type:'post',
								success:function(data){
									
									var url = $("#headimg").val();

									if (data=="success") {
										var newurl = url+"?t="+Math.floor(Math.random()*9999+1);
										$("[src='"+url+"']").attr("src",newurl);
										$("#img-preview img").attr("src",url);
										
										$(".img-show-warp").hide();
									}
									
									

								}
							});
						});















					}

				});



});	

	</script>
</body>
</html>