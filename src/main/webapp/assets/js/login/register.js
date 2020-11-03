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
				
				// email 인증여부 확인
				if(result.SC == "emailCertError"){
					swal("이메일 인증을 받아주세요.", "", "error");
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
	
	/* ID 중복확인 */
	dupliChck:function(){
		
		var data = {
			duId : $("#id").val(),
		}
		
		if(data.duId == null || data.duId == ""){
			swal("아이디를 입력해주세요.", "", "error");
			return false;
		}
		
		
		$.ajax({
			url : '../login/dupliChck',
			type : 'post',
			dataType : 'json',
			data : data,
			success:function(rs){
				console.log(rs);
				
				if(rs.SC == "DUPLICATION"){
					swal("이미 가입된 ID입니다.", "", "error");
				}
				
				if(rs.SC == "SUCCESS"){
					swal("사용가능한 ID입니다.", "", "success");
				}
			}
		});
	},
	
	/*email 인증*/
	emailCert:function(){
		
		if($("#email").val() == "" || $("#email").val() == null){
			swal("email를 입력해주세요", "", "error");
			return false;
		}
		
		var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		
		if(!regExp.test($("#email").val())){
			swal("이메일을 정확하게 입력해주세요", "(ex : ID @ abc.xyz )", "error");
			return false;
		}
		
		var data = {
				EMAIL : $("#email").val(),
		};
		
		$.ajax({
			url : '../login/emailToken',
			type : 'post',
			dataType : 'json',
			data : data,
			success:function(rs){
				if(rs.SC == "SUCCESS"){
					swal("Email이 발송되었습니다.", "", "success");
					$("#eCertBox").css("display", "block");
					$("#email").attr("readonly", true);
				}
			}
		});
	},
	
	/*Email 인증 확인*/
	tokenCheck:function(){
		
		var data = {
				TOKEN : $("#eCert").val(),
				EMAIL : $("#email").val()
		};
		
		$.ajax({
			url : '../login/tokenChck',
			type: 'post',
			dataType : 'json',
			data:data,
			success:function(rs){
				if(rs.SC == "SUCCESS"){
					
				}
			}
		});
	},
	
}
