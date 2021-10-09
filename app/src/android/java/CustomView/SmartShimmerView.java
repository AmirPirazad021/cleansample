package CustomView;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.mpt.saeed.R;
import com.mpt.saeed.androidWrapper.component.RtlGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.supercharge.shimmerlayout.ShimmerLayout;

public class SmartShimmerView extends FrameLayout implements View.OnClickListener {
    private Context context;
    //private LinearLayout llItem;
    //private LinearLayout llOnClick;
    private int viewPartRef;
    private View viewPart;

    @BindView(R.id.rvList)
    RecyclerView rvList;
    @BindView(R.id.shimmerLayout)
    ShimmerLayout shimmerLayout;

    public SmartShimmerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        View view = View.inflate(context, R.layout.view_shimmer, this);
        ButterKnife.bind(this, view);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SmartShimmerView);
        float count_item_in_page = typedArray.getFloat(R.styleable.SmartShimmerView_smart_count_in_page, 1f);
        int orientation = typedArray.getInteger(R.styleable.SmartShimmerView_smart_orientation, 0);
        Drawable drawable = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            drawable = typedArray.getDrawable(R.styleable.SmartShimmerView_smart_list_item);
        } else {
            final int drawableId = typedArray.getResourceId(R.styleable.SmartShimmerView_smart_list_item, -1);
            if (drawableId != -1)
                drawable = AppCompatResources.getDrawable(context, drawableId);
        }
        int spanCount = typedArray.getInteger(R.styleable.SmartShimmerView_smart_span_count, 1);
        int itemCount = typedArray.getInteger(R.styleable.SmartShimmerView_smart_item_count, 8);
        boolean fill_height = typedArray.getBoolean(R.styleable.SmartShimmerView_smart_fill_height, false);
        float margin_item = typedArray.getDimension(R.styleable.SmartShimmerView_smart_margin_item, 0);
        int padding_recyclerview = (int) typedArray.getDimension(R.styleable.SmartShimmerView_smart_padding_recyclerview, 0);
        typedArray.recycle();

        if (fill_height) {
            shimmerLayout.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        }

        rvList.setPadding(padding_recyclerview, 0, padding_recyclerview, 0);
        rvList.setLayoutManager(new RtlGridLayoutManager(context, spanCount, orientation, false));
        List<Drawable> list = new ArrayList<>();
        for (int i = 0; i < itemCount; i++) {
            list.add(drawable);
        }

        float ratioHeightImage = getRatioHeightImage(drawable, count_item_in_page);
        rvList.setAdapter(new SmartShimmerAdapter(context, list, count_item_in_page, ratioHeightImage, margin_item, orientation, fill_height));

    }

    public void startShimmerAnimation() {
        if (shimmerLayout != null) {
            shimmerLayout.startShimmerAnimation();
        }
    }

    public void stopShimmerAnimation() {
        if (shimmerLayout != null) {
            shimmerLayout.stopShimmerAnimation();
        }
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        viewPart = ((View) this.getParent()).findViewById(viewPartRef);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, "clicck", Toast.LENGTH_SHORT).show();
        /*if (v.getId() == llOnClick.getId()) {
            Toast.makeText(context, "llItem", Toast.LENGTH_SHORT).show();
        }*/
    }

    public static int getSizeScreen(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return width;
    }

    public float getRatioHeightImage(Drawable drawable, float count_item_in_page) {
        float imageHeight = drawable.getIntrinsicHeight();
        float imageWidth = drawable.getIntrinsicWidth();
        float ratioHeight = imageWidth * count_item_in_page / imageHeight;
        return ratioHeight;
    }


}
