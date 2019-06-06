package suleman.com.login;

import android.text.TextUtils;

public class LoginInteractorImpl implements LoginInteractor{
    @Override
    public void login(String username, String password, onLoginFinishedListener listener) {
        //instead of second else if we can make call to server using retrofit
        //than call failure or success accordingly
        if (TextUtils.isEmpty(username)) {
            listener.onUserNameError();
        } else if (TextUtils.isEmpty(password)) {
            listener.onPasswordError();
        } else if (username.equals("admin") && password.equals("admin")) {
            listener.onSuccess();
        } else {
            listener.onFailure("Invalid Credentials");
        }
    }
}
