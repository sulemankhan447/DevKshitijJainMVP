package suleman.com.login;


//rsn of implementing LoginInteractor.onLoginFinishedListener bcz usmain jo methods hain woh login ke tym pr kaam aayege
public class LoginPresenterImpl implements LoginPresenter,LoginInteractor.onLoginFinishedListener {

    LoginView mLoginView;
    LoginInteractor mLoginInteractor;

    //constructor for login view


    public LoginPresenterImpl(LoginView mLoginView) {
        this.mLoginView = mLoginView;//to know which view
        mLoginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (mLoginView != null) {
            mLoginView.showProgress();
            //passsing this bcz login presenter impl is implementing onLoginFinishedListener
            mLoginInteractor.login(username,password,this);

        }
    }

    @Override
    public void onDestroy() {
        if (mLoginView != null) {
            mLoginView = null;
            //making it null to avoid memory leaks
        }

    }

    @Override
    public void onUserNameError() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.setUsernameError();
        }
    }

    @Override
    public void onPasswordError() {
        if (mLoginView != null) {
            mLoginView.hideProgress();;
            mLoginView.setPasswordError();
        }
    }

    @Override
    public void onSuccess() {
        if (mLoginView != null) {
            mLoginView.hideProgress();;
            mLoginView.navigateToMain();
        }
    }

    @Override
    public void onFailure(String message) {
        if (mLoginView != null) {
            mLoginView.hideProgress();;
            mLoginView.showAlert(message);
        }
    }
}
