package com.example.adeba001.ejemplotta_1;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


import com.example.adeba001.ejemplotta_1.modelo.Test;
import com.example.adeba001.ejemplotta_1.presentation.Data;

public class TestActivity extends ModelActivity implements View.OnClickListener {

    private int correct=0;
    private Test.Advice advise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Data data= new Data();
        Test test= data.getTest();



        TextView textWording=(TextView)findViewById(R.id.test_wording);
        textWording.setText(test.getWording());


        int i=0;

        RadioGroup group= (RadioGroup)findViewById(R.id.test_radioGroup);

        for(Test.Choice choice : test.getChoices()){

            RadioButton radio=new RadioButton(this);
            radio.setText(choice.getWording());
            radio.setOnClickListener(this);//hacer visible el botton enviar
            group.addView(radio);
            if(choice.isCorrecta()){
                correct=i;
            }
            i++;

           }


        advise=test.getAdvice();

    }

    @Override
    public void onClick(View view){

        findViewById(R.id.test_button_send).setVisibility(View.VISIBLE);


    }

    public void send(View view){


        RadioGroup group= (RadioGroup)findViewById(R.id.test_radioGroup);
        findViewById(R.id.test_button_send).setVisibility(View.GONE);


        int choices=group.getChildCount();
        for(int i=0;i<choices;i++){
            group.getChildAt(i).setEnabled(false);//off el grupo

        }

        int selectedID = group.getCheckedRadioButtonId();
        group.getChildAt(correct).setBackgroundColor(Color.GREEN);
        View radioButton= group.findViewById( selectedID);
        int selected=group.indexOfChild(radioButton);


        if (selected != correct) {
            group.getChildAt(selected).setBackgroundColor(Color.RED);
            Toast.makeText(getApplicationContext(), "Has fallado!", Toast.LENGTH_SHORT).show();

            if(advise!=null){

               findViewById(R.id.test_button_ayuda).setVisibility(View.VISIBLE);


            }
        } else {
            Toast.makeText(getApplicationContext(), "Has acertado", Toast.LENGTH_SHORT).show();
        }



    }


    public void ayuda(View view){

        LinearLayout layout=(LinearLayout)findViewById(R.id.advice_layout);
                switch (advise.getType())
                {
                    case Test.Advice.HTML:
                        showHtml(advise.getContent(),layout);
                        break;
                    case Test.Advice.IMAGE:
                        break;
                    case Test.Advice.AUDIO:
                        break;
                    case Test.Advice.VIDEO:
                        showVideo(advise.getContent(),layout);
                        break;
                    default:
                        break;

                }


                /*
                WebView web= new WebView(this);
                web.loadData(advise,"text/html",null);
                web.setBackgroundColor(Color.TRANSPARENT);
                web.setLayerType(WebView.LAYER_TYPE_SOFTWARE,null);
                layout.addView(web);
                */


    }
    private void showHtml(String advice,LinearLayout layout)
    {
        if(advice.substring(0,10).contains("://"))
        {
            Uri uri= Uri.parse(advice);
            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        }
        else
        {
            WebView web=new WebView(this);
            web.loadData(advice, "text/html", null);
            web.setBackgroundColor(Color.TRANSPARENT);
            web.setLayerType(WebView.LAYER_TYPE_SOFTWARE,null);
            layout.addView(web);
        }
    }
    private void showVideo(String advice,LinearLayout layout)
    {
        VideoView video=new VideoView(this);
        video.setVideoURI(Uri.parse(advice));
        ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        video.setLayoutParams(params);

        MediaController controller=new MediaController(this){

        @Override
        public void hide(){}

        @Override
        public boolean dispatchKeyEvent(KeyEvent event){

            if(event.getKeyCode()==KeyEvent.KEYCODE_BACK)
                finish();
            return super.dispatchKeyEvent(event);
        }

        };
        controller.setAnchorView(video);
        video.setMediaController(controller);
        layout.addView(video);
        video.start();


    }
    private void showAudio()
    {

    }
}






















