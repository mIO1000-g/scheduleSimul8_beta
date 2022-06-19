$(function() {
	$("#version").on("change", function(e) {
		e.preventDefault(); // デフォルトのイベント(ページの遷移やデータ送信など)を無効にする

		// 切り替え前の選択値を保存
		let _title = $("#title").val();

		$.ajax({
			url : "/test/change", // リクエストを送信するURLを指定（action属性のurlを抽出）
			type : "GET", // HTTPメソッドを指定（デフォルトはGET）
			data : {
				version : $("#version").val()
			// 送信データ
			}
		}).done(function(data) {

			let select = $("#title");

			// optionを全て除去
			select.children().remove();

			// 空行を追加
			select.append("<option value=''></option>");

			let keys = Object.keys(data);
			keys.forEach(function(key, i) {
				// option要素を動的に生成＆追加
				let content = this[key];
				let option = $("<option>")
						.text(content["value"])
						.val(content["key"])
						.prop("selected", _title === content["value"]);
				select.append(option);
			}, data);

		}).fail(function() {
			alert("error!"); // 通信に失敗した場合の処理
		})
	});
});