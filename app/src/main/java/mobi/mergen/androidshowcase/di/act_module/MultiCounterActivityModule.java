package mobi.mergen.androidshowcase.di.act_module;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import mobi.mergen.androidshowcase.di.ActivityScope;
import mobi.mergen.androidshowcase.ui.act_multicounter.IMultiCounterNav;
import mobi.mergen.androidshowcase.ui.act_multicounter.MultiCounterNavController;
import mobi.mergen.androidshowcase.ui.act_multicounter.frag.MultiCounterFragment;

@Module
public abstract class MultiCounterActivityModule {

    @Binds
    @ActivityScope
    abstract IMultiCounterNav fragNavController(MultiCounterNavController fragNavController);

    @ContributesAndroidInjector
    abstract MultiCounterFragment contributeMultiCounterFragment();

}