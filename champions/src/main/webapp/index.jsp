<html>
<meta charset="UTF-8">
<title>champions</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<body>
    <script src="js/jquery-1.11.1.js" type="text/javascript">
    </script>
    <script type="text/javascript">

        function all() {
            $.ajax({
                url:"/player/all",
                type:"get",
                contentType: "application/json",
                dataType:"json",
                success: function(){

                }
            });
        }

        function page() {
            var params = {
                page: 1,
                size: 3,
                searchParams: {
                    "name_like":"x"
                },
                sort: {
                    "birthPlace": "asc"
                }
            };
            $.ajax({
                url:"/player/page",
                type:"post",
                contentType: "application/json",
                data:JSON.stringify(params),
                dataType:"json",
                success: function(){

                }
            });
        }

        page();

    </script>
</body>
</html>
