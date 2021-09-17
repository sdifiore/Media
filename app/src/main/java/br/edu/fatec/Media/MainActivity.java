package br.edu.fatec.Media;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.fatec.Media.R;

public class MainActivity extends AppCompatActivity {

    private EditText sNotaP1, sNotaP2, sNotaP3;
    private TextView sNotaMedia, sSituacao;
    private float med;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // vinculação da parte gráfica com a codificação

        sNotaP1 = (EditText) findViewById(R.id.notaP1);
        sNotaP2 = (EditText) findViewById(R.id.notaP1);
        sNotaP3 = (EditText) findViewById(R.id.notaP3);
        sNotaMedia = (TextView) findViewById(R.id.notaMedia);
        sSituacao = (TextView) findViewById(R.id.situacaoFinal);

        // Chamada do método "calcular" pelo botão Calcular

        Button calcular = (Button) findViewById(R.id.btCalcular);
        calcular.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular(view);
            }
            });
    }

    // Criação do método para calcular a média

    public void calcular(View view) {
        float p1 = Float.parseFloat(sNotaP1.getText().toString());
        float p2 = Float.parseFloat(sNotaP2.getText().toString());
        float p3 = Float.parseFloat(sNotaP3.getText().toString());

        // média = (P1*2 + P2*3)/5, e a P3 substituirá a menor nota entre a P1 e a P2, caso seja necessário

        if (((p1*2 + p2*3)/5) < 6.0) {
            if (p1*2 < p2*3) {
                p1 = Float.parseFloat(sNotaP3.getText().toString());
            } else { p2 = Float.parseFloat(sNotaP3.getText().toString());
            }
        }

        // cálculo da média

        float med = ((p1*2 + p2*3)/5);
        sNotaMedia.setText(String.valueOf(med));

        if (med >= 6.0f) {
            sSituacao.setText("Aprovado");
        } else {
            sSituacao.setText("Reprovado");
        }
    }

    // Chamada do método "enviar" pelo botão Enviar

    public void enviar(View view) {
        Intent intent = new Intent(getApplicationContext(), br.edu.fatec.Media.ProximaActivity.class);
        intent.putExtra("nota1",((EditText)findViewById(R.id.notaP1)).getText().toString());
        intent.putExtra("nota2",((EditText)findViewById(R.id.notaP1)).getText().toString());
        intent.putExtra("nota3",((EditText)findViewById(R.id.notaP3)).getText().toString());
        intent.putExtra("media", String.valueOf(((TextView)findViewById(R.id.notaMedia))));
        intent.putExtra("sit", String.valueOf(((TextView)findViewById(R.id.situacaoFinal))));
        startActivity(intent);
    }
}
