package com.example.yiyi.myapplicationmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final static  String USERNAME="用户名";
    private final static String CLASS="班级";
    private final static String SNO="学号";
    private final static String SEX="性别";
    private final static String PHONE="手机";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[]usernames={"小A","小B","小C"};
        String[]classs={"01","02","03"};
        String[]snos={"12345","23456","34567"};
        String[]sexs={"M","F","M"};
        String[]phones={"188-1000-1000","188-1000-1001","188-1000-1010"};

        List<Map<String,Object>> items= new ArrayList<Map<String,Object>>();

        for (int i=0;i<usernames.length;i++)
        {
            Map<String,Object> item=new HashMap<String,Object>();
            item.put(USERNAME, usernames[i]);
            item.put(CLASS, classs[i]);
            item.put(SNO,snos[i]);
            item.put(SEX,sexs[i]);
            item.put(PHONE, phones[i]);
            items.add(item);

        }
        SimpleAdapter adapter=new SimpleAdapter(this,items,R.layout.menu,new String[]{USERNAME ,CLASS,SNO,SEX,PHONE},new int[]{R.id.txtusername,R.id.txtclass,R.id.txtsno,R.id.txtsex,R.id.txtphone});

        ListView list=(ListView)findViewById(R.id.list);

        list.setAdapter(adapter);
        registerForContextMenu(list);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.small_menu, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "修改联系人", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_another:
                Toast.makeText(this, "删除联系人", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }



}
