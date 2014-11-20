package br.com.programadoresemacao.bean;

import java.util.List;

import br.com.programadoresemacao.projetoaula.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterListView extends BaseAdapter{
	private LayoutInflater mInflater;
    private List<Pessoa> itens;
    private Context context;
    
	public AdapterListView(Context context, List<Pessoa> itens) { 
		this.itens = itens; 
		this.context = context;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return itens.size();
	}

	@Override
	public Object getItem(int position) {
		return itens.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	@SuppressWarnings("unused")
	public View getView(int position, View viewParametro, ViewGroup parent) {
		Pessoa pessoa = itens.get(position);
		
		if(viewParametro == null){
			viewParametro = mInflater.inflate(R.layout.item_pessoa,null);
		}
		
		ImageView imageOperadora = ((ImageView) viewParametro.findViewById(R.id.image));
		imageOperadora.setImageResource(pessoa.getImagem());
		
		TextView tvNome = ((TextView) viewParametro.findViewById(R.id.nome));
		tvNome.setText(pessoa.getNome());
		
		TextView tvTelefone = ((TextView) viewParametro.findViewById(R.id.cpf));
		tvTelefone.setText(pessoa.getCpf());
		
		return viewParametro;
	}

}
