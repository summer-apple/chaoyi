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
/* .wangEditor-modal-container .wangEditor-modal{
	margin-top:-1350px !important;
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
					<h1 class="title">招聘管理</h1>
					<p class="description">query edit or create  job</p>
				</div>

				<div class="breadcrumb-env">

					<ol class="breadcrumb bc-1">
						<li><a href="dashboard/home"><i class="fa-home"></i>主页</a></li>
						<li class="active"><strong>查询招聘</strong></li>
					</ol>

				</div>

			</div>


<!--主体部分开始-->
			<div class="add-panel panel panel-default" style="display: none;">
						<div class="panel-heading">
							<h3 class="panel-title">新增招聘</h3>
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
									<label class="col-sm-2 control-label" for="title">标&nbsp;&nbsp;&nbsp;题</label>
									
									<div class="col-sm-10">
										<input name="title" type="text" class="form-control" id="title" placeholder="标题,20字以内">
									</div>
								</div>
								

								<div class="form-group">
									<label class="col-sm-2 control-label" for="link">类&nbsp;&nbsp;&nbsp;型</label>
									
									<div class="col-sm-10">
										<input name="type" type="text" class="form-control" id="type" placeholder="类型" readonly>
									</div>
								</div>
								
								

								<div class="form-group">
									<label class="col-sm-2 control-label" for="content">概&nbsp;&nbsp;&nbsp;要</label>
									<div class="col-sm-10">
										<textarea name="brief" id="brief" class="form-control" placeholder="内容概要，150字以内"></textarea>
									</div>
									
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label" for="content">详&nbsp;&nbsp;&nbsp;情</label>
									<div class="col-sm-10 content-line">
										<input id="content_upload" type="file" name="upload"
											style="display: none;" />
										<div id="tip-queue-2" style="display: none;"></div>
										<div id="uploadContainer">
										    <input type="button" value="选择文件" id="btnBrowse"/>
										</div>

										<textarea name="content" id="content" style='height:500px;'></textarea>
									</div>

								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label" for="img">附&nbsp;&nbsp;&nbsp;件</label>
									
									<div class="col-sm-2">

										<input id="file_upload" type="file" name="upload" style="display:none;" />
										<div id="tip-queue" style="display:none;"></div>
										<input name="attachment" type="hidden" class="form-control" id="attachment">
										<h5>多附件请打包上传</h5>
									</div>
									<div class="col-sm-8 file-show">
										
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
<!--新增招聘表单结束-->

			<div class="qry-panel panel panel-default">
				
				<div class="row">
					
					<div class="col-sm-4">
						
	
						<form class="form-inline" id="qry-form" action="" method="post">
							<div class="row">
							<div class="form-group col-sm-12">
									
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
											<option value="职位招聘">职位招聘</option>
											
											<option value="强鹰学员">强鹰学员</option>
											<option value="名誉学员">名誉学员</option>
											
										</select>
									</div>
								</div>

							
							<div class="form-group"> 
								<input id="pageNo" name="pageNo" class="form-control" type="hidden" value="0" placeholder="页码">
							</div>
							<div class="form-group"> 
								<input id="pageSize" name="pageSize" class="form-control" type="hidden" value="10" placeholder="每页招聘数">
							</div>

							<div class="form-group"> 
								<input id="amount" name="amount" class="form-control" type="hidden" placeholder="总页数">
							</div>
							</div>
						</form>
 
					</div>
					<div class="col-sm-8">
						<a href="javascript:void(0);" class="open-panel btn btn-primary btn-single btn-sm">新建招聘</a>
						
					</div>
				
				</div>

				
				<div class="row">
					<div class="col-sm-12">
						<table id="qry-table" class="table table-bordered table-striped table-condensed table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>类型</th>
												<th>标题</th>
												<th>简介</th>
												<th>附件</th>
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

	<%@ include file="script.jsp" %>
	<script type="text/javascript" src="resources/js/jquery.pagination.js"></script>
	<script src="resources/js/jquery.uploadifive.js"></script>
<!-- 	<script src="resources/js/ckeditor/ckeditor.js"></script>
	<script src="resources/js/ckeditor/adapters/jquery.js"></script> -->

	<script src="resources/js/select2/select2.min.js"></script>
	<script src="resources/js/jquery-ui/jquery-ui.min.js"></script>
	<script src="resources/js/selectboxit/jquery.selectBoxIt.min.js"></script>
	<script src="resources/js/multiselect/js/jquery.multi-select.js"></script>

	<link rel="stylesheet" href="resources/js/wangEditor/css/wangEditor-1.3.12.css">
	<script src="resources/js/wangEditor/js/wangEditor-1.3.12.min.js"></script>

	<script type="text/javascript">
	$().ready(function(){

//首次进入时刷新
		qry(true);

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
	        'formData'     : {"folder":"news"},//The other data want to send
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

textCount($("#title"),20);
textCount($("#brief"),150);





//变更类型时刷新
$("#qry-type").change(function(){
	$("#pageNo").val(0);
	qry(true);

	$(".close-panel").click();
	
	var $qrytype = $("#qry-type").val();
	if($qrytype=="强鹰学员" || $qrytype=="名誉学员"){

		if($qrytype=="强鹰学员"){
			$("#type").val("强鹰学员");
		}else{
			$("#type").val("名誉学员");
		}

		$(".open-panel").hide();

	}else{

		
		$("#type").val("职位招聘");
	
		$(".open-panel").show();
	}

});






//查询方法
		function qry(initPageFlag){
            $.ajax({
                url:'job/qry',
                data: {'pageNo':$('#pageNo').val(),'pageSize':$('#pageSize').val(),'type':$("#qry-type").val()},
                type:'post',
                dataType:'json',
                success:function(data){
                    $("#qry-table tbody").empty();
                	$.each(data.list, function(i, item) {

                		var $str = '<tr class="job-'+item.id+'">'+
									'	<td class="job-id">'+item.id+'</td>'+
									'	<td class="job-type">'+item.type+'</td>'+
									'	<td class="job-title">'+item.title+'</td>'+
									'	<td class="job-brief" style="max-width:400px;">'+item.brief.substring(0,20)+'</a></td>'+
									'	<td class="job-attachment">'+attachment(item.attachment)+'</td>';

						if (item.type=="职位招聘") {
							$str += '	<td style="min-width:115px;"><a class="edit-btn btn btn-primary btn-single btn-sm" onclick="edit('+item.id+')">编辑</a><a class="del-btn btn btn-primary btn-single btn-sm" onclick=del('+item.id+')>删除</a></td>'+
								'</tr>';
						}else{
							$str += '	<td style="min-width:115px;"><a class="edit-btn btn btn-primary btn-single btn-sm" onclick="edit('+item.id+')">编辑</a></td>'+
								'</tr>';
						}

                		 $("#qry-table tbody").append($str);

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


//附件方法
	function attachment(attachment){
		if (attachment!=null) {
			return '<a href="'+attachment+'">'+attachment.substring(attachment.lastIndexOf("/")+1,attachment.lenght)+'</a>';
		}else{
			return "";
		}
	}	

//点击页码查询
		function pageSelectCallback(current_page, aa){
			$("#pageNo").val(current_page+1);
			 qry(false);
		}
		



//添加
	$("#add-form").validate({
							rules: {
								title: {
									required: true,
									maxlength:20
								},
								
								brief: {
									//required: true,
									maxlength:150
								}
							},
							
							messages: {
								title: {
									required: '必填项目',	
									maxlength:'最多20个汉字'
								},
								

								brief: {
									//required: '必填项目',
									maxlength:'最多150个汉字'
								}
							},
							
							// Form Processing via AJAX
							submitHandler: function(form)
							{
								
								if ($("#brief").val()=="") {
									var $brief = $("#content").val().replace(/(\n)/g, "").replace(/(\t)/g, "").replace(/(\r)/g, "").replace(/<\/?[^>]*>/g, "").replace(/\s*/g, "").substring(0,149);
									$("#brief").val($brief);
								}


								var $url ='';

								if ($("#id").val()==0) {
									$url ='job/add';
								}else{
									$url ='job/update';
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
					                    	$(".file-show").html("");
					                    	qry(true);
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
                url:'job/del?id='+$id,
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
		$(".add-panel .panel-title").html("新增招聘");
		$("#add-btn").show();
		$("#update-btn").hide();
		$("#type").val($("#qry-type").val());
		$(".wangEditor-textarea").html("");
		$("#content").val("");
		$(".add-panel").show();
	});

