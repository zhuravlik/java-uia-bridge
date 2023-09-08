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
package zhuravlik.automation.jna.patterns.raw;

import com.sun.jna.platform.win32.WinNT.HRESULT;
import com.sun.jna.platform.win32.jnacom.IID;
import com.sun.jna.platform.win32.jnacom.VTID;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.IntByReference;

/**
 *
 * @author Администратор
 */
@IID("{59213F4F-7346-49E5-B120-80555987A148}")
public interface IUIAutomationRangeValuePattern {    
    @VTID(3)
    public HRESULT SetValue(double value);
    
    @VTID(4)
    public HRESULT Get_CurrentValue(DoubleByReference value);
    
    @VTID(5)
    public HRESULT Get_CurrentIsReadOnly(IntByReference value);
    
    @VTID(6)
    public HRESULT Get_CurrentMaximum(DoubleByReference value);
    
    @VTID(7)
    public HRESULT Get_CurrentMinimum(DoubleByReference value);
    
    @VTID(8)
    public HRESULT Get_CurrentLargeChange(DoubleByReference value);
    
    @VTID(9)
    public HRESULT Get_CurrentSmallChange(DoubleByReference value);
}
