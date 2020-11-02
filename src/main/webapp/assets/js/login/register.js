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
				NAME: $("#name").val(),
				PHONE : $("#phNumber").val()
		};
		
		
		$.ajax({
			url:"../login/ajaxRegister",
			type:"post",
			dataType:"json",
			data:data,
			success:function(result){
				if(result.SC == "SUCCESS"){
					location.href="/login/loginForm";
				}
				
				// email - valid check
				if(result.SC == "emailError"){
					swal("이메일을 정확하게 입력해주세요.", "(ex : ID @ abc.xyz )", "error");
				}
				
				// phone - valid check
				if(result.SC == "phError"){
					swal("핸드폰번호를  정확하게 입력해주세요.", "", "error");
				}
			},
			error:function(error){
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
		} 
		
		else if($("#phNumber").val() == "" || $("#phNumber").val() == null) {
			swal("핸드폰번호를 입력해주세요", "", "error");
		} else{
			REGI.memRegi();
		}
		
	},
	
	userReIdPw:function(){
		console.log("접속 테스트 !!");
	},
	
}
