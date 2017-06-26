	$(document).ready(function() {
		getPurchaseData('');
	});
   /**获取用户订阅资讯**/
   var st='';
   function getPurchaseData(state){
	   st=state;
	   jQuery.ajax( {
			type : "post",
			url : init.userWebUrl+"collection/listCollectPurchase",
			data:{
				"state":state,
				"pageNumber" : pageNo,
				"pageSize" : pageSize
			},
			dataType : "json",
			success : function(result) {
				if(result.status==1){
                   var chart_txt=result.data.list.length>0?"":"没有相关数据。";
                   $("#tab_purchase").html(chart_txt);
                   for(var idx=0;idx<result.data.list.length;idx++){
	                   	var bean=result.data.list[idx];
	                   	var htm_str='<tr><td width="31"><input type="checkbox" name="ckb" value="'+bean.id+'" /></td><td width="484"><ul class="info">';
	                   	htm_str+='<li class="tit"><a href="'+init.purchaseServer+'/purchase/'+bean.purchaseId+'" target="_blank">'+bean.buyTitle+'</a><span class="txt">采购数量：'+bean.qty+''+bean.measureUnit+'</span></li>';
	                   	htm_str+='<li class="summary">'+(bean.explanation.length>80?(bean.explanation.substring(0,80)+"....."):bean.explanation)+'</li>';
	                    var icon;
	                    if(bean.vipLevel==1){
	                   		icon='icon-ps';
	                   	}
	                    if(bean.vipLevel==2){
	                   		icon='icon-cp';
	                   	}
	                   	htm_str+='<li><i class="'+icon+'"></i>'+bean.companyName+' <span class="txt gray">'+bean.placeDetail+'</span></li></ul></td><td width="347"><p>发布时间：'+bean.startTime+'</p>';
	                    htm_str+='<p>剩余时间：'+bean.leftDays+'天</p><p>价格说明：'+bean.description+'</p></td><td width="118" class="btns2"><p></p>';
	                    htm_str+='<p><a class="del-msgs" href="'+init.purchaseServer+'/purchase/'+bean.purchaseId+'" target="_blank">报价</a></p><p><a class="del" href="javascript:deletePurchase('+bean.id+');">删除</a></p></td></tr>';

	                    
	                    $("#tab_purchase").append(htm_str);
                   }
                   setPageList(result.data.page.recordCount);
                   $("#selectall").attr("checked",false);
                   $("#sc_in_con01").show();
                   var winH = $(document).height(); /**适应高度**/
            	   $(window.parent.document).find("iframe:eq(0)").height(winH + 20) ;
				}else{
					alert(result.message);
				}
			}
		});
   }
   
   /**分页**/
    var num='';
    var pageNo=1;
    var pageSize=10;
    var totalPage=1;
    function toPage(no,size){
       if(no>totalPage||no<1||isNaN(no)){
    	   return;
       }
	   pageNo=parseInt(no);
       pageSize=size;
       getPurchaseData(st);
	}
    function jumpPage(){
    	toPage($("#to_txt").val(),pageSize);
    }
	function setPageList(total){
	  var pageCode='';
	  totalPage=Math.ceil(total/pageSize);
	  pageCode+=('<a '+((pageNo<=1||totalPage<2)?'class="pre-disabled"':'class="next"')+' href="#top_href" onclick="toPage('+(pageNo-1)+','+pageSize+');"><span>上一页</span></a>');
	  if(totalPage<=3){
	     for(var i=1;i<=totalPage;i++){
	       pageCode+=(i==pageNo?'<a class="current">'+i+'</a>':'<a href="#top_href" onclick="toPage('+i+','+pageSize+');">'+i+'</a>');
	     }
	  }else{
	     if(pageNo>3){
	        pageCode+='<a href="#top_href" onclick=toPage(1,'+pageSize+');>1</a><a class="omit">...</a>';
	        for(var i=pageNo-1;i<pageNo+2&&i<totalPage;i++){
	           pageCode+=(i==pageNo?'<a class="current">'+i+'</a>':'<a href="#top_href" onclick=toPage('+i+','+pageSize+');>'+i+'</a>');
	        }
	        pageCode+=(pageNo<(totalPage-1)?'<a class="omit" href="#">...</a>':'');
	        pageCode+=(pageNo==totalPage?'<a class="current">'+pageNo+'</a>':'<a href="#top_href" onclick=toPage('+totalPage+','+pageSize+');>'+totalPage+'</a>');
	     }else{
	        for(var i=1;i<=pageNo+2;i++){
	           pageCode+=(i==pageNo?'<a class="current">'+i+'</a>':'<a href="#top_href" onclick=toPage('+i+','+pageSize+');>'+i+'</a>');
	        }
	        pageCode+='<a class="omit" href="#">...</a><a href="#top_href" onclick=toPage('+totalPage+','+pageSize+');>'+totalPage+'</a>';
	     }
	  }
	  pageCode+=('<a '+((pageNo<total)?'class="next"':'class="pre-disabled"')+'  href="#top_href" onclick="toPage('+(pageNo+1)+','+pageSize+');"><span>下一页</span></a>');
	  pageCode+='<li>到<input name="" id="to_txt" type="text" /> 页</li><li><a  href="#top_href" onclick="jumpPage();" class="btn_qd">确定</a>';
	  $("#page").html(pageCode);
	}
	
	//全选
	function allChecked(){
		var ck=$("#selectall").attr("checked");
		$("[name='ckb']").each(function() { 
			this.checked=ck;
		});
	};
	   
	//删除用户订阅采购
	function deletePurchase(ids) {
	   if(ids==''||ids==null){
			$("[name='ckb']").each(function() { 
				if(this.checked){
					if(ids!=""){
						ids+=","+$(this).val();
			      	}else{
			      		ids=$(this).val();
			      	}
				}
			});
	   }
	   jQuery.ajax( {
			type : "post",
			url : init.userWebUrl+"collection/delCollectPurchase",
			data:{
				ids:ids
			},
			dataType : "json",
			success : function(result) {
				alert(result.message);
				getPurchaseData(st);
			}
		});
	}
	$("#sc_in_01,#sc_in_02,#sc_in_03").bind("click",function(){
		num = $(this).attr("id").substring($(this).attr("id").length-1,$(this).attr("id").length);
		for(var i=1;i<=3;i++){
			if(i==num){
				$("#sc_in_0"+i).attr("class","current");
			}else{
				$("#sc_in_0"+i).attr("class","");
			}
		}
	});
