package br.com.programadoresemacao.bean;

import br.com.programadoresemacao.annotations.HelpListView;
import br.com.programadoresemacao.annotations.HelpListViewComponent;
import br.com.programadoresemacao.projetoaula.R;

@HelpListView(listView = R.id.listViewPessoa, itemListView = R.layout.item_pessoa)
public class Pessoa {
	
	public Pessoa(int imagem, String nome, String cpf) {
		this.imagem = imagem;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	@HelpListViewComponent(R.id.image)
	private int imagem;
	
	@HelpListViewComponent(R.id.nome)
	private String nome;
	
	@HelpListViewComponent(R.id.cpf)
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
