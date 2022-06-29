// DOM読み込み後にロードする処理
$(function() {

	// ロード時にチェック済の選択肢を選択済タグの表示部に追加
	addTagOnLoad();

	// タグチェックボックス　クリック時
	$('.taglist input').on('click' , function() {
		// 選択済タグの表示部を取得
		let tagSelectedWrapper = $('.tagselected-wrapper');

		let htmls = [];

		if ($(this).prop('checked')) {
			// チェックONの場合、選択済タグの表示部に追加
			let text = $(this).parent().text();
			htmls.push('<a data-value="' + $(this).val() +'"><em>' + text + '</em><i></i></a>');
			tagSelectedWrapper.append(htmls);
		} else {
			// 上記以外の場合、選択済タグの表示部から除去
			$('[data-value="' + $(this).val() + '"]').remove();
		}
	});

});

// ロード時にタグを一括して表示部に追加
function addTagOnLoad() {
	// TODO:複数化
	// タグについてチェックONの選択肢を探す
	let tagList = $('.taglist');
	let lis = tagList.find('input[checked]');
	// 選択済タグの表示部を取得
	let tagSelectedWrapper = $('.tagselected-wrapper');

	let htmls = [];

	// チェック済の要素内容を選択済タグの表示部に追加
	lis.each(function() {
		//let val = $(this).val();
		let text = $(this).parent().text();
		htmls.push('<a data-value="' + $(this).val() +'"><em>' + text + '</em><i></i></a>');
	});

	tagSelectedWrapper.append(htmls);
}
