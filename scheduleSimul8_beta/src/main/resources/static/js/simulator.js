/**
 * simulatorページ
 */
'use strict';


// テーブル上で右クリックした行数
let rowIndex;

// DOM読み込み後にロードする処理
$(function() {

	// ボディの左クリック
	$(document).on('click', function(e) {
		// コンテキストメニューの非表示
		$('#contextmenu').get(0).style.display = "none";

		// return falseしないこと
		// NOTE: 検索ボタン押下時のBootstrap JS処理も無効になる
	});

	// 追加ボタンへのイベント登録
	$('#addRowB').on('click', addRow);
	// コンテキストメニュー１行目へのイベント登録
	$('#contextmenu > ul > li:eq(0)').on('click', copyRow);
	// コンテキストメニュー２行目へのイベント登録
	$('#contextmenu > ul > li:eq(1)').on('click', removeRow);

	//
	addEventListener();
});

// 最新のテーブルに対してイベント登録
function addEventListener() {

	// コンテキストメニュー表示対象要素の取得
	let targets = $('.showContextmenu');
	// 対象要素にイベントリスナーを登録
	targets.each(function(index, element) {

		// オリジナルの右クリック
		$(element).on('contextmenu', function(e) {
			// マウス位置を取得して表示位置を調整
			$('#contextmenu').get(0).style.left = e.pageX + "px";
			$('#contextmenu').get(0).style.top = e.pageY + "px";
			// コンテキストメニューの表示
			$('#contextmenu').get(0).style.display = "block";
			// テーブル上で右クリックした行数を設定
			rowIndex = index;

			// NOTE:デフォルトのコンテキストメニューを出さないためにfalseとする
			return false;
		});
	});
}

// TODO: 全行が存在しない場合の処理
// TODO: No.の振り直し
// 行追加
function addRow(e) {
	// 最終行を複写して追加。入力値をクリアする
	$('#table tbody tr:last-child').clone(true).appendTo('#table tbody');
	$("#table tbody tr:last-child input").val("");

	// 最新のテーブル内容似合わせてイベント再登録
	addEventListener();

	// 親要素にイベント伝播させない
	// NOTE: falseにしないと、行追加しても、テーブルが初期化されてしまう
	return false;
}

// 行複写
function copyRow(e) {
	// 右クリックした行をコピーして次の行に追加
	let newRow = $('#table > tbody > tr').eq(rowIndex).clone(true);
	$('#table > tbody > tr').eq(rowIndex).after(newRow);

	// 最新のテーブル内容似合わせてイベント再登録
	addEventListener();
	return false;
}

// 行削除
function removeRow(e) {
	// 右クリックした行を削除
	$('#table > tbody > tr').eq(rowIndex).remove();

	// 最新のテーブル内容似合わせてイベント再登録
	addEventListener();
	return false;
}

