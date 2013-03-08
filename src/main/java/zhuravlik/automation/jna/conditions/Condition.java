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

import zhuravlik.automation.jna.conditions.raw.IUIAutomationCondition;

/**
 *
 * @author Администратор
 */
public class Condition {
    protected IUIAutomationCondition rawCondition;
    
    protected IUIAutomationCondition getRawCondition() {
        return rawCondition;
    }
    
    /*protected Condition(IUIAutomationCondition rawCondition) {
        this.rawCondition = rawCondition;
    }*/
}
