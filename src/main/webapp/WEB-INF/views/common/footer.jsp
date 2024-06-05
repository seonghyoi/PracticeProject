<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    /* div{border:1px solid red;} */
    #footer{
        width:90%;
        height:200px;
        margin:auto;
        margin-top:50px;
    }
    #footer-1{
        width:90%;
        height:20%;
        border-top:1px solid lightgray;
        border-bottom:1px solid lightgray;
    }
    #footer-2{
        width:100%;
        height:80%;
    }
    #footer-1, #footer-2{
        padding-left:50px
    }

    #footer-1 > a{
        text-decoration:none;
        font-weight: 600;
        margin:10px;
        line-height: 40px;
        color: black;
    }
    #footer-2>p{
        margin: 0;
        padding:10px;
        font-size: 13px;
    }
    #p2{
        text-align:center;
    }
</style>
</head>
<body>
	<div id="footer">
        <div id="footer-1">
            <a href="#">오늘도</a> | 
            <a href="#">행복한</a> | 
            <a href="#">하루</a> | 
            <a href="#">되세요</a> 
        </div>

        <div id="footer-2">
            <p id="p1">
                본사: 서울특별시 용산구 어딘가 <br>
                지점: 광주광역시 광산구 어딘가 <br>
            </p>
            <p id="p2">Copyright ⓒ 2024 by ksh318.dev. All Rights Reserved.</p>     
        </div>
    </div>
</body>
</html>