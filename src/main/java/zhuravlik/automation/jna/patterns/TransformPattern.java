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
import zhuravlik.automation.jna.patterns.raw.IUIAutomationTransformPattern;

/**
 *
 * @author Администратор
 */
public class TransformPattern {
    private IUIAutomationTransformPattern rawPattern;
    
    public TransformPattern(IUIAutomationTransformPattern rawPattern) {
        this.rawPattern = rawPattern;
    }
    
    public void move(double x, double y) {
        rawPattern.Move(x, y);
    }
    
    public void resize(double width, double height) {
        rawPattern.Resize(width, height);
    }
    
    public void rotate(double degrees) {
        rawPattern.Rotate(degrees);
    }
    
    public boolean isCanMove() {
        IntByReference v = new IntByReference();
        rawPattern.Get_CurrentCanMove(v);
        return v.getValue() != 0;
    }
    
    public boolean isCanResize() {
        IntByReference v = new IntByReference();
        rawPattern.Get_CurrentCanResize(v);
        return v.getValue() != 0;
    }
    
    public boolean isCanRotate() {
        IntByReference v = new IntByReference();
        rawPattern.Get_CurrentCanRotate(v);
        return v.getValue() != 0;
    }
}
