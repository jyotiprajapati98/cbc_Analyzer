package com.healthcare.cbcanalyzer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CBCAnalysis extends AppCompatActivity {
    public EditText hbg;
    public EditText hct;
    public EditText rbc;
    public EditText mcv;
    public EditText mch;
    public EditText mchc;
    public EditText rdw;
    public EditText tlc;
    public EditText neut;
    public EditText lymp;
    public EditText mono;
    public EditText eosi;
    public EditText baso;
    public EditText plt;



    public Button check;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cbc_analysis);

        hbg=findViewById(R.id.hbVal);
        hct =findViewById(R.id.hctVal);
        rbc =findViewById(R.id.rbcVal);
        mcv=findViewById(R.id.mcvVal);
        mch=findViewById(R.id.mchVal);
        mchc=findViewById(R.id.mchcVal);
        rdw=findViewById(R.id.rdwCVVal);
        tlc=findViewById(R.id.tlcVal);/*
        neut = findViewById(R.id.neutVal);
        lymp = findViewById(R.id.lympVal);
        mono=findViewById(R.id.monoVal);
        eosi=findViewById(R.id.eosinVal);
        baso = findViewById(R.id.basophiVal);
        */
        plt = findViewById(R.id.pltVal);


        check=findViewById(R.id.check_button);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean error =false;

                if( TextUtils.isEmpty(hbg.getText())){
                    Toast.makeText(getApplicationContext(),"Please fill empty fields",Toast.LENGTH_SHORT).show();

                    hbg.setError( "Hemoglobin is require/हीमोग्लोबिन भरें" );
                    error = true;

                }
                if( TextUtils.isEmpty(hct.getText())){
                    Toast.makeText(getApplicationContext(),"Please fill empty fields",Toast.LENGTH_SHORT).show();

                    hct.setError( "HCT is require/HCT भरें" );
                    error = true;

                }
                if( TextUtils.isEmpty(rbc.getText())){
                    Toast.makeText(getApplicationContext(),"Please fill empty fields",Toast.LENGTH_SHORT).show();

                    rbc.setError( "RBC is require/RBC भरें" );
                    error = true;

                }
                if( TextUtils.isEmpty(mcv.getText())){
                    Toast.makeText(getApplicationContext(),"Please fill empty fields",Toast.LENGTH_SHORT).show();

                    mcv.setError( "MCV is require/MCV भरें" );
                    error = true;

                }
                if( TextUtils.isEmpty(mch.getText())){
                    Toast.makeText(getApplicationContext(),"Please fill empty fields",Toast.LENGTH_SHORT).show();

                    mch.setError( "MCH is require/MCH भरें" );
                    error = true;

                }
                if( TextUtils.isEmpty(mchc.getText())){
                    Toast.makeText(getApplicationContext(),"Please fill empty fields",Toast.LENGTH_SHORT).show();

                    mchc.setError( "mchc is require/mchc भरें" );
                    error = true;

                }
                if( TextUtils.isEmpty(rdw.getText())){
                    Toast.makeText(getApplicationContext(),"Please fill empty fields",Toast.LENGTH_SHORT).show();

                    rdw.setError( "rdw is require/rdw भरें" );
                    error = true;

                }
                if( TextUtils.isEmpty(tlc.getText())){
                    Toast.makeText(getApplicationContext(),"Please fill empty fields",Toast.LENGTH_SHORT).show();

                    tlc.setError( "tlc is require/tlc भरें" );
                    error = true;

                }
                /*
                if( TextUtils.isEmpty(neut.getText())){
                    Toast.makeText(getApplicationContext(),"Please fill empty fields",Toast.LENGTH_SHORT).show();

                    neut.setError( "Neutrophils is require/Neutrophils भरें" );
                    error = true;

                }
                if( TextUtils.isEmpty(lymp.getText())){
                    Toast.makeText(getApplicationContext(),"Please fill empty fields",Toast.LENGTH_SHORT).show();

                    lymp.setError( "Lympocytes is require/Lympocytes भरें" );
                    error = true;

                }
                if( TextUtils.isEmpty(mono.getText())){
                    Toast.makeText(getApplicationContext(),"Please fill empty fields",Toast.LENGTH_SHORT).show();

                    mono.setError( "Monocytes is require/Monocytes भरें" );
                    error = true;

                }
                if( TextUtils.isEmpty(eosi.getText())){
                    Toast.makeText(getApplicationContext(),"Please fill empty fields",Toast.LENGTH_SHORT).show();

                    eosi.setError( "Eosinophils is require/Eosinophils भरें" );
                    error = true;

                }
                if( TextUtils.isEmpty(baso.getText())){
                    Toast.makeText(getApplicationContext(),"Please fill empty fields",Toast.LENGTH_SHORT).show();

                    baso.setError( "Basophil is require/Basophil भरें" );
                    error = true;

                }

                 */
                if( TextUtils.isEmpty(plt.getText())){
                    Toast.makeText(getApplicationContext(),"Please fill empty fields",Toast.LENGTH_SHORT).show();

                    plt.setError( "Platelets is require/Platelets भरें" );
                    error = true;

                }

                if(!error){
                    Float hb = Float.valueOf(hbg.getText().toString().trim());
                    Float hctStr = Float.valueOf(hct.getText().toString().trim());
                    Float rbcStr = Float.valueOf(rbc.getText().toString().trim());
                    Float mcvStr = Float.valueOf(mcv.getText().toString().trim());
                    Float mchStr = Float.valueOf(mch.getText().toString().trim());
                    Float mchcStr = Float.valueOf(mchc.getText().toString().trim());
                    Float rdwStr = Float.valueOf(rdw.getText().toString().trim());
                    Float tlcStr = Float.valueOf(tlc.getText().toString().trim());
                    /*
                    String neutStr = neut.getText().toString().trim();
                    String lympStr = lymp.getText().toString().trim();
                    String monoStr = mono.getText().toString().trim();
                    String eosiStr = eosi.getText().toString().trim();
                    String basoStr = baso.getText().toString().trim();

                     */
                    Float pltStr = Float.valueOf(plt.getText().toString().trim());


                    Log.d("hemoglobin", String.valueOf(hb));
                    CBC_Variables cbc_variables=new CBC_Variables(hb,hctStr,rbcStr,mcvStr,mchStr,mchcStr,rdwStr,tlcStr,pltStr);
                    Log.d("test1","test1");
                    Intent intent = new Intent(CBCAnalysis.this, AnalysisResult.class);
                    intent.putExtra("CBCobject",cbc_variables);
                    startActivity(intent);
                }
            }
        });

    }
}
