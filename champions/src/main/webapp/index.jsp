<html>
<meta charset="UTF-8">
<title>champions</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<body>
    <script src="js/jquery-1.11.1.js" type="text/javascript">
    </script>
    <script type="text/javascript">
        $.ajax({
            url: "http://localhost:8080/champions/player/save",
            type: "post",
            data: {
                name: "xxxx"
            },
            dataType: "json",
            success: function(){

            }
        });
    </script>
</body>
</html>
