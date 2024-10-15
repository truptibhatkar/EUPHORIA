package com.trup1.euphoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class RockActivity extends AppCompatActivity {
    ListView listView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock);


        ArrayList<String> arrNames = new ArrayList<>();
        listView = findViewById(R.id.list);
        searchView = findViewById(R.id.search_view);

        arrNames.add("I Knew You Were Trouble" + "\n(Taylor swift)");           //1
        arrNames.add("Faded" + "\n(Alan walker)");                                      //2
        arrNames.add("Hamdard" + "\n(Arijit singh)");                                   //3
        arrNames.add("Snow On The Beach" + "\n(Taylor swift)");                         //4
        arrNames.add("Fitoori" + "\n(Shreya ghoshal)");                                 //5
        arrNames.add("Pinga" + "\n(Shreya ghosal)");                                    //6
        arrNames.add("O Re Piya" + "\n(Atif Alslam)");                                  //7
        arrNames.add("Baby Calm Down" + "\n(Rema)");                                    //8
        arrNames.add("Shape Of You" + "\n(Ed shareen)");                                //9
        arrNames.add("Despacito" + "\n(Luis Fonsi)");                                   //10
        arrNames.add("Pasoori" + "\n(Shae Gill, Ali Sethi)");                           //11
        arrNames.add("Bheega Bheega Ye Sama" + "\n(Lata Mangeshkar)");                  //12
        arrNames.add("Jab Tak" + "\n(Armaan Malik)");                                   //13
        arrNames.add("Haye Rama" + "\n(Hariharan, Swarnalatha)");                       //14
        arrNames.add("Sawan Aya He" + "\n(Arijit Singh)");                              //15



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

                if (selectedSongName.equals("I Knew You Were Trouble" + "\n(Taylor swift)")){

                    startActivity(new Intent(RockActivity.this, MusicPlayerActivity.class));
                }
                else if (selectedSongName.equals("Faded" + "\n(Alan walker)")){

                    startActivity(new Intent(RockActivity.this, song2.class));
                }
                else if (selectedSongName.equals("Hamdard" + "\n(Arijit singh)")){

                    startActivity(new Intent(RockActivity.this, song3.class));
                }
                else if(selectedSongName.equals("Snow On The Beach" + "\n(Taylor swift)")){

                    startActivity(new Intent(RockActivity.this, song4.class));
                }
                else if (selectedSongName.equals("Fitoori" + "\n(Shreya ghoshal)")){

                    startActivity(new Intent(RockActivity.this, song5.class));
                }
                else if (selectedSongName.equals("Pinga" + "\n(Shreya ghosal)")){

                    startActivity(new Intent(RockActivity.this, song6.class));
                }
                else  if (selectedSongName.equals("O Re Piya" + "\n(Atif Alslam)")){

                    startActivity(new Intent(RockActivity.this, song7.class));
                }
                else  if (selectedSongName.equals("Baby Calm Down" + "\n(Rema)")){

                    startActivity(new Intent(RockActivity.this, song8.class));
                }
                else  if (selectedSongName.equals("Shape Of You" + "\n(Ed shareen)")) {

                    startActivity(new Intent(RockActivity.this, song9.class));
                }
                else  if (selectedSongName.equals("Despacito" + "\n(Luis Fonsi)")){

                    startActivity(new Intent(RockActivity.this, song10.class));
                }
                else if (selectedSongName.equals("Pasoori" + "\n(Shae Gill, Ali Sethi)")){

                    startActivity(new Intent(RockActivity.this, song11.class));
                }
                else  if (selectedSongName.equals("Bheega Bheega Ye Sama" + "\n(Lata Mangeshkar)")){

                    startActivity(new Intent(RockActivity.this, song12.class));
                }
                else  if (selectedSongName.equals("Jab Tak" + "\n(Armaan Malik)")){

                    startActivity(new Intent(RockActivity.this, song13.class));

                }  else  if (selectedSongName.equals("Haye Rama" + "\n(Hariharan, Swarnalatha)")){

                    startActivity(new Intent(RockActivity.this, song14.class));

                }  else  if (selectedSongName.equals("Sawan Aya He" + "\n(Arijit Singh)")){

                    startActivity(new Intent(RockActivity.this, song15.class));
                }

            }
        });



    }
}