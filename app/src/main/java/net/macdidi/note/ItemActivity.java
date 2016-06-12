package net.macdidi.note;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

public class ItemActivity extends AppCompatActivity {

    private EditText title_text, content_text;

    private static final int START_CAMERA = 0;
    private static final int START_RECORD = 1;
    private static final int START_LOCATION = 2;
    private static final int START_ALARM = 3;
    private static final int START_COLOR = 4;

    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        processViews();
        Intent intent = getIntent();
        String action = intent.getAction();

        if (action.equals("net.macdidi.note.EDIT_ITEM")) {
            item = (Item) intent.getExtras().getSerializable("net.macdidi.note.Item");
            title_text.setText(item.getTitle());
            content_text.setText(item.getContent());
        } else {
            item = new Item();
        }
    }

    private void processViews(){
        title_text = (EditText)findViewById(R.id.title_text);
        content_text = (EditText)findViewById(R.id.enter_content);
    }

    public void onSubmit(View view){
        //ok or cancel button
        if (view.getId() == R.id.ok_teim){
            //read input title and content
            String titleText = title_text.getText().toString(); //read entered title info
            String contentText = content_text.getText().toString(); //read entered content info

            item.setTitle(titleText); //set note title and content
            item.setContent(contentText);

            //if edit note list
            if (getIntent().getAction().equals("net.macdidi.note.EDIT_ITEM")){
                item.setLastModify(new Date().getTime());
            }//add note
            else{
                item.setDatetime(new Date().getTime());
            }

            Intent result = getIntent(); //take info

            result.putExtra("net.macdidi.note.Item", item);
           // result.putExtra("titleText", titleText); //set title and content
           // result.putExtra("contentText", contentText);

            setResult(Activity.RESULT_OK, result); //set reply result to ok
        }
        finish();
    }

    public  void clickFunction(View view){
        int id = view.getId();

        switch (id){
            case R.id.take_picture:
                break;
            case R.id.record_sound:
                break;
            case R.id.set_location:
                break;
            case R.id.set_alarm:
                break;
            case R.id.select_color:
                startActivityForResult(new Intent(this, ColorActivity.class),START_COLOR);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == Activity.RESULT_OK){
            switch (requestCode){
                case START_CAMERA:
                    break;
                case START_RECORD:
                    break;
                case START_LOCATION:
                    break;
                case START_ALARM:
                    break;
                case START_COLOR:
                    int colorId = data.getIntExtra("colorId", Colors.LIGHTGRAY.parseColor());
                    item.setColor(getColors(colorId));
                    break;
            }
        }
    }

    private  Colors getColors(int color){
        Colors result = Colors.LIGHTGRAY;

        if (color == Colors.BLUE.parseColor()){
            result = Colors.BLUE;
        }
        else if (color == Colors.PURPLE.parseColor()){
            result = Colors.PURPLE;
        }
        else if(color == Colors.GREEN.parseColor()){
            result = Colors.ORANGE;
        }
        else if (color == Colors.RED.parseColor()){
            result = Colors.RED;
        }

        return result;
    }

}
