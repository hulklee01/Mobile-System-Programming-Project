package com.mobile.hulklee01.project01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RemoveActivity extends Activity {
    LocationInfo info;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
        info = (LocationInfo)getApplicationContext();
    }

    public void onClickRemoveLocation(View view) {
        EditText editText = (EditText)findViewById(R.id.editText);

        if(editText.getText().toString().equals(info.getName1()))
            info.delete1();
        else if(editText.getText().toString().equals(info.getName2()))
            info.delete2();
        else if(editText.getText().toString().equals(info.getName3()))
            info.delete3();
        else
            Toast.makeText(this, "없는 이름입니다.", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
