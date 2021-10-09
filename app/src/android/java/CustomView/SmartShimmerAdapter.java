package CustomView;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mpt.saeed.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class SmartShimmerAdapter extends RecyclerView.Adapter<SmartShimmerAdapter.ViewHolder> {

    private Context continst;
    private List<Drawable> listinfo;
    private float count_item_in_page;
    private float hieght_item_in_page;
    private int margin_item;
    private int orientation;
    private boolean fill_height;


    public SmartShimmerAdapter(Context continst, List<Drawable> list, float count_item_in_page, float hieght_item_in_page, float margin_item, int orientation, boolean fill_height) {
        this.continst = continst;
        listinfo = list;
        this.count_item_in_page = count_item_in_page;
        this.hieght_item_in_page = hieght_item_in_page;
        this.margin_item = (int) margin_item;
        this.orientation = orientation;
        this.fill_height = fill_height;
    }

    public List<Drawable> getData() {
        return listinfo;
    }

    public void setData(List<Drawable> listinfo) {
        this.listinfo = listinfo;
    }

    @NonNull
    @Override
    public SmartShimmerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(continst).inflate(R.layout.item_shimmer, parent, false);
        return new SmartShimmerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SmartShimmerAdapter.ViewHolder holder, int position) {
        ViewGroup.LayoutParams param = holder.ivImage.getLayoutParams();
        if (orientation == LinearLayout.HORIZONTAL) {
            param.width = (int) (getSizeScreen(continst) / count_item_in_page);
        } else {

        }
        if (!fill_height) {
            param.height = (int) (getSizeScreen(continst) / hieght_item_in_page);
        } else {

        }
        holder.ivImage.setLayoutParams(param);

        ViewGroup.MarginLayoutParams relativeParams2 = (ViewGroup.MarginLayoutParams) holder.ivImage.getLayoutParams();
        relativeParams2.setMargins(margin_item, margin_item, margin_item, margin_item);
        holder.ivImage.setLayoutParams(relativeParams2);


        holder.ivImage.setImageDrawable(listinfo.get(position));

    }

    @Override
    public int getItemCount() {
        return listinfo.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivImage)
        ImageView ivImage;

        public ViewHolder(@NonNull View view) {

            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public static int getSizeScreen(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return width;
    }


}
