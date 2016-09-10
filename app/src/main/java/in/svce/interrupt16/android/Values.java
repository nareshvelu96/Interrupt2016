package in.svce.interrupt16.android;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by root on 31/7/15.
 */
public class Values {
    static String id,name,email,auth_token,phone;
    static boolean ismyb,istabloid,issynt,istrifacta,isbombquad,isdumbc,islucky;
    static boolean is_loggedin;

public Values(Context c){

    SharedPreferences pref = c.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
    name=pref.getString("name", "");
    email=pref.getString("email", "");
    phone=pref.getString("phone", "");
    auth_token=pref.getString("auth_token", "");
    //id=pref.getString("id", "");
    is_loggedin=pref.getBoolean("islogged", false);




}
    public Values(){}
}
