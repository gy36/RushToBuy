
var register = {
	URL:{
		register : function(){
			return '/user/sign_v1';
		}
	},

	//提交
	sbumit:{
		init:function(){
			//绑定注册按钮
			$('#register').click(function () {
				var regUrl = register.URL.register();
				var phone = $('input[name="phone"]').val();
				var re_pwd = $('input[name="re_password"]').val();
				var pwd = $('input[name="password"]').val();
				//$("[data-toggle='popover']").popover();
				$.post(regUrl, {phone:phone,re_pwd:re_pwd,pwd:pwd}, function (result) {
					if (result && result['success']) {
						var stateInfo = result['stateInfo'];

					     $("#register").attr("data-content", "成功注册");
						$('#register').popover('show');
						window.location.href = '/user/login';
					}else{
					    $("#register").attr("data-content", result.error);
						$('#register').popover('show');
						//node.html('<span class="label label-success">' + result.error + '</span>');
					}
					var id = setTimeout(
					        function () {
					            $('#register').popover('hide');
					        }, 500
					    );
									
				});
				
			//		$('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误!</label>').show(300);
				
			});


			
		}
	}
	
	
		
	

};