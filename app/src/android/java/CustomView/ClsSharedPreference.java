package CustomView;


import android.content.Context;
import android.content.SharedPreferences;

public class ClsSharedPreference {
    SharedPreferences.Editor editor;
    SharedPreferences.Editor editorsetting;


    private static final String PREFNAMELGIN = "userlog";
    private static final String PRESETTING = "setting";
    private static final String TEL = "tel";

    private SharedPreferences pref;
    private SharedPreferences prefsetting;

    public ClsSharedPreference(Context context) {
        pref = context.getSharedPreferences(PREFNAMELGIN, 0);
        prefsetting = context.getSharedPreferences(PRESETTING, 0);
        editorsetting = prefsetting.edit();
        editor = pref.edit();
    }

    public void setCountinePlay(boolean status) {
        editorsetting.putBoolean(TEL, status);
        editorsetting.commit();
    }

    public boolean isContinuePlay() {
        return prefsetting.getBoolean(TEL, true);
    }

}
