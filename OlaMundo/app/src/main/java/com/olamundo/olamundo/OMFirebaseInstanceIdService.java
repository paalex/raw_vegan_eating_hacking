package com.olamundo.olamundo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class OMFirebaseInstanceIdService extends Service {
    public OMFirebaseInstanceIdService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
