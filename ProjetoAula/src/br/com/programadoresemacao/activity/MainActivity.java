package br.com.programadoresemacao.activity;

import br.com.programadoresemacao.projetoaula.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
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
		case R.id.main_btn_text_view:
			intent = new Intent(this, TextViewActivity.class);
			startActivity(intent);
		break;
		}
	}


}
