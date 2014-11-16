package br.com.programadoresemacao.activity;

import java.util.ArrayList;

import br.com.programadoresemacao.projetoaula.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ComponentesActivity extends Activity implements OnClickListener, OnItemSelectedListener{
	
	Button btnExemplo;
	
	ArrayList<CheckBox> checkboxs;
	Button btnTesteCheckBox;

	RadioGroup rdgRadioGroup;
	Button btnTesteRadioButton;
	
	Spinner cbxSpinner;
	boolean exibirToast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_componentes);
		
		carregaComponentes();
		carregaListeners();
		carregaDados();
	}

	private void carregaComponentes() {
		btnExemplo = (Button)findViewById(R.id.componentes_btnButton);
		
		checkboxs = new ArrayList<CheckBox>();
		btnTesteCheckBox = (Button) findViewById(R.id.componentes_teste_checkbox);
		
		rdgRadioGroup = (RadioGroup)findViewById(R.id.componentes_radio_group);
		btnTesteRadioButton = (Button)findViewById(R.id.componentes_teste_radiobutton);
		
		cbxSpinner = (Spinner) findViewById(R.id.componentes_spinner);
		
		
		
	}
	
	private void carregaListeners() {
		btnExemplo.setOnClickListener(this);
		btnTesteCheckBox.setOnClickListener(this);
		btnTesteRadioButton.setOnClickListener(this);
		cbxSpinner.setOnItemSelectedListener(this);
	}
	
	private void carregaDados() {
		checkboxs.add((CheckBox) findViewById(R.id.componentes_chk1));
		checkboxs.add((CheckBox) findViewById(R.id.componentes_chk2));
		checkboxs.add((CheckBox) findViewById(R.id.componentes_chk3));
		checkboxs.add((CheckBox) findViewById(R.id.componentes_chk4));
		checkboxs.add((CheckBox) findViewById(R.id.componentes_chk5));
		
		String[] itensSpinner = {"spinner item1","spinner item2","spinner item3"};
		ArrayAdapter<String> arrayAdapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itensSpinner);
		cbxSpinner.setAdapter(arrayAdapterSpinner);
		exibirToast = false;
		
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
		case R.id.componentes_teste_radiobutton:
			testaRadioButton();
			break;
		}
	}
	
	@Override
	public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {
		if(exibirToast){
			String mensagem = "Item selecionado: ";
			mensagem += cbxSpinner.getSelectedItem().toString();
			mensagem += "\nPosicao: ";
			mensagem += position;
			Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
		}
		
		exibirToast = true;
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		
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
	
	private void testaRadioButton() {
		 
		switch (rdgRadioGroup.getCheckedRadioButtonId()) {
		case R.id.componentes_radioButton1:
			Toast.makeText(this, "RadioButton1 Selecionado", Toast.LENGTH_SHORT).show();
			break;
		case R.id.componentes_radioButton2:
			Toast.makeText(this, "RadioButton2 Selecionado", Toast.LENGTH_SHORT).show();
			break;
		case R.id.componentes_radioButton3:
			Toast.makeText(this, "RadioButton3 Selecionado", Toast.LENGTH_SHORT).show();
			break;
		default:
			Toast.makeText(this, "Nenhum RadioButton Selecionado", Toast.LENGTH_SHORT).show();
			break;
		}
	}

	

}
