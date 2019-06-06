package suleman.com.login;

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUsernameError();
    void setPasswordError();
    void navigateToMain();
    void showAlert(String message);
}
