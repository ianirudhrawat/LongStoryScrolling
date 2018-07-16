package com.example.admin.longstoryscrolling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public ScrollView scrollView;
    public TextView textView;
    Button startScrolling;

    int scrolly;
    static final int SPEEDCHANGE=10;
    int textViewHeight;
    Thread playThread;

    private class PlayThread implements Runnable{


        @Override
        public void run() {
            while (true){

                scrollView.smoothScrollTo(0,scrolly);

                scrolly = scrolly + SPEEDCHANGE;
                //Log.e("scrolly=",String.valueOf(scrolly));

                if(scrolly > textViewHeight)
                    break;
                try {
                    Thread.sleep(17);
                } catch (InterruptedException e) {
                    Log.e("ERROR","playThread interrupted");
                    e.printStackTrace();

                }

            }
        }
    }


    public int getViewHeightwidth() {
        int heightMeasureSpec;
        int widthMeasureSpec;
        try {
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);

            widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(dm.widthPixels,
                    View.MeasureSpec.AT_MOST);
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0,
                    View.MeasureSpec.UNSPECIFIED);
            textView.measure(widthMeasureSpec, heightMeasureSpec);
        } catch (Exception e) {
            Log.e("@PS-867","@exception");
            e.printStackTrace();
            //		getViewHeightwidth();
        }
        return textView.getMeasuredHeight();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView  =   findViewById(R.id.mScrollView);
        textView    =   findViewById(R.id.textView);
        startScrolling  =   findViewById(R.id.startScrolling);
        String text = "StoryD1 StoryD2 StoryD3 StoryD4 StoryD5 StoryD6 StoryD7 StoryD8 StoryD9 StoryD10 StoryD11 StoryD12 StoryD13 StoryD14 StoryD15 StoryD16 StoryD17 StoryD18 StoryD19 StoryD20 StoryD21 StoryD22 StoryD23 StoryD24 StoryD25 StoryD26 StoryD27 StoryD28 StoryD29 StoryD30 StoryD31 StoryD32 StoryD33 StoryD34 StoryD35 StoryD36 StoryD37 StoryD38 StoryD39 StoryD40 StoryD41 StoryD42 StoryD43 StoryD44 StoryD45 StoryD46 StoryD47 StoryD48 StoryD49 StoryD50 StoryD51 StoryD52 StoryD53 StoryD54 StoryD55 StoryD56 StoryD57 StoryD58 StoryD59 StoryD60 StoryD61 StoryD62 StoryD63 StoryD64 StoryD65 StoryD66 StoryD67 StoryD68 StoryD69 StoryD70 StoryD71 StoryD72 StoryD73 StoryD74 StoryD75 StoryD76 StoryD77 StoryD78 StoryD79 StoryD80 StoryD81 StoryD82 StoryD83 StoryD84 StoryD85 StoryD86 StoryD87 StoryD88 StoryD89 StoryD90 StoryD91 StoryD92 StoryD93 StoryD94 StoryD95 StoryD96 StoryD97 StoryD98 StoryD99 StoryD100 StoryD101 StoryD102 StoryD103 StoryD104 StoryD105 StoryD106 StoryD107 StoryD108 StoryD109 StoryD110 StoryD111 StoryD112 StoryD113 StoryD114 StoryD115 StoryD116 StoryD117 StoryD118 StoryD119\tStoryD120 StoryD121 StoryD122 StoryD123\tStoryD124 StoryD125 StoryD126 StoryD127 StoryD128 StoryD129 StoryD130 StoryD131 StoryD132 StoryD133 StoryD134 StoryD135 StoryD136 StoryD137 StoryD138 StoryD139 StoryD140 StoryD141 StoryD142 StoryD143 StoryD144 StoryD145 StoryD146 StoryD147 StoryD148 StoryD149 StoryD150 StoryD151\tStoryD152 StoryD153 StoryD154 StoryD155 StoryD156 StoryD157 StoryD158 StoryD159\tStoryD160 StoryD161 StoryD162 StoryD163 StoryD164 StoryD165 StoryD166 StoryD167 StoryD168 StoryD169 StoryD170 StoryD171 StoryD172 StoryD173 StoryD174 StoryD175 StoryD176 StoryD177 StoryD178 StoryD179 StoryD180 StoryD181 StoryD182 StoryD183 StoryD184 StoryD185 StoryD186 StoryD187 StoryD188 StoryD189 StoryD190 StoryD191 StoryD192 StoryD193 StoryD194 StoryD195\tStoryD196 StoryD197 StoryD198 StoryD199 StoryD200 StoryD201 StoryD202 StoryD203 StoryD204 StoryD205 StoryD206 StoryD207 StoryD208 StoryD209 StoryD210 StoryD211 StoryD212 StoryD213 StoryD214 StoryD215 StoryD216 StoryD217 StoryD218 StoryD219 StoryD220 StoryD221 StoryD222 StoryD223 StoryD224 StoryD225 StoryD226 StoryD227\tStoryD228 StoryD229 StoryD230";
        scrolly = 0;
     //   textViewHeight  = 0;
        playThread = new Thread(new PlayThread());
        textView.setText(text);
        textView.setTextSize(100);
        textViewHeight = getViewHeightwidth();
        startScrolling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playThread.start();
            }
        });
    }


}
