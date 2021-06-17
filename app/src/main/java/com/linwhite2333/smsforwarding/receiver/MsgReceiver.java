package com.linwhite2333.smsforwarding.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.transition.Explode;
import android.util.Log;
import android.widget.Toast;

public class MsgReceiver extends BroadcastReceiver {

    private String number;
    private String body;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "收到消息", Toast.LENGTH_SHORT).show();

        Object[] pdus = (Object[]) intent.getExtras().get("pdus");

        for (Object pdu : pdus) {
            SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdu, intent.getStringExtra("format"));
            number = sms.getOriginatingAddress();
            body = sms.getMessageBody();
        }
        Log.d("onReceive", "获取内容");


    }
}