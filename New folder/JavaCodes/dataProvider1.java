package sonatasomething.thesecond;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class dataProvider1 {
    public static HashMap<String,List<String>> getInfo()
    {
        HashMap<String,List<String>> Skills_details=new HashMap<String,List<String>>();
        List<String> item1 =new ArrayList<String>();
        item1.add("Certification name:");
        item1.add("Certified by:");
        item1.add("Score:");
        item1.add("Issue date:");
        List<String> item2 =new ArrayList<String>();
        item2.add("Certification name:");
        item2.add("Certified by:");
        item2.add("Score:");
        item2.add("Issue date:");
        List<String> item3 = new ArrayList<String>();
        item3.add("Certification name:");
        item3.add("Certified by:");
        item3.add("Score:");
        item3.add("Issue date:");
        List<String> item4 = new ArrayList<String>();
        item4.add("Certification name:");
        item4.add("Certified by:");
        item4.add("Score:");
        item4.add("Issue date:");




        Skills_details.put("C", item1);
        Skills_details.put("C++", item2);
        Skills_details.put("Java",item3);
        Skills_details.put("Android",item4);





        return Skills_details;

    };
};
