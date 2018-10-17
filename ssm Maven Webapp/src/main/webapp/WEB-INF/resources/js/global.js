$(document).ready(function(){
	
	/* 菜单切换样式  */
	$(".navbar-clickable-item").hover(function(){
		$(this).css( { "background-color" : "#eee", "color":"#4d9546" } );
	},function(){
		$(this).css( { "background-color" : "#4d9546", "color":"#eee" } );
	});
	
	$(".navbar-clickable").hover(function(){
		if(  $(this).find("span").hasClass("caret")  ){
			$(this).css( { "background-color" : "#4d9546" } );
		}else{
			$(this).css( { "background-color" : "#3da536" } );
		}
	},function(){
		if(  $(this).find("span").hasClass("caret")  ){
			$(this).css( { "background-color" : "#4d9546" } );
		}else{
			$(this).css( { "background-color" : "#3da536" } );
		}
	});
	
	$(".navbar-clickable").click(function(){
		if(  $(this).find("span").hasClass("caret")  ){
			$(this).html( $(this).text()+" <span class='arrow-up'></span>" );
			$(this).css( { "background-color" : "#3da536" } );
		}else{
			$(this).html( $(this).text()+" <span class='caret'></span>" );
			$(this).css( { "background-color" : "#4d9546" } );
		}	
	});
	
	$(".navbar-clickable-blur").blur(function(){
		$(this).html( $(this).text()+" <span class='caret'></span>" );
		$(this).css( { "background-color" : "#4d9546" } );
	});
	
	/* 下拉按钮 */
	$(".dropdown-btn-item").click(function(){
		$(this).parent().prev(".dropdown-btn").html( $(this).text()+" <span class='caret'></span>" );
	});
	
	/* 购物车 */
	$(".cart-dis").click(function(){
		if( parseInt($(this).parent().next("input").val() ) > 1 ){
			$(this).parent().next("input").val( parseInt($(this).parent().next("input").val())-1 );
		}
	});
	$(".cart-add").click(function(){
		$(this).parent().prev("input").val( parseInt($(this).parent().prev("input").val())+1 );
	});
	var prev_amount;
	$(".cart-text").focus(function(){
		prev_amount = $(this).val();
	});
	$(".cart-text").blur(function(){
		var c;
		for( var i = 0 ; i <= $(this).val().length - 1; i++ ){
			c = $(this).val().substr(i,1);
			if( c < '0' || c > '9' ){
				$(this).val( prev_amount );
				return;
			}
		}
	});
	
	/* list-group-link */
	var bg;
	var font;
	$(".list-group-link").hover( function(){
		bg = $(this).css("background-color");
		font = $(this).css("color");
		$(this).css( { "color" : "#eee" , "background-color":"#3da536"} );
	} , function(){
		$(this).css( { "color" : font , "background-color":bg} );
	} );
	
	
	
	$(".btn-darkgreen").hover(function(){
		$(this).css( {"background-color":"#1a9084","color":"white"} );
	},function(){
		$(this).css( {"background-color":"#1AA094","color":"white"} );
	});
	
	$(".nav-dropdown-toggle").click(function(){
		if( $(this).find("span").hasClass("caret") ){
			$(this).css( {"background-color":"#1a9084","color":"white"} );
			$(this).find("span").remove();
			$(this).append("<span class='arrow-up'></span>");
		}else if( $(this).find("span").hasClass("arrow-up") ){
			$(this).css( {"background-color":"#23262E","color":"#ccc"} );
			$(this).find("span").remove();
			$(this).append("<span class='caret'></span>");
		}
	});
	
	$(".nav-dropdown-toggle").blur(function(){
		$(this).css( {"background-color":"#23262E","color":"#ccc"} );
		$(this).find("span").remove();
		$(this).append("<span class='caret'></span>");
	});
	
	$(".nav-menu-item").click(function(){
		$(this).css( "color",$(this).css("color") );
	});
	
	$(".nav-dropdown-menu-item").hover(function(){
		$(this).css( {"background-color":"#23262E","color":"#fff"} );
	},function(){
		$(this).css( {"background-color":"#1AA094","color":"#fff"} );
	});
	
	$(".nav-dropdown-menu-item a").hover(function(){
		$(this).css( {"background-color":"inherit","color":"inherit"} );
	},function(){
		$(this).css( {"background-color":"inherit","color":"inherit"} );
	});
	
	$(".dropdown-menu-item-page-option").hover(function(){
		$(this).css( {"background-color":"#1AA094","color":"#eee"} );
	},function(){
		$(this).css( {"background-color":"#eee","color":"#666"} );
	});
	
	$(".dropdown-menu-item-page-option a").hover(function(){
		$(this).css( {"background-color":"inherit","color":"inherit","text-decoration":"none"} );
	},function(){
		$(this).css( {"background-color":"inherit","color":"inherit","text-decoration":"none"} );
	});
	
	$("#dropdown-page-option").hover(function(){
		$(this).css( {"background-color":"#eee","color":"#666","text-decoration":"none"} );
	},function(){
		$(this).css( {"background-color":"#eee","color":"#666","text-decoration":"none"} );
	});
	
	
	/*
	 导航栏品牌词效果
	 * */
	$(".navbar-brand").hover(function(){
		$(this).stop(true,true);
		$(this).animate( {"opacity":"0.3"} , 300 );
	},function(){
		$(this).stop(true,true);
		$(this).animate( {"opacity":"1.0"} , 300 );
	});
	
	/*
	 左侧滑动面板菜单效果
	 * */
	$(".list-group-item-link").hover(function(){
		$(this).css( {"color":"#eee"} );
		if( $(this).hasClass("list-group-item-link-active") || $(this).hasClass("flag") ){
			return;
		}
		$(this).css( { "background-color":"#494D59","border-left":"8px solid #1AA094","text-decoration":"none" } );
	},function(){
		$(this).css( {"color":"#eee"} );
		if( $(this).hasClass("list-group-item-link-active") || $(this).hasClass("flag") ){
			return;
		}
		$(this).css( { "background-color":"#393D49","border-left":"8px solid #393D49","text-decoration":"none"  } );
	});
	
	$(".list-group-item-link-small").hover(function(){
		
		$(this).css( {"color":"#eee"} );
		if( $(this).hasClass("list-group-item-link-active")  ){
			return;
		}
		$(this).css( { "background-color":"#494D59","border-left":"8px solid #494D59","text-decoration":"none" } );
	},function(){
		$(this).css( {"color":"#eee"} );
		if( $(this).hasClass("list-group-item-link-active") ){
			return;
		}
		$(this).css( { "background-color":"#393D49","border-left":"8px solid #393D49","text-decoration":"none"  } );
	});
	
	$(".list-group-item-link-parent").click(function(){
		if( $(this).find("img").length == 1 ){return;}
		
		$(".list-group-item-link-parent").parents(".list-group-item-slider").next("ul").stop(true,false);
		
		if(  $(this).find(".img-arrow").attr("src") == "img/j14.png"){
			
			$(".list-group-item-link-parent").find(".img-arrow").attr("src","img/j14.png")
			$(".list-group-item-link-parent").parents(".list-group-item-slider").next("ul").slideUp(300);
			$(".list-group-item-link-parent").css( { "background-color":"#393D49" ,"border-left":"8px solid #393D49"} );
			$(".list-group-item-link-parent").removeClass("flag");
			
			$(this).find(".img-arrow").attr("src","img/j15.png")
			$(this).parents(".list-group-item-slider").next("ul").slideDown(300);
			$(this).css( { "background-color":"#292D29" ,"border-left":"8px solid #1AA094" } );
			$(this).addClass("flag");
		}else{
			$(this).find(".img-arrow").attr("src","img/j14.png")
			$(this).parents(".list-group-item-slider").next("ul").slideUp(300);
			$(this).css( { "background-color":"#393D49"  } );
			$(this).removeClass("flag");
		}
	});
	
	/*
	 左侧滑动菜单头像收缩
	 * */
	$( "#face-switch" ).click(function(){
		if( $(this).hasClass("switch-on") ){
			$("#face").fadeOut();
			$(this).removeClass("switch-on");
			$(this).addClass("switch-off");
			$(this).attr("src","img/j14.png");
		}else{
			$("#face").fadeIn();
			$(this).removeClass("switch-off");
			$(this).addClass("switch-on");
			$(this).attr("src","img/j15.png");
		}
	});
	
	/*
	 左侧滑动菜单部分
	 * */
	$("#slide-switch-1").click(function(){
		$("#panel-left").stop(true,false);
		$("#panel-left-top").stop(true,false);
		if( $(this).hasClass("switch-on") ){
			$("#panel-left").animate( {"width":"0px"} , 400 );
			$("#panel-left-top").animate( {"left":"-200px"} , 400 );
			$(this).removeClass("switch-on");
			$(this).addClass("switch-off");
			$(this).attr("src","img/right.png");
		}else{
			$("#panel-left").animate( {"width":"200px"} , 400 );
			$("#panel-left-top").animate( {"left":"0px"} , 400 );
			$(this).removeClass("switch-off");
			$(this).addClass("switch-on");
			$(this).attr("src","img/rrow.png");
		}
	});
	
	$("#slide-switch-2").click(function(){
		$("#panel-left-top").stop(true,false);
		if( $(this).hasClass("switch-on") ){
			$("#panel-left-top").animate( {"left":"-200px"} , 400 );
			$(this).removeClass("switch-on");
			$(this).addClass("switch-off");
			$(this).attr("src","img/right.png");
		}else{
			$("#panel-left-top").removeClass("hidden-xs");
			$("#panel-left-top").css( { "left" : "-200px" } );
			$("#panel-left-top").animate( {"left":"0px"} , 400 );
			$(this).removeClass("switch-off");
			$(this).addClass("switch-on");
			$(this).attr("src","img/rrow.png");
		}
	});
	
	
	/* iframe页面选项卡部分 */
	$(".list-group-item-url,.cap-title").click(function abc(){
		var url = $(this).attr("id");
		var flag = 0;
		
		$(".iframe-index").each(function(index,dom){
			
			if( $(dom).attr("src") == url ){
				$(".iframe-index").stop(true,true);
				$(dom).show();
				$(".iframe-index").css({"top":"30px","opacity":"0"});
				$(".iframe-index").animate({"top":"0px","opacity":"1.0"},600);
				
				flag = 1;
				
			}else{
				$(dom).hide();
			}
		});
		
		$(".cap-title").each(function(index,dom){
			
			if( $(dom).attr("id") == url ){
				$(dom).addClass("cap-title-active");
			}else{
				$(dom).removeClass("cap-title-active");
			}
		});
		
		
		
		if( flag == 0 ){
			$(".iframe-index").hide();
			$("#panel-right").append("<iframe src='"+url+"' class='iframe-index' name='iframe-index'></iframe>");
			$("#panel-right-nav-head").append( "<div id='"+url+"' class='left cap-title cap-title-active hand' align='center'><img src='img/57323.png' height='20px' class='img img-circle hand'/> "+$(this).text()+" &nbsp;&nbsp;<div class='div-close float-right' >×</div></div>" );
			$(".iframe-index").stop(true,true);
			$(".iframe-index").css({"top":"30px","opacity":"0"});
			$(".iframe-index").animate({"top":"0px","opacity":"1.0"},600);
			$(".cap-title").click( abc );
			$(".div-close").click( function(){
				var flag = $(this).parent().hasClass( "cap-title-active" );
				var url = $(this).parent().attr("id");
				$(".iframe-index").each(function(index,dom){
					if( $(dom).attr("src") == url ){
						if( flag ){
							// $(dom).prev().show();
							$(".iframe-index").stop(true,true);
							$(dom).prev().show();
							$(".iframe-index").css({"top":"30px","opacity":"0"});
							$(".iframe-index").animate({"top":"0px","opacity":"1.0"},600);
						}
						$(dom).remove();
					}
				});
				if( flag ){
					$(this).parent().prev().addClass("cap-title-active");
				}
				$(this).parent().remove();
			} );
			$(".div-close").hover( function closeon(){
				$(this).css({"background-color":"#c35707"});
			},function closeout(){
				$(this).css({"background-color":"transparent"});
			} );
			
		}
	});
	
	/* iframe页面选项卡部分2 */
    $(".new-iframe").click(function abc(){
    	
        var url = $(this).attr("id");
        var flag = 0;
        
        $(window.parent.document).find(".iframe-index").each(function(index,dom){
			
            if( $(dom).attr("src") == url ){
                $(window.parent.document).find(".iframe-index").stop(true, true);
                $(dom).show();
                $(window.parent.document).find(".iframe-index").css({ "top": "30px", "opacity": "0" });
                $(window.parent.document).find(".iframe-index").animate({ "top": "0px", "opacity": "1.0" }, 600);
				
                flag = 1;
				
            }else{
                $(dom).hide();
            }
        });
		
        $(window.parent.document).find(".cap-title").each(function (index, dom) {
			
            if( $(dom).attr("id") == url ){
                $(dom).addClass("cap-title-active");
            }else{
                $(dom).removeClass("cap-title-active");
            }
        });
		
		
		
        if( flag == 0 ){
            $(window.parent.document).find(".iframe-index").hide();
            $(window.parent.document).find("#panel-right").append("<iframe src='" + url + "' class='iframe-index' name='iframe-index'></iframe>");
            $(window.parent.document).find("#panel-right-nav-head").append("<div id='" + url + "' class='left cap-title cap-title-active hand' align='center'><img src='img/57323.png' height='20px' class='img img-circle hand'/> " + $(this).text() + " &nbsp;&nbsp;<div class='div-close float-right' >×</div></div>");
            $(window.parent.document).find(".iframe-index").stop(true, true);
            $(window.parent.document).find(".iframe-index").css({ "top": "30px", "opacity": "0" });
            $(window.parent.document).find(".iframe-index").animate({ "top": "0px", "opacity": "1.0" }, 600);
            $(window.parent.document).find(".cap-title").click(abc);
            $(window.parent.document).find(".div-close").click(function () {
                var flag = $(this).parent().hasClass( "cap-title-active" );
                var url = $(this).parent().attr("id");
                $(window.parent.document).find(".iframe-index").each(function (index, dom) {
                    if( $(dom).attr("src") == url ){
                        if( flag ){
                            // $(dom).prev().show();
                            $(window.parent.document).find(".iframe-index").stop(true, true);
                            $(dom).prev().show();
                            $(window.parent.document).find(".iframe-index").css({ "top": "30px", "opacity": "0" });
                            $(window.parent.document).find(".iframe-index").animate({ "top": "0px", "opacity": "1.0" }, 600);
                        }
                        $(dom).remove();
                    }
                });
                if( flag ){
                    $(this).parent().prev().addClass("cap-title-active");
                }
                $(this).parent().remove();
            } );
            $(window.parent.document).find(".div-close").hover(function closeon() {
                $(this).css({"background-color":"#c35707"});
            },function closeout(){
                $(this).css({"background-color":"transparent"});
            } );
			
        }
    });
	
	$(".list-group-item-url").hover(function(){
		$(this).css({"text-decoration":"none"});
	},function(){
		$(this).css({"text-decoration":"none"});
	});
	
	$(".list-group-item-url").click(function(){
		$(this).css({"text-decoration":"none"});
	});
	
	/**
	 * 页面操作
	 * */
	$("#page-option-1").click(function(){
		var url = $(".cap-title-active").attr("id");
		$(".iframe-index").each(function(index,dom){
			if( $(dom).attr("src") == url ){
				$(dom).attr("src",url);
			}
		});
	});
	$("#page-option-2").click(function(){
		var jquery = $(".cap-title");
		jquery = jquery.not(":first");
		jquery = jquery.not(".cap-title-active");
		var index = $(".cap-title").index( $(".cap-title-active") );
		jquery.remove();
		var jq2 = $(".iframe-index");
		jq2 = jq2.not(":first");
		jq2 = jq2.not( $(".iframe-index").eq(index) );
		jq2.remove();
		
		
	});
	$("#page-option-3").click(function(){
		var jquery = $(".cap-title");
		jquery = jquery.not( $(".cap-title").first() );
		jquery.remove();
		var jq2 = $(".iframe-index");
		jq2 = jq2.not( $(".iframe-index").first() );
		jq2.remove();
		
		$(".cap-title").first().addClass("cap-title-active");
		
		$(".iframe-index").stop(true,true);
		$(".iframe-index").first().show();
		$(".iframe-index").css({"top":"30px","opacity":"0"});
		$(".iframe-index").animate({"top":"0px","opacity":"1.0"},600);
		
	});
	
		$(".iframe-index").stop(true,true);
		$(".iframe-index").first().show();
		$(".iframe-index").css({"top":"30px","opacity":"0"});
		$(".iframe-index").animate({"top":"0px","opacity":"1.0"},600);
	
	$("#page-option-4").click(function(){
		$("#dropdown-page-option").blur();
	});
	
	/**
	 * 灰色按钮事件
	 * */
	$(".btn-gray").hover(function(){
		$(this).css( {"color":"#555","background-color":"#ddd"} );
	},function(){
		$(this).css( {"color":"#666","background-color":"#e0e0e0"} );
	});
	
	/**
	 * 按钮动画
	 * */
	$(".animate-btn").hover(function(){
		$(this).find("img").addClass("animated");
		$(this).find("img").addClass("rotateIn");
		
	},function(){
		$(this).find("img").removeClass("animated");
		$(this).find("img").removeClass("rotateIn");
	});
	
	/**
	 * 选项卡控件
	 * */
	$(".panel-tab-body").not( $(".panel-tab-body").first() ).hide();
	$(".btn-tab").click(function(){
		if( $(this).hasClass("active") ) {return;}
		var last = $(".btn-tab").index( $(".btn-tab").filter(".active") );
		var index = $(".btn-tab").index( $(this) );

		$(".panel-tab-body").eq(last).hide();
		$(".panel-tab-body").eq(index).show();

	});
	
	/**
	 * 分步选项卡
	 * */
	$(".panel-step-body").not( $(".panel-step-body").first() ).hide();

	$(".btn-step").each(function(index,dom){
		$(dom).css(  { "z-index" : 999-index , "left" : index * -40 + "px" } );		
	});
	
	$(".btn-step-next").click(function(){
		
		var index = $(".btn-step").index($(".btn-primary"));

		$(".panel-step-body").removeClass("animated");
		$(".panel-step-body").removeClass("bounceOutLeft");
		$(".panel-step-body").removeClass("wow");
		$(".panel-step-body").removeClass("bounceInRight");
		$(".panel-step-body").removeClass("bounceOutRight");
		$(".panel-step-body").removeClass("bounceInLeft");
		
		$(".panel-step-body").eq(index).addClass("animated bounceOutLeft wow");
		$(".panel-step-body").eq(index).delay(300).hide();
		$(".panel-step-body").eq(index+1).delay(400).show();
		$(".panel-step-body").eq(index+1).delay(400).addClass("animated bounceInRight wow");
		
		$(".btn-step").eq(index).removeClass("btn-primary").addClass("btn-default");
		$(".btn-step").eq(index+1).removeClass("btn-default").addClass("btn-primary");
		
		loadBtnStep();
	});
	
	$(".btn-step-prev").click(function(){
		
		var index = $(".btn-step").index($(".btn-primary"));

		$(".panel-step-body").removeClass("animated");
		$(".panel-step-body").removeClass("bounceOutLeft");
		$(".panel-step-body").removeClass("wow");
		$(".panel-step-body").removeClass("bounceInRight");
		$(".panel-step-body").removeClass("bounceOutRight");
		$(".panel-step-body").removeClass("bounceInLeft");
		
		$(".panel-step-body").eq(index).addClass("animated bounceOutRight wow");
		$(".panel-step-body").eq(index).delay(300).hide();
		$(".panel-step-body").eq(index-1).delay(400).show();
		$(".panel-step-body").eq(index-1).delay(400).addClass("animated bounceInLeft wow");
		
		$(".btn-step").eq(index).removeClass("btn-primary").addClass("btn-default");
		$(".btn-step").eq(index-1).removeClass("btn-default").addClass("btn-primary");
		
		loadBtnStep();
	});
	
	
	function loadBtnStep(){
		$(".btn-step-prev").show();
		$(".btn-step-next").show();
		$(".btn-step-submit").hide();
		var index = $(".btn-step").index($(".btn-primary"));
		if( index == 0 ){
			$(".btn-step-prev").hide();
		}
		if( index == $(".btn-step").length - 1 ){
			$(".btn-step-next").hide();
			$(".btn-step-submit").show();
		}
	}
	
	/**
	 * 搜索条件
	 * */
	$(".btn-where").click(function(){
		if( $(this).find("span").hasClass("arrow-up") ){
			$(".row-where").slideUp(300);
			$(this).html("<span class='caret'></span> 显示条件 ");
		}else if($(this).find("span").hasClass("caret")){
			$(".row-where").slideDown(300);
			$(this).html("<span class='arrow-up'></span> 隐藏条件 ");
		}
	});
	
	/**
	 * 全选反选
	 * */
	$(".cbx-all").click(function(){
		
		var jq = $(this).parents(".cbx-group").last().find("input[type='checkbox']").not($(".cbx-all"));
		
		jq.prop("checked",$(this).prop("checked"));
	});
	
	$(".cbx-group").find("input[type='checkbox']").not($(".cbx-all")).click(function(){
		var jq = $(this).parents(".cbx-group").last().find("input[type='checkbox']").not($(".cbx-all"));
		var ck = true;
		jq.each(function(index,dom){
			if( $(this).prop("checked") == false){
				ck =false;
			}
		});
		var jq = $(this).parents(".cbx-group").last().find(".cbx-all").prop("checked",ck);
	});
	
	loadBtnStep();
	new WOW().init();
});
