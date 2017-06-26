// JavaScript Document
$(document).ready(function(){
	//set mainNav hover event
	
	/*左侧菜单JS*/	
	/*$(function(){
		//初始化展开栏目
		var bodyClassName = $('body').attr("class");
		var sideNavListCur = $('.side-nav h3 a[data-side="' + bodyClassName + '"]');
		sideNavListCur.parent().parent().parent().removeClass('hidden');
		sideNavListCur.parent().parent().parent().prev('h2').find('a').removeClass('hide').addClass('show');
		sideNavListCur.parent().next('ul').removeClass('hidden');
		sideNavListCur.addClass('cur');
		if(bodyClassName=='index')$('.side-nav').removeClass('side-line');
		//点击展开收缩效果
		$(".side-list h3.is-sub,.side-list h2.is-sub").click(function(){
			var thisUl = $(this).next('ul');
			if(thisUl.css('display')=='none'){
				$(this).next('ul').slideDown();
				$(this).find('a').removeClass('hide').addClass('show');
			}else{
				$(this).next('ul').slideUp();
				$(this).find('a').removeClass('show').addClass('hide');
			}
		});	
	})*/
	
	/*左侧菜单JS*/	
	$(function(){
		$(".side-list h2.is-sub").live('click',function(){

			var thisUl = $(this).next('ul');
			if(thisUl.css('display')=='none'){
				$(".side-list h2.is-sub").next('ul').slideUp();
				$(".side-list h2.is-sub").find('a').removeClass('show').addClass('hide');
				$(this).next('ul').slideDown();
				$(this).find('a').removeClass('hide').addClass('show');
			}else{
				$(this).next('ul').slideUp();
				$(this).find('a').removeClass('show').addClass('hide');
			}
		});	
		$(".side-list h3.is-sub").live('click',function(){
			var thisUl = $(this).next('ul');
			if(thisUl.css('display')=='none'){
				$(this).next('ul').slideDown();
				$(this).find('a').removeClass('hide').addClass('show');
			}else{
				$(this).next('ul').slideUp();
				$(this).find('a').removeClass('show').addClass('hide');
			}
		});	
		$(".side-list h3[class!='is-sub']").live('click',function(){
			$(".side-list h3 a").removeClass('cur');
			$(this).find('a').addClass('cur');
		});
		$(".side-list h3.is-sub").next('ul').find('li').live('click',function(){
			$(".side-list h3 a").removeClass('cur');
			$(this).parent().prev('h3').find('a').addClass('cur');
			$(".side-list ul ul li a").removeClass('cur');
			$(this).find('a').addClass('cur');
		});
		
	})
	
});
