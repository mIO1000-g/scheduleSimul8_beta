//$(function() {
//	$("#confirmB").click(function(e) {
//		// type="submit"の場合はデフォルトの動作を抑止する
//		//event.preventDefault();
//		$.ajax({
//			url : "/project_edit/confirm",	// リクエストを送信するURLを指定
//			type : "POST",						// HTTPメソッドを指定（デフォルトはGET）
//			data : $("form").serialize(),
//			dataType : "json",
//		}).done(function(data) {
//			let msg = data["message"];
//			console.log(msg);
//			if ("OK" === msg) {
//
//				alert("更新しました");
//			} else {
//				alert("更新失敗しました");
//			}
//
//		}).fail(function() {
//			alert("error!"); // 通信に失敗した場合の処理
//		});
//	});
//});