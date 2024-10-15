package com.trup1.euphoria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.content.SharedPreferences;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class SearchActivity extends AppCompatActivity {
    ListView listView;
    private SearchView searchView;

    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        bnView = findViewById(R.id.bnView);



        //ListView & Autocomplete

        ArrayList<String> arrNames = new ArrayList<>();
        listView = findViewById(R.id.list);
        searchView = findViewById(R.id.search_view);

        arrNames.add("I Knew You Were Trouble" + "\n( Taylor swift)"+"\t( Rock)");           //1
        arrNames.add("Faded" + "\n( Alan walker)"+"\t( Sad)");                                      //2
        arrNames.add("Hamdard" + "\n( Arijit singh)"+"\t( Sad)");                                   //3
        arrNames.add("Snow On The Beach" + "\n( Taylor swift)"+"\t( Rock)");                         //4
        arrNames.add("Fitoori" + "\n( Shreya ghoshal)"+"\t( Sad)");                                 //5
        arrNames.add("Pinga" + "\n( Shreya ghoshal)"+"\t( Happy)");                                    //6
        arrNames.add("O Re Piya" + "\n( Atif Aslam)"+"\t( Happy)");                                  //7
        arrNames.add("Baby Calm Down" + "\n( Rema)"+"\t( Happy)");                                    //8
        arrNames.add("Shape Of You" + "\n( Ed shareen)"+"\t( Rock)");                                //9
        arrNames.add("Despacito" + "\n( Luis Fonsi)"+"\t( Rock)");                                   //10
        arrNames.add("Pasoori" + "\n( Shae Gill, Ali Sethi)"+"\t( Happy)");                           //11
        arrNames.add("Bheega Bheega Ye Sama" + "\n( Lata Mangeshkar)"+"\t( Old)");                  //12
        arrNames.add("Jab Tak" + "\n( Armaan Malik)"+"\t( Sad)");                                   //13
        arrNames.add("Haye Rama" + "\n( Hariharan, Swarnalatha)"+"\t( Sad)");                       //14
        arrNames.add("Sawan Aya He" + "\n( Arijit Singh)"+"\t( Happy)");                              //15


            ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrNames);
            listView.setAdapter(adapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });







    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            String selectedSongName = (String) adapterView.getItemAtPosition(position);

            if (selectedSongName.equals("I Knew You Were Trouble" + "\n( Taylor swift)"+"\t( Rock)")){

                startActivity(new Intent(SearchActivity.this, MusicPlayerActivity.class));
            }
            else if (selectedSongName.equals("Faded" + "\n( Alan walker)"+"\t( Sad)")){

                startActivity(new Intent(SearchActivity.this, song2.class));
            }
            else if (selectedSongName.equals("Hamdard" + "\n( Arijit singh)"+"\t( Sad)")){

                startActivity(new Intent(SearchActivity.this, song3.class));
            }
            else if(selectedSongName.equals("Snow On The Beach" + "\n( Taylor swift)"+"\t( Rock)")){

                startActivity(new Intent(SearchActivity.this, song4.class));
            }
            else if (selectedSongName.equals("Fitoori" + "\n( Shreya ghoshal)"+"\t( Sad)")){

                startActivity(new Intent(SearchActivity.this, song5.class));
            }
            else if (selectedSongName.equals("Pinga" + "\n( Shreya ghoshal)"+"\t( Happy)")){

                startActivity(new Intent(SearchActivity.this, song6.class));
            }
            else  if (selectedSongName.equals("O Re Piya" + "\n( Atif Aslam)"+"\t( Happy)")){

                startActivity(new Intent(SearchActivity.this, song7.class));
            }
            else  if (selectedSongName.equals("Baby Calm Down" + "\n( Rema)"+"\t( Happy)")){

                startActivity(new Intent(SearchActivity.this, song8.class));
            }
            else  if (selectedSongName.equals("Shape Of You" + "\n( Ed shareen)"+"\t( Rock)")) {

                startActivity(new Intent(SearchActivity.this, song9.class));
            }
            else  if (selectedSongName.equals("Despacito" + "\n( Luis Fonsi)"+"\t( Rock)")){

                startActivity(new Intent(SearchActivity.this, song10.class));
            }
            else if (selectedSongName.equals("Pasoori" + "\n( Shae Gill, Ali Sethi)"+"\t( Happy)")){

                startActivity(new Intent(SearchActivity.this, song11.class));
            }
            else  if (selectedSongName.equals("Bheega Bheega Ye Sama" + "\n( Lata Mangeshkar)"+"\t( Old)")){

                startActivity(new Intent(SearchActivity.this, song12.class));
            }
            else  if (selectedSongName.equals("Jab Tak" + "\n( Armaan Malik)"+"\t( Sad)")){

                startActivity(new Intent(SearchActivity.this, song13.class));

            }  else  if (selectedSongName.equals("Haye Rama" + "\n( Hariharan, Swarnalatha)"+"\t( Sad)")){

                startActivity(new Intent(SearchActivity.this, song14.class));

            }  else  if (selectedSongName.equals("Sawan Aya He" + "\n( Arijit Singh)"+"\t( Happy)")){

                startActivity(new Intent(SearchActivity.this, song15.class));
            }

        }
    });






        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_Home) {
                    startActivity(new Intent(SearchActivity.this,HomeActivity.class));
                    finish();

                }
                else if (id == R.id.nav_Library) {
                    startActivity(new Intent(SearchActivity.this,LibraryActivity.class));
                    finish();

                } else if (id == R.id.nav_Premium) {
                    startActivity(new Intent(SearchActivity.this,PremiumActivity.class));
                    finish();

                } else {

                }
                return true;
            }


        });
        bnView.setSelectedItemId(R.id.nav_Search);
    }



}


