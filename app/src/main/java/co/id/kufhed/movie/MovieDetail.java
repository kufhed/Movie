package co.id.kufhed.movie;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetail extends AppCompatActivity {

    protected ImageView imageBanner;
    protected Toolbar toolbar;
    protected CollapsingToolbarLayout collapsingToolbar;
    protected AppBarLayout appBarLayout;
    protected ImageView imagePoster;
    protected TextView durationTextView;
    protected TextView releaseDateTextView;
    protected TextView ratingTextView;
    protected TextView synopsisTextView;
    protected TextView titleMovie;
    private MovieModel movieModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null || !savedInstanceState.containsKey("movieInstance")) {
            movieModel = getIntent().getExtras().getParcelable("movieModel");
        } else {
            movieModel = savedInstanceState.getParcelable("movieInstance");
        }
        super.setContentView(R.layout.activity_movie_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(movieModel.getTitle());
        setTitle(movieModel.getTitle());
        initView();
        releaseDateTextView.setText(movieModel.getRelease_date());
        durationTextView.setText(movieModel.getVote_count());
        ratingTextView.setText(movieModel.getVote_average());
        synopsisTextView.setText(movieModel.getOverview());
        titleMovie.setText(movieModel.getTitle());
        Picasso.with(this).load(APIUrl.BASE_URL_IMAGE + movieModel.getBackdrop_path()).into(imageBanner);
        Picasso.with(this).load(APIUrl.BASE_URL_IMAGE + movieModel.getPoster_path()).into(imagePoster);


    }

    private void initView() {
        imageBanner = (ImageView) findViewById(R.id.imageBanner);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        imagePoster = (ImageView) findViewById(R.id.imagePoster);
        durationTextView = (TextView) findViewById(R.id.durationTextView);
        releaseDateTextView = (TextView) findViewById(R.id.releaseDateTextView);
        ratingTextView = (TextView) findViewById(R.id.ratingTextView);
        synopsisTextView = (TextView) findViewById(R.id.synopsisTextView);
        titleMovie = (TextView) findViewById(R.id.titleMovie);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable("movieInstance", movieModel);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
