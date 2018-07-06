package myserieslist.pilot.utec.myserieslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import myserieslist.pilot.utec.myserieslist.entities.User;

public class RegisterActivity extends AppCompatActivity {

    FlaskConnector request = new FlaskConnector(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Register");
    }

    public void onClickCreateUser(View v){
        EditText txtUsername   = (EditText)findViewById(R.id.registerUsername);
        EditText txtPassword   = (EditText)findViewById(R.id.registerPassword);
        EditText txtPassword2 = (EditText)findViewById(R.id.registerPassword2);
        EditText txtEmail = (EditText)findViewById(R.id.registerEmail);
        EditText txtAnswer = (EditText)findViewById(R.id.registerAnswer);

        final String username = txtUsername.getText().toString();
        final String password = txtPassword.getText().toString();
        final String password2 = txtPassword2.getText().toString();
        final String email = txtEmail.getText().toString();
        final String answer = txtAnswer.getText().toString();
        final String question = "Where are you from?";


        request.register(
                username,
                password,
                password2,
                email,
                question,
                answer,
                new FlaskConnector.VolleyCallback() {
                    @Override
                    public void onSuccess(String successResponse)
                    {
                        if (successResponse.equals("user registered"))
                        {
                            Toast.makeText(RegisterActivity.this,"User Created",Toast.LENGTH_LONG).show();
                            finish();
                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this,successResponse,Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(String errorResponse)
                    {
                        Toast.makeText(RegisterActivity.this, "Unable to connect to server", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
