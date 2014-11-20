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
		mInflater = LayoutInflater.from(context); 
		this.context = context;
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
	public View getView(int position, View viewParametro, ViewGroup parent) {
		Pessoa contato = itens.get(position);
		
		if(viewParametro == null){
			LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			viewParametro = inflate.inflate(R.layout.item_pessoa,null);
		}
		
		ImageView imageOperadora = ((ImageView) viewParametro.findViewById(R.id.image));
		imageOperadora.setImageResource(contato.getImagem());
		
		TextView tvNome = ((TextView) viewParametro.findViewById(R.id.nome));
		tvNome.setText(contato.getNome());
		
		TextView tvTelefone = ((TextView) viewParametro.findViewById(R.id.cpf));
		tvTelefone.setText(contato.getCpf());
		
		return viewParametro;
	}

}
