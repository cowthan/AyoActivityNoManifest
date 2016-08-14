package org.ayo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.ayo.attacher.ActivityAttacher;

/**
 */
public class MainActivity extends AyoActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_ac_main);


        getAgent().enableSystemBarTakenByContent(false);
        getAgent().renderSystemBar(Color.parseColor("#55ff0000"), Color.parseColor("#55ff0000"));


        Button btn1 = id(R.id.btn1);
        Button btn2 = id(R.id.btn2);
        Button btn3 = id(R.id.btn3);
        Button btn4 = id(R.id.btn4);
        Button btn5 = id(R.id.btn5);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.btn1){
            //打开：standard, systembar位置被侵入
            SampleActivity.start(getActivity(), true, ActivityAttacher.LAUNCH_MODE_STANDARD, null);

        }else if(id == R.id.btn2){
            //打开：standard, systembar位置保留
            SampleActivity.start(getActivity(), false, ActivityAttacher.LAUNCH_MODE_STANDARD, null);

        }else if(id == R.id.btn3){
            //打开：singleTask
            SampleActivity.start(getActivity(), false, ActivityAttacher.LAUNCH_MODE_SINGLE_TASK, null);

        }else if(id == R.id.btn4){
            //打开：singleTop
            SampleActivity.start(getActivity(), false, ActivityAttacher.LAUNCH_MODE_SINGLE_TOP, null);

        }else if(id == R.id.btn5){
            //打开：singleInstance，带返回参数
            SampleActivity.start(getActivity(), false, ActivityAttacher.LAUNCH_MODE_SINGLE_INSTANCE, new ActivityAttacher.OnResultCallBack(){
                @Override
                public void onResult(Object t) {
                    String s = (String)t;
                    Toast.makeText(getActivity(), "返回参数：" + t, Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
