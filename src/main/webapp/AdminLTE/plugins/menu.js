 	/*
     * @构建树形菜单
     * @arrJson:json数据
     * @container:菜单容器
     */
    function menuTree(jsonArr,container){
        for(var i = 0 ;i < jsonArr.length; i++){
            var oLi = document.createElement('li');
            var onClick = jsonArr[i].children ? "rootOnclick(this);" : "leafOnclick(this);" ;
			var rigtxt = jsonArr[i].right_text || "";
			rigtxt= rigtxt.length>3? rigtxt.substr(0,3) : rigtxt;
			var url = jsonArr[i].url || "";
			var active = jsonArr[i].active || "";
			var inHt ='<a href="javascript:void(0);" onclick="'+onClick+'" data-url="'+jsonArr[i].url+'" class="nav-link '+active+'"><i class="'+jsonArr[i].icon+'"></i>';

            if(jsonArr[i].children){//遇到是某级别根节点
				var open = jsonArr[i].open || "";
				$(oLi).addClass("nav-item has-treeview "+open);
				if(rigtxt==""){ inHt +='<p>'+jsonArr[i].text+'<i class="right fas fa-angle-left"></i></p></a>';
				}else{ inHt +='<p>'+jsonArr[i].text+'<span class="right badge badge-danger" style="margin-right:30px">'+rigtxt+'</span><i class="right fas fa-angle-left"></i></p></a>'; }
                oLi.innerHTML =inHt;
				var oUl = document.createElement('ul');
				$(oUl).addClass("nav nav-treeview ");
				oLi.appendChild(oUl);
                menuTree(jsonArr[i].children,oUl);//递归构建子菜单
            }else{
				$(oLi).addClass("nav-item");
				if(rigtxt==""){ inHt +='<p>'+jsonArr[i].text+'</p></a>';
				}else{ inHt +='<p>'+jsonArr[i].text+'<span class="right badge badge-danger" >'+rigtxt+'</span></p></a>'; }
                oLi.innerHTML = inHt;
            }
            container.appendChild(oLi);
        }
    }
	function rootOnclick(){

	}
	function leafOnclick(e){
		//1.取消其它所有a标签选中态
		$("#menutree").find('a.active').each(function(){
			$(this).removeClass("active");
		});
		//2.设置父节点选中状态
		$(e).parentsUntil("#menutree","li.has-treeview").each(function(){//选中该元素的所有父根treeview节点
			$(this).children().first().addClass("active");
		});
		//3.给自己添加选中态
		$(e).addClass("active");
		//4.折叠其它treeview
		$("#menutree").children("li.has-treeview.menu-open").each(function(){//children只寻找一层，即只查找儿子元素
			if($(this).find("a.active").length==0){ //find会查找所有子元素，包括孙子曾孙等
				$(this).children().first().click();
			}
		});
		//5.加载网页
		var url = $(e).data("url");
		console.log(url); //要跳转的url
		$("#iframeMain").attr("src",url);
	}