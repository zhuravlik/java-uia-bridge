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
import zhuravlik.automation.jna.patterns.raw.IUIAutomationDockPattern;
import zhuravlik.automation.util.win32.DockPosition;

/**
 *
 * @author Администратор
 */
public class DockPattern {
    private IUIAutomationDockPattern rawPattern;
    
    public DockPattern(IUIAutomationDockPattern rawPattern) {
        this.rawPattern = rawPattern;
    }
    
    public void SetPosition(DockPosition pos) {
        rawPattern.SetDockPosition(pos.ordinal());
    }
    
    public DockPosition GetPosition() {
        IntByReference v = new IntByReference();
        rawPattern.Get_CurrentDockPosition(v);
        return DockPosition.values()[v.getValue()];
    }    
}
