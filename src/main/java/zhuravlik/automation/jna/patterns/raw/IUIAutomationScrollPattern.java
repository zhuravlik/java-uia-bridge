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
