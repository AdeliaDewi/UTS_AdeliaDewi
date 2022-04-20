package com.example.uts_adeliadewi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    public static ArrayList<Shape> shapeList = new ArrayList<Shape>();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupData();
        setUpList();
        setUpOnclickListener();
    }

    private void setupData()
    {
        Shape kentang = new Shape("0", "Kentang", R.drawable.kentang);
        shapeList.add(kentang);

        Shape burger = new Shape("1","Burger", R.drawable.burger);
        shapeList.add(burger);

        Shape burger2 = new Shape("2","Burger", R.drawable.burger2);
        shapeList.add(burger2);

        Shape mie = new Shape("3","Mie", R.drawable.mie);
        shapeList.add(mie);

        Shape salad = new Shape("4","Salad", R.drawable.salad);
        shapeList.add(salad);

        Shape dimsum = new Shape("5", "Dimsum", R.drawable.dimsum);
        shapeList.add(dimsum);

    }

    private void setUpList()
    {
        listView = (ListView) findViewById(R.id.shapesListView);

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Shape selectShape = (Shape) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id",selectShape.getId());
                startActivity(showDetail);
            }
        });

    }

}