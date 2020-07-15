/*
 * Copyright (C) 2019 The Android Open Source Project
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

package androidx.test.internal.events.client;

import android.os.RemoteException;
import androidx.test.services.events.FailureInfo;
import androidx.test.services.events.TestCaseInfo;
import androidx.test.services.events.run.TestRunEvent;

/**
 * Base interface implemented by the test run service client connection, e.g. {@link
 * TestRunConnectionImpl}.
 */
public interface TestRunService {
  /**
   * Sends a test status event and related {@link TestCaseInfo} and {@link FailureInfo} parcelables.
   *
   * @param testRunEvent parcelable with the {@link TestCaseInfo} information.
   */
  void send(TestRunEvent testRunEvent) throws RemoteException;
}
