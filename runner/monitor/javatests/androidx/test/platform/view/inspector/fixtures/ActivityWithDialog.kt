/*
 * Copyright (C) 2021 The Android Open Source Project
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
package androidx.test.platform.view.inspector.fixtures

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle

class ActivityWithDialog : Activity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.simple_activity)

    val builder: AlertDialog.Builder? = this?.let { AlertDialog.Builder(it) }

    builder?.setMessage("This is a dialog")?.setTitle("Dialog Title")

    val dialog: AlertDialog? = builder?.create()
    dialog?.show()
  }
}
