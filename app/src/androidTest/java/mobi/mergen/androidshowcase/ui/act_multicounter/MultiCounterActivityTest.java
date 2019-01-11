package mobi.mergen.androidshowcase.ui.act_multicounter;

import android.content.Context;

import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions;
import com.schibsted.spain.barista.interaction.BaristaClickInteractions;
import com.schibsted.spain.barista.interaction.BaristaMenuClickInteractions;
import com.schibsted.spain.barista.rule.BaristaRule;
import com.schibsted.spain.barista.rule.flaky.AllowFlaky;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import mobi.mergen.androidshowcase.R;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MultiCounterActivityTest {

    private Context context;

    @Rule
    public BaristaRule<MultiCounterActivity> rule = BaristaRule.create(MultiCounterActivity.class);

    @Before
    public void setUp() {
        this.context = InstrumentationRegistry.getInstrumentation().getTargetContext();

        rule.launchActivity();
    }

    @Test
    @AllowFlaky(attempts = 1)
    public void checkPage1InitialContent() {
        BaristaMenuClickInteractions.clickMenu(R.id.action_page1);

        BaristaVisibilityAssertions.assertDisplayed(
                context.getString(R.string.multicounter_page_x, 1, 1));
        BaristaVisibilityAssertions.assertDisplayed(R.id.textview_count, "0");
    }

    @Test
    @AllowFlaky(attempts = 1)
    public void checkPage2InitialContent() {
        BaristaMenuClickInteractions.clickMenu(R.id.action_page2);

        BaristaVisibilityAssertions.assertDisplayed(
                context.getString(R.string.multicounter_page_x, 2, 1));
        BaristaVisibilityAssertions.assertDisplayed(R.id.textview_count, "0");
    }

    @Test
    @AllowFlaky(attempts = 1)
    public void checkPage3InitialContent() {
        BaristaMenuClickInteractions.clickMenu(R.id.action_page3);

        BaristaVisibilityAssertions.assertDisplayed(
                context.getString(R.string.multicounter_page_x, 3, 1));
        BaristaVisibilityAssertions.assertDisplayed(R.id.textview_count, "0");
    }

    @Test
    @AllowFlaky(attempts = 1)
    public void checkPage3ContentAfterIncrement() {
        BaristaMenuClickInteractions.clickMenu(R.id.action_page3);

        BaristaClickInteractions.clickOn(R.id.fab);
        BaristaClickInteractions.clickOn(R.id.fab);
        BaristaClickInteractions.clickOn(R.id.fab);

        BaristaVisibilityAssertions.assertDisplayed(
                context.getString(R.string.multicounter_page_x, 3, 1));
        BaristaVisibilityAssertions.assertDisplayed(R.id.textview_count, "3");
    }
}