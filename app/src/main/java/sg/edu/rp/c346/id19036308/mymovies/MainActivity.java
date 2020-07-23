package sg.edu.rp.c346.id19036308.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

import static java.lang.reflect.Array.set;

public class MainActivity extends AppCompatActivity {

    ListView lvMovies;
    ArrayList<Movie> alMovieList = new ArrayList<Movie>();
    CustomAdapter caMovies;
    ImageView ivMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar date = Calendar.getInstance();


        date.set(2014, 11, 15);
//        Calendar date2 = Calendar.getInstance();
        date.set(2015, 5, 15);

        lvMovies = findViewById(R.id.listViewMovies);
        ivMovies = findViewById(R.id.imageViewRating);
        alMovieList = new ArrayList<>();
        Movie item1 = new Movie("The Avengers", 2012, "pg13", "Action | Sci-Fi", date, "Golden Village - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.", 4);
        alMovieList.add(item1);
        Movie item2 = new Movie("Planes", 2013, "pg", "Animation | Comedy", date, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.", 2);
        alMovieList.add(item2);
        caMovies = new CustomAdapter(this, R.layout.row, alMovieList);

        lvMovies.setAdapter(caMovies);

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Prepare Intent
                Intent intentDetails = new Intent(MainActivity.this, MovieDetailsActivity.class);
                //Insert data into the intent
                Movie currentMovie = alMovieList.get(position);
                intentDetails.putExtra("title", currentMovie.getTitle());
                intentDetails.putExtra("year", currentMovie.getYear());
                intentDetails.putExtra("rated", currentMovie.getRated());
                intentDetails.putExtra("genre", currentMovie.getGenre());
                intentDetails.putExtra("watched_on", currentMovie.getWatched_on());
                intentDetails.putExtra("in_theatre", currentMovie.getIn_theatre());
                intentDetails.putExtra("description", currentMovie.getDescription());
                //Start new activity
                startActivity(intentDetails);
            }
        });
    }
}
