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
<select name="categoryId" class="form-control" id="qry-categoryId" style="display: block;">
    <option value="0">所有分类</option>
    <opthon value="3">新手上路</opthon><opthon value="4">五大免费服务</opthon><opthon value="5">安全保障</opthon><opthon value="40">花边系列</opthon><opthon value="41">挂球系列</opthon><opthon value="42">艺术圈系列</opthon><opthon value="43">水晶花边</opthon><opthon value="44">珍珠花边</opthon><opthon value="45">杨梅球花边</opthon><opthon value="52">招商加盟</opthon><opthon value="53">线下体验店</opthon><opthon value="55">草莓花边</opthon><opthon value="56">包丝珠花边</opthon><opthon value="57">牛筋珠花边</opthon><opthon value="58">其他花边</opthon><opthon value="59">扭排花边</opthon><opthon value="60">排须花边</opthon><opthon value="61">绒珠花边</opthon><opthon value="69">布带、布钩系列</opthon><opthon value="70">装饰小边系列</opthon><opthon value="71">其他辅料</opthon><opthon value="72">关于我们</opthon><opthon value="73">产品介绍</opthon><opthon value="74">联系我们</opthon><opthon value="75">会员注册</opthon><opthon value="76">会员等级</opthon><opthon value="77">会员积分</opthon><opthon value="78">订货流程</opthon><opthon value="79">发票制度</opthon><opthon value="80">在线支付</opthon><opthon value="81">银行汇款</opthon><opthon value="82">账户余额</opthon><opthon value="83">产品包装</opthon><opthon value="84">物流商</opthon><opthon value="85">关于运费</opthon><opthon value="86">质量保证</opthon><opthon value="87">退换政策</opthon><opthon value="88">常见问题</opthon><opthon value="89">订货说明</opthon><opthon value="95">棉边</opthon><opthon value="96">蕾丝边</opthon><opthon value="97">水晶挂球</opthon><opthon value="98">手工挂球</opthon><opthon value="100">小边</opthon><opthon value="101">高档套系花边</opthon><opthon value="104">潮亿资讯</opthon><opthon value="105">装饰小吊穗</opthon><opthon value="106">墙钩系列</opthon><opthon value="107">窗纱、成品帘头系列</opthon><opthon value="108">水晶合金墙钩</opthon><opthon value="109">窗帘绑带</opthon><opthon value="110">窗纱帘头</opthon><opthon value="111">窗纱系列</opthon><opthon value="112">塑料墙钩</opthon><opthon value="113">树脂墙钩</opthon><opthon value="114">铁质墙钩</opthon><opthon value="115">印花艺术圈</opthon><opthon value="117">单色艺术圈</opthon><opthon value="118">玉石艺术圈</opthon><opthon value="119">布带系列</opthon><opthon value="120">造型艺术圈</opthon><opthon value="122">布钩系列</opthon><opthon value="126">更多辅料</opthon><opthon value="128">水晶扣</opthon><opthon value="129">膨胀螺丝</opthon><opthon value="130">铅线铅块</opthon><opthon value="138">吊穗花边</opthon><opthon value="139">珠子吊穗花边</opthon><opthon value="142">晚秋系列</opthon><opthon value="143">天空系列</opthon><opthon value="144">金玉满堂系列</opthon><opthon value="145">跳跃系列</opthon><opthon value="146">印象系列</opthon><opthon value="147">暖阳系列</opthon><opthon value="148">浮华系列</opthon><opthon value="149">魅惑系列</opthon><opthon value="150">淡雅系列</opthon><opthon value="152">水墨系列</opthon><opthon value="154">落樱系列</opthon><opthon value="155">伊人系列</opthon><opthon value="156">烟雨系列</opthon><opthon value="157">法式风情系列</opthon><opthon value="158">刺绣帘头套系</opthon><opthon value="159">刺绣中小宽边</opthon><opthon value="160">提花帘头套系</opthon><opthon value="161">提花中小宽边</opthon><opthon value="163">皇家系列</opthon><opthon value="164">欣欣向荣系列</opthon><opthon value="165">维多利亚系列</opthon><opthon value="166">古典华风系列</opthon><opthon value="167">绒绒系列</opthon><opthon value="168">巴洛克系列</opthon><opthon value="169">异域风情系列</opthon><opthon value="170">眉飞色舞系列</opthon><opthon value="171">炫彩系列</opthon><opthon value="172">缤纷系列</opthon><opthon value="173">瑞丽系列</opthon><opthon value="174">彩虹系列</opthon><opthon value="175">梦幻系列</opthon><opthon value="176">锦上添花系列</opthon><opthon value="177">珠宝系列</opthon><opthon value="178">丝滑系列</opthon><opthon value="180">简爱系列</opthon><opthon value="181">彩色果系列</opthon><opthon value="3">新手上路</opthon><opthon value="4">五大免费服务</opthon><opthon value="5">安全保障</opthon><opthon value="40">花边系列</opthon><opthon value="41">挂球系列</opthon><opthon value="42">艺术圈系列</opthon><opthon value="43">水晶花边</opthon><opthon value="44">珍珠花边</opthon><opthon value="45">杨梅球花边</opthon><opthon value="52">招商加盟</opthon><opthon value="53">线下体验店</opthon><opthon value="55">草莓花边</opthon><opthon value="56">包丝珠花边</opthon><opthon value="57">牛筋珠花边</opthon><opthon value="58">其他花边</opthon><opthon value="59">扭排花边</opthon><opthon value="60">排须花边</opthon><opthon value="61">绒珠花边</opthon><opthon value="69">布带、布钩系列</opthon><opthon value="70">装饰小边系列</opthon><opthon value="71">其他辅料</opthon><opthon value="72">关于我们</opthon><opthon value="73">产品介绍</opthon><opthon value="74">联系我们</opthon><opthon value="75">会员注册</opthon><opthon value="76">会员等级</opthon><opthon value="77">会员积分</opthon><opthon value="78">订货流程</opthon><opthon value="79">发票制度</opthon><opthon value="80">在线支付</opthon><opthon value="81">银行汇款</opthon><opthon value="82">账户余额</opthon><opthon value="83">产品包装</opthon><opthon value="84">物流商</opthon><opthon value="85">关于运费</opthon><opthon value="86">质量保证</opthon><opthon value="87">退换政策</opthon><opthon value="88">常见问题</opthon><opthon value="89">订货说明</opthon><opthon value="95">棉边</opthon><opthon value="96">蕾丝边</opthon><opthon value="97">水晶挂球</opthon><opthon value="98">手工挂球</opthon><opthon value="100">小边</opthon><opthon value="101">高档套系花边</opthon><opthon value="104">潮亿资讯</opthon><opthon value="105">装饰小吊穗</opthon><opthon value="106">墙钩系列</opthon><opthon value="107">窗纱、成品帘头系列</opthon><opthon value="108">水晶合金墙钩</opthon><opthon value="109">窗帘绑带</opthon><opthon value="110">窗纱帘头</opthon><opthon value="111">窗纱系列</opthon><opthon value="112">塑料墙钩</opthon><opthon value="113">树脂墙钩</opthon><opthon value="114">铁质墙钩</opthon><opthon value="115">印花艺术圈</opthon><opthon value="117">单色艺术圈</opthon><opthon value="118">玉石艺术圈</opthon><opthon value="119">布带系列</opthon><opthon value="120">造型艺术圈</opthon><opthon value="122">布钩系列</opthon><opthon value="126">更多辅料</opthon><opthon value="128">水晶扣</opthon><opthon value="129">膨胀螺丝</opthon><opthon value="130">铅线铅块</opthon><opthon value="138">吊穗花边</opthon><opthon value="139">珠子吊穗花边</opthon><opthon value="142">晚秋系列</opthon><opthon value="143">天空系列</opthon><opthon value="144">金玉满堂系列</opthon><opthon value="145">跳跃系列</opthon><opthon value="146">印象系列</opthon><opthon value="147">暖阳系列</opthon><opthon value="148">浮华系列</opthon><opthon value="149">魅惑系列</opthon><opthon value="150">淡雅系列</opthon><opthon value="152">水墨系列</opthon><opthon value="154">落樱系列</opthon><opthon value="155">伊人系列</opthon><opthon value="156">烟雨系列</opthon><opthon value="157">法式风情系列</opthon><opthon value="158">刺绣帘头套系</opthon><opthon value="159">刺绣中小宽边</opthon><opthon value="160">提花帘头套系</opthon><opthon value="161">提花中小宽边</opthon><opthon value="163">皇家系列</opthon><opthon value="164">欣欣向荣系列</opthon><opthon value="165">维多利亚系列</opthon><opthon value="166">古典华风系列</opthon><opthon value="167">绒绒系列</opthon><opthon value="168">巴洛克系列</opthon><opthon value="169">异域风情系列</opthon><opthon value="170">眉飞色舞系列</opthon><opthon value="171">炫彩系列</opthon><opthon value="172">缤纷系列</opthon><opthon value="173">瑞丽系列</opthon><opthon value="174">彩虹系列</opthon><opthon value="175">梦幻系列</opthon><opthon value="176">锦上添花系列</opthon><opthon value="177">珠宝系列</opthon><opthon value="178">丝滑系列</opthon><opthon value="180">简爱系列</opthon><opthon value="181">彩色果系列</opthon></select>
    <input type="text" id="goodsNo" placeholder="goodsNo">
    <input type="int" id="cagegoryId" placeholder="cagegoryId">
    <button id="btn" type="submit">search</button>


