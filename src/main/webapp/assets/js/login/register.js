/**
 * 
 */

var REGI = {
	global : {

	},
	
	memRegi:function(){
		
		var formData = new FormData();
		formData.append('ID', $("#id").val());
		formData.append('PW', $("#password").val());
		formData.append('EMAIL', $("#email").val());
		formData.append('NAME', $("#name").val());
		
		$.ajax({
			url:"../login/register",
			data:formData,
			dataType:"json",
			contentType: false,
			processData: false,
			type:"post",
			success:function(){
				location.reload();
			}
		});
	},
	
	register:function(){
		
		if($("#id").val() == "" || $("#id").val() == null){
			alert("ID를 입력해주세요");
		}
		
		else if($("#password").val() == "" || $("#password").val() == null){
			alert("password를 입력해주세요");
		}
		
		else if($("#re_password").val() == "" || $("#re_password").val() == null){
			alert("비밀번호를 확인해주세요");
		}
		
		else if($("#email").val() == "" || $("#email").val() == null){
			alert("email를 입력해주세요");
		}
		
		else if($("#name").val() == "" || $("#name").val() == null){
			alert("name을 입력해주세요");
		} else{
			REGI.memRegi();
		}
		
	},
	
}
