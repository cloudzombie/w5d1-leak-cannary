package saulo.com.w5d1_leak_cannary;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by saulo on 4/25/16.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }

}
