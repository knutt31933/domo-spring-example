var SERVICURL = "/service";

function btnclick(){
	
	var title = $("#title").val();
	var story = $("#story").val();
	$.ajax({
		
		url : SERVICURL+"/findByTitleAndStory?aTitle="+title+"&aStory="+story,
		type: "GET",
		success:function(response){
			for(var i=0;i<response.length;i++){
				$('#tb tbody').append('<tr class="child"><td>'+response[i].title+" "+response[i].story+'</td></tr>');
			}
			console.log(response.length);
			
		},
		error : function(error){
			console.log("error");
		}
		
	});
	console.log(title + " " +story);
}


function addWebboard(){
	
	
	$("#tb2 tbody").empty();
	var addauthor = $("#inauthor").val();
	var addtitle = $("#intitle").val();
	var addstory = $("#instory").val();
	var addcreatedate = "2023-07-06";
	var addupdatedate = "2022-07-06";
	var addisactive = "hello";
	
	
	var postData = {
			author : addauthor ,
			title : addtitle,
			story : addstory,
			isActive : addisactive,
			createBy : addcreatedate,
			updateBy : addupdatedate
	};
	
$.ajax({
		
		url : SERVICURL+"/addWebboard",
		type: "POST",
		data : JSON.stringify(postData),
		contentType : "application/json; charset=utf-8",
		success:function(response){
			findAll();
		},
		error : function(error){
			console.log("error");
		}
		
	});


}

$(document).ready(function(){
	findAll();
	
});


function findAll(){

	$.ajax({
		url : SERVICURL+"/findAll",
		type : "GET",
		success:function(response){
			for(var i=0;i<response.length;i++){
				var td1 ='<td>'+response[i].title+'</td>';
				var td2 ='<td>'+response[i].story+'</td>';
				var td3 ='<td>'+response[i].author+'</td>';
				var td4 ='<td>'+response[i].isActive+'</td>';
				var td5 ='<td>'+response[i].createDate+'</td>';
				var td6 ='<td>'+response[i].createBy+'</td>';
				var td7 ='<td>'+response[i].updateDate+'</td>';
				var td8 ='<td>'+response[i].updateBy+'</td>';
				$('#tb2 tbody').append('<tr class="child2">'+td1+td2+td3+td4+td5+td6+td7+td8+'</tr>');
			}
			console.log(response.length);
			
		},
		error : function(error){
			console.log("error");
		}
	});
}

function custom(){
	var title = $("#puttitle").val();
	var story = $("#teststory").val();
	var author = $("#testauthor").val();
	
	$.ajax({
		
		url : SERVICURL+"/findByTitleAndStoryAndAuthor?aTitle="+title+"&aStory="+story+"&aAuthor="+author,
		type: "GET",
		success:function(response){
			for(var i=0;i<response.length;i++){
				$('#tb tbody').append('<tr class="child"><td>'+response[i].title+" "+response[i].story+" "+response[i].author+'</td></tr>');
			}
			console.log(response.length);
			
		},
		error : function(error){
			console.log("error");
		}
		
	});
}

