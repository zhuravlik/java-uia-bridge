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
package zhuravlik.automation.jna.conditions.raw;

import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.jnacom.IID;
import com.sun.jna.platform.win32.jnacom.VTID;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

/**
 *
 * @author Администратор
 */
@IID("{8753F032-3DB1-47B5-A1FC-6E34A266C712}")
public interface IUIAutomationOrCondition {
    @VTID(3)
    public WinNT.HRESULT Get_ChildCount(IntByReference v);
    
    @VTID(4)
    public WinNT.HRESULT GetChildrenAsNativeArray(PointerByReference v, IntByReference cnt);
    
    @VTID(5)
    public WinNT.HRESULT GetChildren(PointerByReference v);    
}
