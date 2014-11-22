package br.com.programadoresemacao.global;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;
import br.com.programadoresemacao.annotations.HelpListViewActivity;
import br.com.programadoresemacao.bean.AdapterListView;
import br.com.programadoresemacao.bean.Pessoa;
import br.com.programadoresemacao.projetoaula.R;

public class Utils {
	
	public ListView geraListView(ArrayList<Object> obj, Context context){
		int idListView = (obj.get(0).getClass().getAnnotation(HelpListViewActivity.class)).activity();
		ListView retorno = (ListView) ((Activity)context).findViewById(idListView);
		AdapterListView adapterListView = new AdapterListView(context.getApplicationContext(), obj);
		retorno.setAdapter(adapterListView);
		
		return retorno;
	}
	
	/*private class AdapterListView extends BaseAdapter {
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
			View view;
			
			if(viewParametro == null){
				LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = inflate.inflate((obj.getClass().getAnnotation(HelpListViewLayout.class)).layout(), null);
			}else{
				view = viewParametro;
			}
			
			for (Field campo : obj.getClass().getDeclaredFields()) {
				String nomeMetodo = "get" + campo.getName().substring(0,1).toUpperCase() + campo.getName().substring(1);
				Method method;
				try {
					  method = obj.getClass().getMethod(nomeMetodo);
					  
					  if(campo.isAnnotationPresent(HelpListViewTextView.class)){
						  HelpListViewTextView anotacao = campo.getAnnotation(HelpListViewTextView.class);
						  ((TextView) view.findViewById(anotacao.component())).setText((CharSequence) method.invoke(obj));
					  }else if(campo.isAnnotationPresent(HelpListViewImageView.class)){
						  HelpListViewImageView anotacao = campo.getAnnotation(HelpListViewImageView.class);
						  if(anotacao.resource()){
							  ((ImageView) view.findViewById(anotacao.component())).setImageResource((Integer) method.invoke(obj));
						  }else{
							  ((ImageView) view.findViewById(anotacao.component())).setImageBitmap((Bitmap) method.invoke(obj));
						  }
					  }
				} catch (Exception e) {}
			}			
			return view;
		}
	}*/
}
//teste a vera
