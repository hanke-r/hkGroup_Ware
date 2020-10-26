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

	memOptionChange : function(userId) {
		swal("Member Grade Change!", "변경하시겠습니까?", "warning");
	},
}
