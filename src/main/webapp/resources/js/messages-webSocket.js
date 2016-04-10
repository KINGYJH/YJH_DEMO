/**
 * Created by YJH on 2016/4/10 0010.
 */
$(function () {

    var sockjsAddr = "/messages_webSocket";
    var sockjsClient = null;

    var onopen = function () {
        console.log('open');
        $("#status").val("已连接");
    };
    var onmessage = function (e) {
        alert(e.data);
    };
    var onclose = function () {
        console.log('close');
        $("#status").val("未连接");
    };

    $("#socket_open").click(function () {
        $("#status").val("正在连接中...");
        sockjsClient = new SockJS(sockjsAddr);
        sockjsClient.onopen = onopen;
        sockjsClient.onmessage = onmessage;
        sockjsClient.onclose = onclose;
    });

    $("#socket_close").click(function () {
        if (sockjsClient != null) {
            sockjsClient.close();
            sockjsClient = null;
            $("#status").val("未连接");
        }
    });

    $("#socket_send").click(function () {
        if (null == sockjsClient) {
            alert("请先连接");
            return;
        }
        var message = "发送了一条消息";
        if (message.length <= 0) {
            return;
        }
        try {
            var isSendSuccess = sockjsClient.send(message);
            if (!isSendSuccess) {
                alert("发送失败");
            } else {
                $("#message").val("");
            }
        } catch (e) {
            alert("发送失败");
        }
    });

})