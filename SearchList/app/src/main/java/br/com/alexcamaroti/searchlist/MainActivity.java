package br.com.alexcamaroti.searchlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView jListView;
    SearchView jSearchView;
   CheckWordTypoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jListView = (ListView) findViewById(R.id.jListView);
        jSearchView = (SearchView) findViewById(R.id.jSearchView);


        String[] names = {"Alex", "Bruno","Carol","Daniel", "Yago", "Iago", "Ferdinando"};
        adapter = new CheckWordTypoAdapter(this,android.R.layout.simple_list_item_1, Arrays.asList(names));
        jListView.setAdapter(adapter);

        jSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                //CheckWordTypoUtil.isTypoWord(newText);
                //Pego o tanto que eu digitei. E encontrar resultados com o mesmo tamanho de caracteres ou 1 digito menor.
                //Se for um digito menor, ver se o conteúdo é identico. //Se for do mesmo tamanho, verificar se existe no máximo 1 erro.
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });


    }
}
