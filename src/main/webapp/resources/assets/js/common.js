/**
 * Created by YJH on 2016/3/11.
 */

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

    append : function (str) {
        this._strings.push(str);
        return this;
    },

    clear : function () {
        this._strings.length = 0;
    },

    toString : function () {
        var str = (arguments.length == 0) ? "" : arguments[0];
        return this._strings.join(str);
    }
}


//设置cookie
function setCookie(name, value, expires){   //创建cookie
    var oDate = new Date();
    oDate.setDate(oDate.getDate() + 10);
    document.cookie = name + '=' + value + ';' + expires + '=' + oDate +";path =/";
};

function getCookie(name){   //获取cookie
    var cookieArr = document.cookie.split('; ');
    for(var i = 0; i < cookieArr.length; i++){
        var nameArr = cookieArr[i].split('=');
        if(nameArr[0] == name){
            return nameArr[1];
        }
    }
    return '';
};
function removeCookie(name){   //移除cookie
    setCookie(name, 'null', -1)
};
