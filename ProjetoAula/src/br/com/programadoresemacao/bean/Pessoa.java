package br.com.programadoresemacao.bean;

import br.com.programadoresemacao.annotations.HelpListViewImageView;
import br.com.programadoresemacao.annotations.HelpListViewLayout;
import br.com.programadoresemacao.annotations.HelpListViewTextView;
import br.com.programadoresemacao.projetoaula.R;

@HelpListViewLayout(layout = R.layout.item_pessoa)
public class Pessoa {
	
	public Pessoa(int imagem, String nome, String cpf) {
		this.imagem = imagem;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	@HelpListViewImageView(component = R.id.image)
	private int imagem;
	
	@HelpListViewTextView(component= R.id.nome)
	private String nome;
	
	@HelpListViewTextView(component= R.id.cpf)
	private String cpf;
	
	public String getNome() {
		return nome;
	}
	public int getImagem() {
		return imagem;
	}
	public void setImagem(int imagem) {
		this.imagem = imagem;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
