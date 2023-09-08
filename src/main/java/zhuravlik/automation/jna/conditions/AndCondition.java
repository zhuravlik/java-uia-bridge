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

package zhuravlik.automation.jna.conditions;

import com.sun.jna.platform.win32.jnacom.ComObject;
import com.sun.jna.platform.win32.jnacom.IUnknown;
import com.sun.jna.ptr.PointerByReference;
import zhuravlik.automation.jna.IUIAutomation;
import zhuravlik.automation.jna.conditions.raw.IUIAutomationAndCondition;
import zhuravlik.automation.util.NativeUtils;
import zhuravlik.automation.util.win32.UIAObject;

/**
 *
 * @author Администратор
 */
public class AndCondition extends Condition {

    public AndCondition(Condition first, Condition second) throws Exception {
        PointerByReference result = new PointerByReference();
        IUIAutomation iua = UIAObject.getRootOleObject();
        
        iua.CreateAndCondition(
                NativeUtils.UnwrapNativeComInterface(first.getRawCondition()),
                NativeUtils.UnwrapNativeComInterface(second.getRawCondition()),
                result);
        
        IUnknown iu2 = ComObject.wrapNativeInterface(result.getValue(), IUnknown.class);
        rawCondition = iu2.queryInterface(IUIAutomationAndCondition.class);
    }
    
}
