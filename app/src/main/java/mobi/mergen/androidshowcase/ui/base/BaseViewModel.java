package mobi.mergen.androidshowcase.ui.base;

import com.blankj.utilcode.util.LogUtils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseViewModel extends ViewModel
        implements LifecycleObserver {

    private CompositeDisposable compositeDisposable;


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStarted() {
        LogUtils.d("onStarted()", getClass().getSimpleName());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStopped() {
        LogUtils.d("onStopped()", getClass().getSimpleName());
    }

    @Override
    protected void onCleared() {
        LogUtils.d("onCleared()", getClass().getSimpleName());
        disposeAll();
    }

    public void dispose(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    private void disposeAll() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
        compositeDisposable = null;
    }
}
