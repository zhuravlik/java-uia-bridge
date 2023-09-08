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
