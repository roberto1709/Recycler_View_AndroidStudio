package com.myapp.rober.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<EntityNews> entityNewsArrayList;

    int layoutview = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        prepare_news();
    }

    public void prepare_news()
    {
        entityNewsArrayList = new ArrayList<>();

        entityNewsArrayList.add(new EntityNews("https://imagenes.universia.net/gc/net/images/gente/5/5-/5-c/5-claves-de-los-estudiantes-universitarios-de-hoy.jpg","USA","How International Students Can Practice English"));
        entityNewsArrayList.add(new EntityNews("https://imagenes.universia.net/gc/net/images/gente/5/5-/5-c/5-claves-de-los-estudiantes-universitarios-de-hoy.jpg","India","International Yoga Day Theme Of The Year"));
        entityNewsArrayList.add(new EntityNews("https://imagenes.universia.net/gc/net/images/gente/5/5-/5-c/5-claves-de-los-estudiantes-universitarios-de-hoy.jpg","Canada","World Development Report the Age of Global Value Chains"));

        entityNewsArrayList.add(new EntityNews("https://imagenes.universia.net/gc/net/images/gente/5/5-/5-c/5-claves-de-los-estudiantes-universitarios-de-hoy.jpg","USA","How International Students Can Practice English"));
        entityNewsArrayList.add(new EntityNews("https://imagenes.universia.net/gc/net/images/gente/5/5-/5-c/5-claves-de-los-estudiantes-universitarios-de-hoy.jpg","India","International Yoga Day Theme Of The Year"));
        entityNewsArrayList.add(new EntityNews("https://imagenes.universia.net/gc/net/images/gente/5/5-/5-c/5-claves-de-los-estudiantes-universitarios-de-hoy.jpg","Canada","World Development Report the Age of Global Value Chains"));

        entityNewsArrayList.add(new EntityNews("https://imagenes.universia.net/gc/net/images/gente/5/5-/5-c/5-claves-de-los-estudiantes-universitarios-de-hoy.jpg","USA","How International Students Can Practice English"));
        entityNewsArrayList.add(new EntityNews("https://imagenes.universia.net/gc/net/images/gente/5/5-/5-c/5-claves-de-los-estudiantes-universitarios-de-hoy.jpg","India","International Yoga Day Theme Of The Year"));
        entityNewsArrayList.add(new EntityNews("https://imagenes.universia.net/gc/net/images/gente/5/5-/5-c/5-claves-de-los-estudiantes-universitarios-de-hoy.jpg","Canada","World Development Report the Age of Global Value Chains"));

        entityNewsArrayList.add(new EntityNews("https://imagenes.universia.net/gc/net/images/gente/5/5-/5-c/5-claves-de-los-estudiantes-universitarios-de-hoy.jpg","USA","How International Students Can Practice English"));
        entityNewsArrayList.add(new EntityNews("https://imagenes.universia.net/gc/net/images/gente/5/5-/5-c/5-claves-de-los-estudiantes-universitarios-de-hoy.jpg ","India","International Yoga Day Theme Of The Year"));
        entityNewsArrayList.add(new EntityNews("https://images.app.goo.gl/JcDJ8Lrjnz3t5jcK9","Canada","World Development Report the Age of Global Value Chains"));

        CustomAdapter customAdapter= new CustomAdapter(entityNewsArrayList,MainActivity.this);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_change)
        {
            if(layoutview==0){
                layoutManager= new GridLayoutManager(this, 2);
                recyclerView.setLayoutManager(layoutManager);
                layoutview=1;
            }
            else if(layoutview==1){
                layoutManager= new LinearLayoutManager(this);
                recyclerView.setLayoutManager(layoutManager);
                layoutview=0;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}

