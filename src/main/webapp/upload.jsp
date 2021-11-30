<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" session="true" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload</title>
    <style>
    	@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}
body{
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  background: #F4F6FB;
}
.drag-area{
  border: 2px dashed black;
  height: 500px;
  width: 700px;
  border-radius: 5px;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}
.drag-area.active{
  border: 2px solid #fff;
}
.drag-area .icon{
  font-size: 100px;
  color: #fff;
}
.drag-area header{
  font-size: 30px;
  font-weight: 500;
  color: dark;
}
.drag-area span{
  font-size: 25px;
  font-weight: 500;
  color: dark;
  margin: 10px 0 15px 0;
}
.drag-area input{
  padding: 10px 25px;
  font-size: 20px;
  font-weight: 500;
  border: none;
  outline: none;
  background: #c8e6c9;
  color: #5256ad;
  border-radius: 5px;
  cursor: pointer;
}
.drag-area img{
  height: 100%;
  width: 100%;
  object-fit: cover;
  border-radius: 5px;
}
    </style>
</head>
<body>
	<form action="upload" method="post" enctype="multipart/form-data">
        
        <div class="drag-area">
    		<div class="icon"><i class="fas fa-cloud-upload-alt"></i></div>
    		<header>UPLOAD YOUR FILE</header>
    		<br>
    		<h3>Account: <%= request.getSession().getAttribute("user") == null ? "Unknown" : request.getSession().getAttribute("user").toString() %></h3>
        	<br>
        	<br>
        	<input class="input" type="file"name="file" >
        	<br>
        	<input type="submit" value="Submit">
        	<br>
        	<input type="reset" value="Reset">
        	<br>
        	<a href="index"><input type="button" value="Go back to home"></a>
    		
    		
  		</div>
    </form>
</body>
</html>



