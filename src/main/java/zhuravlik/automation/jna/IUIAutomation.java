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
package zhuravlik.automation.jna;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinNT.HRESULT;
import com.sun.jna.platform.win32.WinUser.POINT;
import com.sun.jna.platform.win32.jnacom.IID;
import com.sun.jna.platform.win32.jnacom.IUnknown;
import com.sun.jna.platform.win32.jnacom.VTID;
import com.sun.jna.ptr.PointerByReference;


@IID("{30cbe57d-d9d0-452a-ab13-7ac5ac4825ee}")
public interface IUIAutomation extends IUnknown {
    
    
    @VTID(5)
    public HRESULT GetRootElement(PointerByReference elt);
    
    @VTID(6)
    public HRESULT ElementFromHandle(HWND hwnd, PointerByReference element);
    
    @VTID(7)
    public HRESULT ElementFromPoint(POINT pt, PointerByReference element);
    
    @VTID(8)
    public HRESULT GetFocusedElement(PointerByReference elt);
    
    @VTID(9)
    public HRESULT CreateTreeWalker(Pointer uiaCondition, PointerByReference walker);
    
    @VTID(21)
    public HRESULT CreateTrueCondition(PointerByReference v);
    
    @VTID(22)
    public HRESULT CreateFalseCondition(PointerByReference v);
    
    @VTID(23)
    public HRESULT CreatePropertyCondition(int propertyId, Variant value, PointerByReference result);
    
    @VTID(25)
    public HRESULT CreateAndCondition(Pointer c1, Pointer c2, PointerByReference v);
    
    @VTID(28)
    public HRESULT CreateOrCondition(Pointer c1, Pointer c2, PointerByReference v);
    
    @VTID(31)
    public HRESULT CreateNotCondition(Pointer c, PointerByReference v);
}
