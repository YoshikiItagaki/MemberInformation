package jp.co.aforce.message;

import java.util.HashMap;

public class Messages {

	public HashMap<String, String> message(){

		HashMap<String, String> m = new HashMap<>();

		//warning
		m.put("001", "{0}は必須入力項目です。");

		//errors
		m.put("101", "会員情報が既に登録されています。");
		m.put("102", "会員情報の登録に失敗しました。");
		m.put("103", "入力された情報は登録されていません。");
		m.put("104", "会員情報は更新されませんでした。");
		m.put("105", "会員情報の削除に失敗しました。");


		//information
		m.put("200", "会員登録処理を続けます。");
		m.put("201", "会員情報の登録が完了しました。");
		m.put("202", "会員情報の確認に成功しました。");
		m.put("203", "会員情報の更新が完了しました。");
		m.put("204", "会員情報は削除されました。");



		return m;
	}


}
