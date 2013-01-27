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
package zhuravlik.automation.jna.patterns.raw;

import com.sun.jna.platform.win32.WinNT.HRESULT;
import com.sun.jna.platform.win32.jnacom.IID;
import com.sun.jna.platform.win32.jnacom.VTID;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

/**
 *
 * @author Администратор
 */
@IID("{8D253C91-1DC5-4BB5-B18F-ADE16FA495E8}")
public interface IUIAutomationMultipleViewPattern {
    
    @VTID(3)
    public HRESULT GetViewName(int viewId, PointerByReference name);
    
    @VTID(4)
    public HRESULT SetCurrentView(int viewId);
    
    @VTID(5)
    public HRESULT Get_CurrentCurrentView(IntByReference viewId);
    
    @VTID(6)
    public HRESULT GetCurrentSupportedViews(PointerByReference viewIds);
}
