package br.com.trinopolo.appfile2;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.Preference;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        atualizaTela();
    }


    private void atualizaTela() {

        TextView textView =
                (TextView) findViewById(R.id.textView);


        SharedPreferences config = getSharedPreferences("config", MODE_PRIVATE);

        if(config.getBoolean("modo_noturno", false) == true) {

            textView.setBackgroundColor(Color.BLACK);

        } else {

            textView.setBackgroundColor(Color.WHITE);

        }
    }

    public void modoDiurno(View view) {

        SharedPreferences config = getSharedPreferences("config", MODE_PRIVATE);

        config.edit().putBoolean("modo_noturno", false).commit();

        atualizaTela();
    }

    public void modoNoturno(View view) {

        SharedPreferences config = getSharedPreferences("config", MODE_PRIVATE);

        config.edit().putBoolean("modo_noturno", true).commit();

        atualizaTela();
    }
}
