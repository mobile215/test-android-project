/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.test.espresso.device

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.device.EspressoDevice.Companion.onDevice
import androidx.test.espresso.device.action.ScreenOrientation
import androidx.test.espresso.device.action.setFlatMode
import androidx.test.espresso.device.action.setScreenOrientation
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.foldable.app.FoldableActivity
import androidx.test.foldable.app.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class FoldableEspressoDeviceTest {
  @get:Rule
  val activityScenario: ActivityScenarioRule<FoldableActivity> =
    ActivityScenarioRule(FoldableActivity::class.java)

  @Test
  fun setFlatMode() {
    onDevice().setFlatMode()

    onView(withId(R.id.current_fold_mode)).check(matches(withText("flatmode")))
  }

  @Test
  fun setTabletopMode() {
    // Rotate the fold to be horizontal.
    // TODO(b/217579879) Remove this once fold orientation is handled by TabletopModeAction.
    onDevice().setScreenOrientation(ScreenOrientation.LANDSCAPE)

    onDevice().setTabletopMode()

    onView(withId(R.id.current_fold_mode)).check(matches(withText("tabletopmode")))
  }
}
