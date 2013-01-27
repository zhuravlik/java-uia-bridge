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
@IID("{0FAEF453-9208-43EF-BBB2-3B485177864F}")
public interface IUIAutomationWindowPattern extends IUnknown {
    
    @VTID(3)
    HRESULT Close();
    
    @VTID(4)
    HRESULT WaitForInputIdle(int millis, IntByReference success);
    
    @VTID(5)
    HRESULT SetWindowVisualState(int state);
    
    @VTID(6)
    HRESULT Get_CurrentCanMaximize(IntByReference result);
    
    @VTID(6)
    HRESULT Get_CurrentCanMinimize(IntByReference result);
    
    @VTID(7)
    HRESULT Get_CurrentIsModal(IntByReference result);
    
    @VTID(8)
    HRESULT Get_CurrentIsTopmost(IntByReference result);
    
    @VTID(9)
    HRESULT Get_CurrentWindowVisualState(IntByReference result);
    
    @VTID(10)
    HRESULT Get_CurrentWindowInteractionState(IntByReference result);
    
    /*
    
    procedure Close: HRESULT;;
    procedure WaitForInputIdle(const milliseconds: Integer; var retval success: LongInt): HRESULT;;
    procedure SetWindowVisualState(const state: WindowVisualState): HRESULT;;
    procedure Get_CurrentCanMaximize(var retval retVal: LongInt): HRESULT;;
    procedure Get_CurrentCanMinimize(var retval retVal: LongInt): HRESULT;;
    procedure Get_CurrentIsModal(var retval retVal: LongInt): HRESULT;;
    procedure Get_CurrentIsTopmost(var retval retVal: LongInt): HRESULT;;
    procedure Get_CurrentWindowVisualState(var retval retVal: WindowVisualState): HRESULT;;
    procedure Get_CurrentWindowInteractionState(var retval retVal: WindowInteractionState): HRESULT;;
    procedure Get_CachedCanMaximize(var retval retVal: LongInt): HRESULT;;
    procedure Get_CachedCanMinimize(var retval retVal: LongInt): HRESULT;;
    procedure Get_CachedIsModal(var retval retVal: LongInt): HRESULT;;
    procedure Get_CachedIsTopmost(var retval retVal: LongInt): HRESULT;;
    procedure Get_CachedWindowVisualState(var retval retVal: WindowVisualState): HRESULT;;
    procedure Get_CachedWindowInteractionState(var retval retVal: WindowInteractionState): HRESULT;; 
    
     */
}
