package splittask.app.com.splittask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by vmankena on 10/7/16.
 */


public class SplashActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    finish();
                    Intent intent = new Intent();
                    intent.setClassName("splittask.app.com.splittask","splittask.app.com.splittask.LoginActivity");
                    startActivity(intent);
                }
            }
        };
        splashThread.start();
    }
}