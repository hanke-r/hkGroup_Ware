/**
 * 
 */

var USIC = {
	global : {

	},
	
	idSearch:function(){
		 var $active = $('.wizard .nav-tabs li.active');
	     nextTab($active);
	     
	},
	
	pwSearch:function(){
		var $active = $('.wizard .nav-tabs li.active');
	    nextTab($active);
	    
		$("#idSearch").css("display", "none");
		$("#pwSearch").css("display", "block");
	},
	
	emailCert:function(){
		var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		if(!re.test($("#email").val())){
			swal("Email 형식이 맞지 않습니다.", "", "error");
			return false;
		}
		var data = {
				EMAIL : $("#email").val()
		};
		
		$.ajax({
			url : '../login/idSearch',
			type : 'post',
			dataType : 'json',
			data : data,
			success:function(rs){
				console.log(rs);
				if(rs.SC == "SUCCESS"){
					swal("Email이 발송되었습니다. 인증번호를 입력해주세요.", "", "success");
					$("#email").attr("readonly", true);
					$("#idCertCheck").css('display', 'block');
				}
				
				if(rs.SC == "FAILED"){
					swal("Email이 없습니다. Email을 확인해주세요.", "", "error");
					return false;
				}
				
			},
			beforeSend:function(){
				$('.wrap-loading').removeClass('display-none');
			},
			complete:function(){
				$('.wrap-loading').addClass('display-none');
			}
		});
		
	},
	
	emailCertChck:function(){
		
		var data = {
				ETOKEN : $("#emailToken").val(),
				EMAIL : $("#email").val()
		};
		
		$.ajax({
			url : '../login/ajaxETokenChck',
			type : 'post',
			dataType : 'json',
			data : data,
			success:function(rs){
				if(rs.SC.result == "SUCCESS"){
					var $active = $('.wizard .nav-tabs li.active');
				    nextTab($active);
				    var html = "";
				    $("#compIdShow").append(html);
				    
				    
				    html 
				    	= "<h3 style='text-align : center;'>ID : <font color='blue'>"+rs.SC.username+"</font> 입니다.</h3>"
						+ "<ul class='list-inline pull-right'>"
		                + "		<li><button type='button' class='btn btn-default' onclick=\"location.href='/login/loginForm';\">로그인</button></li>"
		                + "</ul>";			
				    
				    $("#compIdShow").append(html);
				} else{
					swal("인증번호가 맞지않습니다. 다시 확인해주세요.", "", "error");
				}
				
				
			}
		});
	}
}
