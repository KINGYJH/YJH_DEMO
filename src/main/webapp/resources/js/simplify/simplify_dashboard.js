$(function	()	{

  	//Flot Chart (Total Sales)
	//var d1 = [];
	//for (var i = 0; i <= 10; i += 1) {
	//	//d1.push([i, parseInt(Math.random() * 30)]);
	//	d1 = [[0,700],[1,1200],[2,1100],[3,900],[4,500],[5,700],[6,500],[7,600],[8,1200],[9,1700],[10,1200]];
	//}

	$("<div id='tooltip'></div>").css({
		position: "absolute",
		display: "none",
		border: "1px solid #222",
		padding: "4px",
		color: "#fff",
		"border-radius": "4px",
		"background-color": "rgb(0,0,0)",
		opacity: 0.90
	}).appendTo("body");
	

	//时间选择
	//$('#calendar').DatePicker({
	//	flat: true,
	//	date: '2014-06-07',
	//	current: '2014-06-07',
	//	calendars: 1,
	//	starts: 1
	//});

	//天气
	//var icons = new Skycons({"color": "white"});
    //icons.set("skycon1", "sleet");
    //icons.set("skycon2", "partly-cloudy-day");
    //icons.set("skycon3", "wind");
    //icons.set("skycon4", "clear-day");
    //icons.play();

	//聊天窗口滚动
	//$('#chatScroll').slimScroll({
	//	height:'230px'
	//});

	//聊天通知
	//setTimeout(function() {
	//	$('.chat-notification').find('.badge').addClass('active');
	//	$('.chat-alert').addClass('active');
	//}, 3000);

	//setTimeout(function() {
	//	$('.chat-alert').removeClass('active');
	//}, 8000);
});
