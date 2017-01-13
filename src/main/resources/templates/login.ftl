<!DOCTYPE html>
<html lang="zh-CN"
      xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta charset="UTF-8" />
    <title></title>
</head>
<body>

<h1>登录页面</h1>
<form action="${base}/signin" method="post">
    <label>用户名：</label><input name="name" /></br>
    <label>密  码：</label><input name="password" /></br>
    <input type="submit" placeholder="signIn" />
</form>
</body>
</html>