<html>
<head>
    <meta charset="utf-8"><meta>
    <title>操作失败</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="alert alert-dismissable alert-danger">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <h4>
                        失败!
                    </h4> <strong>${msg!""}!</strong>3秒后自动跳转！<a href="${url}" class="alert-link">手动跳转</a>
                </div>
            </div>
        </div>
    </div>
</body>

<script>
    setTimeout('location.href="${url}"', 3000);
</script>
</html>