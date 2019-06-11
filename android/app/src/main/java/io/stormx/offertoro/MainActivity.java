package io.stormx.offertoro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.offertoro.sdk.OTOfferWallSettings;
import com.offertoro.sdk.interfaces.OfferWallListener;
import com.offertoro.sdk.sdk.OffersInit;

public class MainActivity extends AppCompatActivity implements OfferWallListener {

    private static final String TAG = "OfferToroSDK";

    public static final String appId = "appId";
    public static final String secretKey = "secretKey";
    public static final String pubUid = "pubUid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OTOfferWallSettings.getInstance().configInit(getIntent().getStringExtra(appId), getIntent().getStringExtra(secretKey), getIntent().getStringExtra(pubUid));
        OffersInit.getInstance().create(MainActivity.this);
        OffersInit.getInstance().showOfferWall(this);
        OffersInit.getInstance().setOfferWallListener(this);
    }

    @Override
    public void onOTOfferWallInitSuccess() {
        Log.d(TAG, "onOTOfferWallInitSuccess");
    }

    @Override
    public void onOTOfferWallInitFail(String error) {
        Log.d(TAG, "onOTOfferWallInitFail");
        Log.d(TAG, error);
    }

    @Override
    public void onOTOfferWallOpened() {
        Log.d(TAG, "onOTOfferWallOpened");
    }

    @Override
    public void onOTOfferWallCredited(double v, double v1) {
        Log.d(TAG, "onOTOfferWallCredited");
    }

    @Override
    public void onOTOfferWallClosed() {
        Log.d(TAG, "onOTOfferWallClosed");
        this.finish();
    }
}
