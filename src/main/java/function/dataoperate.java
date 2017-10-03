package function;

import bean.keybean;
import com.google.gson.Gson;
import core.*;

import com.google.gson.JsonObject;
import net.sf.json.JSONObject;


import java.util.HashSet;

public class dataoperate {

    public static void initialdata()
    {
        Main m=new Main();
        ConvertJson cj=new ConvertJson();
        HashSet<Key1> k1=m.getAllKeys();
        HashSet<Lock1> l1=m.getAllLocks();
        HashSet<KeyLock> kl1=m.getAllCombos();

        String keys= cj.set2json(m.getAllKeys());
        String locks= cj.set2json(m.getAllLocks());
        String combos= cj.set2json(m.getAllCombos());
//        System.out.println(keys);
//        System.out.println(".............................................");
//        System.out.println(locks);
//        System.out.println(".............................................");
//        System.out.println(combos);
        //JSONObject jsonObject = JSONObject.fromObject(keys);
        keybean[] kb=new Gson().fromJson(keys,keybean[].class);
        System.out.println("name01 = " + kb[0].getID());
        System.out.println("name02 = " + kb[1].getID());
    }
}
