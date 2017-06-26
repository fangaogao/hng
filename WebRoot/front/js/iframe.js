/*我的账户页面-控制父窗口框架*/
/*var local = document.location.href ;
var index = local.indexOf(".cn/") ;
index = index < 0 ? (local.indexOf(".com") + ".com".length) : ( index + ".cn/".length);
var sdomain = local.substring(0,index + 1);
var domain = 'cnhnb.com';
if(sdomain.indexOf("cnhnkj")>=0){
	domain = 'cnhnkj.cn';
}else if(sdomain.indexOf("lvsema")>=0){
	domain = 'lvsema.cn';
}else if(sdomain.indexOf("zym888")>=0){
	domain = 'zym888.com';
}
document.domain = domain;*/
//框架的使用
$(window.parent.document).find("#content-iframe").load(function(){
	var main = $(window.parent.document).find("#content-iframe");
	var thisheight = $(document).height()+30;
	main.height(thisheight < 500 ? 500 : thisheight);
});

/*控制父窗口框架*/
function changeIfranme(){
	var main = $(window.parent.document).find("#content-iframe");
	var thisheight = $('.content').height()+100;
	main.height(thisheight < 500 ? 500 : thisheight);	
}