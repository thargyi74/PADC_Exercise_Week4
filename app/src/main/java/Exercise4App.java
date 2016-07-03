import android.app.Application;
import android.content.Context;

/**
 * Created by Dell on 29-Jun-16.
 */
public class Exercise4App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
    }
    public static Context getContext() {return context;}
}
