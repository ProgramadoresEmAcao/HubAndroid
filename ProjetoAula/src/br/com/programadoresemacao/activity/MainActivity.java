package br.com.programadoresemacao.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import br.com.programadoresemacao.bean.Pessoa;
import br.com.programadoresemacao.global.Utils;
import br.com.programadoresemacao.projetoaula.R;

public class MainActivity extends Activity implements OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_pessoa);
	
		ListView lvPessoas = (ListView)findViewById(R.id.listViewPessoa);
		
		ArrayList<Object> pessoas = new ArrayList<Object>();
		pessoas.add(new Pessoa(R.drawable.e1, "Nome1", "12345678911"));
		pessoas.add(new Pessoa(R.drawable.e2, "Nome2", "12345678912"));
		pessoas.add(new Pessoa(R.drawable.e3, "Nome3", "12345678913"));
		
		ListView listViewPessoa = (ListView) findViewById(R.id.listViewPessoa);
		listViewPessoa = (new Utils()).geraListView(pessoas, this);
		
	}
	
	@Override
	public void onClick(View view) {
		
	}
	/*
	Button btnCicloDeVida;
	Button btnComponentes;
	Button btnTextView;
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		carregaElementos();
		carregaListeners();
	}

	private void carregaElementos() {
		btnCicloDeVida = (Button) findViewById(R.id.main_activity_btn_ciclo_de_vida);
		btnComponentes = (Button) findViewById(R.id.main_btn_componentes);
		btnTextView = (Button) findViewById(R.id.main_btn_text_view);
	}

	private void carregaListeners() {
		btnCicloDeVida.setOnClickListener(this);
		btnComponentes.setOnClickListener(this);
		btnTextView.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.main_activity_btn_ciclo_de_vida:
			intent = new Intent(this, CicloDeVidaActivity.class);
			startActivity(intent);
			break;
		case R.id.main_btn_componentes:
			intent = new Intent(this, ComponentesActivity.class);
			startActivity(intent);
			break;
		case R.id.main_btn_text_view:
			intent = new Intent(this, TextViewActivity.class);
			startActivity(intent);
			break;
		}
	}*/


}
