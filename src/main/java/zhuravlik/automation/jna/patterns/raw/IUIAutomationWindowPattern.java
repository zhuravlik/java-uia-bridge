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
