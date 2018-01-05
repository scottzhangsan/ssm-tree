<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EasyUI-Tree</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout">
 <!--     <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>    -->
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>   
    <!-- <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>   --> 
    <div data-options="region:'west',title:'菜单',split:true" style="width:200px;">
   <ul id="tt"></ul>
    </div>   
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
   <div id ="demo">

  </div>
    </div>   

    
   
	<script type="text/javascript">
	$(function(){
		
		
		
		$('#tt').tree({
		    url: "/category/async",
		    animate:true,
		    onClick: function(node){
		    	if($(this).tree("isLeaf",node.target)){ // 如果该节点是叶节点就填写到categoryId中,并关闭窗口
    				if(node.url){
    					alert(node.url );
    				}
    			}
    		}
		});
		
		 $("#demo").load('login2.jsp');
		
	});
	
	// 官方提供的 js 解析 json 代码
	function convert(rows){
		function exists(rows, parentId){
			for(var i=0; i<rows.length; i++){
				if (rows[i].id == parentId) return true;
			}
			return false;
		}
		var nodes = [];
		for(var i=0; i<rows.length; i++){	// get the top level nodes
			var row = rows[i];
			if (!exists(rows, row.parentId)){
				nodes.push({
					id:row.id,
					text:row.text,
					state:row.state
				});
			}
		}
		var toDo = [];
		for(var i=0; i<nodes.length; i++){
			toDo.push(nodes[i]);
		}
		while(toDo.length){
			var node = toDo.shift();	// the parent node
			for(var i=0; i<rows.length; i++){	// get the children nodes
				var row = rows[i];
				if (row.parentId == node.id){
					var child = {id:row.id,text:row.text,state:row.state};
					if (node.children){
						node.children.push(child);
					} else {
						node.children = [child];
					}
					toDo.push(child);
				}
			}
		}
		return nodes;
	}

	</script>
	
	

</body>
</html>
