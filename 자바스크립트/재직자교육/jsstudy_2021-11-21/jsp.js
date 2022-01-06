    // var sampleUrl = "http://reze.com/search?name=로제&age=24&hobby=노래&hobby=춤&hobby=기타";
    // var query = sampleUrl.split("?")[1];
    // var params = query.split("&");
    // var name = params[0].split("=")[1];
    
    var request = {};

    request.getParameter = function(name) {
        var sampleUrl = location.href;

        if(sampleUrl.indexOf("?") < 0)
        {
            return null;
        }
        // var query = sampleUrl.split("?")[1];
        var query = location.href.split("?")[1];
        var params = query.split("&");

        var valueArray = [];

        for(let i = 0; i < params.length; i++)
        {
            var key = params[i].split("=")[0];
            var value = params[i].split("=")[1];
            if(key == name) {
                value = decodeURIComponent(value);
                valueArray.push(value);
            }
        }
        if(!valueArray.length) 
        {
            return null;
        }
        return valueArray; // 못 찾았을 때, 디폴트 값 설정
    }
   
    var out = {};
    out.print = function(msg) {
        document.write(msg);
    }
    out.println = function(msg) {
        document.writeln(msg);
    }