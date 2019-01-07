package mobi.mergen.androidshowcase.ui.act_fleximages;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.annotation.Nullable;
import mobi.mergen.androidshowcase.R;
import mobi.mergen.androidshowcase.databinding.ActivityFlexImagesBinding;
import mobi.mergen.androidshowcase.ui.base.BaseActivity;

public class FlexImagesActivity extends BaseActivity<ActivityFlexImagesBinding> {

    private final static String[] IMAGE_URLS = {
            "https://images.pexels.com/photos/507410/pexels-photo-507410.jpeg",
            "https://images.pexels.com/photos/460634/pexels-photo-460634.jpeg",
            "https://images.pexels.com/photos/705405/pexels-photo-705405.jpeg",
            "https://images.pexels.com/photos/257372/pexels-photo-257372.jpeg",
            "https://images.pexels.com/photos/416887/pexels-photo-416887.jpeg",
            "https://images.pexels.com/photos/786360/pexels-photo-786360.jpeg",
            "https://images.pexels.com/photos/831082/pexels-photo-831082.jpeg",
            "https://images.pexels.com/photos/1055068/pexels-photo-1055068.jpeg",
            "https://images.pexels.com/photos/947179/pexels-photo-947179.jpeg"
    };
    private final static String IMAGE_URL_SUFFIX
            = "?auto=compress&cs=tinysrgb&dpr=2&h=600&w=600";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < ((ViewGroup) getBinding().getRoot()).getChildCount(); i++) {
            ImageView imageView = (ImageView) ((ViewGroup) getBinding().getRoot()).getChildAt(i);
            Picasso.get()
                    .load(IMAGE_URLS[i] + IMAGE_URL_SUFFIX)
                    .fit().centerCrop()
                    .into(imageView);
        }
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_flex_images;
    }

    @Override
    public boolean doubleClickToExitEnabled() {
        return true;
    }

}