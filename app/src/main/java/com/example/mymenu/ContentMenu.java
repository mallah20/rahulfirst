package com.example.mymenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ContentMenu extends AppCompatActivity {
ListView listView;
ArrayAdapter aa;
String user;
String[] contacts={"Yash","Niranjan","Khyati","Sanika"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_menu);
        listView=findViewById(R.id.listV);
        aa=new ArrayAdapter(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(aa);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.content_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        user=listView.getOnItemSelectedListener().toString();
        if(item.getTitle().equals("Call")||item.getTitle().equals("SMS")||item.getTitle().equals("Email"))
        {
            Toast.makeText(this,item.getTitle()+user,Toast.LENGTH_SHORT).show();
        }
        else
        {
            return false;
        }
        return super.onContextItemSelected(item);
    }
}
