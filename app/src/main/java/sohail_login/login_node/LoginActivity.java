package sohail_login.login_node;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import sohail_login.login_node.API.ApiInterface;
import sohail_login.login_node.API.InitDeletion;
import sohail_login.login_node.API.RestClient;


public class LoginActivity extends Activity {

    EditText email,password,res_email,code,newpass;
    Button InitDeletetion,cont,cont_code,cancel,cancel1,register,forpass;
    String emailtxt, passwordtxt,email_res_txt,code_txt,npass_txt;

    Dialog reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final ApiInterface service = RestClient.getClient();

        //Edittext
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.ID);

        //Buttons
        InitDeletetion = (Button)findViewById(R.id.InitDeletebtn);
        register = (Button)findViewById(R.id.register);
        forpass = (Button)findViewById(R.id.forgotpass);

        //Register Onclick
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regactivity = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(regactivity);
                finish();
            }
        });

        //Login Onclick
        InitDeletetion.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                emailtxt = email.getText().toString();
                passwordtxt = password.getText().toString();
                System.out.println("reached here");

                Call<InitDeletion> call = service.INIT_DELETION_CALL(emailtxt, passwordtxt);

                //Asynchronous Request
                call.enqueue(new Callback<InitDeletion>() {
                    @Override
                    public void onResponse(Response<InitDeletion> response, Retrofit retrofit) {
                        Log.d("Keys", "values = " + emailtxt);
                        Log.d("Keys", "values = " + passwordtxt);
                        Log.d("LoginActivity", "Status Code = " + response.code());
                        Log.d("LoginActivity", "Status message = " + response.message());
                        if (response.isSuccess()) {
                            // request successful (status code 200)
                            InitDeletion result = response.body();
                            Log.d("LoginActivity", "Success Code = " + response.code());
                            Log.d("LoginActivity", "Status message = " + response.body());
                        } else {
                            // response received but request not successful (like 400,401,403 etc)
                            //Handle errors
                            Log.d("LoginActivity", "fail Code = " + response.code());
                            Log.d("LoginActivity", "Status message = " + response.body());
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.d("LoginActivity", "failed: " + t);
                    }
                });
            }
        });
        //ForgotPass Onclick
        forpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset = new Dialog(LoginActivity.this);
                reset.setTitle("Reset Password");
                reset.setContentView(R.layout.reset_pass_init);
                cont = (Button) reset.findViewById(R.id.resbtn);
                cancel = (Button) reset.findViewById(R.id.cancelbtn);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reset.dismiss();
                    }
                });
                res_email = (EditText) reset.findViewById(R.id.email);

                cont.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        email_res_txt = res_email.getText().toString();

                    }
                });


                reset.show();
            }
        });
    }




}
