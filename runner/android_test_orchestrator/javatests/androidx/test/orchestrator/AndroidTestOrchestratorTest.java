/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package androidx.test.orchestrator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

/** Unit tests for {@link AndroidTestOrchestrator}. */
@RunWith(RobolectricTestRunner.class)
public class AndroidTestOrchestratorTest {

  @Test
  public void testSingleMethodTest() {
    assertThat(AndroidTestOrchestrator.isSingleMethodTest("org.example.class#method"), is(true));
    assertThat(AndroidTestOrchestrator.isSingleMethodTest("org.example.class"), is(false));
    assertThat(
        AndroidTestOrchestrator.isSingleMethodTest("org.example.class,org.example.another#method"),
        is(false));
    assertThat(
        AndroidTestOrchestrator.isSingleMethodTest(
            "org.example.class#method,org.example.class#anotherMethod"),
        is(false));
  }

  @Test
  public void testSingleMethodTest_blankInput() {
    assertThat(AndroidTestOrchestrator.isSingleMethodTest(null), is(false));
    assertThat(AndroidTestOrchestrator.isSingleMethodTest(""), is(false));
  }
}
