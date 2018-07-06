package myserieslist.pilot.utec.myserieslist;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class FlaskConnector
{
    String user = "";
    final String URL = "http://eb441f67.ngrok.io";
    String response = "";
    private static final String TAG = "RequestsFlask";
    public Context mContext;
    public FlaskConnector(Context context)
    {
        mContext = context;
    }

    public interface VolleyCallback
    {
        void onSuccess(String successResponse);
        void onFailure(String errorResponse);
    }

    public void login(
            final String username,
            final String password,
            final VolleyCallback callback)
    {
        String url = URL+"/dologin";

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        Log.d(TAG, "onResponse: " + response);
                        callback.onSuccess(response);
                        FlaskConnector.this.response = response;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse: "+ error.toString());
                        callback.onFailure(error.toString());
                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                params.put("User-Agent","android");
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                params.put("username", username);
                params.put("password",password);
                return params;
            }
        };
        Singleton.getInstance(mContext).addToRequestQueue(stringRequest);
    }


    public void register(
            final String username,
            final String password,
            final String password2,
            final String email,
            final String question,
            final String answer,
            final VolleyCallback callback)
    {
        String url = URL+"/registerUser";

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        Log.d(TAG, "onResponse: " + response);
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse: "+ error.toString());
                        callback.onFailure(error.toString());
                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                params.put("User-Agent","android");
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                params.put("username", username);
                params.put("password",password);
                params.put("copassword",password2);
                params.put("email",email);
                params.put("question",question);
                params.put("answer",answer);
                return params;
            }
        };




        Singleton.getInstance(mContext).addToRequestQueue(stringRequest);
    }


    public void getRanking(
            final VolleyCallback callback)
    {
        String url = URL+"/getTop10";
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        Log.d(TAG, "onResponse: " + response);

                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse: "+ error.toString());
                        callback.onFailure(error.toString());
                    }
                })
        {

        };
        Singleton.getInstance(mContext).addToRequestQueue(stringRequest);

    }


    public void getShow(
            final String showName,
            final VolleyCallback callback)
    {
        String url = URL+"/m/"+showName;
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        Log.d(TAG, "onResponse: " + response);

                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse: "+ error.toString());
                        callback.onFailure(error.toString());
                    }
                })
        {

        };
        Singleton.getInstance(mContext).addToRequestQueue(stringRequest);

    }

    public void getUserId(
            final String username,
            final VolleyCallback callback)
    {
        String url = URL+"/id/"+username;
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        Log.d(TAG, "onResponse: " + response);
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse: "+ error.toString());
                        callback.onFailure(error.toString());
                    }
                })
        {

        };
        Singleton.getInstance(mContext).addToRequestQueue(stringRequest);

    }

    public void getUser(
            final String user_id,
            final VolleyCallback callback) {
        String url = URL + "/account/"+user_id;

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "onResponse: " + response);
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse: " + error.toString());
                        callback.onFailure(error.toString());
                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("User-Agent", "android");
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("logged_as", user_id);
                return params;
            }
        };
        Singleton.getInstance(mContext).addToRequestQueue(stringRequest);
    }


    public void rate(
            final String user_id,
            final String showName,
            final String rating,
            final VolleyCallback callback)
    {
        String url = URL+"/add_mobile";

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        Log.d(TAG, "onResponse: " + response);
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse: "+ error.toString());
                        callback.onFailure(error.toString());
                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                params.put("User-Agent","android");
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                params.put("user_id", user_id);
                params.put("showName",showName);
                params.put("rating",rating);
                return params;
            }
        };
        Singleton.getInstance(mContext).addToRequestQueue(stringRequest);
    }

    public void changePassword(
            final String user_id,
            final String oldPassword,
            final String newPassword,
            final String confirmPassword,
            final VolleyCallback callback) {
        String url = URL + "/changePassword";

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "onResponse: " + response);
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse: " + error.toString());
                        callback.onFailure(error.toString());
                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("User-Agent", "android");
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("logged_as", user_id);
                params.put("old_password",oldPassword);
                params.put("password", newPassword);
                params.put("confirm_password", confirmPassword);
                return params;
            }
        };
        Singleton.getInstance(mContext).addToRequestQueue(stringRequest);
    }


    public void getAccountAge(
            final String user_id,
            final VolleyCallback callback) {
        String url = URL + "/age";

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "onResponse: " + response);
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse: " + error.toString());
                        callback.onFailure(error.toString());
                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("User-Agent", "android");
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("logged_as", user_id);
                return params;
            }
        };
        Singleton.getInstance(mContext).addToRequestQueue(stringRequest);
    }
}
