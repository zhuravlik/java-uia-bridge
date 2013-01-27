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
import com.sun.jna.platform.win32.jnacom.IUnknown;
import com.sun.jna.platform.win32.jnacom.VTID;
import com.sun.jna.ptr.IntByReference;

/**
 *
 * @author Администратор
 */
@IID("{78F8EF57-66C3-4E09-BD7C-E79B2004894D}")
public interface IUIAutomationGridItemPattern extends IUnknown {
    //TODO: Get_CurrentContainingGrid
    
    @VTID(4)
    public HRESULT Get_CurrentRow(IntByReference row);
    
    @VTID(5)
    public HRESULT Get_CurrentColumn(IntByReference column);
    
    @VTID(6)
    public HRESULT Get_CurrentRowSpan(IntByReference span);
    
    @VTID(7)
    public HRESULT Get_CurrentColumnSpan(IntByReference span);
}