<script>
    $().ready(function () {

        // 复杂参数
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





        var transOrder = {
            "addressName": "3",
            "addressPhone": "3",
            "addressDetail": "3",
            "orderId": 0,
            "branchStoreId": 0,
            "mainStoreId": 0,
            "totalPrice": 0,
            "createTime": "",
            "sendTime": "",
            "reciveTime": "",
            "transOrder": "",
            "stat": "0",
            "orderGoodses": [
                {
                    "id": 0,
                    "orderId": "0",
                    "imgUrl": "http://www.hzcycs.com/upload/201704/27/201704271400102998.JPG",
                    "subGoodsId": 231323,
                    "goodsId": 111,
                    "goodsNo": "bh59",
                    "model": "分类10",
                    "price": 100.00,
                    "quantity": 3
                },
                {
                    "id": 0,
                    "orderId": "0",
                    "imgUrl": "http://www.hzcycs.com/upload/201704/27/201704271400102998.JPG",
                    "subGoodsId": 231323,
                    "goodsId": 111,
                    "goodsNo": "bh59",
                    "model": "分类10",
                    "price": 100.00,
                    "quantity": 3
                },
                {
                    "id": 0,
                    "orderId": "0",
                    "imgUrl": "http://www.hzcycs.com/upload/201704/27/201704271400102998.JPG",
                    "subGoodsId": 231323,
                    "goodsId": 111,
                    "goodsNo": "bh59",
                    "model": "分类10",
                    "price": 100.00,
                    "quantity": 3
                },
                {
                    "id": 0,
                    "orderId": "0",
                    "imgUrl": "http://www.hzcycs.com/upload/201704/27/201704271400102998.JPG",
                    "subGoodsId": 231323,
                    "goodsId": 111,
                    "goodsNo": "bh59",
                    "model": "分类10",
                    "price": 100.00,
                    "quantity": 3
                }
            ]
        };



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












        //简单参数
        $('#btn').click(function (data) {

            var goodsNo = $('#goodsNo').val();
            var categoryId = $('#cagegoryId').val();


            console.log(JSON.stringify(param));

            $.ajax({
                url:'goods/filter',
                data: {'goodsNo':goodsNo,'categoryId':categoryId,'page':1,'size':10},
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
