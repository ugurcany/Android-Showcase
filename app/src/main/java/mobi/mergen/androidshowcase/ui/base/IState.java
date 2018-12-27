package mobi.mergen.androidshowcase.ui.base;

import com.blankj.utilcode.util.LogUtils;

import io.reactivex.functions.Consumer;

public interface IState<V> {

    void decorate(V binding);

    default void decorate(Consumer<V> consumer, V binding) {
        try {
            consumer.accept(binding);
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }
}
