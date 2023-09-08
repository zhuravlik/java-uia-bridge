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
@IID("{88F4D42A-E881-459D-A77C-73BBBB7E02DC}")
public interface IUIAutomationScrollPattern {    
    @VTID(3)
    public HRESULT Scroll(int horizontalAmountType, int verticalAmountType);
    
    @VTID(4)
    public HRESULT SetScrollPercent(double horizontalPercent, double verticalPercent);
    
    @VTID(5)
    public HRESULT Get_CurrentHorizontalScrollPercent(DoubleByReference v);
    
    @VTID(6)
    public HRESULT Get_CurrentVerticalScrollPercent(DoubleByReference v);
    
    @VTID(7)
    public HRESULT Get_CurrentHorizontalViewSize(DoubleByReference v);
    
    @VTID(8)
    public HRESULT Get_CurrentVerticalViewSize(DoubleByReference v);
    
    @VTID(9)
    public HRESULT Get_CurrentHorizontallyScrollable(IntByReference v);
    
    @VTID(10)
    public HRESULT Get_CurrentVerticallyScrollable(IntByReference v);    
}
