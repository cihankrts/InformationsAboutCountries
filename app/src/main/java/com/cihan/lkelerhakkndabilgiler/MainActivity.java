package com.cihan.lkelerhakkndabilgiler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String TrueAnswer="";
    private int point=0;
    private int randomNumber;
    private boolean tr = true;
    private String cevap ="";

    private boolean answer;

    private String Country;
    private String SiteTR ="https://tr.wikipedia.org/wiki/";
    private String SiteUK = "https://en.wikipedia.org/wiki/";
    private String mainSite;

    private Spinner mspinnerCountries;

    private Button mbtnA;
    private Button mbtnB;
    private Button mbtnC;
    private Button mbtnD;
    private WebView mwebView;


    private ImageView mIVturkey;
    private ImageView mIVuk;

    private TextView mtxtPoint1;
    private TextView mtxtPoint2;
    private TextView mtxtInfo;
    private TextView mtxtselectedCountryName;
    String[] Country_array;
    String[] Capital_array;
    String[] Ulke_array;
    String[] Baskent_array;


    public void init(){
        mtxtInfo = (TextView) findViewById(R.id.txtInfo);
        mtxtInfo.setText("Uygulamamıza hoşgeldiniz");
        mIVturkey = (ImageView) findViewById(R.id.IVturkey);
        mIVuk = (ImageView) findViewById(R.id.IVuk);
        mspinnerCountries = (Spinner) findViewById(R.id.spinnerCountries);
        ArrayAdapter<CharSequence> adapterStation = ArrayAdapter.createFromResource(this,
                R.array.ulkeler,R.layout.spinner_countries);
        adapterStation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinnerCountries.setAdapter(adapterStation);

        mtxtselectedCountryName = (TextView) findViewById(R.id.txtselectedCountryName);
        Country_array =  getResources().getStringArray(R.array.countries);
        Capital_array =  getResources().getStringArray(R.array.capitals);
        Ulke_array =  getResources().getStringArray(R.array.ulkeler);
        Baskent_array =  getResources().getStringArray(R.array.baskentler);

        mwebView = (WebView) findViewById(R.id.webView);
        mwebView.setWebViewClient((new WebViewClient()));
        WebSettings webSettings = mwebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mwebView.setBackgroundColor(Color.TRANSPARENT);
        mwebView.loadUrl("https://tr.wikipedia.org/wiki/Afganistan");


        mbtnA = (Button) findViewById(R.id.btnA);
        mbtnB = (Button) findViewById(R.id.btnB);
        mbtnC = (Button) findViewById(R.id.btnC);
        mbtnD = (Button) findViewById(R.id.btnD);

        mtxtPoint1 = (TextView) findViewById(R.id.txtPoint1);
        mtxtPoint2 = (TextView) findViewById(R.id.txtPoint2);

        mtxtPoint2.setText(point + " puan..");



    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnA:
            {
                cevap = mbtnA.getText().toString();
                if (TrueAnswer==cevap)
                {
                    if (tr) {
                        point = point + 1;
                        mtxtPoint2.setText(point + " puan..");
                        Toast.makeText(MainActivity.this, "Tebrikler Doğru cevap 1 puan kazandınız..", Toast.LENGTH_LONG).show();
                    }else{
                        point = point + 1;
                        mtxtPoint2.setText(point + " point..");
                        Toast.makeText(MainActivity.this, "Cong.. Correct answer you earned 1 " +
                                        "point..",
                                Toast.LENGTH_LONG).show();
                    }
                }else
                {
                    if (tr) {
                        point = point - 1;
                        mtxtPoint2.setText(point + " puan..");
                        Toast.makeText(MainActivity.this, "Üzgünüz yanlış cevap verdiniz 1 puan kaybettiniz..", Toast.LENGTH_LONG).show();
                    }else{
                        point = point - 1;
                        mtxtPoint2.setText(point + " point..");
                        Toast.makeText(MainActivity.this, "Sorry.. Wrong answer you lost 1 point..",
                                Toast.LENGTH_LONG).show();
                    }
                }
                break;
            }
            case R.id.btnB:
            {
                cevap = mbtnB.getText().toString();
                if (TrueAnswer==cevap)
                {
                    if (tr) {
                        point = point + 1;
                        mtxtPoint2.setText(point + " puan..");
                        Toast.makeText(MainActivity.this, "Tebrikler Doğru cevap 1 puan kazandınız..", Toast.LENGTH_LONG).show();
                    }else{
                        point = point + 1;
                        mtxtPoint2.setText(point + " point..");
                        Toast.makeText(MainActivity.this, "Cong.. Correct answer you earned 1 " +
                                "point..", Toast.LENGTH_LONG).show();
                    }
                }else
                {
                    if (tr) {
                        point = point - 1;
                        mtxtPoint2.setText(point + " puan..");
                        Toast.makeText(MainActivity.this, "Üzgünüz yanlış cevap verdiniz 1 puan kaybettiniz..", Toast.LENGTH_LONG).show();
                    }else{
                        point = point - 1;
                        mtxtPoint2.setText(point + " point..");
                        Toast.makeText(MainActivity.this, "Sorry.. Wrong answer you lost 1 point..", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            }
            case R.id.btnC:
            {
                cevap = mbtnC.getText().toString();
                if (TrueAnswer==cevap)
                {
                    if (tr) {
                        point = point + 1;
                        mtxtPoint2.setText(point + " puan..");
                        Toast.makeText(MainActivity.this, "Tebrikler Doğru cevap 1 puan kazandınız..", Toast.LENGTH_LONG).show();
                    }else {
                        point = point + 1;
                        mtxtPoint2.setText(point + " point..");
                        Toast.makeText(MainActivity.this, "Cong.. Correct answer you earned 1 " +
                                "point..", Toast.LENGTH_LONG).show();
                    }
                }else
                {
                    if (tr) {
                        point = point - 1;
                        mtxtPoint2.setText(point + " puan..");
                        Toast.makeText(MainActivity.this, "Üzgünüz yanlış cevap verdiniz 1 puan kaybettiniz..", Toast.LENGTH_LONG).show();
                    }else {
                        point = point - 1;
                        mtxtPoint2.setText(point + " point..");
                        Toast.makeText(MainActivity.this, "Sorry.. Wrong answer you lost 1 point..", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            }
            case R.id.btnD:
            {
                cevap = mbtnD.getText().toString();
                if (TrueAnswer==cevap)
                {
                    if (tr) {
                        point = point + 1;
                        mtxtPoint2.setText(point + " puan..");
                        Toast.makeText(MainActivity.this, "Tebrikler Doğru cevap 1 puan kazandınız..", Toast.LENGTH_LONG).show();
                    }else {
                        point = point + 1;
                        mtxtPoint2.setText(point + " point..");
                        Toast.makeText(MainActivity.this, "Cong.. Correct answer you earned 1 " +
                                "point..", Toast.LENGTH_LONG).show();
                    }
                }else
                {
                    if (tr) {
                        point = point - 1;
                        mtxtPoint2.setText(point + " puan..");
                        Toast.makeText(MainActivity.this, "Üzgünüz yanlış cevap verdiniz 1 puan kaybettiniz..", Toast.LENGTH_LONG).show();
                    }else {
                        point = point - 1;
                        mtxtPoint2.setText(point + " point..");
                        Toast.makeText(MainActivity.this, "Sorry.. Wrong answer you lost 1 point..", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            }


        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mbtnA.setOnClickListener(this);
        mbtnB.setOnClickListener(this);
        mbtnC.setOnClickListener(this);
        mbtnD.setOnClickListener(this);

        Random random = new Random();
        randomNumber = random.nextInt((3-0)+0)+0;

        mtxtselectedCountryName.setText("Aşağıdakilerden hangisi "+ mspinnerCountries.getSelectedItem().toString()+
                " ülkesinin başkentidir?");

            mbtnA.setText(Baskent_array[randomNumber]);
            mbtnB.setText(Baskent_array[randomNumber+3]);
            mbtnC.setText(Baskent_array[randomNumber+6]);
            mbtnD.setText(Baskent_array[randomNumber+9]);


        // Uygulamamızın dili Türkçe oluyor
        mIVturkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtxtInfo.setText("Uygulamamıza hoşgeldiniz \n Uygulamamızda sizlere ülkeler " +
                        "hakkında bilgiler vereceğiz..");
                ArrayAdapter<CharSequence> adapterStation =
                        ArrayAdapter.createFromResource(MainActivity.this,
                        R.array.ulkeler,R.layout.spinner_countries);
                adapterStation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mspinnerCountries.setAdapter(adapterStation);

                mtxtPoint1.setText("Puanınız: ");
                mtxtPoint2.setText(point + " puan..");

                tr=true;
            }
        });

        // Uygulamamızın dili ingilizce oluor
        mIVuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtxtInfo.setText("Welcome to our application \n We will give you some information" +
                        " about countries in this application" +
                        "..");
                ArrayAdapter<CharSequence> adapterStation =
                        ArrayAdapter.createFromResource(MainActivity.this,
                                R.array.countries,R.layout.spinner_countries);
                adapterStation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mspinnerCountries.setAdapter(adapterStation);

                mtxtPoint1.setText("Your point: ");
                mtxtPoint2.setText(point + " point..");
                tr=false;
            }
        });

        mspinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Country = mspinnerCountries.getSelectedItem().toString();
                if (tr) {
                    mainSite = SiteTR + Country;
                }else
                    mainSite = SiteUK + Country;
                mwebView.loadUrl(mainSite);


                int sayi = ((position*3)+2) % 4;

                TrueAnswer = Baskent_array[position];

            //    if (TrueAnswer == cevap)
             //   {
               //     point++;
               //     Toast.makeText(MainActivity.this,"tebrikler doğru", Toast.LENGTH_LONG).show();
              //  } else{point--;   Toast.makeText(MainActivity.this,"yanlış",
               //         Toast.LENGTH_LONG).show();}

                
                if (tr)
                {
                    mtxtselectedCountryName.setText("Aşağıdakilerden hangisi "+ mspinnerCountries.getSelectedItem().toString()+
                            " ülkesinin başkentidir?");
                 if (sayi==0)
                 {

                     if (position<180) {
                         mbtnA.setText(Baskent_array[position]);
                         mbtnB.setText(Baskent_array[position + 3]);
                         mbtnC.setText(Baskent_array[position + 6]);
                         mbtnD.setText(Baskent_array[position + 9]);

                     }else{
                         mbtnA.setText( Baskent_array[position]);
                         mbtnB.setText( Baskent_array[position - 3]);
                         mbtnC.setText( Baskent_array[position - 6]);
                         mbtnD.setText( Baskent_array[position - 9]);
                       
                     }
                 } else if (sayi==1)
                 {


                     if (position<180) {
                     mbtnB.setText(Baskent_array[position]);
                     mbtnA.setText(Baskent_array[position+3]);
                     mbtnC.setText(Baskent_array[position+6]);
                     mbtnD.setText(Baskent_array[position+9]);
                     }else{
                         mbtnB.setText(Baskent_array[position]);
                         mbtnA.setText(Baskent_array[position-3]);
                         mbtnC.setText(Baskent_array[position-6]);
                         mbtnD.setText(Baskent_array[position-9]);
                     }
                 } else if (sayi==2)
                 {


                     if (position<180) {
                     mbtnC.setText(Baskent_array[position]);
                     mbtnA.setText(Baskent_array[position+3]);
                     mbtnD.setText(Baskent_array[position+6]);
                     mbtnB.setText(Baskent_array[position+9]);
                     }else{
                         mbtnC.setText(Baskent_array[position]);
                         mbtnA.setText(Baskent_array[position-3]);
                         mbtnD.setText(Baskent_array[position-6]);
                         mbtnB.setText(Baskent_array[position-9]);
                     }
                 }else if (sayi==3)
                 {
                     

                     if (position<180) {
                     mbtnD.setText(Baskent_array[position]);
                     mbtnB.setText(Baskent_array[position+3]);
                     mbtnA.setText(Baskent_array[position+6]);
                     mbtnC.setText(Baskent_array[position+9]);
                     }else{
                         mbtnD.setText(Baskent_array[position]);
                         mbtnB.setText(Baskent_array[position-3]);
                         mbtnA.setText(Baskent_array[position-6]);
                         mbtnC.setText(Baskent_array[position-9]);
                     }
                 }
                }else
                {
                    mtxtselectedCountryName.setText("Which city is capital of "+ mspinnerCountries.getSelectedItem().toString()+" ?");
                    if (sayi==0)
                    {
                        if (position<180) {
                            mbtnA.setText( Baskent_array[position]);
                            mbtnB.setText( Baskent_array[position + 3]);
                            mbtnC.setText( Baskent_array[position + 6]);
                            mbtnD.setText( Baskent_array[position + 9]);
                        }else{
                            mbtnA.setText( Baskent_array[position]);
                            mbtnB.setText( Baskent_array[position - 3]);
                            mbtnC.setText( Baskent_array[position - 6]);
                            mbtnD.setText( Baskent_array[position - 9]);
                        }
                    } else if (sayi==1)
                    {
                        if (position<180) {
                            mbtnB.setText(Baskent_array[position]);
                            mbtnA.setText(Baskent_array[position+3]);
                            mbtnC.setText(Baskent_array[position+6]);
                            mbtnD.setText(Baskent_array[position+9]);
                        }else{
                            mbtnB.setText(Baskent_array[position]);
                            mbtnA.setText(Baskent_array[position-3]);
                            mbtnC.setText(Baskent_array[position-6]);
                            mbtnD.setText(Baskent_array[position-9]);
                        }
                    } else if (sayi==2)
                    {
                        if (position<180) {
                            mbtnC.setText(Baskent_array[position]);
                            mbtnA.setText(Baskent_array[position+3]);
                            mbtnD.setText(Baskent_array[position+6]);
                            mbtnB.setText(Baskent_array[position+9]);
                        }else{
                            mbtnC.setText(Baskent_array[position]);
                            mbtnA.setText(Baskent_array[position-3]);
                            mbtnD.setText(Baskent_array[position-6]);
                            mbtnB.setText(Baskent_array[position-9]);
                        }
                    }else if (sayi==3)
                    {
                        if (position<180) {
                            mbtnD.setText(Baskent_array[position]);
                            mbtnB.setText(Baskent_array[position+3]);
                            mbtnA.setText(Baskent_array[position+6]);
                            mbtnC.setText(Baskent_array[position+9]);
                        }else{
                            mbtnD.setText(Baskent_array[position]);
                            mbtnB.setText(Baskent_array[position-3]);
                            mbtnA.setText(Baskent_array[position-6]);
                            mbtnC.setText(Baskent_array[position-9]);
                        }
                    }
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mtxtselectedCountryName.setText(Country_array[175]);
            }
        });



        
    }
}