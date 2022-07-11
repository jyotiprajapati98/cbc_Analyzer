package com.healthcare.cbcanalyzer;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CBC_RangeBook extends AppCompatActivity {

    private RecyclerView cbc_Variables;

    // Arraylist for storing data
    private ArrayList<CBC_BookModal> cbcVariableRangeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cbc_range_book);
        cbc_Variables = findViewById(R.id.cbc_Variables);

        // here we have created new array list and added data to it.
        cbcVariableRangeList = new ArrayList<CBC_BookModal>();
        cbcVariableRangeList.add(new CBC_BookModal("Hemoglobin (HB)", "HB shows the red blood cell (RBCs) quantity in human body. If it is less than 11.5 g/dL than person is suffering from anemia. HB shows protein level of RBCs." +
                "(HB लेवल यह प्रदर्शित करता हैं की, आपके शरीर में लाल रक्त कणिकाओं की मात्रा कितनी है। अगर HB की मात्रा 11.5 g/dL से कम हैं तो आपको एनीमिया की शिकायत हो सकती हैं। HB खून में प्रोटीन की मात्रा को बताता है। )"));
        cbcVariableRangeList.add(new CBC_BookModal("HCT or Hematocrit", "Normal level of HCT for men(41%-50%) and for women (36%-44%). HCT shows the number of RBCs in blood."+
                "(खून में HCT की सामान्य मात्रा महिलाओं के लिए 36%-44% तथा पुरुषों के लिए 41%-50% होती है। HCT, RBC रक्त कणिकाओं की इनकी मात्रा को दिखाता है। )"));
        cbcVariableRangeList.add(new CBC_BookModal("RBC or Red Blood Cells", "RBC is type of blood cell present in blood. Normal range of RBC is men (4.7 to 6.1 cells/mcL) and for women (4.2 to 5.4 cells/mcL)."+
                "( RBC रक्त कणिकाओं का ही प्रकार है। इसकी सामान्य मात्रा महिलाओं में 4.2 to 5.4 cells/mcL तथा पुरुषों में 4.7 to 6.1 cells/mcL होती है। )"));
        cbcVariableRangeList.add(new CBC_BookModal("MCV or Mean Corpuscular Volume", "MCV test shows the size and volume of RBCs. Normal range of MCV is 80–100 fl. If it is not range means person is suffering from anemia."+
                "( MCV की जाँच से खून में RBC के आकार का पता चलता है। इसका सामान्य आकार 80–100 fl होता है। अगर किसी के खून में RBC का आकार छोटा या बड़ा होता हैं तो उसके एनीमिया की शिकायत होती है। )"));
        cbcVariableRangeList.add(new CBC_BookModal("MCH or Mean Corpuscular Hemoglobin", "MCH shows the average quantity of HB in single blood cell. The range of MCH is between 27.5 and 33.2 picograms (pg). Abnormal MCH range cause anemia."+
                "( MCH एक रक्त कोशिका में HB की औसत मात्रा को दर्शाता है। MCH की सीमा 27.5 - 33.2 पिकोग्राम (pg) के बीच होती हैं । असामान्य MCH की मात्रा एनीमिया का कारण बनता है। )"));
        cbcVariableRangeList.add(new CBC_BookModal("MCHC or Mean Corpuscular Hemoglobin Concentration", "The MCHC measure the average concentration of HB inside single blood cell. The normal range of MCHC is 33.4–35.5 grams per deciliter (g/dL). Low MCHC cause due to iron deficiency."+
                " ( MCHC की जाँच से खून की हर एक कणिका में HB अवशोषण क्षमता का पता चलता हैं। MCHC की सामान्य मात्रा 33.4–35.5 g/dL होती हैं।  MCHC की कमी आयरन की कमी के कारण होती है। )"));
        cbcVariableRangeList.add(new CBC_BookModal("RDW-CV or Red cell Distribution Width", "The normal range of RDW-CV in RBCs is 11.5–15.4%. High RDW cause due to nutrient deficiencies(deficiency of iron, folate, or vitamin B-12)." +
                " ( खून में RDW-CV की सामान्य मात्रा 11.5–15.4% होती है। शरीर में पोषक तत्वों की कमी के कारण RDW-CV की मात्रा बढ़ जाती हैं। इसका कारण आयरन / फोलेट / विटामिन बी-12 की कमी भी होती है। )"));
        cbcVariableRangeList.add(new CBC_BookModal("TLC or Total Leukocyte Count", "TLC range is used to check the infection in body. TLC and WBC(White blood cells) both are same. The normal range for TLC is between 4,000 - 11,000 cells/ cubic millimeter of blood." +
                " ( TLC की मात्रा शरीर में इन्फेक्शन देखने के काम आती है।  TLC अथवा WBC एक ही होते है।  खून में इनकी सामान्य मात्रा  4,000 - 11,000 cells/cubic मिलीमीटर होती हैं। ) "));
        cbcVariableRangeList.add(new CBC_BookModal("Platelets", "Platelets help to clot the blood and stop the bleeding. A normal platelet ranges 150,000 - 450,000 platelets/microliter of blood."+
                " ( खून में प्लेटलेट्स होने कारण ही जब हमे चोट लगती हैं खून की बून्द जम जाती है। प्लेटलेट्स की कमी होने से खून का थक्का नहीं जमता हैं वही अगर इसकी मात्रा ज्यादा हो तो शरीर में खून जमने लगता हैं। प्लेटलेट्स की सामान्य मात्रा 50,000 - 450,000 platelets/ माइक्रोलीटर होती हैं। )"));


        // we are initializing our adapter class and passing our arraylist to it.
        CBC_RangeBookAdapter courseAdapter = new CBC_RangeBookAdapter(this, cbcVariableRangeList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        cbc_Variables.setLayoutManager(linearLayoutManager);
        cbc_Variables.setAdapter(courseAdapter);
    }
}
