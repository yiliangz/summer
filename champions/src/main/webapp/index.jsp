<html>
<meta charset="UTF-8">
<title>champions</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<body>
    <script src="js/jquery-1.11.1.js" type="text/javascript">
    </script>
    <script type="text/javascript">

        function get(url, params) {
            request(url, params, "get");
        }

        function post(url, params) {
            request(url, params, "post");
        }

        function request(url, params, type) {
            $.ajax({
                url: url,
                type: type,
                data:JSON.stringify(params),
                contentType: "application/json",
                dataType: "json",
                success: function (data) {
                    $("body").append(JSON.stringify(data));
                }
            });
        }

        function all() {
            get("/player/all",null);
        }

        function page() {
            var params = {
                page: 0,
                size: 5,
                searchParams: {
                    "team.name_like":"队"
                },
                sort: {
                    "birthPlace": "asc"
                }
            };
            post("/player/page",params);
        }

        function update() {
            var params = {
                city: "san antonio"
            };
            post(url,params);
        }

        page();

//        update();

//        all();
    </script>
</body>
</html>
