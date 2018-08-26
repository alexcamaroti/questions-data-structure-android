package br.com.alexcamaroti.searchlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckWordTypoAdapter extends ArrayAdapter<String> {

    private List<String> listaCompleta;
    private List<String> resultados;

    public CheckWordTypoAdapter(@NonNull Context context, int resource, @NonNull List<String> textos) {
        super(context, resource, textos);
        this.listaCompleta = textos;
        this.resultados = listaCompleta;
    }

    @Override
    public int getCount() {
        return resultados.size();
    }

    @Nullable
    @Override
    public String getItem(int position) {
        if (resultados != null
                && resultados.size() > 0
                && position < resultados.size()){
            return resultados.get(position);
        } else {
            return null;
        }
    }

    @NonNull
    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                ArrayList<String> temp = new ArrayList<String>();

                if (constraint != null && constraint.length() > 0) {
                    for (String p : listaCompleta) {
                        boolean isTypoWord = CheckWordTypoUtil.isTypoWord(constraint.toString(), p);
                        if(isTypoWord) {
                            temp.add(p);
                        }
                    }
                } else {
                    temp.addAll(listaCompleta);
                }
                filterResults.values = temp;
                filterResults.count = temp.size();
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                resultados = (ArrayList<String>) filterResults.values;
                notifyDataSetChanged();
            }
        };

        return filter;
    }
}
