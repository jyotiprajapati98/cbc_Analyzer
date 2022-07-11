package com.healthcare.cbcanalyzer;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Locale;

public class AnalysisResult extends AppCompatActivity {
    public TextView hbVal;
    public TextView hbAnalysis;
    public TextView hctVal;
    public TextView hctAnalysis;
    public TextView rbcVal;
    public TextView rbcAnalysis;
    public TextView mcvVal;
    public TextView mcvAnalysis;
    public TextView mchVal;
    public TextView mchAnalysis;
    public TextView mchcVal;
    public TextView mchcAnalysis;
    public TextView rdwVal;
    public TextView rdwAnalysis;
    public TextView tlcVal;
    public TextView tlcAnalysis;
    /*
    public TextView neutVal;
    public TextView neutAnalysis;
    public TextView lympVal;
    public TextView lympAnalysis;
    public TextView monoVal;
    public TextView monoAnalysis;
    public TextView eosinVal;
    public TextView eosinAnalysis;
    public TextView basoVal;
    public TextView basoAnalysis;

     */
    public TextView pltVal;
    public TextView pltAnalysis;


    public CBC_Variables cbc_variables;
    public Button audioReport;
    public Button exit;
    public Button cbcRangeBook;
    public TextToSpeech textToSpeech;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analysis_result);

        hbVal=findViewById(R.id.hbTV);
        hbAnalysis =findViewById(R.id.hbAnalysisTV);

        hctVal=findViewById(R.id.hctTV);
        hctAnalysis =findViewById(R.id.hctAnalysisTV);

        rbcVal=findViewById(R.id.rbcTV);
        rbcAnalysis =findViewById(R.id.rbcAnalysisTV);

        mcvVal=findViewById(R.id.mcvTV);
        mcvAnalysis =findViewById(R.id.mcvAnalysisTV);

        mchVal=findViewById(R.id.mchTV);
        mchAnalysis =findViewById(R.id.mchAnalysisTV);

        mchcVal=findViewById(R.id.mchcTV);
        mchcAnalysis =findViewById(R.id.mchcAnalysisTV);

        rdwVal=findViewById(R.id.rdwTV);
        rdwAnalysis =findViewById(R.id.rdwAnalysisTV);

        tlcVal=findViewById(R.id.tlcTV);
        tlcAnalysis =findViewById(R.id.tlcAnalysisTV);
        /*
        neutVal=findViewById(R.id.neutTV);
        neutAnalysis =findViewById(R.id.neutAnalysisTV);

        lympVal=findViewById(R.id.lympTV);
        lympAnalysis =findViewById(R.id.lympAnalysisTV);

        monoVal=findViewById(R.id.monoTV);
        monoAnalysis =findViewById(R.id.monoAnalysisTV);

        eosinVal=findViewById(R.id.eosinTV);
        eosinAnalysis =findViewById(R.id.eosinAnalysisTV);

        basoVal=findViewById(R.id.basoTV);
        basoAnalysis =findViewById(R.id.basoAnalysisTV);

         */

        pltVal=findViewById(R.id.pltTV);
        pltAnalysis =findViewById(R.id.pltAnalysisTV);

        exit = findViewById(R.id.exit);
        cbcRangeBook = findViewById(R.id.cbcRangebook);
        //data extraction
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Log.d("We are in Analysis Result","test3");
            cbc_variables = (CBC_Variables) bundle.getSerializable("CBCobject");
        } else {
            Toast.makeText(AnalysisResult.this, "Cannot retrieve data", Toast.LENGTH_LONG).show();
            finish();
        }

        //check hb values
        Float hb=cbc_variables.getHb();
        String hbReport;
        float float_hb =hb;
        if(float_hb>=11.5){
            hbAnalysis.setText("आप स्वस्थ्य हैं!");
            hbReport = "Ap svasth ho";
            Log.d("We are in Analysis Result","test4");
        }
        else {
            hbAnalysis.setText("आपका हीमोग्लोबिन औसत रेंज से कम हैं जिसकी वजह से आपको एनीमिया की शिकायत हो सकती हैं जैसे - कमजोरी, भूख न लगना तथा नींद न आना !");
            hbReport = "aapaka heemoglobin kam hai aapako anemia hai jiski wajah se  apako kamajori, bhookh kam lagna aur need ki shikayat ho sakti hai";
        }

        //check hct value
        Float hct=cbc_variables.getHct();
        String hctReport;
        Float int_hct = hct;
        if(int_hct>=35 && int_hct<=50){
            hctAnalysis.setText("आप स्वस्थ्य हैं |");
            hctReport = "Ap svasth ho ";
            //Log.d("We are in Analysis Result","test5");

        }
        else {
            if(int_hct<35) {
                hctAnalysis.setText("आपका हेमेटोक्रिट% कम है!");
                hctReport = "aapaka Hematocrit kam hai";
            } else {
                hctAnalysis.setText("आपका हेमटोक्रिट % ज्यादा है!");
                hctReport = "aapaka Hematocrit % jada hai";
            }
        }

        //check rbc value
        Float rbc=cbc_variables.getRbc();
        String rbcReport;
        float float_rbc =rbc;
        if(float_rbc>=3.8 && float_rbc<=4.8){
            rbcAnalysis.setText("आप स्वस्थ्य हैं |");
            rbcReport = "Ap svasth ho .";
            //Log.d("We are in Analysis Result","test5");

        }
        else {
            if(float_rbc<3.8) {
                rbcAnalysis.setText("आपका रेड ब्लड सेल्स की मात्रा कम है!");
                rbcReport = "aapaka red blood cells kam hai";
            } else if(float_rbc>4.8){
                rbcAnalysis.setText("आपका रेड ब्लड सेल्स की मात्रा ज्यादा है!");
                rbcReport = "aapaka red blood cells jada hai";
            }
            else{
                rbcAnalysis.setText("आपका रेड ब्लड सेल्स की मात्रा नार्मल नहीं हैं !");
                rbcReport = "aapaka red blood cells normal nahi hai";
            }
        }

        //check mcv value
        Float mcv=cbc_variables.getMcv();
        String mcvReport;
        float float_mcv =rbc;
        if(float_mcv>=80 && float_mcv<=100){
            mcvAnalysis.setText("आप स्वस्थ्य हैं |");
            mcvReport = "Ap svasth ho";
        }
        else {
            if(float_mcv<80) {
                mcvAnalysis.setText("आपका रेड ब्लड सेल्स की मात्रा कम है!");
                mcvReport = "aapaka MCV kam hai";
            } else if(float_rbc>100){
                mcvAnalysis.setText("आपका MCV की मात्रा ज्यादा है!");
                mcvReport = "aapaka MCV jada hai";
            }
            else{
                mcvAnalysis.setText("आपका MCV की मात्रा नार्मल नहीं हैं !");
                mcvReport = "aapaka MCV normal nahi hai";
            }
        }

        //check mch value
        Float mch=cbc_variables.getMch();
        String mchReport;
        float float_mch =rbc;
        if(float_mch>=27.5 && float_mch<=33.2){
            mchAnalysis.setText("आप स्वस्थ्य हैं |");
            mchReport = "Ap svasth ho .";
        }
        else {
            if(float_mch<27.5) {
                mchAnalysis.setText("आपका MCH की मात्रा कम है!");
                mchReport = "aapaka MCH kam hai";
            } else if(float_mch>33.2){
                mchAnalysis.setText("आपका MCH की मात्रा ज्यादा है!");
                mchReport = "aapaka MCH jada hai";
            }
            else{
                mchAnalysis.setText("आपका MCH की मात्रा नार्मल नहीं हैं !");
                mchReport = "aapaka MCH normal nahi hai";
            }
        }

        //check MCHC value
        Float mchc=cbc_variables.getmchc();
        String mchcReport;
        float float_mchc =rbc;
        if(float_mchc>=33.4 && float_mchc<=35.5){
            mchAnalysis.setText("आप स्वस्थ्य हैं |");
            mchcReport = "Ap svasth ho .";
        }
        else {
            if(float_mchc<33.4) {
                mchcAnalysis.setText("आपका MCHC की मात्रा कम है!");
                mchcReport = "aapaka MCH kam hai";
            } else if(float_mchc>35.5){
                mchAnalysis.setText("आपका MCHC की मात्रा ज्यादा है!");
                mchcReport = "aapaka MCH jada hai";
            }
            else{
                mchAnalysis.setText("आपका MCHC की मात्रा नार्मल नहीं हैं !");
                mchcReport = "aapaka MCHC normal nahi hai";
            }
        }

        //check rdw value
        Float rdwcv=cbc_variables.getrdw();
        String rdwReport;
        float float_rdwcv =rbc;
        if(float_rdwcv>=11.5 && float_rdwcv<=15.4){
            rdwAnalysis.setText("आप स्वस्थ्य हैं |");
            rdwReport = "Ap svasth ho";
            Log.d("We are in Analysis Result","test5");

        }
        else {
            if(float_rdwcv<11.5) {
                rdwAnalysis.setText("आपका Red blood Cell Distribution % कम है!");
                rdwReport = "aapaka Red blood Cell Distribution % kam hai";
            } else if(float_rdwcv>15.4){
                rdwAnalysis.setText("आपका Red blood Cell Distribution % की मात्रा ज्यादा है!");
                rdwReport = "aapaka Red blood Cell Distribution % jada hai";
            }
            else{
                rdwAnalysis.setText("आपकाRed blood Cell Distribution % की मात्रा नार्मल नहीं हैं !");
                rdwReport = "aapaka Red blood Cell Distribution % normal nahi hai";
            }
        }

        //check tlc value
        Float tlc=cbc_variables.gettlc();
        String tlcReport;
        float float_tlc =rbc;
        if(float_tlc>=4 && float_tlc<=10){
            tlcAnalysis.setText("आप स्वस्थ्य हैं |");
            tlcReport = "Ap svasth ho";
            //Log.d("We are in Analysis Result","test5");

        }
        else {
            if(float_tlc<4) {
                tlcAnalysis.setText("आपका TLC cells/cubic mL कम है!");
                tlcReport = "aapaka TLC cells per cubic mili liter kam hai";
            } else if(float_tlc>10){
                tlcAnalysis.setText("आपका TLC cells/cubic mLकी मात्रा ज्यादा है!");
                tlcReport = "aapaka TLC cells per cubic mili liter jada hai";
            }
            else{
                tlcAnalysis.setText("आपका TLC cells/cubic mL की मात्रा नार्मल नहीं हैं !");
                tlcReport = "aapaka TLC cells per cubic mili liter normal nahi hai";
            }
        }