//编辑
	window.edit = function(id){
		$("#add-form")[0].reset();
		$(".add-panel .panel-title").html("更新招聘");
		
		$("#add-btn").hide();
		$("#update-btn").show();

		$.ajax({
                url:'job/get-one?id='+id,
                type:'post',
                dataType:'json',
                success:function(data){
                	$("#id").val(data.id);
                	$("#title").val(data.title);
                	$("#brief").val(data.brief);
                	$("#content").val(data.content);
                	$(".wangEditor-textarea").html(data.content);
                	$("#attachment").val(data.attachment);
                	if (data.attachment!=null) {
                		$(".file-show").html('<h5 class="file-name">'+data.attachment.substring(data.attachment.lastIndexOf("/")+1,data.attachment.lenght)+'  <a class="remove-file" href="javascript:void(0);"><span class="fa fa-close" style="color:#000;"></span></a></h5>');
                	}else{
                		$(".file-show").html("");
                	}
                	
                	$("#typeSelectBoxItText").attr("data-val",data.type).html(data.type);
                	$("#type").val(data.type);
                	//alert($("#add-form").find("#typeSelectBoxItOptions li[data-val='"+data.type+"']").attr("data-val"));
                	//$("#add-form").find("#typeSelectBoxItOptions li[data-val='"+data.type+"']").click();
                }
            });
		
		$(".add-panel").show();
	}//333

	

