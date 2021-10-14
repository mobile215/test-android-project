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

package androidx.test.espresso.device.controller

/** Implementation of {@link DeviceController} for tests run on an Emulator. */
class EmulatorController() : DeviceController {
  override fun setDeviceMode(deviceMode: Int) {
    // TODO(b/200863559) Set the connected test device to the provided device mode.
  }

  override fun setDeviceScreenOrientation(screenOrientation: Int) {
    // TODO(b/202018386) Set the connected test device to the provided screen orientation.
  }
}
