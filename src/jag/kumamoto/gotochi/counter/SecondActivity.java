
package jag.kumamoto.gotochi.counter;



import android.app.Activity;
import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;

public class SecondActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // アラートダイアログのタイトルを設定します
        alertDialogBuilder.setTitle("熊本ご当地アプリのダウンロード");
        // アラートダイアログのメッセージを設定します
        alertDialogBuilder.setMessage("熊本ご当地アプリをダウンロードしますか？");
        // アラートダイアログの肯定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
        alertDialogBuilder.setPositiveButton("ＯＫ",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    	/*
                    	 * TODO:URIを入れる
                    	 */
                    	Resources res = getResources();
                    	String gotochiuri = new String();
                    	gotochiuri = res.getString(R.string.gotochiurl1) + res.getString(R.string.gotochiurl2);
                    	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(gotochiuri)));  
                    }
                });

        // アラートダイアログの否定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
        alertDialogBuilder.setNegativeButton("キャンセル",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    	startActivity(new Intent(SecondActivity.this,CounterActivity.class));
                    }
                });
        // アラートダイアログのキャンセルが可能かどうかを設定します
        alertDialogBuilder.setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        // アラートダイアログを表示します
        alertDialog.show();
    }
     
}
