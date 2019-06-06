package suleman.com.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import suleman.com.MainActivity;
import suleman.com.R;

public class LoginActivity extends AppCompatActivity implements LoginView{
    private EditText edtUsername,edtPassword;
    private Button btnDone;
    private ProgressBar progressBar;

    private LoginPresenter mLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsername = (EditText)findViewById(R.id.edtUsername);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnDone = (Button)findViewById(R.id.btnDone);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        mLoginPresenter = new LoginPresenterImpl(this);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                mLoginPresenter.validateCredentials(username,password);
            }
        });
    }

    @Override
    public void showProgress() {

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {

        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {

        edtUsername.setError("Username Empty");
    }

    @Override
    public void setPasswordError() {

        edtPassword.setError("Password Empty");
    }

    @Override
    public void navigateToMain() {

        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();;
    }
}
