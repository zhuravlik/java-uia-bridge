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
package zhuravlik.automation.jna.patterns;

import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.IntByReference;
import zhuravlik.automation.jna.patterns.raw.IUIAutomationScrollPattern;
import zhuravlik.automation.util.win32.ScrollAmount;

/**
 *
 * @author Администратор
 */
public class ScrollPattern {
    private IUIAutomationScrollPattern rawPattern;
    
    public ScrollPattern(IUIAutomationScrollPattern rawPattern) {
        this.rawPattern = rawPattern;
    }
    
    public void scroll(ScrollAmount horizontal, ScrollAmount vertical) {
        rawPattern.Scroll(horizontal.ordinal(), vertical.ordinal());
    }
    
    public void setScrollPercent(double horizontalPercent, double verticalPercent) {
        rawPattern.SetScrollPercent(horizontalPercent, verticalPercent);
    }
    
    public double getHorizontalScrollPercent() {
        DoubleByReference v = new DoubleByReference();
        rawPattern.Get_CurrentHorizontalScrollPercent(v);
        return v.getValue();
    }
    
    public double getVerticalScrollPercent() {
        DoubleByReference v = new DoubleByReference();
        rawPattern.Get_CurrentVerticalScrollPercent(v);
        return v.getValue();
    }
    
    public double getHorizontalViewSize() {
        DoubleByReference v = new DoubleByReference();
        rawPattern.Get_CurrentHorizontalViewSize(v);
        return v.getValue();
    }
    
    public double getVerticalViewSize() {
        DoubleByReference v = new DoubleByReference();
        rawPattern.Get_CurrentVerticalViewSize(v);
        return v.getValue();
    }
    
    public boolean getVerticallyScrollable() {
        IntByReference v = new IntByReference();
        rawPattern.Get_CurrentVerticallyScrollable(v);
        return v.getValue() != 0;
    }
    
    public boolean getHorizontallyScrollable() {
        IntByReference v = new IntByReference();
        rawPattern.Get_CurrentHorizontallyScrollable(v);
        return v.getValue() != 0;
    }
}
