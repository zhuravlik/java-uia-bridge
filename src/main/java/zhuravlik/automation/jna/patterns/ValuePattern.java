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
import com.sun.jna.ptr.PointerByReference;
import zhuravlik.automation.jna.patterns.raw.IUIAutomationValuePattern;

/**
 *
 * @author Администратор
 */
public class ValuePattern {
    private IUIAutomationValuePattern rawPattern;
    
    public ValuePattern(IUIAutomationValuePattern rawPattern) {
        this.rawPattern = rawPattern;
    }
    
    public void setValue(String value) {
        rawPattern.SetValue(value);
    }
    
    public String getValue() {
        PointerByReference v = new PointerByReference();
        rawPattern.Get_CurrentValue(v);
        return v.getValue().getString(0, true);
    }
    
    public boolean isReadOnly() {
        IntByReference v = new IntByReference();
        rawPattern.Get_CurrentIsReadOnly(v);
        return v.getValue() != 0;
    }
}
