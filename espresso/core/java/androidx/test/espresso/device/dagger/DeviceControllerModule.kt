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

import android.os.Build
import androidx.test.espresso.device.context.ActionContext
import androidx.test.espresso.device.context.InstrumentationTestActionContext
import androidx.test.espresso.device.controller.DeviceController
import androidx.test.espresso.device.controller.EmulatorController
import androidx.test.espresso.device.controller.PhysicalDeviceController
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/** Dagger module for DeviceController. */
@Module
internal class DeviceControllerModule {
  companion object {
    /**
     * Detects if the test is running on an emulator or a real device using some heuristics based on
     * the device properties.
     */
    private fun isEmulator(): Boolean {
      val qemu: String? = System.getProperty("ro.kernel.qemu", "?")
      return qemu.equals("1") ||
        Build.HARDWARE.contains("goldfish") ||
        Build.HARDWARE.contains("ranchu")
    }
  }

  @Provides
  @Singleton
  fun provideActionContext(): ActionContext {
    // TODO(b/203570026) Initialize ActionContext depending on whether the test is an
    // instrumentation
    // test or Robolectric
    return InstrumentationTestActionContext()
  }

  @Provides
  @Singleton
  fun provideDeviceController(): DeviceController {
    if (isEmulator()) {
      return EmulatorController()
    } else {
      return PhysicalDeviceController()
    }
  }
}
