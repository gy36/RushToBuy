
var login = {
	URL:{
		register : function(){
			return '/user/login';
		}
	},

	//提交
	sbumit:{
		init:function(){
			//绑定注册按钮
			$('#login').click(function () {
				var regUrl = login.URL.register();
				var phone = $('input[name="phone"]').val();
				var pwd = $('input[name="password"]').val();
				//$("[data-toggle='popover']").popover();
				$.post(regUrl, {phone:phone,pwd:pwd}, function (result) {
					if (result && result['success']) {

					     $("#login").attr("data-content", "成功登陆");
						$('#login').popover('show');
						window.location.href = '/seckill';
					}else{
					    $("#login").attr("data-content", result.error);
						$('#login').popover('show');
						//node.html('<span class="label label-success">' + result.error + '</span>');
					}
					var id = setTimeout(
					        function () {
					            $('#login').popover('hide');
					        }, 500
					    );
									
				});
			//		$('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误!</label>').show(300);
			});


			
		}
	}
	
	
		
	

};