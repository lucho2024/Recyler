package com.example.recyler;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList <String>listadatos;

    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler=(RecyclerView)findViewById(R.id.recyclerid);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        new scrape().execute();

    }

    class scrape extends AsyncTask<Void,Void,ArrayList<String>>
    {

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {

            try {

                ArrayList<String> lista = new ArrayList<>();

                Document html = Jsoup
                        .connect("https://tmofans.com/viewer/5d25793eabf05/cascade")
                        .get();

                Elements img = html.select("img[class=viewer-image]");

                for (int i = 0; i < img.size(); i++)
                {
                    lista.add(
                            img.get( i ).attr("src")
                    );
                }
                return lista;

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<String> lista) {
            recycler.setAdapter( new adaptador( lista ) );

        }
    }
}
