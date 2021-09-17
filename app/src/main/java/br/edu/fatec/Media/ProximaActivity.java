package br.edu.fatec.Media;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.fatec.Media.R;

public class ProximaActivity extends AppCompatActivity {

    private TextView sitFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxima);

        // vinculação da parte gráfica com a codificação

        EditText idDisc = (EditText) findViewById(R.id.disciplina);
        EditText nomeAluno = (EditText) findViewById(R.id.aluno);
        EditText nFaltas = (EditText) findViewById(R.id.faltas);
        TextView sitFinal = (TextView) findViewById(R.id.situacaoFinal);

        // Recuperação das informações passadas da primeira activity

        String n1 = getIntent().getStringExtra("n1");
        String n2 = getIntent().getStringExtra("n2");
        String n3 = getIntent().getStringExtra("n3");
        String md = getIntent().getStringExtra("md");
        String sit = getIntent().getStringExtra("sit");

        // Mensagem a ser compartilhada

        String msg = "O(a) aluno(a) " + nomeAluno + " foi " + sit + " com média " + md + " em " + idDisc + " com as notas P1 = " + n1+ ", P2 = " + n2+ ", P3 = " + n3 + " e " + nFaltas + " faltas!";
        sitFinal.setText(msg);
    }

    // Criação do método "compartilhar" pelo botão Compartilhar

    public void compartilhar(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Situação acadêmica");
        intent.putExtra(Intent.EXTRA_TEXT, String.valueOf(sitFinal));
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "Compartilhando com..."));
    }
}
