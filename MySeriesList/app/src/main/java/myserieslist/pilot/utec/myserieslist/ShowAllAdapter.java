package myserieslist.pilot.utec.myserieslist;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowAllAdapter extends RecyclerView.Adapter<ShowAllAdapter.ViewHolder> {
    public JSONArray elements;
    private Context mContext;
    private static final String TAG = "MyAdapter";

    // Constructor of the class
    public ShowAllAdapter(JSONArray elements, Context context) {
        this.elements = elements;
        this.mContext = context;
        //this.userFromId = userFromId;
    }

    // The ViewHolder class is the place to create and instantiate View elements using findViewById
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView first_line, second_line;
        RelativeLayout container;

        public ViewHolder(View itemView) {
            super(itemView);
            first_line = itemView.findViewById(R.id.element_view_first_line);
            second_line = itemView.findViewById(R.id.element_view_second_line);
            container = itemView.findViewById(R.id.element_view_container);
        }
    }

    @NonNull
    @Override
    //The method onCreateViewHolder declares which View will be used as the template of each child.
    public ShowAllAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_view, parent, false);
        return new ViewHolder(view);
    }

    /*
    The method onBindViewHolder is the place to populate the Views created in the Viewholder
    class. In this case, setText() is used to fill the TextView elements with data from
    each iteration of the "elements" JSONArray.
    */
    public void onBindViewHolder(@NonNull ShowAllAdapter.ViewHolder holder, final int position) {
        try {
            final JSONObject element = elements.getJSONObject(position);
            final String mFirstLine = element.getString("name")+" "+element.getString("rating");
            final String mSecondLine = "rank: "+element.getString("rank");
            //final String id = element.getString("id");

            holder.first_line.setText(mFirstLine);
            holder.second_line.setText(mSecondLine);

            holder.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //String text = mFirstLine + ": " + mSecondLine;
                    Intent intent = new Intent(mContext, MainActivity.class);
                    //intent.putExtra(ShowAllActivity.EXTRA_USER_FROM_ID, userFromId);
                    //intent.putExtra(ShowAllActivity.EXTRA_USER_TO_ID, id);
                    mContext.startActivity(intent);
                    //Toast.makeText(mContext, text+":"+userFromId+"--"+id, Toast.LENGTH_SHORT).show();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    // This method is crucial and it must return the number of children to be displayed.
    public int getItemCount() {
        return elements.length();
    }
}
