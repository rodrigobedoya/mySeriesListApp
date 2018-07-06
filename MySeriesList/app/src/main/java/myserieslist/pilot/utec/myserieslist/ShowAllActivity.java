package myserieslist.pilot.utec.myserieslist;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowAllActivity extends AppCompatActivity{

    public static final String TAG = "RankingActivity";

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;

    public Activity getActivity() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows);
        mRecyclerView = findViewById(R.id.showAll_recycler_view);
        setTitle("Shows");
    }

    @Override
    protected void onResume() {
        super.onResume();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        String url = "http://cfd882dc.ngrok.io/shows";
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    mAdapter = new ShowAllAdapter(response.getJSONArray("response"),getActivity());
                    Toast.makeText(ShowAllActivity.this,getString(mAdapter.getItemCount()),Toast.LENGTH_LONG).show();
                    mRecyclerView.setAdapter(mAdapter);
                } catch (JSONException e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, error.getMessage());
            }
        }
        );

        queue.add(jsonObjectRequest);
    }
}
