package xqy.com.firstclick;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String TAG = "XQY.MainActivity";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        if (!getServiceIsEnabled()) {
            Intent intent =  new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
            startActivity(intent);
            Toast.makeText(mContext, "在本界面开启FirstClick的辅助功能服务", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean getServiceIsEnabled() {
        boolean isEnabled = false;

        try {
            isEnabled = Settings.Secure.getInt(mContext.getContentResolver(),
                    android.provider.Settings.Secure.ACCESSIBILITY_ENABLED) == 1;
        } catch (Settings.SettingNotFoundException e) {
            Log.i(TAG, e.getMessage());
        }
        return isEnabled;
    }
}
