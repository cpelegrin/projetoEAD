package br.com.cpelegrin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        final EditText texto = findViewById(R.id.editTexto);
        ImageButton imgBotao = findViewById(R.id.imgBotao);

        imgBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "" + texto.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
