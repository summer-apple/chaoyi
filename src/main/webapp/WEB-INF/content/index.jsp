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
<form id="login">
    <input type="text" id="username" placeholder="username">
    <input type="text" id="password" placeholder="password">
    <button type="submit">Login</button>
</form>

<script>
    $().ready(function () {
//        $.ajax({
//            url:'user/login',
//            type:'POST',
//            data:{"username":"xiadong","password":"xiadong"},
//            contentType:"application/json",  //发送至服务器的类型
//            dataType : "json",
//            success:function (data) {
//                alert(data);
//            }
//        });

        $('#login').validate({
            rules:{
                username:{
                    required:true
                },
                passowrd:{
                    required:true
                }
            },
            messages:{
                username:{
                    required:'啊啊啊啊啊啊啊'
                },
                passowrd:{
                    required:'aaaaaaaaaaaa'
                }
            },
            submitHandler:function (form) {
                $("#login").ajaxSubmit({
                    url:'user/login',
                    type:'post',
                    dataType:'json',
                    success:function(data){
                        $('body').append(data);
                    }
                });
            }
        });


    });
</script>
</body>
</html>
