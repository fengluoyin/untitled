import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;


public class GetGson {
    static Map<String,List<String>> map=new HashMap<>();
    public static void main (String[] args) {

        String a1="1";
        String a2="2";
        List<String> lst1=new ArrayList<>();
        List<String> lst2=new ArrayList<>();
        lst1.add("a1");
        lst1.add("a2");
        lst1.add("a3");
        lst2.add("a1");
        lst2.add("a2");
        lst2.add("a3");
        map.put(a1,lst1);
        map.put(a2,lst2);
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(test.class, new testser());
        gsonBuilder.setPrettyPrinting();
        final Gson gson = gsonBuilder.create();

        final test[] effectiveJava1 = new test[2];
        for(int j=0;j<effectiveJava1.length;j++)
        {
            effectiveJava1[j]=new test();
            effectiveJava1[j].id=new String();
            effectiveJava1[j].environments=new String[3];

        }
        int i=0;
        for(String a:map.keySet())
        {

            effectiveJava1[i].id=a;
            effectiveJava1[i].environments=map.get(a).toArray(new String[0]);
            i++;
        }
        final String json = gson.toJson(effectiveJava1);

        
        System.out.println(json);
    }


}
