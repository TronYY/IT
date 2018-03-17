var IE = navigator.userAgent.indexOf("MSIE")>0? 1: 0;
var HOST = "http://stat.doc88.com";
var getArgs=(function()
{
    var sc=document.getElementsByTagName('script');
    var paramsArr=sc[sc.length-1].src.split('?')[1].split('&');
    var args={},argsStr=[],param,t,name,value;
    for(var ii=0,len=paramsArr.length;ii<len;ii++)
    {
            param=paramsArr[ii].split('=');
            name=param[0],value=param[1];
            if(typeof args[name]=="undefined")
            { //参数尚不存在
                args[name]=value;
            }
            else if(typeof args[name]=="string")
            { //参数已经存在则保存为数组
                args[name]=[args[name]]
                args[name].push(value);
            }
            else
            {  //已经是数组的
                args[name].push(value);
            }
    }
    return function()
    {
    	return args;
    } //以json格式返回获取的所有参数
})();


$(document).ready(function(){
initCount();
});

function detectBrowser()
{
	try
	{
		if(window.external && window.external.max_version)
		{
			return "Maxthon";
		}
	}
	catch(e)
	{
		
	}
	var Sys = {}; 
	var ua = navigator.userAgent.toLowerCase(); 
	var s; 
	(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] : 
	(s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] : 
	(s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] : 
	(s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] : 
	(s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0; 
	if (Sys.ie) 
	{
		return "IE: "+Sys.ie; 
	}
	if (Sys.firefox) 
		return "Firefox";
	if (Sys.chrome)
	{
		
		return "Chrome";
	}
	if (Sys.opera)
		return "Opera";
	if (Sys.safari)
		return "Safari";
	return "UnKnow";
}
function detectOS()
{
	var sUserAgent = navigator.userAgent;
	var isWin = (navigator.platform == "Win32") || (navigator.platform == "Windows");     
	var isMac = (navigator.platform == "Mac68K") || (navigator.platform == "MacPPC") || (navigator.platform == "Macintosh") || (navigator.platform == "MacIntel");
	if (isMac) return "Mac";      
	var isUnix = (navigator.platform == "X11") && !isWin && !isMac;      
	if (isUnix) return "Unix";     
	var isLinux = (String(navigator.platform).indexOf("Linux") > -1); 
	if (isLinux) return "Linux"; 
	if (isWin) 
	{  
		var isWin2K = sUserAgent.indexOf("Windows NT 5.0") > -1 || sUserAgent.indexOf("Windows 2000") > -1; 
		if (isWin2K) return "Win2000"; 
		var isWinXP = sUserAgent.indexOf("Windows NT 5.1") > -1 || sUserAgent.indexOf("Windows XP") > -1; 
		if (isWinXP) return "WinXP";          
		var isWin2003 = sUserAgent.indexOf("Windows NT 5.2") > -1 || sUserAgent.indexOf("Windows 2003") > -1;          
		if (isWin2003) return "Win2003";          
		var isWin2003 = sUserAgent.indexOf("Windows NT 6.0") > -1 || sUserAgent.indexOf("Windows Vista") > -1; 
		if (isWin2003) return "WinVista"; 
		var isWin2003 = sUserAgent.indexOf("Windows NT 6.1") > -1 || sUserAgent.indexOf("Windows 7") > -1;  
		if (isWin2003) return "Win7"; 
	}     
	return "UnKnow";  
}
function initCount()
{
	var c = getArgs()["c"];
	if(c==undefined)
		c = "";
	var visitor_member_id = getArgs()["vm"];
	if(visitor_member_id==undefined)
		visitor_member_id = "0";
	var member_id = getArgs()["m"];
	if(member_id==undefined)
		member_id = "0";
	var url = window.location.href;
	var appName = navigator.appName;
	var referrerURL =encodeURIComponent(document.referrer);
	var url =encodeURIComponent(url);
	if(referrerURL==null||referrerURL=="")
		referrerURL = "";
	var screenSize = encodeURIComponent(window.screen.width+"x"+window.screen.height);
	var countDiv = document.createElement("div");
	countDiv.innerHTML = '<iframe src="'+HOST+'/count.do?screenSize='+screenSize+'&browser='+detectBrowser()+'&os='+detectOS()+'&c='+c+'&code='+Math.random()+'&m='+member_id+'&vm='+visitor_member_id+'&url='+url+'&app_name='+appName+'&refer_url='+referrerURL+'" width="0" height="0" style="display:none"></iframe>';
	document.body.appendChild(countDiv);
}

