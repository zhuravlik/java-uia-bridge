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
package zhuravlik.automation.jna.patterns;

import com.sun.jna.ptr.IntByReference;
import zhuravlik.automation.jna.patterns.raw.IUIAutomationWindowPattern;
import zhuravlik.automation.util.win32.WindowVisualState;

/**
 *
 * @author Администратор
 */
public class WindowPattern {
    private IUIAutomationWindowPattern rawPattern;
    
    public WindowPattern(IUIAutomationWindowPattern rawPattern) {
        this.rawPattern = rawPattern;
    }
    
    public void Close() {
        rawPattern.Close();
    }
    
    public boolean WaitForInputIdle(int millis) {
        IntByReference ibr = new IntByReference();
        rawPattern.WaitForInputIdle(millis, ibr);
        
        return ibr.getValue() != 0;
    }
    
    public void setVisualState(WindowVisualState state) {
        rawPattern.SetWindowVisualState(state.ordinal());
    }
    
    public boolean isCanMaximize() {
        IntByReference ibr = new IntByReference();
        rawPattern.Get_CurrentCanMaximize(ibr);
        return ibr.getValue() != 0;
    }
    
    public boolean isCanMinimize() {
        IntByReference ibr = new IntByReference();
        rawPattern.Get_CurrentCanMinimize(ibr);
        return ibr.getValue() != 0;
    }
    
    public boolean isModal() {
        IntByReference ibr = new IntByReference();
        rawPattern.Get_CurrentIsModal(ibr);
        return ibr.getValue() != 0;
    }
    
    public boolean isTopmost() {
        IntByReference ibr = new IntByReference();
        rawPattern.Get_CurrentIsTopmost(ibr);
        return ibr.getValue() != 0;
    }
    
    public WindowVisualState getVisualState() {
        IntByReference ibr = new IntByReference();
        rawPattern.Get_CurrentWindowVisualState(ibr);
        
        return WindowVisualState.values()[ibr.getValue()];
    } 
}
