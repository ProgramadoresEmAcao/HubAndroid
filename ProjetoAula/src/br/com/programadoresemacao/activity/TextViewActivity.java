package br.com.programadoresemacao.activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import br.com.programadoresemacao.projetoaula.R;

public class TextViewActivity extends Activity implements OnClickListener, OnCheckedChangeListener, OnSeekBarChangeListener{
	TextView tvEditar;
	EditText edtTexto;
	Button btnSetText;
	CheckBox ckbNegrigo;
	CheckBox ckbItalico;
	RadioGroup rdgFont;
	SeekBar skbTamanho;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_view);
		
		carregaComponentes();
		carregaListeners();
		carregaDados();
		
		//tvEditar.setTextSize(40);
	}

	private void carregaComponentes() {
		tvEditar = (TextView) findViewById(R.id.text_view_tvEditar);
		
		edtTexto = (EditText) findViewById(R.id.text_view_edtTexto);
		btnSetText = (Button) findViewById(R.id.text_view_btnSetText);
		ckbNegrigo = (CheckBox) findViewById(R.id.text_view_chb_negrito);
		ckbItalico = (CheckBox) findViewById(R.id.text_view_chb_italico);
		rdgFont = (RadioGroup) findViewById(R.id.text_view_rdg_font);
		skbTamanho = (SeekBar) findViewById(R.id.text_view_seekBar1);
	}

	private void carregaListeners() {
		btnSetText.setOnClickListener(this);
		ckbNegrigo.setOnCheckedChangeListener(this);
		ckbItalico.setOnCheckedChangeListener(this);
		rdgFont.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				setTypeFace(getTypeFaceStyle(),getTypeFaceFont());
			}
		});
		skbTamanho.setOnSeekBarChangeListener(this);
		
	}

	private void carregaDados() {
		edtTexto.setText(tvEditar.getText());
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.text_view_btnSetText:
			tvEditar.setText(edtTexto.getText());
			break;
		}
		
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		setTypeFace(getTypeFaceStyle(),getTypeFaceFont());
	}

	private int getTypeFaceStyle() {
		if (ckbItalico.isChecked() && ckbNegrigo.isChecked()) {
			return Typeface.BOLD_ITALIC;
		}else if (ckbNegrigo.isChecked()) {
			return Typeface.BOLD;
		}else if (ckbItalico.isChecked()) {
			return Typeface.ITALIC;
		}else{
			return 0;
		}
	}

	private Typeface getTypeFaceFont() {
		switch(rdgFont.getCheckedRadioButtonId()){
			case R.id.text_view_rdb_sans_serif:
				return Typeface.SANS_SERIF;
			default:
				return Typeface.SERIF;
		}
		
	}
	
	private void setTypeFace(int typeFaceStyle, Typeface TypeFaceFont){
		tvEditar.setTypeface(getTypeFaceFont(), getTypeFaceStyle());
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		tvEditar.setTextSize(progress + 10);
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		
	}

}
