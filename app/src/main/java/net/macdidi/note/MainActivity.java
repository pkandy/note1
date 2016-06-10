package net.macdidi.note;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import net.macdidi.note.Colors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView item_list;
    private TextView show_app_name;

    //private ArrayList<String> data = new ArrayList<>();
    //private ArrayAdapter<String> adapter;

    private ItemAdapter itemAdapter;
    private List<Item> items;

    private MenuItem add_item, search_item, revert_item, delete_item;
    private int selectedCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processViews();
        processControllers();

        items = new ArrayList<Item>();

        items.add(new Item(1, new Date().getTime(), Colors.RED, "Relate to Android Tutorial.",
                "Hello content","","",0,0,0));
        items.add(new Item(2,new Date().getTime(), Colors.BLUE,"it is a very cute puppy!",
                "Her name call [Big Hot Dog], also call \n [Kiss], she is a very cute\n dog.","","",
                0,0,0));
        items.add(new Item(3, new Date().getTime(), Colors.GREEN,"it is a very nice sound!",
                "Hello content","","",0,0,0));

        itemAdapter = new ItemAdapter(this, R.layout.single_item, items);
        item_list.setAdapter(itemAdapter);

        //data.add("Relate to Android Tutorial");
        //data.add("it is a very cute puppy!");
        //data.add("it is a very nice music!");

        //int layoutId = android.R.layout.simple_list_item_1;
        //adapter = new ArrayAdapter<String>(this, layoutId, data);

        /*String[] data ={
                "Relate to Android Tutorial",
                "it is a very cute puppy!",
                "it is a very nice music!"};
        int layoutId = android.R.layout.simple_list_item_1;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, layoutId, data);
        ListView item_list = (ListView) findViewById(R.id.item_list);*/

            //item_list.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        /*if (resultCode == Activity.RESULT_OK){
            String titleText = data.getStringExtra("titleText");
            if (requestCode == 0) {
                this.data.add(titleText);
                adapter.notifyDataSetChanged();
            }else if (requestCode == 1){
                int position = data.getIntExtra("position", -1);
                if (position != -1){
                    this.data.set(position, titleText);
                    adapter.notifyDataSetChanged();
                }
            }
        }*/
    }

    private  void processViews(){
        item_list = (ListView) findViewById(R.id.item_list);
        show_app_name = (TextView) findViewById(R.id.show_app_name);
    }

    private  void  processControllers(){
      /*  AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //Toast.makeText(MainActivity.this, data.get(position), Toast.LENGTH_LONG).show();
                Intent intent = new Intent("net.macdidi.note.Edit_ITEM");
                intent.putExtra("position", position);
                intent.putExtra("titleText", data.get(position));
                startActivityForResult(intent,1);
            }
        };

        item_list.setOnItemClickListener(itemListener);

        AdapterView.OnItemLongClickListener itemLongListener = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Long: " + data.get(position), Toast.LENGTH_LONG).show();
                return false;
            }
        }; */
    }

    public void aboutApp(View view){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void clickMenuItem(MenuItem item){
        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.search_item:
                break;
            case R.id.add_item:
                Intent intent = new Intent("net.macdidi.note.ADD_ITEM");
                startActivityForResult(intent, 0);
                break;
            case R.id.revert_item:
                break;
            case R.id.delete_item:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}

