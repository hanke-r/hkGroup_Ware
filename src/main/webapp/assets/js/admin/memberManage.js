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
			closeOnConfirm: false
		}).then(function(){
			MANAGE.memJoin(userId);
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

		});
		
		location.reload();
	},
}
