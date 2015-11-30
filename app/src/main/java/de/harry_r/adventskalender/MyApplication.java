package de.harry_r.adventskalender;

import android.app.Application;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.acra.sender.HttpSender;

@ReportsCrashes(
        httpMethod = HttpSender.Method.PUT,
        reportType = HttpSender.Type.JSON,
        formUri = "https://acra.mytfg.de/acra-adventskalender/_design/acra-storage/_update/report",
        formUriBasicAuthLogin = "adventskalender_app",
        formUriBasicAuthPassword = "1hv8AeshKfgWyKtbsJxM420La8iLcRUlEg==",

        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.crash_toast
)

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Initialise ACRA:
        ACRA.init(this);
    }
}
