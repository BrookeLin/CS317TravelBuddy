package com.example.brookelin.cs317trialrun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

    // Creating variable
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Mapping with your XML view
        listView = (ListView) findViewById(R.id.itemList);

        /// Getting list of Strings from your resource
        String[] testArray = getResources().getStringArray(R.array.test);
        List<String> testList = Arrays.asList(test);

        // Instanciating Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getBaseContext(),
                android.R.layout.simple_list_item_1, testList);

        // setting adapter on listview
        listview.setAdapter(adapter);
    }
}
