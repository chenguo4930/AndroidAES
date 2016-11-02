package com.example.cheng.aesdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText mInputET;
    private TextView mShowEncryputTV;
    private TextView mShowInputTV;
    private static final String PASSWORD_STRING = "12345678";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInputET = (EditText) findViewById(R.id.ase_input);
        mShowEncryputTV = (TextView) findViewById(R.id.show_oringe_encrypt);
        mShowInputTV = (TextView) findViewById(R.id.show_ase_encrypt);
    }

    /**
     * 加密
     *
     * @param view
     */
    public void encrypt(View view) {
        String inputString = mInputET.getText().toString().trim();
        if (inputString.length() == 0) {
            Toast.makeText(this, "请输入要加密的内容", Toast.LENGTH_SHORT).show();
            return;
        }
        String encryStr = Aes.encrypt(PASSWORD_STRING, inputString);
        mShowInputTV.setText(encryStr);
    }

    /**
     * 解密
     *
     * @param view
     */
    public void decrypt(View view) {
        String encryptString = mShowInputTV.getText().toString().trim();
        if (encryptString.length() == 0) {
            Toast.makeText(this, "解密字符串不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String decryStr = Aes.decrypt(PASSWORD_STRING, encryptString);
        mShowEncryputTV.setText(decryStr);
    }
}
