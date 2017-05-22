package test.qht.com.newss.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import test.qht.com.newss.R;

public class Phone_Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText phone_edit_n;
    private TextView send_phone;
    private EditText phone_edit_y;
    private TextView phone_text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_);
        initView();

    }

    private void initView() {
        phone_edit_n = (EditText) findViewById(R.id.phone_edit_n);
        send_phone = (TextView) findViewById(R.id.send_phone);
        phone_edit_y = (EditText) findViewById(R.id.phone_edit_y);
        phone_text2 = (TextView) findViewById(R.id.phone_text2);

        send_phone.setOnClickListener(this);
        phone_text2.setOnClickListener(this);
    }

    private void submit() {
        // validate
        String n = phone_edit_n.getText().toString().trim();
        if (TextUtils.isEmpty(n)) {
            Toast.makeText(this, "手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String y = phone_edit_y.getText().toString().trim();
        if (TextUtils.isEmpty(y)) {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send_phone:

                break;
            case R.id.phone_text2:

                break;

            default:
                break;
        }
    }
}