/*
        //check neut value
        String neut=cbc_variables.getneut();
        String neutReport;
        float float_neut =Float.parseFloat(neut);
        if(float_neut>=31.5 && float_neut<=34.5){
            neutAnalysis.setText("आप स्वस्थ्य हैं |");
            neutReport = "Ap svasth ho";
            Log.d("We are in Analysis Result","test5");

        }
        else {
            if(float_neut<31.5) {
                neutAnalysis.setText("आपका Red blood Cell Distribution % कम है!");
                neutReport = "aapaka Red blood Cell Distribution % kam hai.";
            } else if(float_neut>34.5){
                neutAnalysis.setText("आपका Red blood Cell Distribution % की मात्रा ज्यादा है!");
                neutReport = "aapaka Red blood Cell Distribution % jada hai.";
            }
            else{
                neutAnalysis.setText("आपकाRed blood Cell Distribution % की मात्रा नार्मल नहीं हैं !");
                neutReport = "aapaka Red blood Cell Distribution % normal nahi hai.";
            }
        }


        //check lymp value
        String lymp=cbc_variables.getlymp();
        String lympReport;
        float float_lymp =Float.parseFloat(lymp);
        if(float_lymp>=31.5 && float_lymp<=34.5){
            lympAnalysis.setText("आप स्वस्थ्य हैं |");
            lympReport = "Ap svasth ho";
            Log.d("We are in Analysis Result","test5");

        }
        else {
            if(float_lymp<31.5) {
                lympAnalysis.setText("आपका Red blood Cell Distribution % कम है!");
                lympReport = "aapaka Red blood Cell Distribution % kam hai.";
            } else if(float_lymp>34.5){
                lympAnalysis.setText("आपका Red blood Cell Distribution % की मात्रा ज्यादा है!");
                lympReport = "aapaka Red blood Cell Distribution % jada hai.";
            }
            else{
                lympAnalysis.setText("आपकाRed blood Cell Distribution % की मात्रा नार्मल नहीं हैं !");
                lympReport = "aapaka Red blood Cell Distribution % normal nahi hai.";
            }
        }


        //check mono value
        String mono=cbc_variables.getmono();
        String monoReport;
        float float_mono =Float.parseFloat(mono);
        if(float_mono>=31.5 && float_mono<=34.5){
            monoAnalysis.setText("आप स्वस्थ्य हैं |");
            monoReport = "Ap svasth ho";
            Log.d("We are in Analysis Result","test5");

        }
        else {
            if(float_mono<31.5) {
                monoAnalysis.setText("आपका Red blood Cell Distribution % कम है!");
                monoReport = "aapaka Red blood Cell Distribution % kam hai.";
            } else if(float_mch>34.5){
                monoAnalysis.setText("आपका Red blood Cell Distribution % की मात्रा ज्यादा है!");
                monoReport = "aapaka Red blood Cell Distribution % jada hai.";
            }
            else{
                monoAnalysis.setText("आपकाRed blood Cell Distribution % की मात्रा नार्मल नहीं हैं !");
                monoReport = "aapaka Red blood Cell Distribution % normal nahi hai.";
            }
        }

        //check eosin value
        String eosin=cbc_variables.geteosi();
        String eosinReport;
        float float_eosin =Float.parseFloat(eosin);
        if(float_eosin>=31.5 && float_eosin<=34.5){
            eosinAnalysis.setText("आप स्वस्थ्य हैं |");
            eosinReport = "Ap svasth ho";
            Log.d("We are in Analysis Result","test5");

        }
        else {
            if(float_eosin<31.5) {
                eosinAnalysis.setText("आपका Red blood Cell Distribution % कम है!");
                eosinReport = "aapaka Red blood Cell Distribution % kam hai.";
            } else if(float_eosin>34.5){
                eosinAnalysis.setText("आपका Red blood Cell Distribution % की मात्रा ज्यादा है!");
                eosinReport = "aapaka Red blood Cell Distribution % jada hai.";
            }
            else{
                eosinAnalysis.setText("आपकाRed blood Cell Distribution % की मात्रा नार्मल नहीं हैं !");
                eosinReport = "aapaka Red blood Cell Distribution % normal nahi hai.";
            }
        }

        //check baso value
        String baso=cbc_variables.getbaso();
        String basoReport;
        float float_baso =Float.parseFloat(baso);
        if(float_baso>=31.5 && float_baso<=34.5){
            basoAnalysis.setText("आप स्वस्थ्य हैं |");
            basoReport = "Ap svasth ho";
            Log.d("We are in Analysis Result","test5");

        }
        else {
            if(float_mch<31.5) {
                basoAnalysis.setText("आपका Red blood Cell Distribution % कम है!");
                basoReport = "aapaka Red blood Cell Distribution % kam hai.";
            } else if(float_mch>34.5){
                basoAnalysis.setText("आपका Red blood Cell Distribution % की मात्रा ज्यादा है!");
                basoReport = "aapaka Red blood Cell Distribution % jada hai.";
            }
            else{
                basoAnalysis.setText("आपकाRed blood Cell Distribution % की मात्रा नार्मल नहीं हैं !");
                basoReport = "aapaka Red blood Cell Distribution % normal nahi hai.";
            }
        }
        */
        //check plt value
        Float plt=cbc_variables.getplt();
        String pltReport;
        float float_plt =rbc;
        if(float_plt>=150 && float_plt<=450){
            pltAnalysis.setText("आप स्वस्थ्य हैं |");
            pltReport = "Ap svasth ho";
            Log.d("We are in Analysis Result","test5");

        }
        else {
            if(float_plt<150) {
                pltAnalysis.setText("आपका Platelets cells /cubic mL कम है!");
                pltReport = "aapaka Platelets cells per cubic mili liter kam hai";
            } else if(float_plt>450){
                pltAnalysis.setText("आपका Platelets cells /cubic mL की मात्रा ज्यादा है!");
                pltReport = "aapaka Platelets cells per cubic mili liter jada hai";
            }
            else{
                pltAnalysis.setText("आपका Platelets cells /cubic mL की मात्रा नार्मल नहीं हैं !");
                pltReport = "aapaka Platelets cells per cubic mili liter normal nahi hai";
            }
        }

        //set values
        hbVal.setText(cbc_variables.getHb()+" g/dL");
        Log.d("test4","test6");
        hctVal.setText(cbc_variables.getHct()+"%");
        rbcVal.setText(cbc_variables.getRbc()+" mcL");
        mcvVal.setText(cbc_variables.getMcv()+" fl");
        mchVal.setText(cbc_variables.getMch()+" pg");
        mchcVal.setText(cbc_variables.getmchc()+" g/dL");
        rdwVal.setText(cbc_variables.getrdw()+" %");
        tlcVal.setText(cbc_variables.gettlc()+" cells/mm^3");
        /*
        neutVal.setText(cbc_variables.getneut()+" %");
        lympVal.setText(cbc_variables.getlymp()+" %");
        monoVal.setText(cbc_variables.getmono()+" %");
        eosinVal.setText(cbc_variables.geteosi()+" %");
        basoVal.setText(cbc_variables.getbaso()+" %");

         */
        pltVal.setText(cbc_variables.getplt()+" cells/mm^3");

        // create an object textToSpeech and adding features into it
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                // if No error is found then only it will run
                if(i!=TextToSpeech.ERROR){
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });
        String report = "apka hemoglobin "+hb+" deci liter hain" +hbReport +"apka Hematocrit "+hct+"percent hain" +hctReport
                +"apka RBC "+rbc+"microliter  hain" +rbcReport+"apka MCV" +mcv+" femoliter hain" +mcvReport+"apka MCH"+mch+"picograms  hain"+mchReport
                +"apka MCHC"+mchc+"deci liter hain"+mchcReport+"apka Red blood Cell Distribution"+rdwcv+"percent hain" + rdwReport
                +"apkA TLC "+tlc+"cell per cubic mili liter hain "+tlcReport+"apka platelets"+plt+"platelets per micro liter  hain" + pltReport
                ;
        //audio CBC report
        audioReport = findViewById(R.id.audioReport);
        audioReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.setPitch((float) 1.2);
                    textToSpeech.setSpeechRate((float) 0.7);
                    textToSpeech.speak(report,TextToSpeech.QUEUE_FLUSH,null,null);
                } else {
                    textToSpeech.speak(report, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });



        //back and exit button
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        //back and exit button
        cbcRangeBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cbcRangeIntent = new Intent(AnalysisResult.this, CBC_RangeBook.class);
                startActivity(cbcRangeIntent);
            }
        });

    }
}

