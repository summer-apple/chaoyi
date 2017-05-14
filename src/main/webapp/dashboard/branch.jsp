<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>





<html lang="en">
<head>
<base href="<%=basePath%>">
<%@ include file="meta.jsp" %>

<%@ include file="css.jsp" %>
<style type="text/css">



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
					<h1 class="title">分店-${store.storeName}</h1>
					<p class="description">query edit or create  news</p>
			</div>
				<div class="breadcrumb-env">

					<ol class="breadcrumb bc-1">
						<li><a href="dashboard/home"><i class="fa-home"></i>主页</a></li>
						<li class="active"><strong>查询新闻</strong></li>
					</ol>

				</div>

			</div>


<!--主体部分开始-->








			<div class="add-panel panel panel-default" style="display: block;">
						<div class="panel-heading">
							<h3 class="panel-title">进货单</h3>
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
							<div class="row">
								<label class="col-sm-2 control-label" style="text-align: right;" for="order-goods-table">商&nbsp;&nbsp;&nbsp;品</label>
								<div class="col-sm-10">
									<table id="order-goods-table" class="table table-bordered table-striped table-condensed table-hover">
										<thead><tr>
											<th>图片</th>
											<th>子商品ID</th>
											<th>商品ID</th>
											<th>商品编号</th>
											<th>型号</th>
											<th>价格</th>
											<th>数量</th>
											<th>操作</th>
										</tr></thead>

										<tbody>
											<tr>

												<td class="imgUrl"><img style="width: 75px;height:75px;" src="http://www.hzcycs.com/upload/201704/27/201704271400102998.JPG"></td>
												<td class="subGoodsId">231323</td>
												<td class="goodsId">111</td>
												<td class="goodsNo">bh59</td>
												<td class="model">分类10</td>
												<td class="price">100.00</td>
												<td class="quantity">3</td>
												<td>
													<a href="javascript:void(0);">删除</a>
												</td>
											</tr>
											<tr>

												<td class="imgUrl"><img style="width: 75px;height:75px;" src="http://www.hzcycs.com/upload/201704/27/201704271400102998.JPG"></td>
												<td class="subGoodsId">231323</td>
												<td class="goodsId">111</td>
												<td class="goodsNo">bh59</td>
												<td class="model">分类10</td>
												<td class="price">100.00</td>
												<td class="quantity">3</td>
												<td>
													<a href="javascript:void(0);">删除</a>
												</td>
											</tr>
											<tr>

												<td class="imgUrl"><img style="width: 75px;height:75px;" src="http://www.hzcycs.com/upload/201704/27/201704271400102998.JPG"></td>
												<td class="subGoodsId">231323</td>
												<td class="goodsId">111</td>
												<td class="goodsNo">bh59</td>
												<td class="model">分类10</td>
												<td class="price">100.00</td>
												<td class="quantity">3</td>
												<td>
													<a href="javascript:void(0);">删除</a>
												</td>
											</tr>
											<tr>

												<td class="imgUrl"><img style="width: 75px;height:75px;" src="http://www.hzcycs.com/upload/201704/27/201704271400102998.JPG"></td>
												<td class="subGoodsId">231323</td>
												<td class="goodsId">111</td>
												<td class="goodsNo">bh59</td>
												<td class="model">分类10</td>
												<td class="price">100.00</td>
												<td class="quantity">3</td>
												<td>
													<a href="javascript:void(0);">删除</a>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<form id="add-form" role="form" class="form-horizontal" action="" method="post">


								<div class="form-group">
									<label class="col-sm-2 control-label" for="addressName">收件人</label>
									
									<div class="col-sm-10">
										<input name="addressName" type="text" class="form-control" id="addressName" placeholder="收件人">
										
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label" for="addressPhone">手&nbsp;&nbsp;&nbsp;机</label>

									<div class="col-sm-10">
										<input name="addressPhone" type="text" class="form-control" id="addressPhone" placeholder="11位手机号码">

									</div>
								</div>
								

								
								
								<div class="form-group">
									<label class="col-sm-2 control-label" for="addressDetail">地&nbsp;&nbsp;&nbsp;址</label>
									
									<div class="col-sm-10">
										<input name="addressDetail" type="text" maxlength="50" class="form-control" id="addressDetail" placeholder="详细地址：X省X市X县X街道X号">
									</div>
								</div>

								
								
								<div class="form-group">
									<div class="col-sm-2">
									</div>
									<div class="col-sm-10" style="text-align: center;">
										<a id="submit-order" href="javascript:void(0);" class="btn btn-primary btn-single btn-sm">提 交</a>
										<a id="close-order" href="javascript:void(0);" class="btn btn-primary btn-single btn-sm">取 消</a>
									</div>
								</div>
								
								
							</form>
							
						</div>
					</div>
