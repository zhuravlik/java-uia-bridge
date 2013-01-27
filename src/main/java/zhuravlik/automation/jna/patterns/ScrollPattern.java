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
