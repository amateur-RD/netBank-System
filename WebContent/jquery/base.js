var TREE = {
		navTreeint:function() {
			$(".nav-tree .item").off("click");
			$(".nav-tree .item").on("click", function(e) {
				e.stopPropagation();//阻止冒泡
				if($(this).attr("state")=="closed"){
					if($(this).children("ul").length==1){
						if ($(this).children("ul").css("display") == "none") {
							$(this).children("ul").hide().slideDown();
						} else {
							$(this).children("ul").slideUp();
						}
					}else {
						TREE.getTree({
							url	: TREE.url,
							obj : $(this)
						});
					}
				}
			});
		},
		getTree : function(args) {
			//url : "loginAction/getTree.action",
			//obj : $(".nav .nav-tree"),
			TREE.url=args.url;
			var d = {};
			if($(args.obj).attr("id")){
				$.post(args.url,{nid:$(args.obj).attr("id")},function(data) {
					var html = "<ul>";
					for(var i =0;i<data.length;i++){
						if(data[i].state=="closed"){
							html+='<li class="item" id="'+data[i].id+'" state ="'+data[i].state+'" ><a class="'+data[i].iconCls+'">'+ data[i].text + '</a></li>';
						}
						if(data[i].state=="open"){
							html+='<li class="item"  state ="'+data[i].state+'" ><a class="'+data[i].iconCls+'"'+ '" href="javascript:TREE.getIframe(\'' + data[i].url	+ '\')">'+ data[i].text + '</a></li>';
						}
					}
					html+="</ul>";
					args.obj.append(html);	
					TREE.navTreeint();
					args.obj.children("ul").hide().slideDown();
				}, "json");
			}else{
				$.post(args.url,function(data) {
					/*if(!data){
						window.location.href="login.jsp";
					}*/
					var html = "";
					for(var i =0;i<data.length;i++){
						if(data[i].state=="closed"){
							html+='<li class="item" id="'+data[i].id+'" state ="'+data[i].state+'" ><a class="'+data[i].iconCls+'">'+ data[i].text + '</a></li>';
						}
						if(data[i].state=="open"){
							html+='<li class="item"  state ="'+data[i].state+'" ><a class="'+data[i].iconCls+'"'+ '" href="javascript:TREE.getIframe(\'' + data[i].url	+ '\')">'+ data[i].text + '</a></li>';
						}
					}
					args.obj.append(html);	
					TREE.navTreeint();
				}, "json");
			}
			
		},
		getIframe:function(url){
			if ($("." + url).css("display") == "block") {

			} else {
				$(".tabs").css("display", "none");
				$("." + url).css("display", "block");
				eval(url + "()");
			}
		}
};

	

var TABLE = {};

TABLE.datagrid = function() {
	//"medicineAction/medicine.action", {},"medicine_manager"
	if(arguments.length==3){
		TABLE.url=arguments[0];
		TABLE.d=arguments[1];
		TABLE.obj=arguments[2];
	}else if(arguments.length==1){
		TABLE.d=arguments[0];//"page.page":"1"
	}
	
	var childs = $("#"+TABLE.obj).children("tbody");
	if(childs.length!=0){
		childs.remove("tbody");
	}
	//$(#medicine_manager thead tr th).
	//取数据的时候 tbMedicine.id
	var ths = $("#"+TABLE.obj).children("thead").children("tr").children("th");
	var cols = {};
	for (var i = 0; i < ths.length; i++) {
		//{id:'id',medno:'medno',name:'name'}
		cols[$(ths[i]).attr("col")] = $(ths[i]).attr("col");
	}
	//alert(TABLE.url)
	$.getJSON(TABLE.url, TABLE.d, function(data) {
		
		//#medicine_managerpages
		$("#"+TABLE.obj+"pages").text(data.pages);
		$("#"+TABLE.obj+"counts").text(data.counts);
		// 组装数据
		var rows = data.rows;
		var tabs = "<tbody>";
		for (var i = 0; i < rows.length; i++) {
			tabs+="<tr>";
			for ( var key in cols) {
				if(key=="id"){
					tabs+='<td class="checkbox"><input type="checkbox" value="'+eval("rows["+i+"]."+key)+'"/></td>';
				}else{
					tabs+="<td>"+eval("rows["+i+"]."+key)+"</td>";
				}
			}
			tabs+="</tr>";
		}
		tabs += "</tbody>";
		$("#"+TABLE.obj).append(tabs);
		TABLE.tabinit();
	});
}

