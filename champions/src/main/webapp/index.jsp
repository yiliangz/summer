<html>
<meta charset="UTF-8">
<title>champions</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<body>
    <script src="js/jquery-1.11.1.js" type="text/javascript">
    </script>
    <script type="text/javascript">
        var params = {"name": "name",address:"eesss"};
        $.ajax({
            url:"/player/all",
            type:"get",
            contentType: "application/json",
            data:JSON.stringify(params),
            dataType:"json",
            success: function(){

            }
        });
    </script>
</body>
</html>
