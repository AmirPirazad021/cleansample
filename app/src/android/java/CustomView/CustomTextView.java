package CustomView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.appcompat.widget.AppCompatTextView;

public class CustomTextView extends AppCompatTextView {

    private ClsSharedPreference sharedPreference;
    private String FontSize;

    public CustomTextView(Context context) {
        super(context);
        init(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(replaceEngToArb(text), type);
    }

    public String replaceEngToArb(CharSequence strNumberParam) {
        try {
            return strNumberParam.toString().replaceAll("0", "۰")
                    .replaceAll("1", "۱")
                    .replaceAll("2", "۲")
                    .replaceAll("3", "۳")
                    .replaceAll("4", "۴")
                    .replaceAll("5", "۵")
                    .replaceAll("6", "۶")
                    .replaceAll("7", "۷")
                    .replaceAll("8", "۸")
                    .replaceAll("9", "۹")
                    .replaceAll("٫", ".");
        } catch (Exception e) {
            return "";
        }
    }

    public void init(Context context) {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/iryekl.ttf");
        setTypeface(tf, Typeface.NORMAL);
        sharedPreference = new ClsSharedPreference(context);

    }
}
