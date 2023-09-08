/*
    Copyright (C) 2012-2013 Anton Lobov <zhuravlik> <ahmad200512[at]yandex.ru>

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
*/
package zhuravlik.automation.jna.patterns;

import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import zhuravlik.automation.jna.patterns.raw.IUIAutomationValuePattern;

/**
 *
 * @author Администратор
 */
public class ValuePattern {
    private IUIAutomationValuePattern rawPattern;
    
    public ValuePattern(IUIAutomationValuePattern rawPattern) {
        this.rawPattern = rawPattern;
    }
    
    public void setValue(String value) {
        rawPattern.SetValue(value);
    }
    
    public String getValue() {
        PointerByReference v = new PointerByReference();
        rawPattern.Get_CurrentValue(v);
        return v.getValue().getString(0, true);
    }
    
    public boolean isReadOnly() {
        IntByReference v = new IntByReference();
        rawPattern.Get_CurrentIsReadOnly(v);
        return v.getValue() != 0;
    }
}
