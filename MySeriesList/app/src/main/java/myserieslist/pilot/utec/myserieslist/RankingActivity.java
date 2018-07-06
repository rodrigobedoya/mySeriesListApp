package myserieslist.pilot.utec.myserieslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RankingActivity extends AppCompatActivity
{
    FlaskConnector request = new FlaskConnector(this);
    String logged_as = "";
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

    }

    @Override
    protected void onResume(){
        super.onResume();
        setTitle("Ranking");

        extras = getIntent().getExtras();

        if (extras!= null)
            logged_as = extras.getString("logged_as");

        request.getRanking(
                new FlaskConnector.VolleyCallback()
                {
                    @Override
                    public void onSuccess(String response)
                    {
                        request.response = response;

                        JSONArray jsonArray;
                        JSONObject jsonObject;

                        int[] nameIds = {R.id.RankedName1,R.id.RankedName2,R.id.RankedName3,R.id.RankedName4,R.id.RankedName5,R.id.RankedName6,R.id.RankedName7,R.id.RankedName8,R.id.RankedName9,R.id.RankedName10};
                        int[] ratingIds = {R.id.RankedRating1,R.id.RankedRating2,R.id.RankedRating3,R.id.RankedRating4,R.id.RankedRating5,R.id.RankedRating6,R.id.RankedRating7,R.id.RankedRating8,R.id.RankedRating9,R.id.RankedRating10};

                        try{
                            jsonArray = new JSONArray(response);
                            String ShowName="",ShowRating="",ShowRank="";
                            for (int i = 0; i < jsonArray.length();i++)
                            {
                                jsonObject = jsonArray.getJSONObject(i);
                                ShowName = jsonObject.getString("name");
                                ShowRating = jsonObject.getString("rating");
                                ShowRank = jsonObject.getString("rank");


                                TextView xmlName = (TextView) findViewById(nameIds[i]);
                                TextView xmlRating = (TextView) findViewById(ratingIds[i]);
                                CharSequence newName = ShowRank+". "+ShowName;
                                CharSequence newRating = "Rating: "+ShowRating;
                                xmlName.setText(newName);
                                xmlRating.setText(newRating);
                            }


                        }
                        catch (JSONException e){}
                    }

                    @Override
                    public void onFailure(String error)
                    {
                        Toast.makeText(RankingActivity.this, "Unable to connect to server", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void onClickRanked1(View v)
    {
        Intent showActivityIntent = new Intent(RankingActivity.this,ShowActivity.class);
        TextView showName = (TextView) findViewById(R.id.RankedName1);
        String Name = StringUtils.substringAfter(showName.getText().toString()," ");
        showActivityIntent.putExtra("name_of_show",Name);
        showActivityIntent.putExtra("logged_as",logged_as);
        startActivity(showActivityIntent);
    }

    public void onClickRanked2(View v)
    {
        Intent showActivityIntent = new Intent(RankingActivity.this,ShowActivity.class);
        TextView showName = (TextView) findViewById(R.id.RankedName2);
        String Name = StringUtils.substringAfter(showName.getText().toString()," ");
        showActivityIntent.putExtra("name_of_show",Name);
        showActivityIntent.putExtra("logged_as",logged_as);
        startActivity(showActivityIntent);
    }

    public void onClickRanked3(View v)
    {
        Intent showActivityIntent = new Intent(RankingActivity.this,ShowActivity.class);
        TextView showName = (TextView) findViewById(R.id.RankedName3);
        String Name = StringUtils.substringAfter(showName.getText().toString()," ");
        showActivityIntent.putExtra("name_of_show",Name);
        showActivityIntent.putExtra("logged_as",logged_as);
        startActivity(showActivityIntent);
    }

    public void onClickRanked4(View v)
    {
        Intent showActivityIntent = new Intent(RankingActivity.this,ShowActivity.class);
        TextView showName = (TextView) findViewById(R.id.RankedName4);
        String Name = StringUtils.substringAfter(showName.getText().toString()," ");
        showActivityIntent.putExtra("name_of_show",Name);
        showActivityIntent.putExtra("logged_as",logged_as);
        startActivity(showActivityIntent);
    }

    public void onClickRanked5(View v)
    {
        Intent showActivityIntent = new Intent(RankingActivity.this,ShowActivity.class);
        TextView showName = (TextView) findViewById(R.id.RankedName5);
        String Name = StringUtils.substringAfter(showName.getText().toString()," ");
        showActivityIntent.putExtra("name_of_show",Name);
        showActivityIntent.putExtra("logged_as",logged_as);
        startActivity(showActivityIntent);
    }

    public void onClickRanked6(View v)
    {
        Intent showActivityIntent = new Intent(RankingActivity.this,ShowActivity.class);
        TextView showName = (TextView) findViewById(R.id.RankedName6);
        String Name = StringUtils.substringAfter(showName.getText().toString()," ");
        showActivityIntent.putExtra("name_of_show",Name);
        showActivityIntent.putExtra("logged_as",logged_as);
        startActivity(showActivityIntent);
    }

    public void onClickRanked7(View v)
    {
        Intent showActivityIntent = new Intent(RankingActivity.this,ShowActivity.class);
        TextView showName = (TextView) findViewById(R.id.RankedName7);
        String Name = StringUtils.substringAfter(showName.getText().toString()," ");
        showActivityIntent.putExtra("name_of_show",Name);
        showActivityIntent.putExtra("logged_as",logged_as);
        startActivity(showActivityIntent);
    }

    public void onClickRanked8(View v)
    {
        Intent showActivityIntent = new Intent(RankingActivity.this,ShowActivity.class);
        TextView showName = (TextView) findViewById(R.id.RankedName8);
        String Name = StringUtils.substringAfter(showName.getText().toString()," ");
        showActivityIntent.putExtra("name_of_show",Name);
        showActivityIntent.putExtra("logged_as",logged_as);
        startActivity(showActivityIntent);
    }

    public void onClickRanked9(View v)
    {
        Intent showActivityIntent = new Intent(RankingActivity.this,ShowActivity.class);
        TextView showName = (TextView) findViewById(R.id.RankedName9);
        String Name = StringUtils.substringAfter(showName.getText().toString()," ");
        showActivityIntent.putExtra("name_of_show",Name);
        showActivityIntent.putExtra("logged_as",logged_as);
        startActivity(showActivityIntent);
    }

    public void onClickRanked10(View v)
    {
        Intent showActivityIntent = new Intent(RankingActivity.this,ShowActivity.class);
        TextView showName = (TextView) findViewById(R.id.RankedName10);
        String Name = StringUtils.substringAfter(showName.getText().toString()," ");
        showActivityIntent.putExtra("name_of_show",Name);
        showActivityIntent.putExtra("logged_as",logged_as);
        startActivity(showActivityIntent);
    }
}