// JavaScript Document
var webUrl = init.webUrl;
$(document).ready(function(){
	/*删除按钮 start*/
	var idarry = {};
	function deleteMsg(obj){
		if(!obj || obj == '') return ;
		//alert('删除ID为'+obj.ids+'的记录');
		$("#ids").val(obj.ids);
		$.ajax({
				type: "POST",
				url: webUrl+"person/deleteMessage",
				dataType : "json",
				async: false,
				data: {
					ids : obj.ids
				},
				success: function(){
					
				}
		});
		var msgType = $("#msgType").val();
		refreshData(msgType);
	}
	
	$('.all-del').live("click",function(){
		var ids=""; 
		var mesgType = $("#msgType").val();
		var $sel = $("#tab"+mesgType).find("input[class='sel']:checked");
		$($sel).each(function(i){
			ids += $(this).attr("id") + ",";
		});
		if(ids=="" && ids.length==0){
			windows_open(1,"请选择一条记录");
			return;
		}
		ids = ids.substring(0,ids.length - 1);
		idarry.ids=ids;
		fx_confirm_window('是否确认删除?',deleteMsg,idarry);
	});
	/*删除按钮 end*/
	
	 /*列表全选 start*/
	$(".all-sel").live("click",function() {
		var mesgType = $("#msgType").val();
		var $sel = $("#tab"+mesgType).find("input[class='sel']:checkbox");
		if($(this).attr('checked')){
        	$($sel ).attr("checked", true);
		}else{
			$($sel ).attr("checked", false);	
		}
    });
	$(".all-sel-a").live("click",function() {
		var mesgType = $("#msgType").val();
		var $allsel = $("#tab"+mesgType).find("input[class='all-sel']");
		var $sel = $("#tab"+mesgType).find("input[class='sel']:checkbox");
		
		$($allsel).attr('checked',true);
		$($sel).attr("checked", true);
    });
	$(".sel").live("click",function(){
		var mesgType = $("#msgType").val();
		var $allsel = $("#tab"+mesgType).find("input[class='all-sel']");
		var $sel = $("#tab"+mesgType).find("input[class='sel']");
		
		var len = $($sel).length;
		var j;
		for(var i = 0; i < len; i++){
			if($($sel).eq(i).attr("checked")){j=1;}else{j=0;break;}	
		}
		if(j == 1){
			$($allsel).attr('checked',true);
		}else{
			$($allsel).attr('checked',false);
		}
	});
	/*列表全选 end*/
	
	/*标记为已读*/
	function updateMsg(obj){
		if(!obj || obj == '') return ;
		var ids = obj.ids.split(",");
		for(var i=0;i<ids.length;i++){
			var id = ids[i];
			$("#"+id+"_v").attr("class","read");
			$.ajax({
				type: "POST",
				url: webUrl+"person/userMessageDetail",
				dataType : "json",
				async: false,
				data: {
					id : id
				},
				success: function(){
					
				}
			});
			var msgType = $("#msgType").val();
			refreshData(msgType);
		}
	}
	$(".as-read").live("click",function(){
		var ids=""; 
		var mesgType = $("#msgType").val();
		var $sel = $("#tab"+mesgType).find("input[class='sel']:checked");
		$($sel).each(function(i){
			ids += $(this).attr("id") + ",";
		});
		if(ids=="" && ids.length==0){
			windows_open(1,"请选择一条记录");
			return;
		}
		ids = ids.substring(0,ids.length - 1);
		idarry.ids=ids;
		fx_confirm_window('是否确认标记为已读?',updateMsg,idarry);
	});
	/*标记为已读end*/
	
	$('.list .record-title').live('click',function(){
      if($(this).find('.toggle-btn').hasClass('hide')) {
        $(this).siblings('.record-content').addClass('view').parent().siblings().find('.record-content').removeClass('view');
        $(this).find('.toggle-btn').removeClass('hide').html('收起');
        $(this).parent().siblings().find('.toggle-btn').addClass('hide').html('展开');
        
        var id = $(this).attr("id");
  	  	var mesgType = $("#msgType").val();
  	  	var $read = $("#tab"+mesgType).find("[id='"+id+"_v']");
  	  	$($read).attr("class","read");
  	  	$.ajax({
  			type: "POST",
  			url: webUrl+"person/userMessageDetail",
  			dataType : "json",
  			data: {
  				id : id
  			},
  			success: function(){
  				
  			}
  		});
      }else{
        $(this).siblings('.record-content').removeClass('view');
        $(this).find('.toggle-btn').addClass('hide').html('展开');
      }
    });

	
	function refreshData(msgType){
		var num = $("#tab"+msgType).find("input[name='pageNumber']").val();
		hnUtil.view.html("userMessageType",{msgType:msgType,pageNumber:num,pageSize:10}, function(data){
			//填充数据
			$("#tab"+msgType).show();
			$("#"+msgType).siblings().hide();
			$("#tab"+msgType).html(data);
		});
	}
});


var _type;
var webUrl = init.webUrl;
/*jqtabs*/
$(document).ready(function(){
    $("#usual1 ul").idTabs();
    var msgType=$("#msgType").val();
    $("#tab"+msgType).html("<div class='letter-layout'><img src='"+init.resoruceUrl+"common/default/images/loading_32x32.gif'/></div>");
    $("#"+msgType).addClass("selected");
    $("#"+msgType).siblings().removeClass("selected");
    var _pageNumber = $("#pageNumber").val();//当前tab的当前页
    hnUtil.view.html("userMessageType",{msgType:msgType,pageNumber:_pageNumber,pageSize:10}, function(data){
        //填充数据
        $("#tab"+msgType).show();
        $("#"+msgType).siblings().hide();
        $("#tab"+msgType).html(data);
        //$("#tab"+msgType).find("#pageNumber").val(_pageNumber);
    });

    $("#usual1 ul li a").click(function(){
        var msgType = $(this).attr("id");
        $("#msgType").val(msgType);
        $("#tab"+msgType).show();
        $("#"+msgType).siblings().hide();
        _pageNumber = $("#tab"+msgType).find("#pageNumber").val();

    });
    //加载其他类型的数据
    $("#usual1 ul li a").each(function(i,n){
        var _defType = $("#msgType").val();
        if(parseInt(_defType)!=parseInt(n.id)){
            hnUtil.view.html("userMessageType",{msgType:n.id}, function(data){
                //$("#tab"+n.id).show();
                $("#tab"+n.id).html(data);
            });
        }
    });
});