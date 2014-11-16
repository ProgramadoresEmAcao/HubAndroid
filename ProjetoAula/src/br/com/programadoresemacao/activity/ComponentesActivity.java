package br.com.programadoresemacao.activity;

import java.util.ArrayList;

import br.com.programadoresemacao.projetoaula.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class ComponentesActivity extends Activity implements OnClickListener{
	
	Button btnExemplo;
	ArrayList<CheckBox> checkboxs;
	Button btnTesteCheckBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_componentes);
		
		carregaComponentes();
		carregaListeners();
	}

	private void carregaComponentes() {
		btnExemplo = (Button)findViewById(R.id.componentes_btnButton);
		
		checkboxs = new ArrayList<CheckBox>();
		checkboxs.add((CheckBox) findViewById(R.id.componentes_chk1));
		checkboxs.add((CheckBox) findViewById(R.id.componentes_chk2));
		checkboxs.add((CheckBox) findViewById(R.id.componentes_chk3));
		checkboxs.add((CheckBox) findViewById(R.id.componentes_chk4));
		checkboxs.add((CheckBox) findViewById(R.id.componentes_chk5));
		btnTesteCheckBox = (Button) findViewById(R.id.componentes_teste_checkbox);
		
	}
	
	private void carregaListeners() {
		btnExemplo.setOnClickListener(this);
		btnTesteCheckBox.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.componentes_btnButton:
			Toast.makeText(this, "Clicou no botao de teste", Toast.LENGTH_SHORT).show();
			break;
		case R.id.componentes_teste_checkbox:
			testaComboBox();
			break;
		}
	}

	private void testaComboBox() {
		String mensagem = "";
		int contador = 0;
		
		for (CheckBox chk : checkboxs) {
			if(chk.isChecked()){
				mensagem += chk.getText().toString() + " - ";
				contador++;
			}
		}
		
		if(contador == 0){
			mensagem = "Nenhum item marcado!";
		}else if(contador == 1){
			mensagem += "Marcado";
		}else if(contador > 1){
			mensagem += "Marcados";
		}
		
		Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
	}

}
