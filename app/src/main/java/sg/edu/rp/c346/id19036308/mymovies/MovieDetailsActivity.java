package sg.edu.rp.c346.id19036308.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieDetailsActivity extends AppCompatActivity {
    TextView tvTitle, tvGenre, tvYear, tvDescription, tvWatchDate, tvTheatre;
    ImageView ivRating;
    RatingBar rbRate;
    ArrayList<Movie> movieList = new ArrayList<Movie>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        tvTitle = findViewById(R.id.textViewTitle);
        tvGenre = findViewById(R.id.textViewGenre);
        tvYear = findViewById(R.id.textViewYear);
        tvDescription = findViewById(R.id.textViewDescription);
        tvWatchDate = findViewById(R.id.textViewWatchDate);
        tvTheatre = findViewById(R.id.textViewTheatre);
        ivRating = findViewById(R.id.imageViewRating);
        rbRate = findViewById(R.id.ratingBarRate);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int ratingBar = intent.getIntExtra("rating", 0);
        int year = intent.getIntExtra("year",0);
        String rating = intent.getStringExtra("rated");
        String genre = intent.getStringExtra("genre");
        String watchDate = intent.getStringExtra("watch_on");
        String theatre = intent.getStringExtra("in_theatre");
        String description = intent.getStringExtra("description");

//        Intent intentReceived = getIntent();

//        ImageView rating = intentReceived.addCategory("rating","pg13");
//        String title = intentReceived.getStringExtra("title","The Avengers");

        if(rating.equalsIgnoreCase("g")){
            ivRating.setImageResource(R.drawable.rating_g);
        } else if (rating.equalsIgnoreCase("pg")){
            ivRating.setImageResource(R.drawable.rating_pg);
        } else if (rating.equalsIgnoreCase("pg13")){
            ivRating.setImageResource(R.drawable.rating_pg13);
        } else if (rating.equalsIgnoreCase("nc16")){
            ivRating.setImageResource(R.drawable.rating_nc16);
        } else if (rating.equalsIgnoreCase("m18")){
            ivRating.setImageResource(R.drawable.rating_m18);
        }else if (rating.equalsIgnoreCase("r21")){
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        tvTitle.setText(title);
//        String strGenre = (year) + " - " + genre;
        tvYear.setText(year + "");
        tvGenre.setText(genre);
//        tvGenre.setText(strGenre);
        rbRate.setNumStars(ratingBar);
        tvDescription.setText(description);
        tvWatchDate.setText("Watch On: " + watchDate);
        tvTheatre.setText("In Theatre: " + theatre);
    }
}
