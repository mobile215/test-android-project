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

package androidx.test.espresso.base;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import android.view.View;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ThrowableHandlerTest {
  private ThrowableHandler handler;
  private Matcher<View> viewMatcher;

  @Before
  public void setUp() {
    handler = new ThrowableHandler();
    viewMatcher =
        new BaseMatcher<View>() {
          @Override
          public boolean matches(Object o) {
            return false;
          }

          @Override
          public void describeTo(Description description) {
            description.appendText("A view matcher");
          }
        };
  }

  @Test
  public void handle_checkedException() {
    RuntimeException thrown =
        assertThrows(
            RuntimeException.class,
            () ->
                handler.handle(new NullPointerException("A null pointer exception"), viewMatcher));
    assertThat(thrown).hasMessageThat().contains("A null pointer exception");
  }

  @Test
  public void handle_runtimeException() {
    RuntimeException thrown =
        assertThrows(
            RuntimeException.class,
            () -> handler.handle(new RuntimeException("A runtime error"), viewMatcher));
    assertThat(thrown).hasMessageThat().contains("A runtime error");
  }
}