<!--购物车结束-->

			<div class="panel panel-default">
				
				<div class="row">

					<div class="col-sm-8">
						<form class="form-inline" id="qry-form" action="" method="post">
							<div class="row">
								<div class="form-group col-sm-4" style="min-width: 150px;">
									<script type="text/javascript">
										jQuery(document).ready(function($)
										{
											$("#qry-categoryId").selectBoxIt().on('open', function()
											{
												// Adding Custom Scrollbar
												$(this).data('selectBoxSelectBoxIt').list.perfectScrollbar();
											});
										});
									</script>
									<div class="col-sm-12">
										<select name="categoryId" class="form-control" id="qry-categoryId" style="display: none;">
											<option value="105" selected>商品类目</option>
											<option value="0" >商品类目2</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<input id="qry-goodsNo" name="goodsNo" class="form-control" type="text" placeholder="商品编号" value="bh">
								</div>
								<div class="form-group">
									<button id="qry-btn" type="button" class="btn btn-primary btn-single btn-sm">查 询</button>
								</div>

							</div>
						</form>

					</div>

					
					
				
				</div>

				<table id="test-table"></table>


				

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
	<!-- <script src="resources/js/ckeditor/ckeditor.js"></script> -->
	<!-- <script src="resources/js/ckeditor/adapters/jquery.js"></script> -->

	<script src="resources/js/select2/select2.min.js"></script>
	<script src="resources/js/jquery-ui/jquery-ui.min.js"></script>
	<script src="resources/js/selectboxit/jquery.selectBoxIt.min.js"></script>
	<script src="resources/js/multiselect/js/jquery.multi-select.js"></script>


	<link rel="stylesheet" href="resources/js/wangEditor/css/wangEditor-1.3.12.css">
	<script src="resources/js/wangEditor/js/wangEditor-1.3.12.min.js"></script>

	<script type="text/javascript">
	$().ready(function(){

		$.ajax({
			url: 'goods/category',
			method:'get',
			dataType: 'json',
			success:function(data){
				$.each(data, function (i,item) {
					$("#qry-categoryId").append("<opthon value='"+item.categoryId+"'>"+item.categoryName+"</option>")
				});
			}
		});




		$(function () {

			//1.初始化Table
			var oTable = new TableInit();
			oTable.Init();

			//2.初始化Button的点击事件
			/* var oButtonInit = new ButtonInit();
			 oButtonInit.Init(); */

		});

		var responseHandler = function (e) {
			if (e.retCode == 0 && e.retContent.numberOfElements > 0) {
				return { "rows": e.retContent.content, "total": e.retContent.totalElements };
			}
			else {
				return { "rows": [], "total": 0 };
			}

		}

		var imgFormatter = function (res) {
			var html = "<img style='width: 75px;height:75px;' src='"+ res + "'>";
			return html;
		}

		var numFormatter = function (subGoodsId) {
			return "<input type='number' value='1' min='1' id='"+ subGoodsId +"'>"
		}

		var btnFormatter = function (lst) {
			return "<a href='javascript:void(0);'>加入订货单</a>"
		}


		var TableInit = function () {
			var oTableInit = new Object();
			//初始化Table
			oTableInit.Init = function () {
				$('#test-table').bootstrapTable({
					url: 'goods/filter',     //请求后台的URL（*）
					method: 'post',           //请求方式（*）
					contentType: 'application/x-www-form-urlencoded',
					toolbar: $('#toolbar'),        //工具按钮用哪个容器
					striped: true,           //是否显示行间隔色
					cache: false,            //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
					pagination: true,          //是否显示分页（*）
					sortable: false,           //是否启用排序
					sortOrder: "asc",          //排序方式
					queryParams: oTableInit.queryParams,//传递参数（*）
					sidePagination: "server",      //分页方式：client客户端分页，server服务端分页（*）
					pageNumber:1,            //初始化加载第一页，默认第一页
					//pageSize: 50,            //每页的记录行数（*）
					pageList: [10, 25, 50, 100],    //可供选择的每页的行数（*）
					strictSearch: false,
					clickToSelect: true,        //是否启用点击选中行
					//height: 460,            //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
					uniqueId: "goodsId",           //每一行的唯一标识，一般为主键列
					cardView: false,          //是否显示详细视图
					detailView: true,          //是否显示父子表
					paginationPreText: "上一页",
					paginationNextText: "下一页",
					paginationFirstText: "首页",
					paginationLastText: "尾页",
					smartDisplay: false,
					responseHandler: responseHandler,
					columns: [{
						field: 'imgUrl',
						title: '图片',
						formatter: imgFormatter
					}, {
						field: 'goodsId',
						title: '商品ID',
						visible: false
					}, {
						field: 'goodsNo',
						title: '商品编号'
					}, {
						field: 'categoryName',
						title: '分类'

					}, {
						field: 'categoryId',
						title: '分类ID',
						visible: false

					}],
					//注册加载子表的事件。注意下这里的三个参数！
					onExpandRow: function (index, row, $detail) {
						InitSubTable(index, row, $detail);
					}
				});
			};


			//初始化子表格
			var InitSubTable = function (index, row, $detail) {
				var parentid = row.goodsId;
				var cur_table = $detail.html('<table></table>').find('table');
				$(cur_table).bootstrapTable({
					data: row.subGoodses,
					striped: true,           //是否显示行间隔色
					uniqueId: "subGoodsId",
					columns: [  {
						field: 'imgUrl',
						title: '图片',
						formatter: imgFormatter
					}, {
						field: 'subGoodsId',
						title: '子商品ID'
					}, {
						field: 'model',
						title: '型号'
					}, {
						field: 'price',
						title: '价格'
					}, {
						title: '数量',
						formatter: numFormatter
					}, {
						title: '操作',
						formatter: btnFormatter
					}, {
						field: 'goodsId',
						title: '商品ID',
						visible: false
					}, {
						field: 'goodsNo',
						title: '商品编号',
						visible: false
					} ]
				});
			};


			//得到查询的参数
			oTableInit.queryParams = function (params) {
				var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					size: params.limit,  //页面大小
					page: Math.ceil(params.offset / params.limit) + 1, //页码
					goodsNo: $("#qry-goodsNo").val(),
					categoryId: $("#qry-categoryId").val()
				};
				return temp;
			};
			return oTableInit;
		};



		$('#submit-order').click(function () {
			var transOrder = new Object();
			transOrder.addressName = $('#addressName').val();
			transOrder.addressPhone = $('#addressPhone').val();
			transOrder.addressDetail = $('#addressDetail').val();

			var orderGoods = new Array();
			$('#order-goods-table tbody tr').each(function(index){
				var goods = new Object();
				goods.imgUrl = $(this).find($('.imgUrl img')).attr('src');
				goods.subGoodsId = $(this).find($('.subGoodsId')).html();
				goods.goodsId = $(this).find($('.goodsId')).html();
				goods.goodsNo = $(this).find($('.goodsNo')).html();
				goods.model = $(this).find($('.model')).html();
				goods.price = $(this).find($('.price')).html();
				goods.quantity = $(this).find($('.quantity')).html();
				orderGoods.push(goods);
			});
			transOrder.orderGoodses = orderGoods;
			console.log(JSON.stringify(transOrder));

			$.ajax({
				url:'trans-order/create',
				data: JSON.stringify(transOrder),
				type:'post',
				contentType: 'application/json',
				dataType:'json',
				success:function(data){
					console.log(data);
				}
			});


		});














//查询方法
		function qry(initPageFlag){
            $.ajax({
                url:'news/qry-for-admin',
                data: {'pageNo':$('#pageNo').val(),'pageSize':$('#pageSize').val(),'type':$("#qry-type").val()},
                type:'post',
                dataType:'json',
                success:function(data){
                    $("#qry-table tbody").empty();
                    
                	$.each(data.list, function(i, item) {
                		 $("#qry-table tbody").append(
                		'<tr class="news-'+item.id+'">'+
						'	<td class="news-id">'+item.id+'</td>'+
						'	<td class="news-type">'+item.typeValue+'</td>'+
						'	<td class="news-title">'+item.title+'</td>'+
						'	<td class="news-weight">'+item.weight+'</td>'+
						'	<td class="news-brief" style="max-width:400px;">'+item.brief+'</a></td>'+
						'	<td class="news-headimg"><a href="'+item.headimg+'"><img src="'+item.headimg+'" style="width:50px;"></a></td>'+
						'	<td class="news-time">'+transTime(item.time,true)+'</td>'+
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


//添加
	$("#add-form").validate({
							rules: {
								title: {
									required: true,
									maxlength:30
								},
								
								weight: {
									//required: true,
									number:true,
									max:11,
									min:0
								},
								
								brief: {
									//required: true,
									maxlength:150
								},
								
								headimg: {
									required: true
								}
							},
							
							messages: {
								title: {
									required: '必填项目',	
									maxlength:'最多30个汉字'
								},
								
								weight: {
									//required: '必填项目',
									number:'必须为非负整数',
									max:'最大值为11',
									min:'最小值为0'
								},

								brief: {
									//required: '必填项目',
									maxlength:'最多150个汉字'
								},
								
								headimg: {
									required: '必填项目'
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
									$url ='news/add';
								}else{
									$url ='news/update';
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
                url:'news/del?id='+$id,
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
		$(".img-show").html("	");
		$(".add-panel .panel-title").html("新增新闻");
		$("#content").val("");
		$(".wangEditor-textarea").html("");
		$("#add-btn").show();
		$("#update-btn").hide();
		$(".add-panel").show();
	});

//编辑
	window.edit = function(id){
		$("#add-form")[0].reset();
		$(".add-panel .panel-title").html("更新新闻");
		
		$("#add-btn").hide();
		$("#update-btn").show();

		$.ajax({
                url:'news/get-one?id='+id,
                type:'post',
                dataType:'json',
                success:function(data){
                	$("#id").val(data.id);
                	$("#title").val(data.title);
                	$("#brief").val(data.brief);
                	$("#weight").val(data.weight);
                	$("#content").val(data.content);
                	$(".wangEditor-textarea").html(data.content);
                	$("#headimg").val(data.headimg);
                	$(".img-show").html('<img src="'+data.headimg+'" style="width:100%;">');
                	$("#typeSelectBoxItText").attr("data-val",data.type).html(data.typeValue);
                	$("#type").val(data.type);
                	//alert($("#add-form").find("#typeSelectBoxItOptions li[data-val='"+data.type+"']").attr("data-val"));
                	//$("#add-form").find("#typeSelectBoxItOptions li[data-val='"+data.type+"']").click();
                }
            });
		
		$(".add-panel").show();
	}//333





});	

	</script>
</body>
</html>