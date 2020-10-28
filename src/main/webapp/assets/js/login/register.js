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
			swal("ID를 입력해주세요.","","error");
		}
		
		else if($("#password").val() == "" || $("#password").val() == null){
			swal("password를 입력해주세요","","error");
		}
		
		else if($("#re_password").val() == "" || $("#re_password").val() == null){
			swal("비밀번호를 확인해주세요", "", "error");
		}
		
		else if($("#email").val() == "" || $("#email").val() == null){
			swal("email를 입력해주세요", "", "error");
		}
		
		else if($("#name").val() == "" || $("#name").val() == null){
			swal("이름을 입력해주세요","","error");
		} else{
			REGI.memRegi();
		}
		
	},
	
}
