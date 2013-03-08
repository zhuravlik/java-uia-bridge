/*
   Copyright (C) 2012-2013 Anton Lobov <zhuravlik> <ahmad200512[at]yandex.ru>

   This library is free software; you can redistribute it and/or
   modify it under the terms of the GNU Lesser General Public
   License as published by the Free Software Foundation; either
   version 3 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
   Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General
   Public License along with this library; if not, write to the
   Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
   Boston, MA 02110-1301 USA
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
