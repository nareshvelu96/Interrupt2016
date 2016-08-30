package com.example.naresh.interrupt2016;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Login extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private static final String LOGIN_URL = "http://bhojansvce.16mb.com/interruptlogin.php";
    @InjectView(R.id.input_email) EditText _emailText;

    @InjectView(R.id.input_password)    EditText _passwordText;
    @InjectView(R.id.btn_login)    Button _loginButton;
    @InjectView(R.id.link_signup)    TextView _signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);


        final String email = _emailText.getText().toString();
        final String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();

                    }
                }, 3000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Full LogIn logic checking
                // By default we just finish the Activity and log them in automatically
                // this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // enable going back to the MainActivity
        Intent i= new Intent(getBaseContext(),MainActivity.class);
        startActivity(i);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        setResult(RESULT_OK, null);
        checkuser();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }


    private void checkuser(){
        String email = _emailText.getText().toString().trim().toLowerCase();
        String password = _passwordText.getText().toString().trim().toLowerCase();
        check(email,password);
    }
    private void check(String email, String password)
    { class UserLoginClass extends AsyncTask<String,Void,String> {
        ProgressDialog loading;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loading = ProgressDialog.show(Login.this,"Please Wait",null,true,true);
        }


        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            loading.dismiss();
            if(s.equalsIgnoreCase("success")){
                Values.is_loggedin=true;
                Intent intent = new Intent(Login.this,MainActivity.class);
             //   finish();
                startActivity(intent);
            }else{
                Toast.makeText(Login.this,"Invalid Username or Password",Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            HashMap<String,String> data = new HashMap<>();
            data.put("email",params[0]);
            data.put("password",params[1]);

            RegisterUserClass ruc = new RegisterUserClass();

            String result = ruc.sendPostRequest(LOGIN_URL,data);

            return result;
        }
    }
        UserLoginClass ulc = new UserLoginClass();
        ulc.execute(email,password);

    }

}
