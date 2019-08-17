package com.example.checkboxes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mInputMoney;
    private EditText mInputInfo;
    private Button mBtnPay;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mBtnPay = findViewById(R.id.btnPay);
        mBtnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Платёж на сумму " + mInputMoney.getText().toString() + " успешно осуществлён", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initViews() {
        mInputMoney = findViewById(R.id.txtInputMoney);
        mInputInfo = findViewById(R.id.txtPaymentInfo);
        mBtnPay = findViewById(R.id.btnPay);
        mBankCardChkBx = findViewById(R.id.chkBxBankCard);
        mMobilePhoneChkBx = findViewById(R.id.chkBxMobilePhone);
        mCashAddressChkBx = findViewById(R.id.chkBxCash);
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);
    }

    private void resetCheckBoxes(){
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
        mCashAddressChkBx.setChecked(false);
    }
    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                switch (compoundButton.getId()) {
                    case R.id.chkBxBankCard:
                        resetCheckBoxes();
                        mBankCardChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                        break;
                    case R.id.chkBxMobilePhone:
                        resetCheckBoxes();
                        mMobilePhoneChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                        break;
                    case R.id.chkBxCash:
                        resetCheckBoxes();
                        mCashAddressChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                    default:
                }
            }
        }
    };
}