TABLE.tabinit=function () {
	$(".table tbody tr").on("click", function(e) {
		if (e.target.tagName != "INPUT") {
			var checkbox = $(this).children(".checkbox").children("input")[0];
			if (checkbox.checked) {
				checkbox.checked = false;
				$(this).removeClass("active");
			} else {
				checkbox.checked = true;
				$(this).addClass("active");
			}
		}

	});
	
	$(".table thead .checkbox").on("click", function(e) {
		var this_ = e.target;
		var c = $(".checkbox input[type='checkbox']");
		if (this_.checked) {
			for (var i = 1; i < c.length; i++) {
				c[i].checked = true;
				$(".table tbody tr").addClass("active");
			}
		}
		if (!this_.checked) {
			for (var i = 1; i < c.length; i++) {
				c[i].checked = false;
				$(".table tbody tr").removeClass("active");
			}
		}

	});
	
	var page = $("#"+TABLE.obj+"page").text();
	var pages = $("#"+TABLE.obj+"pages").text();
	$('.first').attr('href','javascript:TABLE.first()');
	$('.last').attr('href','javascript:TABLE.last()');
	$('.next').attr('href','javascript:TABLE.next()');
	$('.end').attr('href','javascript:TABLE.end()');
	
	if(page==1){
		$('.first').removeAttr('href');
		$('.last').removeAttr('href');
	}
	if(page==pages){
		$('.next').removeAttr('href');
		$('.end').removeAttr('href');
	}
	
	
}

TABLE.reload=function(){
	TABLE.datagrid();//????有问题
}

TABLE.remove=function(url,fn){
	//获取移除对象
	var ids = "";
	var checks = $(".table td.checkbox input[type='checkbox']");
	for(var i =0;i<checks.length;i++){
		if(checks[i].checked){
			ids+=$(checks[i]).val()+",";
		}
	}
	if(ids.trim().length==0){
		alert("至少选中一项")
	}else{
		$.get(url,{"ids":ids},function(data){
			fn(data);
		});
	}
}


TABLE.first = function() {
	$("#"+TABLE.obj+"page").text(1);
	TABLE.datagrid({
		"page.page":"1"
	});
}


TABLE.last = function() {
	$("#"+TABLE.obj+"page").text(parseInt($("#"+TABLE.obj+"page").text())-1);
	TABLE.datagrid({
		"page.page":$("#"+TABLE.obj+"page").text()
	});
}

TABLE.next = function() {
	$("#"+TABLE.obj+"page").text(parseInt($("#"+TABLE.obj+"page").text())+1);
	TABLE.datagrid({
		"page.page":$("#"+TABLE.obj+"page").text()
	});
}

TABLE.end = function() {
	$("#"+TABLE.obj+"page").text($("#"+TABLE.obj+"pages").text());
	TABLE.datagrid({
		"page.page":$("#"+TABLE.obj+"pages").text()
	});
}

serializeObject = function(form) {
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
			o[this['name']] = this['value'];
		}
	});
	return o;
};



function isCheck(elements) {

	for(var i = 0; i < elements.length; i++) {

		if($(elements[i]).hasClass("isNull")) {
			if(!isNull(elements[i])) {
				warning({
					element:elements[i],
					text:'内容不能为空'
				});
				$(elements[i]).focus();
				//$(elements[i]).focus().css('border','1px solid red');
				return false
			}
		}
		if($(elements[i]).hasClass("isAccont")) {
			if(!isAccont(elements[i])) {
				warning({
					element:elements[i],
					text:'5-10位的数字或字母'
				});
				$(elements[i]).focus();
				//$(elements[i]).focus().css('border','1px solid red');
				return false
			}
		}
		if($(elements[i]).hasClass("isPassword")) {
			if(!isPassword(elements[i])) {
				warning({
					element:elements[i],
					text:'4-10位不能是中文'
				});
				$(elements[i]).focus();
				//$(elements[i]).focus().css('border','1px solid red');
				return false
			}
		}
	}
	return true;

}
/**
 * 
 * @param {Object} d:{element:element;text:text}
 */
function warning(d) {
	var top = $(d.element).offset().top + "px";
	var left = $(d.element).offset().left+$(d.element).outerWidth() + "px";//***
	$(".warning .text").text(d.text);
	$(".warning").css('display', 'block').css('top', top).css('left', left);
	$(window).on('mousedown', function() {
		$(".warning").css('display', 'none');
		$(window).off('mousedown');
	})
}

function isPassword(element) {
	var pattern = /^[^\u2E80-\u9FFF]{4,10}$/g;
	if(!pattern.test($(element).val())) {
		return false;
	}
	return true;
}

function isAccont(element) {
	var pattern = /^[0-9a-zA-Z]{5,10}$/g;
	if(!pattern.test($(element).val())) {
		return false;
	}
	return true;
}

function isNull(element) {
	if($(element).val().length == 0) {
		return false;
	}
	return true;
}
//自己调用
function subm() {
	isCheck($(".check"));
}