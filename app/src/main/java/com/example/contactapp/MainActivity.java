 package com.example.contactapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

 public class MainActivity extends AppCompatActivity {

    private FloatingActionButton add_btn;
    private RecyclerView contactRv;
    private DbHelper dbHelper;
    private AdapterContact adapterContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);

        add_btn = findViewById(R.id.add_btn);
        contactRv = findViewById(R.id.contact_Rv);

        contactRv.setHasFixedSize(true);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,EditContact.class);
                startActivity(intent);
            }
        });
        loadData();
    }

     private void loadData() {
         adapterContact = new AdapterContact(this,dbHelper.getAllData());
         contactRv.setAdapter(adapterContact);
     }

     protected void onResume() {
         super.onResume();
         loadData();
     }

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {

         getMenuInflater().inflate(R.menu.main_top_menu,menu);
         MenuItem item = menu.findItem(R.id.seacrh_contacts);
         SearchView searchView = (SearchView) item.getActionView();
         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
             @Override
             public boolean onQueryTextSubmit(String query) {
                 searchContact(query);
                 return true;
             }

             @Override
             public boolean onQueryTextChange(String newText) {
                 searchContact(newText);
                 return true;
             }
         });
         return true;
     }

     public void searchContact(String query){
         adapterContact = new AdapterContact(this,dbHelper.getSearchContact(query));
         contactRv.setAdapter(adapterContact);

     }

     @Override
     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         switch (item.getItemId()){
             case R.id.deleteAllContact:
                 dbHelper.deleteAllContact();
                 onResume();
                 break;
         }
         return true;
     }


 }