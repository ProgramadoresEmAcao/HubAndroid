package br.com.programadoresemacao.activity;

import br.com.programadoresemacao.projetoaula.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class CicloDeVidaActivity extends Activity {
	
	/*	Conhecer o ciclo de vida de uma activity eh importante
	 * 	Para saber o momento exato de chamar seus metodos.
	 * 	Imagine duas telas, uma lista e uma tela de cadastro
	 * 	a lista possui apenas um item e chamamos o cadastro e salvamos um novo item
	 * 	quando apertarmos o botao voltar, a lista estarah atualizada?
	 * 	depende de onde atualizamos a lista, se for no onCreate a lista ficara
	 * 	apenas com um item, pois ela so atualizara na criacao da activity
	 * 	(lembrando que voltar nao cria uma nova tela)
	 * 	se atualizarmos a lista no onResume, ao apertar o botao voltar
	 * 	na tela de cadastro, a lista estara atualizada(vide imagem
	 * 	Ciclo_de_vida na pasta tutoriais
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ciclo_de_vida);
		Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onPause() {		
		super.onPause();
		Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
	}
}
