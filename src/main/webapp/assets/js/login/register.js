/**
 * 
 */

var REGI = {
	global : {

	},
	
	memRegi:function(){
		
		var data = {
				ID: $("#id").val(),
				PW: $("#password").val(),
				EMAIL: $("#email").val(),
				NAME: $("#name").val()
		};
		
		
		$.ajax({
			url:"../login/ajaxRegister",
			type:"post",
			dataType:"json",
			data:data,
			success:function(result){
				console.log(result);
				location.reload();
			},
			error:function(error){
				console.log("ERRRRRRRRRRRRRRRRRRR");
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
