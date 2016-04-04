var G = {
    baseUrl: "",
    debug: "debug",             //调试logger组件
    browser: {},                //浏览器
    platform: {},               //操作系统
    errors: {                   //错误提醒
        "-1": "undefined error"
    },

    errorHandlers: {},          //colorbox_up start
    analysis: true,
    loadedScripts: {},
    ajaxLoadReturn: {},
    eventDepends: {},
    eventDependsParams: {},
    eventDependsTrigger: {},
    eventDependsHandlerMapping: {},
    eventDependsHandler: {},    //colorbox_up end

    tmp: {},                    //临时对象
    userinfo: {}               //用户信息
};

if (typeof(logger) == 'undefined') {
    var logger = {};
}
/**
 * 浏览器信息
 */
(function () {
    var userAgent = navigator.userAgent.toLowerCase();
    G.browser.version = (userAgent.match(/.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/) || [])[1];
    G.browser.msie = /msie/.test(userAgent) && !/opera/.test(userAgent);
    G.browser.mozilla = /mozilla/.test(userAgent) && !/(compatible|webkit)/.test(userAgent);
    G.browser.opera = /opera/.test(userAgent);
    G.browser.webkit = /webkit/.test(userAgent);

    // pre-hack for IE6
    if (G.browser.msie && parseInt(G.browser.version, 10) == 6) {
        try {
            document.execCommand("BackgroundImageCache", false, true);
        }
        catch (e) {
        }
    }
})();

/**
 * 操作系统信息
 */
(function () {
    if (typeof(navigator.platform) == "undefined") {
        G.platform.unknown = true;
    }
    else {
        var data = [
            {
                string: navigator.platform,
                subString: "Win",
                identity: "windows"
            },
            {
                string: navigator.platform,
                subString: "Mac",
                identity: "mac"
            },
            {
                string: navigator.platform,
                subString: "Linux",
                identity: "linux"
            }
        ];
        for (var i = 0; i < data.length; i++) {
            var dataString = data[i].string;
            if (dataString) {
                if (dataString.indexOf(data[i].subString) != -1) {
                    G.platform[data[i].identity] = true;
                }
            }
        }
    }
    G.platform.unkown = !!G.platform.unkown;
    G.platform.windows = !!G.platform.windows;
    G.platform.mac = !!G.platform.mac;
    G.platform.linux = !!G.platform.linux;
})();

/**
 * 日志封装
 */
(function () {
    logger._enable = typeof(console) != "undefined" && typeof(console.log) != "undefined";
    if (logger._enable) {
        if (typeof(console.log) == "function") {
            // here comes normal browsers, firefox and chrome
            logger._log = function () {
                try {
                    //console.log.apply(console, arguments);
                }
                catch (e) {
                }
            };
        } else if (typeof(console.log) == "object") {
            //  console.log in IE8 isn't a true Javascript function. It doesn't support the apply or call methods.
            logger._log = function () {
                try {
                    //console.log(Array.prototype.slice.call(arguments));
                }
                catch (e) {
                }
            };
        } else {
            // a blank function
            logger._log = function () {
            }();
        }
    } else {
        logger._log = function () {
        };
    }
    var debugLevels = {
        none: 0,
        debug: 1,
        info: 2,
        warn: 3,
        error: 4
    }
    var level = debugLevels[G.debug];
    if (typeof(level) == "undefined") {
        level = 0;
    }
    for (var func in debugLevels) {
        if (level > 0) {
            if (debugLevels[func] > 0) {
                if (debugLevels[func] >= level) {
                    logger[func] = function () {
                        logger._log.apply(logger, arguments);
                    };
                }
                else {
                    logger[func] = function () {
                    };
                }
            }
        } else {
            logger[func] = function () {
            };
        }
    }
})();

/**
 * 字符串拼接
 * @param str
 * @constructor
 */
function StringBuilder(str) {
    this._strings = new Array();
    if (typeof(str) != "undefined") {
        this.append(str);
    }
};

StringBuilder.prototype = {

    append: function (str) {
        this._strings.push(str);
        return this;
    },

    clear: function () {
        this._strings.length = 0;
    },

    toString: function () {
        var str = (arguments.length == 0) ? "" : arguments[0];
        return this._strings.join(str);
    }
}

$(document).ready(function () {

    //showAlert自动隐藏
    var _showAlert = $(".show-alert");
    var _showAlert_timeOut = 5;
    if (_showAlert[0]) {
        function doWork() {
            _showAlert.find(".time-message").text(_showAlert_timeOut + "秒后自动关闭");
            if (_showAlert_timeOut > 0) {
                setTimeout(doWork, 1000);
            } else {
                _showAlert.css("display", "none");
            }
            _showAlert_timeOut--;
        }

        setTimeout(doWork, 1000);
    }

    //水平滚动条
    var _scroll = $(".nice-scrollbar");   //容器

    if (_scroll[0]) {
        _scroll.niceScroll({
            cursorcolor: "#000000",
            zindex: 100,
            bouncescroll: true,
            cursoropacitymax: 0.4,
            cursorborderradius: "5px",
            cursorwidth: "8px"
        });
    }

    //设置cookie
    function setCookie(name, value, expires) {   //创建cookie
        var oDate = new Date();
        oDate.setDate(oDate.getDate() + 10);
        document.cookie = name + '=' + value + ';' + expires + '=' + oDate + ";path =/";
    };

    function getCookie(name) {   //获取cookie
        var cookieArr = document.cookie.split('; ');
        for (var i = 0; i < cookieArr.length; i++) {
            var nameArr = cookieArr[i].split('=');
            if (nameArr[0] == name) {
                return nameArr[1];
            }
        }
        return '';
    };

    function removeCookie(name) {   //移除cookie
        setCookie(name, 'null', -1)
    };

});
