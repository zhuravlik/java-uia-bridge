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
import zhuravlik.automation.jna.patterns.raw.IUIAutomationGridItemPattern;

/**
 *
 * @author Администратор
 */
public class GridItemPattern {
    private IUIAutomationGridItemPattern rawPattern;
    
    public GridItemPattern(IUIAutomationGridItemPattern rawPattern) {
        this.rawPattern = rawPattern;
    }
    
    public int getRow() {
        IntByReference v = new IntByReference();
        rawPattern.Get_CurrentRow(v);
        return v.getValue();
    }
    
    public int getColumn() {
        IntByReference v = new IntByReference();
        rawPattern.Get_CurrentColumn(v);
        return v.getValue();
    }
    
    public int getRowSpan() {
        IntByReference v = new IntByReference();
        rawPattern.Get_CurrentRowSpan(v);
        return v.getValue();
    }
    
    public int getColumnSpan() {
        IntByReference v = new IntByReference();
        rawPattern.Get_CurrentColumnSpan(v);
        return v.getValue();
    }
}
