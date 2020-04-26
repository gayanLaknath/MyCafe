package com.example.mycafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class RecipeAndOrder extends AppCompatActivity {

    ImageView BackToMenu;
    ArrayList<String> selectedItems = new ArrayList<>();
    ListView ch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_and_order);

        BackToMenu = findViewById(R.id.back);
        ch1 =findViewById(R.id.checkable_list);

        ch1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] items = {"Omlet(Add Rs.5.00)","Cutlet(Add Rs.10.00)","Fry Fish(Add Rs.15.00)"};
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.txt_lan, items);
        ch1.setAdapter(adapter);
        ch1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView)view).getText().toString();

                if (selectedItems.contains(selectedItem)){
                    selectedItems.remove(selectedItem); //unchecked item
                }
                else{
                    selectedItems.add(selectedItem);
                }
            }
        });

        BackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToDashboard = new Intent(RecipeAndOrder.this,Dashboard.class);
                startActivity(intentToDashboard);
                finish();
            }
        });
    }
    public void showSelectedItems(View view){
        String items="";
        for (String item:selectedItems){
            items+="-"+item+"\n";
        }
        Toast.makeText(this,"You have Selected \n "+items,Toast.LENGTH_LONG).show();
    }

}
