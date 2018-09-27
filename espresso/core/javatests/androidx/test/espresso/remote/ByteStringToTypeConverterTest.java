/*
 * Copyright (C) 2016 The Android Open Source Project
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
 *
 */
package androidx.test.espresso.remote;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import android.test.suitebuilder.annotation.SmallTest;
import androidx.test.runner.AndroidJUnit4;
import com.google.protobuf.ByteString;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Tests for {@link ByteStringToTypeConverter} */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class ByteStringToTypeConverterTest {

  @Test
  public void convertByteStringToType() {
    String hello = "Hello";
    TypeToByteStringConverter<String> typeToByteStringConverter = new TypeToByteStringConverter<>();
    ByteString byteString = typeToByteStringConverter.convert(hello);
    assertThat(byteString, notNullValue());

    ByteStringToTypeConverter<String> byteStringToTypeConverter = new ByteStringToTypeConverter<>();
    String expectedString = byteStringToTypeConverter.convert(byteString);
    assertThat(expectedString, equalTo(hello));
  }
}
