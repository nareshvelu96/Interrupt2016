package in.svce.interrupt16.android;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Register extends AppCompatActivity {
    private static final String TAG = "SignupActivity";
    private static final String REGISTER_URL = "http://interrupt16.in/app/register.php";

    @InjectView(R.id.name) EditText _nameText;
    @InjectView(R.id.email) EditText _emailText;
    @InjectView(R.id.passwrd) EditText _passwordText;
    @InjectView(R.id.rpasswrd) EditText _cpasswordText;
    @InjectView(R.id.phone) EditText _phoneNumber;
    @InjectView(R.id.btn_signup) Button _signupButton;
    @InjectView(R.id.dept) MaterialBetterSpinner _dept;
    @InjectView(R.id.year) MaterialBetterSpinner _year;
    @InjectView(R.id.college) EditText _college;
    @InjectView(R.id.link_login) TextView _loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.inject(this);
        TextView college =(TextView)findViewById(R.id.college);

        Button bt = (Button) findViewById(R.id.btn_signup);
        Typeface fontRobo1 = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Medium.ttf");
        bt.setTypeface(fontRobo1);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
        //String[] colnames = getResources().getStringArray(R.array.college_names);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(Register.this,android.R.layout.simple_list_item_1,colnames);


        //college.setAdapter(adapter);

        String[] deptlist = getResources().getStringArray(R.array.dept);
        String[] yearlist = getResources().getStringArray(R.array.year);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, deptlist);
        _dept.setAdapter(adapter2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, yearlist);
        _year.setAdapter(adapter1);
    }




    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }
        else {
            //onSignupSuccess();
        }


        _signupButton.setEnabled(false);

     /*   final ProgressDialog progressDialog = new ProgressDialog(SignUp.this, R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show(); */




        // TODO: Full SignUp logic checking

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        //                 progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        registerUser();
        SharedPreferences pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor = pref.edit();
        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String phno = _phoneNumber.getText().toString();

        // if(pref.getString("done", null)==null){
        editor.putString("name",name);
        editor.putString("email", email);
        editor.putString("phone", phno);
        //editor.putString("auth_token", Values.auth_token);
        editor.putString("id", "0");
        editor.putBoolean("complete", true);
        editor.putBoolean("islogged",true);
        Values.is_loggedin=true;
        editor.commit();
        Values.email=email;
        Values.name=name;
        Values.phone=phno;
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);




    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Sign-Up failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;


        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        String cpassword = _cpasswordText.getText().toString();
        String phno = _phoneNumber.getText().toString();
        String college= _college.getText().toString();
        MaterialBetterSpinner yearS = (MaterialBetterSpinner) findViewById(R.id.year);
        String year = yearS.getText().toString();
        MaterialBetterSpinner deptS = (MaterialBetterSpinner)findViewById(R.id.dept);
        String dept = deptS.getText().toString();

        if (name.isEmpty() || name.length() < 5) {
            _nameText.setError("At least 5 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (college.isEmpty()) {
            _college.setError("Enter College");
            valid = false;
        } else {
            _college.setError(null);
        }



        if (year.isEmpty()||dept.isEmpty()) {
            Toast.makeText(getBaseContext(), "Select option", Toast.LENGTH_LONG).show();
            valid = false;
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("Enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("Between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }
        if (cpassword.isEmpty() || cpassword.length() < 4 || cpassword.length() > 10) {
            _cpasswordText.setError("Between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _cpasswordText.setError(null);
        }

        if (!(cpassword.matches(password))) {
            _cpasswordText.setError("Passwords don't match");
            valid = false;
        } else {
            _cpasswordText.setError(null);
        }
        if (phno.isEmpty() || phno.length() < 10 || phno.length() > 10) {
            _phoneNumber.setError("Phone number should be 10 digits");
            valid = false;
        } else {
            _phoneNumber.setError(null);
        }
        return valid;
    }
    private void register(String name,String email,String phno, String password, String college, String dept, String year) {
        class RegisterUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            RegisterUserClass ruc = new RegisterUserClass();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Register.this, "Please Wait",null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                //if()
                Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String,String>();
                data.put("name",params[0]);
                data.put("email",params[1]);
                data.put("phone_no",params[2]);
                data.put("password",params[3]);
                data.put("college",params[4]);
                data.put("tag","test");
                data.put("year",params[6]);

                String result = ruc.sendPostRequest(REGISTER_URL,data);
                return  result;
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(name,email,phno,password,college,dept,year);
    }
    private void registerUser() {
        String name = _nameText.getText().toString().trim().toLowerCase();
        String password = _passwordText.getText().toString().trim().toLowerCase();
        String email = _emailText.getText().toString().trim().toLowerCase();
        String phno = _phoneNumber.getText().toString().trim().toLowerCase();
        String year = _year.getText().toString().trim().toLowerCase();
        String dept = _dept.getText().toString().trim().toLowerCase();
        String college = _college.getText().toString().trim().toLowerCase();

        register(name,email,phno,password,college,dept,year);
    }
}