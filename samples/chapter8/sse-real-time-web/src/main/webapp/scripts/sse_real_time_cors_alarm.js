
/**
 * Created by waylau.com on 2015/8/22
 */

//判断浏览器是否支持 EventSource
if (typeof (EventSource) !== "undefined") {
    var source = new EventSource("http://192.168.11.220:8081/webapi/alarm-events?entId="+22);

    // 当通往服务器的连接被打开
    source.onopen = function(event) {
        console.log("连接开启！");

    };

    // 当接收到消息。只能是事件名称是 message
    source.onmessage = function(event) {
        console.log(event.data);
        var data = event.data;
        var lastEventId = event.lastEventId;
        document.getElementById("x").innerHTML += "\n" + 'lastEventId:'+lastEventId+';data:'+data;
    };

    //可以是任意命名的事件名称
    /*
    source.addEventListener('message', function(event) {
        console.log(event.data);
        var data = event.data;
        var lastEventId = event.lastEventId;
        document.getElementById("x").innerHTML += "\n" + 'lastEventId:'+lastEventId+';data:'+data;
    });
    */

    // 当错误发生
    source.onerror = function(event) {
        console.log("连接错误！");

    };
} else {
    document.getElementById("result").innerHTML = "Sorry, your browser does not support server-sent events..."
}