//添加附件
 	  $("#select-img-btn").click(function(){
    	  $("#uploadifive-file_upload").click();
          });

  	  $('#file_upload').uploadifive({
  			'width'           : 75,                 // The width of the button
  			'height'          : 30,                 // The height of the button
  	        'auto' : true,   //取消自动上传 
  	        'uploadScript' : 'util/upload-file', //处理上传文件Action路径 
  	        'fileObjName'  : 'file',        //文件对象
	        'buttonText'   : '选择文件',   //按钮显示文字 
	        'queueID'      : 'tip-queue', //drug and drop box's ID 
	        //'fileType'     : 'image/jpg,image/jpeg,image/png',   //允许上传文件类型 
	        'fileSizeLimit'   : '20MB',                  // Maximum allowed size of files to upload
	        'formData'     : {"folder":"attachment"},//The other data want to send
	        'queueSizeLimit'  : 100,                  //The maximum number of files in drup and drop box 
            'simUploadLimit'  : 100,                  // The maximum number of files to upload at once
            'uploadLimit'     : 100,                  // The maximum number of files you can upload
	        'onUploadComplete' : function(file, data) { //文件上传成功后执行 
	        	
	        	var $obj = $.parseJSON($.parseJSON(data)); 
	        	

	        	$(".file-show").html('<h5 class="file-name">'+$obj.name+'  <a class="remove-file" href="javascript:void(0);"><span class="fa fa-close" style="color:#000;"></span></a></h5>');
	        	$("#attachment").val($obj.url);
					}

				});

	$(".file-show").on("click",".remove-file",function(){
		$(".file-show").html("");
		$("#attachment").val("");
	});




});
	</script>
</body>
</html>