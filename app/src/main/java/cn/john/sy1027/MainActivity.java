package cn.john.sy1027;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ChatContent> contents=new ArrayList<ChatContent>();
    private ChatContentAdapter adapter;
    private ListView chatLv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chatLv=findViewById(R.id.chatListLv);
        for(int i=0;i<3;i++){
            ChatContent cc=new ChatContent();
            cc.setContent("hello world!");
            cc.setMe(i%2==0?true:false);
            contents.add(cc);
        }
        adapter=new ChatContentAdapter(this,R.layout.chat_layout,contents);
        chatLv.setAdapter(adapter);

    }

    public void send(View view) {
        EditText et=findViewById(R.id.sendMsg);

        ChatContent cc=new ChatContent();
        cc.setContent(et.getText().toString());
        double ran=Math.random();
        if(ran>0.5){
            cc.setMe(true);
        }
        et.setText("");
        contents.add(cc);

        adapter.notifyDataSetChanged();

    }
}
