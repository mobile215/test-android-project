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

package androidx.test.espresso.device.dagger

import androidx.test.espresso.device.controller.DeviceController
import androidx.test.espresso.device.controller.EmulatorController
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Dagger module for DeviceController.
 *
 * @hide
 */
@Module
class DeviceControllerModule {
  @Provides
  @Singleton
  fun provideDeviceController(): DeviceController {
    // TODO(b/200852481): initialize the correct instance depending on whether the test is run on a
    // real device or an emulator
    return EmulatorController()
  }
}
