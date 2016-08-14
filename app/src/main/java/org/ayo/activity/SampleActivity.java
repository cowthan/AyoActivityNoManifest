package org.ayo.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import org.ayo.attacher.ActivityAttacher;
import org.ayo.attacher.SimpleBundle;

/**
 */
public class SampleActivity extends AyoActivityAttacher {

    public static void start(Context c, boolean takeSystemBar, int lanuchMode, OnResultCallBack callBack){

        SimpleBundle sb = new SimpleBundle();
        sb.putExtra("takeSystemBar", takeSystemBar);
        ActivityAttacher.startActivity(c, SampleActivity.class, sb, false, lanuchMode, callBack);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_ac_sample);

        boolean takeSystemBar = getIntent().getBooleanExtra("takeSystemBar");
        getAgent().enableSystemBarTakenByContent(takeSystemBar);

        getAgent().renderSystemBar(Color.parseColor("#44ff0000"), Color.parseColor("#55ff0000"));

        if(!hasResultCallback()){
            this.<View>id(R.id.btn5).setVisibility(View.GONE);
        }else{
            this.<View>id(R.id.btn5).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    getResultCallback().onResult("代替OnActivityReslt和setResult");
                    finish();
                }
            });
        }

    }
}
