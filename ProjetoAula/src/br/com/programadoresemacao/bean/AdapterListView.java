package br.com.programadoresemacao.bean;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import br.com.programadoresemacao.annotations.HelpListView;
import br.com.programadoresemacao.annotations.HelpListViewComponent;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class AdapterListView extends BaseAdapter {
	private LayoutInflater mInflater;
    private List<Object> itens;
    private Context context;
    
	public AdapterListView(Context context, List<Object> itens) { 
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
		Object obj = itens.get(position);
		if(viewParametro == null){
			LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			viewParametro = inflate.inflate((obj.getClass().getAnnotation(HelpListView.class)).itemListView(), null);
		}
		
		for (Field campo : obj.getClass().getDeclaredFields()) {
			String nomeMetodo = "get" + campo.getName().substring(0,1).toUpperCase() + campo.getName().substring(1);
			Method method;
			try {
				  method = obj.getClass().getMethod(nomeMetodo);
				  
				  if(campo.isAnnotationPresent(HelpListViewComponent.class)){
					  HelpListViewComponent anotacao = campo.getAnnotation(HelpListViewComponent.class);
					  View componente = viewParametro.findViewById(anotacao.value());
					  
					  if (componente instanceof TextView) {
						  ((TextView)componente).setText((CharSequence) method.invoke(obj));
					  }else if(componente instanceof ImageView && anotacao.imageTipe().equalsIgnoreCase("RESOURCE")){
							 ((ImageView)componente).setImageResource((Integer) method.invoke(obj));
					  }else if(componente instanceof ImageView && anotacao.imageTipe().equalsIgnoreCase("BITMAP")){
							((ImageView)componente).setImageBitmap((Bitmap) method.invoke(obj));
					  }
				  }
			} catch (Exception e) {}
		}			
		return viewParametro;
	}
}
/*public class AdapterListView extends BaseAdapter{
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

}*/
