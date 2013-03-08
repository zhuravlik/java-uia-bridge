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

package zhuravlik.automation.jna.conditions;

import com.sun.jna.platform.win32.jnacom.ComObject;
import com.sun.jna.platform.win32.jnacom.IUnknown;
import com.sun.jna.ptr.PointerByReference;
import zhuravlik.automation.jna.IUIAutomation;
import zhuravlik.automation.jna.conditions.raw.IUIAutomationPropertyCondition;
import zhuravlik.automation.util.win32.AutomationProperty;
import zhuravlik.automation.util.win32.UIAObject;

/**
 *
 * @author Администратор
 */
public class PropertyCondition extends Condition {          
    public PropertyCondition(AutomationProperty prop, Object value) throws Exception {
        PointerByReference result = new PointerByReference();
        IUIAutomation iua = UIAObject.getRootOleObject();
        iua.CreatePropertyCondition(prop.getValue(), null, result);
        IUnknown iu2 = ComObject.wrapNativeInterface(result.getValue(), IUnknown.class);
        rawCondition = iu2.queryInterface(IUIAutomationPropertyCondition.class);
    }
}
