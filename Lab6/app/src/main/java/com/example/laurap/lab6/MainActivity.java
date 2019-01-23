package com.example.laurap.lab6;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // JSON Node names
    private static final String TAG_RESTAURANT_NAME = "RestaurantName";
    private static final String TAG_MENUS_FOR_DAYS = "MenusForDays";
    private static final String TAG_DATE = "Date";
    private static String TAG_LUNCH_TIME = "LunchTime";
    private static final String TAG_SET_MENUS = "SetMenus";
    private static final String TAG_SORT_ORDER = "SortOrder";
    private static final String TAG_NAME = "Name";
    private static final String TAG_PRICE = "Price";
    private static final String TAG_COMPONENTS ="Components";

    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;
    TextView restaurantName;
    TextView lTime;


    // URL to get contacts JSON
    private static String url = "https://www.amica.fi/modules/json/json/Index?costNumber=0235&language=fi";

    ArrayList<HashMap<String, String>> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuList = new ArrayList<>();

        restaurantName = (TextView)findViewById(R.id.tv_restaurant);
        lTime = (TextView) findViewById(R.id.tv_time);
        lv = (ListView) findViewById(R.id.list);

        new GetContacts().execute();
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    // The first object
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    // Getting RestaurantName string from jsonObj
                    final String restaurant = jsonObj.getString(TAG_RESTAURANT_NAME);
                    // Getting MenusForDays Array from jsonObj
                    JSONArray menusForDays = jsonObj.getJSONArray(TAG_MENUS_FOR_DAYS);
                    // Getting object from MenusForDays
                    JSONObject jsonObj3 = menusForDays.getJSONObject(0);
                    // Getting the first Lunch time string
                    final String lunch = jsonObj3.getString(TAG_LUNCH_TIME);


                    // looping through All MenusForDays
                    for (int i = 0; i < menusForDays.length(); i++) {

                        // Getting another Json object from MenusForDays
                        JSONObject c = menusForDays.getJSONObject(i);
                        // Setting new value to Date
                        // Today
                        if(c.getString("LunchTime").equals("Kotkanpoika kello:  10.15 - 13.00 ")){
                            JSONObject f = menusForDays.getJSONObject(0);
                            f.put("Date", "Tänään");


                        }
                        // Tomorrow
                        if(c.getString("LunchTime").equals("Kotkanpoika kello:  10.15 - 13.00 ")){
                            JSONObject f = menusForDays.getJSONObject(1);
                            f.put("Date", "Huomenna");
                        }

                        if(c.getString("LunchTime").equals("Kotkanpoika kello:  10.15 - 13.00 ")){
                            JSONObject f = menusForDays.getJSONObject(0);
                            f.put("Date", "Tänään");
                        }

                        if(c.getString("LunchTime").equals("Kotkanpoika kello:  10.15 - 13.00 ")){
                            JSONObject f = menusForDays.getJSONObject(1);
                            f.put("Date", "Huomenna");
                        }
                        if(c.getString("LunchTime").equals("Kotkanpoika kello:  10.15 - 13.00 ") || c.getString("LunchTime").equals("Kotkanpoika kello:  10.15 - 13.00 ")){
                            JSONObject f = menusForDays.getJSONObject(2);
                            f.getString(TAG_DATE.replace("\"2018\"", "\"TESTI\""));
                        }

                        String date = c.getString(TAG_DATE);


                        // Getting JSON Array from SetMenus
                        JSONArray setMenus = c.getJSONArray(TAG_SET_MENUS);

                        // looping through all SetMenus
                        for(int j = 0; j < setMenus.length(); j++){
                            // Getting the last object from setMenus
                            JSONObject jsonObj2 = setMenus.getJSONObject(j);

                            String sortOrder = jsonObj2.getString(TAG_SORT_ORDER);
                            String name = jsonObj2.getString(TAG_NAME);
                            String price = jsonObj2.getString(TAG_PRICE);

                            // Getting the components array from jsonObj2
                            JSONArray components = jsonObj2.getJSONArray(TAG_COMPONENTS);

                            // looping through all components
                            for(int k = 0; k < components.length(); k++){
                                String cp = components.getString(k);


                                // tmp hash map for single contact
                                HashMap<String, String> menu = new HashMap<>();

                                // adding each child node to HashMap key => value
                                menu.put("Date", date);
                                menu.put("Name", name);
                                menu.put("Components", cp);
                                // adding contact to contact list
                                menuList.add(menu);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        restaurantName.setText(restaurant);
                                        lTime.setText(lunch);
                                    }
                                });
                            }
                        }
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, menuList,
                    R.layout.list_item, new String[]{
                    "Name", "LunchTime", "Components", "Date"},
                    new int[]{R.id.name, R.id.tv_time, R.id.components, R.id.date});

            lv.setAdapter(adapter);
        }

    }
}