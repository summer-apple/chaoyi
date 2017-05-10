  <%--
  Created by IntelliJ IDEA.
  User: summer
  Date: 16-8-15
  Time: 上午11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Drartisan</title>
    <script src="//cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
    <script src="//cdn.bootcss.com/jquery.form/4.2.1/jquery.form.min.js"></script>
</head>
<body>

    <input type="text" id="goodsNo" placeholder="goodsNo">
    <input type="int" id="cagegoryId" placeholder="cagegoryId">
    <button id="btn" type="submit">search</button>


<script>
    $().ready(function () {
        var subGoodses = [{'subGoodsId':1,'goodsId':10,'goodsNo':'55','model':'222','price':34.56,'imgUrl':'urlll'},{'subGoodsId':1,'goodsId':10,'goodsNo':'55','model':'222','price':34.56,'imgUrl':'urlll'}];
        var goods = {'goodsNo':'55','categoryId':60,'categoryName':'aaa','goodsId':10,imgUrl:'urlllll'};
        goods['subGoodses'] = subGoodses;
        var param = new Object();
        param['goods'] = goods;
        param['subGoodses'] = subGoodses;
        console.log(JSON.stringify(goods));
        $.ajax({
            url:'goods/obj',
            data: JSON.stringify(goods),
            type:'post',
            contentType: 'application/json',
            dataType:'json',
            success:function(data){
                console.log(data);
            }
        });

//        $.ajax({
//            url:'goods/obj',
//            data: {'goodsNo':'55','categoryId':60,'categoryName':'aaa','goodsId':10,imgUrl:'urlllll'},
//            type:'post',
//            dataType:'json',
//            success:function(data){
//                console.log(data);
//            }
//        });


        $('#btn').click(function (data) {

            var goodsNo = $('#goodsNo').val();
            var categoryId = $('#cagegoryId').val();
            var kvs = new Object({'goodsNo':goodsNo,'categoryId':categoryId});
            var param = new Object({'kvs':kvs,'page':1,'size':10});
            console.log(JSON.stringify(param));

            $.ajax({
                url:'goods/kvs',
                data: {'goodsNo':'55','categoryId':'60','page':1,'size':10},
                type:'post',
                dataType:'json',
                success:function(data){
                    console.log(data);
                }
            })

        });


    });
</script>
</body>
</html>
