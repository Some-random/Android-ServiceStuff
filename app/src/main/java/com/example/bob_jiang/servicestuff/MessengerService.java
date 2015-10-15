package com.example.bob_jiang.servicestuff;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.widget.Toast;

/**
 * Created by Bob_JIANG on 10/15/2015.
 */

// Summary:
// 1 The service implements a Handler that receives a callback for each call from a client. The
// Handler is used to create a Messenger object (new Messenger(new IncomingHandler)) (which is a
// reference to the Handler).
// 2 The Messenger (mMessager) creates an IBinder (mMessager.getbinder()) that the service returns
// to clients from onBind().
// 3 Clients use the IBinder to instantiate the Messenger (Messenger = new Messenger(IBinder))
// (that references the service's Handler), which the client uses to send Message objects to the service.
// 4 The service receives each Message in its Handler—specifically, in the handleMessage() method.
// Result:
// 1 Client doesn't call any of the methods within service, just send messages to the service
// 2 Service deal with all the request in handleMessage method


public class MessengerService extends Service {
    /** Command to the service to display a message */
    static final int MSG_SAY_HELLO = 1;

    /**
     * Handler of incoming messages from clients.
     */
    class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SAY_HELLO:
                    Toast.makeText(getApplicationContext(), "hello!", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }

    /**
     * Target we publish for clients to send messages to IncomingHandler.
     */
    final Messenger mMessenger = new Messenger(new IncomingHandler());

    /**
     * When binding to the service, we return an interface to our messenger
     * for sending messages to the service.
     */
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(), "binding", Toast.LENGTH_SHORT).show();
        return mMessenger.getBinder();
    }
}
