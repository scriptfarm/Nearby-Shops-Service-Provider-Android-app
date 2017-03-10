package org.nearbyshops.serviceprovider.ItemSpecName.EditItemSpecName;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;


import org.nearbyshops.serviceprovider.ModelItemSpecification.ItemSpecificationName;
import org.nearbyshops.serviceprovider.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by sumeet on 19/10/16.
 */



public class UtilityItemSpecName {

    public static final String TAG_ITEM_PREF = "tag_item_spec_name";


    public static void saveItemSpecName(ItemSpecificationName itemSpecName, Context context)
    {

        //Creating a shared preference

        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPref.edit();

        if(itemSpecName == null)
        {
            prefsEditor.putString(TAG_ITEM_PREF, "null");

        }
        else
        {
            Gson gson = new Gson();
            String json = gson.toJson(itemSpecName);
            prefsEditor.putString(TAG_ITEM_PREF, json);
        }

        prefsEditor.apply();
    }


    public static ItemSpecificationName getItemSpecName(Context context)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);

        Gson gson = new Gson();
        String json = sharedPref.getString(TAG_ITEM_PREF, "null");

        if(json.equals("null"))
        {

            return null;

        }else
        {
            return gson.fromJson(json, ItemSpecificationName.class);
        }
    }



    // Item for Item ID






}
