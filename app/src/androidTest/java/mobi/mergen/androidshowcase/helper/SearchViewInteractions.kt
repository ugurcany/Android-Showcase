/*
 * Copyright 2018 UGURCAN YILDIRIM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mobi.mergen.androidshowcase.helper

import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.widget.SearchView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.*
import com.schibsted.spain.barista.internal.performAction
import org.hamcrest.Matcher
import org.hamcrest.Matchers

object SearchViewInteractions {

    @JvmStatic
    fun typeAndSubmit(@IdRes searchViewId: Int, text: String) {
        val withId = withId(searchViewId)
        val assignableFrom = isAssignableFrom(SearchView::class.java)
        val simpleMatcher = Matchers.allOf(withId, assignableFrom)
        val wrapperMatcher = Matchers.allOf(isDescendantOfA(withId), assignableFrom)
        val combinedMatcher = Matchers.anyOf(simpleMatcher, wrapperMatcher)
        combinedMatcher.performAction(perform(text))
    }

    @JvmStatic
    private fun perform(text: String): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return Matchers.allOf(isDisplayed(), isAssignableFrom(SearchView::class.java))
            }

            override fun getDescription(): String {
                return "Set text and submit"
            }

            override fun perform(uiController: UiController, view: View) {
                (view as SearchView).setQuery(text, true)
            }
        }
    }

}
