package br.com.programadoresemacao.global;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;
import br.com.programadoresemacao.annotations.HelpListView;
import br.com.programadoresemacao.bean.AdapterListView;
import br.com.programadoresemacao.bean.Pessoa;
import br.com.programadoresemacao.projetoaula.R;

public class Utils {
	
	public ListView geraListView(ArrayList<Object> obj, Activity activity){
		int idListView = (obj.get(0).getClass().getAnnotation(HelpListView.class)).listView();
		ListView retorno = (ListView) activity.findViewById(idListView);
		AdapterListView adapterListView = new AdapterListView(activity, obj);
		retorno.setAdapter(adapterListView);
		
		return retorno;
	}
}
