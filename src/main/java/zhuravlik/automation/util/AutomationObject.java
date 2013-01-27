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
package zhuravlik.automation.util;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

public abstract class AutomationObject {
    public abstract List<AutomationObject> getChildItems();    
    public abstract AutomationObject getParent();
    
    public abstract Rectangle getRectangle();
    public abstract void mouseDown(Point p);
    public abstract void mouseUp(Point p);
    
    public void mouseClick(Point p) {
        mouseDown(p);
        mouseUp(p);
    }
}
