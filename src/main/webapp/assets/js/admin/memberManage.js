var MANAGE = {
	global : {

	},

	memberManage : function() {
		$.ajax({
			url : '../admin/adminPage',
			type : 'POST',
			dataType : 'json',
			success : function(result) {
			}
		});
	},
	
	
	/*
	 * MEMBER GRADE CHANGING
	 */
	memOptionChange : function(userId) {
		swal({
			title: "Member Grade Change!", 
			text: "승인하시겠습니까?",
			icon: "warning",
			buttons: true,
			showCancelButton: true,
			closeOnConfirm: false,
			cancelButtonText: 'cancel'
		}).then(function(result){
			if(result.dismiss == 'cancel'){
				console.log(cancel);
			}else {
				MANAGE.memJoin(userId);
			}
		});
	},
	
	memJoin: function(userId){
		var data = {
				userId:userId
		}
		
		$.ajax({
			url: '/admin/memChck',
			type:'post',
			dataType:'json',
			data:data,
			success:function(result){
				location.reload();
			}
		});
		
	},
	
	memExpire:function(userId, memGrade){
		if(memGrade != 'ROLE_ADMIN'){
			swal({
				title: "Member Expire!", 
				text: "강퇴하시겠습니까?",
				icon: "error",
				buttons: true,
				showCancelButton: true,
				closeOnConfirm: false,
				cancelButtonText: 'cancel'
			}).then(function(result){
				if(result.dismiss == 'cancel'){
				}else {
					var data={
						userId:userId	
					};
					
					$.ajax({
						url: '/admin/memExpire',
						type: 'post',
						dataType:'json',
						data:data,
						success:function(result){
							console.log("result = " + result);
							
							location.reload();
						}
					});
				}
			});
		} else {
			swal({
				title : "관리자입니다.",
				icon : "error"
			});
		}
		
	},
}
