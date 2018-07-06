package myserieslist.pilot.utec.myserieslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowActivity extends AppCompatActivity{

    String Name="";
    String logged_as="";
    Bundle extras;


    TextView Title,Rating,Rank,Description,Episodes,Seasons,Votes;
    RatingBar ratingBar;
    LinearLayout mainLayout;

    FlaskConnector request = new FlaskConnector(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
    }

    @Override
    protected void onResume(){
        extras = getIntent().getExtras();

        if (extras!= null)
        {
            Name = extras.getString("name_of_show");
            logged_as = extras.getString("logged_as");
        }

        super.onResume();
        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        Title = (TextView) findViewById(R.id.show_name);
        Rating = (TextView) findViewById(R.id.rating);
        Rank = (TextView) findViewById(R.id.rank);
        Description = (TextView) findViewById(R.id.description);
        Episodes = (TextView) findViewById(R.id.episodes);
        Seasons = (TextView) findViewById(R.id.seasons);
        Votes = (TextView) findViewById(R.id.votes);
        update();
    }

    public void onClickRate(View v)
    {
        final String rated = String.valueOf(ratingBar.getRating());
        request.rate(
                logged_as,
                Name,
                rated,
                new FlaskConnector.VolleyCallback() {
                    @Override
                    public void onSuccess(String successResponse) {
                        //Toast.makeText(ShowActivity.this,"You rated " + Title.getText()+" with "+rated+" stars",Toast.LENGTH_LONG).show();
                        Toast.makeText(ShowActivity.this,successResponse,Toast.LENGTH_LONG).show();
                        update();
                    }

                    @Override
                    public void onFailure(String errorResponse) {
                        Toast.makeText(ShowActivity.this,"Something went wrong",Toast.LENGTH_LONG).show();
                    }
                }

        );



    }

    private void update()
    {
        request.getShow(
                Functions.formatToFileName(Name),
                new FlaskConnector.VolleyCallback() {
                    @Override
                    public void onSuccess(String response) {
                        JSONArray jsonArray;
                        JSONObject jsonObject;

                        try{
                            jsonArray = new JSONArray(response);
                            jsonObject = jsonArray.getJSONObject(0);
                            String ShowName = jsonObject.getString("name");
                            String ShowRating = jsonObject.getString("rating");
                            String ShowRank = jsonObject.getString("rank");
                            String ShowDescription = jsonObject.getString("description");
                            String ShowEpisodes = jsonObject.getString("episodes");
                            String ShowSeasons = jsonObject.getString("seasons");
                            String ShowVotes = jsonObject.getString("votes");
                            Title.setText(ShowName);
                            Rank.setText(ShowRank);

                            Rating.setText(ShowRating);
                            Description.setText(ShowDescription);
                            Seasons.setText(ShowSeasons);
                            Episodes.setText(ShowEpisodes);
                            Votes.setText(ShowVotes);

                            setTitle(ShowName);
                            ratingBar.setRating(Float.parseFloat(Rating.getText().toString()));
                            createText();
                        }
                        catch (JSONException e){
                            Toast.makeText(ShowActivity.this,"We don't have that show yet",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(String errorResponse) {
                        Toast.makeText(ShowActivity.this, "Unable to connect to server", Toast.LENGTH_LONG).show();
                    }
                });


    }

    private void createText()
    {
        mainLayout.setVisibility(View.VISIBLE);
    }

}
