package br.com.cpelegrin.myapplication;

import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class BancoDados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banco_dados);

        FloatingActionButton fabDB = findViewById(R.id.FabDB);

        DBHelper db = new DBHelper(this);
        db.insert("linha 1");
        db.insert("linha 2");
        db.insert("linha 3");

        fabDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(getApplicationContext());
                Cursor cursor = db.selectAsterisco();
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    String s = cursor.getString(cursor.getColumnIndex("valor"));
                    Log.e("DB", s);
                    TextView textDB = findViewById(R.id.TextDB);
                    textDB.append("\n"+s);
                    cursor.moveToNext();
                }
            }
        });
    }


}
