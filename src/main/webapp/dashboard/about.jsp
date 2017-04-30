<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>





<html lang="en">
<head>
<base href="<%=basePath%>">
<%@ include file="meta.jsp" %>
<%@ include file="css.jsp"%>
<style type="text/css">
#uploadifive-file_upload, #uploadifive-content_upload,.edui-btn-image {
	display: none !important;
}
/* .wangEditor-modal-container .wangEditor-modal{
	margin-top:-570px !important;
} */
</style>




</head>
<body class="page-body">



	<div class="page-container">

		<%@ include file="side-bar.jsp"%>
		<div class="main-content">

			<%@ include file="top-bar.jsp"%>

			<div class="page-title">

				<div class="title-env">
					<h1 class="title">关于管理</h1>
					<p class="description">edit about</p>
				</div>

				<div class="breadcrumb-env">

					<ol class="breadcrumb bc-1">
						<li><a href="dashboard/home"><i class="fa-home"></i>主页</a></li>
						<li class="active"><strong>查询关于</strong></li>
					</ol>

				</div>

			</div>


			<!--主体部分开始-->
			<div class="add-panel panel panel-default">
				<div class="row">


					<div class="col-sm-4">


						<form class="form-inline" id="qry-form" action="" method="post">
							<div class="row">
								<div class="form-group col-sm-12">

									<script type="text/javascript">
										jQuery(document)
												.ready(
														function($) {
															$("#qry-type")
																	.selectBoxIt()
																	.on(
																			'open',
																			function() {
																				// Adding Custom Scrollbar
																				$(
																						this)
																						.data(
																								'selectBoxSelectBoxIt').list
																						.perfectScrollbar();
																			});
														});
									</script>
									<div class="col-sm-12">
										<select name="type" class="form-control" id="qry-type"
											style="display: none;">
											<option value="1">时代强鹰</option>
											<option value="2">校园联盟</option>
											<option value="3">强鹰青年圈</option>
											<option value="4">强鹰孵化平台</option>
										</select>
									</div>
								</div>

							</div>
						</form>

					</div>
					<div class="col-sm-8"></div>

				</div>

				<div class="panel-body">

					<form id="add-form" role="form" class="form-horizontal" action=""
						method="post">

						<input name="id" type="hidden" id="id"> <input
							name="title" type="hidden" id="title">


						<div class="form-group">
							<label class="col-sm-2 control-label" for="content">详&nbsp;&nbsp;&nbsp;情</label>
							<div class="col-sm-10">

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
							<div class="col-sm-6"></div>
							<div class="col-sm-2">
								<button id="add-btn" type="submit"
									class="btn btn-primary btn-single btn-sm">更 新</button>
							</div>
						</div>


					</form>

				</div>
			</div>
			<!--新增关于表单结束-->








			<!--主体部分结束-->
			<%@ include file="footer.jsp"%>
		</div>



	</div>


	<div class="page-loading-overlay">
		<div class="loader-2"></div>
	</div>

	<link rel="stylesheet" href="resources/js/select2/select2.css">
	<link rel="stylesheet" href="resources/js/select2/select2-bootstrap.css">

	<%@ include file="script.jsp"%>
	<script src="resources/js/jquery.uploadifive.js"></script>
	<script src="resources/js/select2/select2.min.js"></script>
	<script src="resources/js/jquery-ui/jquery-ui.min.js"></script>
	<script src="resources/js/selectboxit/jquery.selectBoxIt.min.js"></script>
	<script src="resources/js/multiselect/js/jquery.multi-select.js"></script>

	<link rel="stylesheet" href="resources/js/wangEditor/css/wangEditor-1.3.12.css">
	<script src="resources/js/wangEditor/js/wangEditor-1.3.12.min.js"></script>


	
	<script type="text/javascript">
		$().ready(function() {

		

					
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

    
  	$(document).on("click","#btnBrowse",function(){
						$("#real-input:last").click();
					});

  	 $('#content_upload').uploadifive({
  			'width'           : 75,                 // The width of the button
  			'height'          : 30,                 // The height of the button
  	        'auto' : true,   //取消自动上传 
  	        'uploadScript' : 'util/upload-image', //处理上传文件Action路径 
  	        'fileObjName'  : 'file',        //文件对象
	        'buttonText'   : '上传详情图片',   //按钮显示文字 
	        'queueID'      : 'tip-queue-2', //drug and drop box's ID 
	        'fileType'     : 'image/jpg,image/jpeg,image/png',   //允许上传文件类型 
	        'fileSizeLimit'   : '20MB',                  // Maximum allowed size of files to upload
	        'formData'     : {"folder":"about"},//The other data want to send
	        'queueSizeLimit'  : 100,                  //The maximum number of files in drup and drop box 
            'simUploadLimit'  : 100,                  // The maximum number of files to upload at once
            'uploadLimit'     : 100,                  // The maximum number of files you can upload
	        'onUploadComplete' : function(file, data) { //文件上传成功后执行 
	        				var basePath = "<%=basePath%>";
							var url = basePath + $.parseJSON(data);
							// $("#content").append('<img src="'+url+'">');
							editor.command(event, 'insertHTML', '<img src="' + url + '"/>');
							$("#real-input:first").remove();
						}

					});








					//载入时
					edit();

					//类型改变时
					$("#qry-type").change(function() {
						edit();
					});

					//编辑
					function edit() {
						var id = $('#qry-type').val();
						$.ajax({
							url : 'about/get-one?id=' + id,
							type : 'post',
							dataType : 'json',
							success : function(data) {
								$("#id").val(data.id);
								$("#title").val(data.title);
								$(".wangEditor-textarea").html(data.content);
								$("#content").html(data.content);
								
								$("#typeSelectBoxItText").attr("data-val",data.id).html(data.title);
							}
						});
					}


					

					$(document).on("click",".edui-icon-image",function(){
						$("#real-input:last").click();
					});
					

				

//更新
	$("#add-form").validate({
							// Form Processing via AJAX
							submitHandler: function(form)
							{
								$("#add-form").ajaxSubmit({
					                url:'about/update',
					                type:'post',
					                dataType:'json',
					                success:function(data){
					                    if (data!=0) {
					                    	alert("保存成功...");
					                    }else{
					                    	alert("保存出错...");
					                    };
					                }
					            });
							}
						});



 	  

});
	</script>
</body>
</html>