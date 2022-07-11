package com.healthcare.cbcanalyzer;

import android.util.Log;
import android.widget.EditText;

import java.io.Serializable;

public class CBC_Variables implements Serializable {
    public Float hb;
    public Float hct;
    public Float rbc;
    public Float mcv;
    public Float mch;
    public Float mchc;
    public Float rdw;
    public Float tlc;
    public String neut;
    public String lymp;
    public String mono;
    public String eosi;
    public String baso;
    public Float plt;
    public CBC_Variables(Float hb, Float hct, Float rbc, Float mcv, Float mch, Float mchc, Float rdw, Float tlc,
                         Float plt){
        this.hb=hb;
        this.hct=hct;
        this.rbc=rbc;
        this.mcv=mcv;
        this.mch=mch;
        this.mchc=mchc;
        this.rdw=rdw;
        this.tlc=tlc;
        this.neut=neut;
        this.lymp=lymp;
        this.mono=mono;
        this.eosi=eosi;
        this.baso=baso;
        this.plt=plt;

    }
    public void setHb(Float hb) {
        this.hb = hb;
        Log.d("test27","test27");
    }
    public Float getHb() { return hb; }

    public void setHct(Float hct) {
        this.hct = hct;
    }
    public Float getHct() { return hct; }

    public void setRbc(Float rbc) {
        this.rbc = rbc;
    }
    public Float getRbc() { return rbc; }

    public void setMcv(Float mcv) {
        this.mcv = mcv;
    }
    public Float getMcv() { return mcv; }

    public void setMch(Float mch) {
        this.mch = mch;
    }
    public Float getMch() { return mch; }

    public void setmchc(Float mchc) {
        this.mchc = mchc;
    }
    public Float getmchc() { return mchc; }

    public void setrdw(Float rdw) {
        this.rdw = rdw;
    }
    public Float getrdw() { return rdw; }

    public void settlc(Float tlc) {
        this.tlc = tlc;
    }
    public Float gettlc() { return tlc; }

    public void setneut(String neut) {
        this.neut = neut;
    }
    public String getneut() { return neut; }

    public void setlymp(String lymp) {
        this.lymp = lymp;
    }
    public String getlymp() { return lymp; }

    public void setmono(String mono) {
        this.mono = mono;
    }
    public String getmono() { return mono; }

    public void seteosi(String eosi) {
        this.eosi = eosi;
    }
    public String geteosi() { return eosi; }

    public void setbaso(String baso) {
        this.baso = baso;
    }
    public String getbaso() { return baso; }

    public void setplt(Float tlc) {
        this.plt = plt;
    }
    public Float getplt() { return plt; }

}
